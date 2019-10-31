package com.ceiba.citas_medicas.domain.persistence;

import com.ceiba.citas_medicas.domain.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientPersistence {

    Client save(Client client);

    void delete(Client client);

    List<Client> findAll();

    Optional<Client> find(Long id);

    Optional<Client> findByDocumentNumber(String documentNumber);
}
