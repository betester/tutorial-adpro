package id.ac.ui.cs.advprog.tutorial0.service;

import id.ac.ui.cs.advprog.tutorial0.model.Student;


import java.util.List;

public interface StudentService {
    public Student create(Student student);
    public List<Student> findAll();

}
