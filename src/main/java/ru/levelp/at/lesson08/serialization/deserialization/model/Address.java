package ru.levelp.at.lesson08.serialization.deserialization.model;

import java.io.Serializable;

public class Address implements Serializable {

    private String addressLine1;    // улица
    private String addressLine2;    // дом
    private String city;

    public Address(String addressLine1, String addressLine2, String city) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{"
            + "addressLine1='" + addressLine1 + '\''
            + ", addressLine2='" + addressLine2 + '\''
            + ", city='" + city + '\''
            + '}';
    }
}
