package com.Studentdb.Studentdb.Controller;

import com.Studentdb.Studentdb.Model.Course;
import com.Studentdb.Studentdb.Model.Registration;
import com.Studentdb.Studentdb.Model.Student;
import com.Studentdb.Studentdb.Repository.CourseRepository;
import com.Studentdb.Studentdb.Repository.RegistrationRepository;
import com.Studentdb.Studentdb.Repository.StudentRepository;
import com.Studentdb.Studentdb.Service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private RegistrationRepository registrationRepository;
  @Autowired
     private CourseRepository courseRepository;

     @Autowired
     private StudentService studentService;


    @GetMapping("/login")
    public String showLoginForm(Model model) {

        return "signIn";
    }

    @PostMapping("/logged")
    public String login(
            @RequestParam Long studentId,
            @RequestParam String password,
            HttpSession session, Model model) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);


        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();

            if (student.getStudentPassword().equals(password)) {
                List<Registration> registrations = registrationRepository.findByStudent(student);


                model.addAttribute("student", student);
                model.addAttribute("registrations", registrations);



                return "studentDashboard";
            }
        }

        model.addAttribute("error", "Invalid credentials");
        return "signIn"; // go back to login page on failure
    }




}


