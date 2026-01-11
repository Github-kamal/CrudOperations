package com.payilgam.CrudOperations.pojo;

public class EmpAddressPojo {

    private Long id;          // Optional if you want to track address IDs
    private String street;
    private String city;
    private String state;
    private String zipcode;   // Use String to avoid null→int mapping issues

    // Default constructor
    public EmpAddressPojo() {}

    // Parameterized constructor
    public EmpAddressPojo(Long id, String street, String city, String state, String zipcode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "EmpAddressPojo{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}