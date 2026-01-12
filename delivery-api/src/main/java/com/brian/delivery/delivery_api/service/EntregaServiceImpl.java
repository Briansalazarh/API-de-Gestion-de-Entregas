package com.brian.delivery.delivery_api.service;


import com.brian.delivery.delivery_api.model.Destinatario;
import com.brian.delivery.delivery_api.model.Localizacao;
import com.brian.delivery.delivery_api.repository.DestinatarioRepository;
import com.brian.delivery.delivery_api.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EntregaServiceImpl implements EntregaService {

    // Patrón Singleton: Spring inyecta estas instancias
    @Autowired private DestinatarioRepository destinatarioRepository;
    @Autowired private LocalizacaoRepository localizacaoRepository;
    @Autowired private ViaCepService viaCepService;

    @Override
    public Iterable<Destinatario> buscarTodos() {
        return destinatarioRepository.findAll();
    }

    @Override
    public Destinatario buscarPorId(Long id) {
        return destinatarioRepository.findById(id).orElse(null);
    }

    @Override
    public void registrarEntrega(Destinatario destinatario) {
        salvarDestinatarioComCep(destinatario);
    }

    @Override
    public void atualizarEntrega(Long id, Destinatario destinatario) {
        Optional<Destinatario> existente = destinatarioRepository.findById(id);
        if (existente.isPresent()) {
            salvarDestinatarioComCep(destinatario);
        }
    }

    @Override
    public void cancelarEntrega(Long id) {
        destinatarioRepository.deleteById(id);
    }

    // Patrón FACADE: Encapsulamos la complejidad de buscar el CEP
    private void salvarDestinatarioComCep(Destinatario destinatario) {
        // 1. Recuperamos el CEP que viene del JSON
        String cep = destinatario.getLocalizacao().getCep();

        // 2. Buscamos si ya existe en nuestra base de datos local
        Localizacao localizacao = localizacaoRepository.findById(cep).orElseGet(() -> {
            // 3. Si NO existe, consultamos a la API externa (ViaCEP)
            Localizacao nova = viaCepService.consultarCep(cep);
            // 4. Guardamos la nueva dirección en nuestra BD para cachearla
            localizacaoRepository.save(nova);
            return nova;
        });

        // 5. Asignamos la dirección completa al destinatario y guardamos
        destinatario.setLocalizacao(localizacao);
        destinatarioRepository.save(destinatario);
    }
}