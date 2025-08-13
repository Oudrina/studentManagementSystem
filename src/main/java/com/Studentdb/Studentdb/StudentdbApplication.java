package com.Studentdb.Studentdb;

import com.Studentdb.Studentdb.Model.Course;
import com.Studentdb.Studentdb.Model.Registration;
import com.Studentdb.Studentdb.Model.Student;
import com.Studentdb.Studentdb.Repository.CourseRepository;
import com.Studentdb.Studentdb.Repository.RegistrationRepository;
import com.Studentdb.Studentdb.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentdbApplication.class, args);
    }

}



