package com.adn.Service;

import com.adn.Model.StudentDetails;
import com.adn.Repository.StudentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailsService {

    @Autowired
    StudentDetailsRepository studentRepository;

    public StudentDetails save(StudentDetails student) {
        return studentRepository.save(student);
    }

    public List<StudentDetails> saveAll(List<StudentDetails> students) {
        return studentRepository.saveAll(students);
    }

    public StudentDetails get(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentDetails> getAll() {
        return studentRepository.findAll();
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public StudentDetails update(int id, StudentDetails student) {
        StudentDetails details = studentRepository.findById(id).orElse(null);
        details.setPhone(student.getPhone());
        details.setEmail(student.getEmail());
        details.setCourse(student.getCourse());
        return studentRepository.save(details);
    }
}
