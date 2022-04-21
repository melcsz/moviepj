package com.example.moviepj.persistance.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "first name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name is mandatory")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "email is mandatory")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank(message = "password is mandatory")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "age is mandatory")
    @Column(name = "age")
    private Integer age;

    @NotBlank(message = "city is mandatory")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "country is mandatory")
    @Column(name = "country")
    private String country;

    public UserEntity(Long id, String firstName, String lastName, String email, String password,
                      Integer age, String city, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setStreet(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
