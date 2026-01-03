package com.payilgam.CrudOperations.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name= "user_details")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "user_id")
    @GenericGenerator(name = "user_id", strategy = "com.payilgam.CrudOperations.entity.UserIdGenerator")
    @Column(name="user_id", updatable = false, nullable = false)
    private String id;


    @Column(name= "user_name", nullable = false)
    @NotBlank(message = "Name cannot be blank")

    private String name;
    @Column(name= "user_email",nullable = false)
    @Email(message = "Email should be valid")
    private String email;

    @Column(name="user_gender", nullable = false)
    @NotBlank(message = "gender cannot be blank")
    @Pattern(regexp = "male|female", message = "Gender must be either 'male' or 'female'")

    private String gender;

    public UserEntity() {
    }

    public UserEntity( String name, String email, String gender) {

        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
