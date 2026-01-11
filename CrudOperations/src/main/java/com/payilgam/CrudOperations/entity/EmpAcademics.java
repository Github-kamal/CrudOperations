package com.payilgam.CrudOperations.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emp_academic_details")
public class EmpAcademics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "degree")
    private String degree;
    @Column(name = "university")
    private String university;
    @Column(name = "year_of_passing")
    private int yearOfPassing;
    @Column(name = "percentage")
    private double percentage;


    @JoinColumn(name= "emp_id")
    @ManyToOne
    private EmployeeEntity employeeEntity;

    // Getters and Setters

    @Override
    public String toString() {
        return "EmpAcademics{" +
                "id=" + id +
                ", degree='" + degree + '\'' +
                ", university='" + university + '\'' +
                ", yearOfPassing=" + yearOfPassing +
                ", percentage=" + percentage +
                ", employeeEntity=" + employeeEntity +
                '}';
    }

    public EmpAcademics() {
    }

    public EmpAcademics(int id, EmployeeEntity employeeEntity, double percentage, int yearOfPassing, String university, String degree) {
        this.id = id;
        this.employeeEntity = employeeEntity;
        this.percentage = percentage;
        this.yearOfPassing = yearOfPassing;
        this.university = university;
        this.degree = degree;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(int yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
