package com.adn.Controller;

import com.adn.Model.Student;
import com.adn.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PostMapping("/students")
    public List<Student> addStudents(@RequestBody  List<Student> students) {
         return studentService.saveAll(students);
    }

    @PutMapping("student/{id}")
    public Student updateStudent(@PathVariable(name = "id") int id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    @GetMapping("/student/{id}")
    public Student retrieveStudentsById(@PathVariable(name = "id") int id) {
        return studentService.get(id);
    }

    @GetMapping("/students")
    public List<Student> retrieveStudents() {
        return studentService.getAll();
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable(name = "id") int id){
        studentService.deleteById(id);
        return "Student Deleted with Student ID : "+id;
    }
}

