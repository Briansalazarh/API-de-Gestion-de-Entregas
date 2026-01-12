package com.brian.delivery.delivery_api.service;

import com.brian.delivery.delivery_api.model.Destinatario;

// Definimos la estrategia de negocio
public interface EntregaService {
    Iterable<Destinatario> buscarTodos();

    Destinatario buscarPorId(Long id);

    void registrarEntrega(Destinatario destinatario);

    void atualizarEntrega(Long id, Destinatario destinatario);

    void cancelarEntrega(Long id);
}