package com.example.demo.entity;

import com.example.demo.dto.StudentDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String firstname;
    @Column(length = 30, nullable = false)
    private String lastname;
    @Column(length = 30, nullable = false)
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(nullable = false)
    private Boolean active;

    public StudentDTO toDTO() {
        StudentDTO dto = new StudentDTO();
        dto.setFirstname(this.firstname);
        dto.setLastname(this.lastname);
        dto.setEmail(this.email);
        dto.setPhone(this.phone);
        dto.setActive(this.active);
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
