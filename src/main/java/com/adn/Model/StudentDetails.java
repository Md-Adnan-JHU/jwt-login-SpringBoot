package com.adn.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackRefrence;

import javax.persistence.*;

@Entity
public class StudentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "st_phone_number")
    private long phone;

    @Column(name = "st_email_id")
    private String email;

    @Column(name = "st_course")
    private String course;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "studentDetails")
    @JsonIgnore
    @JsonBackReference
    private Student student;


    public StudentDetails() { }

    public StudentDetails(int id, long phone, String email, String course, Student student) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.course = course;
        this.student = student;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
