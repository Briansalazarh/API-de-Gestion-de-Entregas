package com.brian.delivery.delivery_api.service;

import com.brian.delivery.delivery_api.model.Localizacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Cliente HTTP que consume la API de ViaCEP
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    // Mapeamos la respuesta JSON a nuestro objeto Localizacao
    @GetMapping("/{cep}/json/")
    Localizacao consultarCep(@PathVariable("cep") String cep);
}