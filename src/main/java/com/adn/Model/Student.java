package com.adn.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_department")
    private String department;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnore
    private StudentDetails studentDetails;

    public Student() { }

    public Student(int id, String name, String department, StudentDetails studentDetails) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.studentDetails = studentDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public StudentDetails getStudentDetails() { return studentDetails; }

    public void setStudentDetails(StudentDetails studentDetails) { this.studentDetails = studentDetails; }
}
