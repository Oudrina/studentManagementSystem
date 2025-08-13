package com.Studentdb.Studentdb.Controller;

import com.Studentdb.Studentdb.Model.Admin;
import com.Studentdb.Studentdb.Model.Course;
import com.Studentdb.Studentdb.Model.Department;
import com.Studentdb.Studentdb.Model.Student;
import com.Studentdb.Studentdb.Repository.CourseRepository;
import com.Studentdb.Studentdb.Repository.DepartmentRepository;
import com.Studentdb.Studentdb.Repository.StudentRepository;
import com.Studentdb.Studentdb.Service.CourseService;
import com.Studentdb.Studentdb.Service.DepartmentService;
import com.Studentdb.Studentdb.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminConntroller {

    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/register")
    public String showAdminSignup(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "adminsignup";
    }

    @PostMapping("/registered")
    public String showAdminSign(Model model, Admin admin) {
        model.addAttribute("admin", admin);
        return "admindashboard";
    }

    @GetMapping("/login")
    public String showAdminLogin(Model model) {
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "adminlogin";
    }

    //    username.equals("admin") &&
    @PostMapping("/login")
    public String processAdminLogin(
            @RequestParam String email,
            @RequestParam String password,
            ModelMap model) {

        if (email.equals("admin@gmail.com") && password.equals("password1234")) {
            return "redirect:/admin/dashboard?view=students";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "adminlogin";
        }

    }

    @GetMapping("/dashboard")
    public String allDashboard(@RequestParam(required = false, defaultValue = "students") String view,
                               Model model) {

        model.addAttribute("view", view);

        // Shared totals for the cards
        model.addAttribute("totalCourse", courseRepo.count());
        model.addAttribute("totalStudent", studentRepository.count());
        model.addAttribute("totalDepartment", departmentRepo.count());

        // Load just the selected section
        switch (view) {
            case "courses" -> model.addAttribute("courses", courseService.allCourses());
            case "departments" -> model.addAttribute("departments", departmentRepo.findAll());
            default -> model.addAttribute("students", studentService.students());
        }

        return "admindashboard";
    }

    @GetMapping("/createCourse")
    public String createCourse(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "createcourse";
    }

    @GetMapping("/createDepartment")
    public String createDepartment(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "addDepartment";
    }

    @PostMapping("/saveCourse")
    public String saveCourse(Model model, @ModelAttribute("course") Course course) {
        model.addAttribute("course", course);
        courseService.saveCourse(course);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(Model model, @ModelAttribute("department") Department department) {
        model.addAttribute("department", department);
        departmentService.saveCourse(department);
        return "redirect:/admin/dashboard";
    }
}
