package com.Studentdb.Studentdb.Service;

import com.Studentdb.Studentdb.Model.Department;
import com.Studentdb.Studentdb.Model.Student;
import com.Studentdb.Studentdb.Repository.DepartmentRepository;
import com.Studentdb.Studentdb.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> students() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.findByStudentId(studentId).get();
    }


}
