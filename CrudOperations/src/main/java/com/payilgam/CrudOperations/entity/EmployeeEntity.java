package com.payilgam.CrudOperations.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "emp_details")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated numeric ID
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "emp_department", nullable = false)
    private String department;

    @Column(name = "emp_salary", nullable = false)
    private Double salary;

    // One-to-One mapping with EmpAddressEntity
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private EmpAddressEntity address;

    @OneToMany(mappedBy = "employeeEntity", cascade = CascadeType.ALL)
    private List<EmpAcademics> academics;
    // Constructors
    public EmployeeEntity() {}

    public EmployeeEntity(Long id, String name, String department, Double salary, EmpAddressEntity address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }

    public EmpAddressEntity getAddress() { return address; }
    public void setAddress(EmpAddressEntity address) { this.address = address; }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}