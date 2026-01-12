package com.brian.delivery.delivery_api.repository;

import com.brian.delivery.delivery_api.model.Destinatario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinatarioRepository extends CrudRepository<Destinatario, Long> {
    // CRUD básico ya implementado por Spring
}