package com.l2realstate.inmobiliaria.persistence;

import com.l2realstate.inmobiliaria.domain.ClientMessage;
import com.l2realstate.inmobiliaria.domain.repository.ClientMessageRepository;
import com.l2realstate.inmobiliaria.persistence.crud.MensajeClienteCrudRepository;
import com.l2realstate.inmobiliaria.persistence.entity.MensajeCliente;
import com.l2realstate.inmobiliaria.persistence.mapper.ClientMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajeClienteRepository implements ClientMessageRepository {

    @Autowired
    private MensajeClienteCrudRepository    mensajeClienteCrudRepository;
    @Autowired
    private ClientMessageMapper clientMessageMapper;




    @Override
    public List<ClientMessage> getAll() {

        List<MensajeCliente> mensajesCliente = (List<MensajeCliente>) mensajeClienteCrudRepository.findAll();
        return clientMessageMapper.toClientsMessage(mensajesCliente);
    }

    @Override
    public Optional<List<ClientMessage>> getByOperation(int operationId) {

        return mensajeClienteCrudRepository.findByIdOperacionOrderByFechaMClienteAsc(operationId).map
                (a -> clientMessageMapper.toClientsMessage(a));
    }

    @Override
    public Optional<ClientMessage> getClientMessage(int idClientMessage) {
        Optional<MensajeCliente> mensajeCliente=  mensajeClienteCrudRepository.findById(idClientMessage);
        return mensajeCliente.map(message -> clientMessageMapper.toClientMessage(message)); //Convirtiendo a Client Message
    }

    @Override
    public ClientMessage saveClientMessage(ClientMessage clientMessage) {
        MensajeCliente mensajeCliente = clientMessageMapper.toMensajeCliente(clientMessage);
        return clientMessageMapper.toClientMessage(mensajeClienteCrudRepository.save(mensajeCliente));
    }

    @Override
    public void deleteClientMessage(int idClientMessage) {

        mensajeClienteCrudRepository.deleteById(idClientMessage);

    }
}
