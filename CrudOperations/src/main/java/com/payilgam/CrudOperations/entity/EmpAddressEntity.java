package com.payilgam.CrudOperations.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_address_details")
public class EmpAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipcode;

    // Bidirectional mapping (optional)
    @OneToOne(mappedBy = "address")
    private EmployeeEntity employee;

    // Constructors
    public EmpAddressEntity() {}

    public EmpAddressEntity(Long id, String street, String city, String state, String zipcode) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public EmployeeEntity getEmployee() { return employee; }
    public void setEmployee(EmployeeEntity employee) { this.employee = employee; }

    @Override
    public String toString() {
        return "EmpAddressEntity{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}