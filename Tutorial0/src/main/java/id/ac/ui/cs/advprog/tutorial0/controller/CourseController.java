package id.ac.ui.cs.advprog.tutorial0.controller;


import id.ac.ui.cs.advprog.tutorial0.model.Course;
import id.ac.ui.cs.advprog.tutorial0.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/list")
    public String courseListPage(Model model) {
        List<Course> allCourse = service.findAll();
        model.addAttribute("courses", allCourse);
        return "courseList";
    }

    @GetMapping("/create")
    public String createCoursePage(Model model){
        Course course = new Course();
        model.addAttribute("course", course);
        return "createCourse";
    }

    @PostMapping("/create")
    public String createCoursePost(@ModelAttribute Course course, Model model) {
        service.create(course);
        return "redirect:list";
    }
}
