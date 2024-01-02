package com.dreamhomes.dreamhomes.models;

public class Address {
    private int addressId;
    private final String address1;
    private final String address2;
    private final String address3;
    private final String city;
    private final String state;
    private final String country;
    private final int postalCode;

    public Address(String address1, String address2, String address3, String city, String state, String country, int postalCode) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public Address(int addressId, String address1, String address2, String address3, String city, String state, String country, int postalCode) {
        this.addressId = addressId;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPostalCode() {
        return postalCode;
    }
}
