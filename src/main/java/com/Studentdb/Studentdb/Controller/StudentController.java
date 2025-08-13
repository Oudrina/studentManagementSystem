package com.Studentdb.Studentdb.Controller;

import com.Studentdb.Studentdb.Model.Course;
import com.Studentdb.Studentdb.Model.Department;
import com.Studentdb.Studentdb.Model.Registration;
import com.Studentdb.Studentdb.Model.Student;
import com.Studentdb.Studentdb.Repository.CourseRepository;
import com.Studentdb.Studentdb.Repository.DepartmentRepository;
import com.Studentdb.Studentdb.Repository.RegistrationRepository;
import com.Studentdb.Studentdb.Repository.StudentRepository;
import com.Studentdb.Studentdb.Service.RegistrationService;
import com.Studentdb.Studentdb.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    public DepartmentRepository departmentRepository;

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    RegistrationRepository registrationRepository;
    private Registration registration;


    @GetMapping("/register")
    public String Register(Model model, Student student) {
        Registration registration1 = new Registration();
        registration1.setStudent(new Student());
//        student.setDepartment(new Department());
        model.addAttribute("student", student);
        model.addAttribute("department", departmentRepository.findAll());
        model.addAttribute("registration", registration1);
        return "signup";
    }


    @PostMapping("/registered")
    public String createRegistration(@ModelAttribute Registration registration) {
        // Extract student from registration
        Student student = registration.getStudent();

        // Fetch department from DB using the id bound by the form
        Long deptId = student.getDepartment().getId();
        Department dept = departmentRepository.findById(deptId).orElseThrow();

        // Replace department reference with the fully-loaded one
        student.setDepartment(dept);

        // Save student and registration
        studentService.saveStudent(student);
        registration.setStudent(student);
        registrationService.save(registration);

        return "studentDashboard";
    }


}
