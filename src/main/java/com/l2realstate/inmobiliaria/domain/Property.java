package com.l2realstate.inmobiliaria.domain;

import java.util.List;

public class Property {

    private int propertyId;

    private Double price;

    private int years;

    private Double area;

    private Double constructionSize;

    private int rooms;

    private int restrooms;

    private int halfRestroom;

    private int parkingLots;

    private String description;

    private int propertyTypeId;

    private int stateId;

    private int residentialId;

    private int cityId;

    private PropertyType propertyType;

    private City city;

    private State state;

    private Residential residential;

    private List<Operation> operationList;

    private List<PropertiesService> propertiesServices;


    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getConstructionSize() {
        return constructionSize;
    }

    public void setConstructionSize(Double constructionSize) {
        this.constructionSize = constructionSize;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRestrooms() {
        return restrooms;
    }

    public void setRestrooms(int restrooms) {
        this.restrooms = restrooms;
    }

    public int getHalfRestroom() {
        return halfRestroom;
    }

    public void setHalfRestroom(int halfRestroom) {
        this.halfRestroom = halfRestroom;
    }

    public int getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(int parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(int propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getResidentialId() {
        return residentialId;
    }

    public void setResidentialId(int residentialId) {
        this.residentialId = residentialId;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Residential getResidential() {
        return residential;
    }

    public void setResidential(Residential residential) {
        this.residential = residential;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public List<PropertiesService> getPropertiesServices() {
        return propertiesServices;
    }

    public void setPropertiesServices(List<PropertiesService> propertiesServices) {
        this.propertiesServices = propertiesServices;
    }
}


