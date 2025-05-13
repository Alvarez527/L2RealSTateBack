package com.l2realstate.inmobiliaria.domain.service;

import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.domain.repository.ClientMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientMessageService {

    @Autowired
    private ClientMessageRepository clientMessageRepository;

    public List<ClientMessage> getAll(){

        return clientMessageRepository.getAll();
    }

    public Optional<ClientMessage> getClientMessage(int idClientMessage){

        return clientMessageRepository.getClientMessage(idClientMessage);
    }

    public Optional<List<ClientMessage>> getMessagesByOperation(int operationId){

        return clientMessageRepository.getByOperation(operationId);
    }


    public ClientMessage saveMessage(ClientMessage clientMessage){

        return clientMessageRepository.saveClientMessage(clientMessage);
    }

    public boolean deleteMessage(int idClientMessage){

        if(clientMessageRepository.getClientMessage(idClientMessage).isPresent()){

            clientMessageRepository.deleteClientMessage(idClientMessage);
            return true;
        }else{

            return false;
        }

    }


}
