package com.Studentdb.Studentdb.Service;

import com.Studentdb.Studentdb.Model.Course;
import com.Studentdb.Studentdb.Model.Registration;
import com.Studentdb.Studentdb.Model.Student;
import com.Studentdb.Studentdb.Repository.CourseRepository;
import com.Studentdb.Studentdb.Repository.RegistrationRepository;
import com.Studentdb.Studentdb.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public void studentCourse(Long studentId, List<Long> courseIds) {
        Student student = studentRepository.findById(studentId).orElseThrow();

        for (Long courseId : courseIds) {
            Course course = courseRepository.findById(courseId).orElseThrow();
            Registration registration = new Registration();
            registration.setCourse(course);
            registration.setStudent(student);

            registrationRepository.save(registration);

        }
    }


    public Registration saveStudent(Registration registration){
        return   registrationRepository.save(registration);
    }


    public void save(Registration registration) {

        registrationRepository.save(registration);
    }
}
