package id.ac.ui.cs.advprog.tutorial0.controller;

import id.ac.ui.cs.advprog.tutorial0.exception.DuplicateStudentNameException;
import id.ac.ui.cs.advprog.tutorial0.model.Student;
import id.ac.ui.cs.advprog.tutorial0.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/list")
    public String studentListPage(Model model) {
        List<Student> allStudent = service.findAll();
        model.addAttribute("students", allStudent);
        return "studentList";
    }

    @GetMapping("/create")
    public String createStudentPage(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "createStudent";
    }

    @PostMapping("/create")
    public String createStudentPost (@ModelAttribute Student student, Model model) {
        try {
            service.create(student);
        }
        catch (DuplicateStudentNameException e) {
            model.addAttribute("error", e);
            model.addAttribute("student", student);
            return "createStudent";
        }
        return "redirect:list";
    }

}


