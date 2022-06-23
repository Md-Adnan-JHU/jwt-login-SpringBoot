package com.adn.Service;

import com.adn.Model.Student;
import com.adn.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveAll(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student get(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student update(int id, Student student) {
        Student student1 = studentRepository.findById(id)
                .orElse(null);

        student1.setName(student.getName());
        student1.setDepartment(student.getDepartment());
        return studentRepository.save(student1);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
