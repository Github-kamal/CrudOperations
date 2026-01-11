package com.payilgam.CrudOperations.pojo;

public class AcademicsPojo {

    private Long employeeId;
    private String degree;
    private String university;
    private Integer yearOfPassing;
    private Double percentage;

    public AcademicsPojo() {
    }

    public AcademicsPojo(Long employeeId, String degree, String university, Integer yearOfPassing, Double percentage) {
        this.employeeId = employeeId;
        this.degree = degree;
        this.university = university;
        this.yearOfPassing = yearOfPassing;
        this.percentage = percentage;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(Integer yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}