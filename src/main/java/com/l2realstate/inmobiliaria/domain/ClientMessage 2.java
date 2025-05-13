package com.l2realstate.inmobiliaria.domain;

import java.time.LocalDateTime;

public class ClientMessage {

    private int idClientMessage;
    private String message;

    private int operationId;

    private LocalDateTime clientMessageDate;

    public int getIdClientMessage() {
        return idClientMessage;
    }

    public void setIdClientMessage(int idClientMessage) {
        this.idClientMessage = idClientMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public LocalDateTime getClientMessageDate() {
        return clientMessageDate;
    }

    public void setClientMessageDate(LocalDateTime clientMessageDate) {
        this.clientMessageDate = clientMessageDate;
    }
}
