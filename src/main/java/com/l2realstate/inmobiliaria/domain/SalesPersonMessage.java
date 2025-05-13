package com.l2realstate.inmobiliaria.domain;

import java.time.LocalDateTime;

public class SalesPersonMessage {

    private int idSalesPersonMessage;
    private String salesPersonMessage;

    private int operationId;

    private LocalDateTime salesPersonMessageDate;

    public int getIdSalesPersonMessage() {
        return idSalesPersonMessage;
    }

    public void setIdSalesPersonMessage(int idSalesPersonMessage) {
        this.idSalesPersonMessage = idSalesPersonMessage;
    }

    public String getSalesPersonMessage() {
        return salesPersonMessage;
    }

    public void setSalesPersonMessage(String salesPersonMessage) {
        this.salesPersonMessage = salesPersonMessage;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public LocalDateTime getSalesPersonMessageDate() {
        return salesPersonMessageDate;
    }

    public void setSalesPersonMessageDate(LocalDateTime salesPersonMessageDate) {
        this.salesPersonMessageDate = salesPersonMessageDate;
    }
}
