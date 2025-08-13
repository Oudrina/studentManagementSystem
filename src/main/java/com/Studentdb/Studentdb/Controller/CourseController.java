package com.Studentdb.Studentdb.Controller;

import com.Studentdb.Studentdb.Model.Course;
import com.Studentdb.Studentdb.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class CourseController {

    @Autowired
    private CourseService courseService;
    @GetMapping("/createCourse")
    public  String  createCourse(Model model ){
        Course course = new Course();
        model.addAttribute("course",course);
        return "createcourse";
    }


    @PostMapping("/saveCourse")
    public  String saveCourse(Model model , @ModelAttribute("course") Course course){
        model.addAttribute("course",course);
        courseService.saveCourse(course);
        return "admin";
    }
}
