package com.printhouse.orderField.domain.client;

import javax.persistence.Embeddable;

@Embeddable
public class Address{

    private String street;

    private String town;

    private String country;

    private String postcode;

    public Address(){

    }

    Address(String street, String town, String country, String postcode) {
        this.street = street;
        this.town = town;
        this.country = country;
        this.postcode = postcode;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }
}
