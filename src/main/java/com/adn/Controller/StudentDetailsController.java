package com.adn.Controller;

import com.adn.Model.Student;
import com.adn.Model.StudentDetails;
import com.adn.Service.StudentDetailsService;
import com.adn.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentDetailsController {

    @Autowired
    StudentDetailsService studentService;

    @PostMapping("/studentDetail")
    public StudentDetails addStudentDetail(@RequestBody StudentDetails student) {
        return studentService.save(student);
    }

    @PostMapping("/studentDetails")
    public List<StudentDetails> addStudentDetails(@RequestBody  List<StudentDetails> students) {
        return studentService.saveAll(students);
    }

    @GetMapping("/studentDetail/{id}")
    public StudentDetails retrieveStudentDetailsById(@PathVariable("id") int id) {
        return studentService.get(id);
    }

    @GetMapping("/studentDetails")
    public List<StudentDetails> retrieveStudentDetails() {
        return studentService.getAll();
    }

    @PutMapping("studentDetail/{id}")
    public StudentDetails updateStudentDetails(@PathVariable int id, @RequestBody StudentDetails student) {
        return studentService.update(id, student);
    }

    @DeleteMapping("/studentDetail/{id}")
    public String deleteStudentDetailsById(@PathVariable(name = "id") int id){
        studentService.deleteById(id);
        return "Student Details Deleted with Student ID : "+id;
    }
}
