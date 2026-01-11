package com.payilgam.CrudOperations.pojo;

public class EmployeePojo {

    private Long id;              // Use wrapper type to allow null
    private String name;
    private String department;
    private Double salary;
    private EmpAddressPojo address; // Nested address object

    // Default constructor
    public EmployeePojo() {}

    // Parameterized constructor
    public EmployeePojo(Long id, String name, String department, Double salary, EmpAddressPojo address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmpAddressPojo getAddress() {
        return address;
    }
    public void setAddress(EmpAddressPojo address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "EmployeePojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }
}