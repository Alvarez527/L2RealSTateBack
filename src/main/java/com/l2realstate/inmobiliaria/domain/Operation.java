package com.l2realstate.inmobiliaria.domain;

import java.util.List;

public class Operation {

    private int operationId;

    private int propertyId;

    private String operationType;

    private int customerId;

    private int salesPersonId;

    private Customer customer;

    private SalesPerson salesPerson;

    private Property property;

    private List<ClientMessage> clientMessageList;

    private List<SalesPersonMessage> salesPersonMessageList;



    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<ClientMessage> getClientMessageList() {
        return clientMessageList;
    }

    public void setClientMessageList(List<ClientMessage> clientMessageList) {
        this.clientMessageList = clientMessageList;
    }

    public List<SalesPersonMessage> getSalesPersonMessageList() {
        return salesPersonMessageList;
    }

    public void setSalesPersonMessageList(List<SalesPersonMessage> salesPersonMessageList) {
        this.salesPersonMessageList = salesPersonMessageList;
    }


}

