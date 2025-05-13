package com.l2realstate.inmobiliaria.domain.repository;

import com.l2realstate.inmobiliaria.domain.ClientMessage;

import java.util.List;
import java.util.Optional;

public interface ClientMessageRepository {

    public List<ClientMessage> getAll();
    public Optional<List<ClientMessage>> getByOperation(int operationId);
    public Optional<ClientMessage> getClientMessage(int idClientMessage);

    public ClientMessage saveClientMessage(ClientMessage clientMessage);

    public void deleteClientMessage(int idClientMessage);

}

