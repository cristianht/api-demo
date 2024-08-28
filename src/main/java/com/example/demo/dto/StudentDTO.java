package com.example.demo.dto;

import com.example.demo.entity.Student;

import javax.validation.constraints.Digits;

public class StudentDTO {

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Boolean active;

    public Student toEntity() {
        Student entity = new Student();

        entity.setFirstname(this.firstname);
        entity.setLastname(this.lastname);
        entity.setEmail(this.email);
        entity.setPhone(this.phone);
        entity.setActive(this.active);

        return entity;
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
