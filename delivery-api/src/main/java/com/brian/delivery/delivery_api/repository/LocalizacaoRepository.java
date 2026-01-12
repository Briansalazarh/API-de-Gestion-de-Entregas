package com.brian.delivery.delivery_api.repository;

import com.brian.delivery.delivery_api.model.Localizacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizacaoRepository extends CrudRepository<Localizacao, String> {
    // CRUD básico para direcciones
}