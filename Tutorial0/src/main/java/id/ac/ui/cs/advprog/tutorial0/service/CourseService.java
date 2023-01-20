package id.ac.ui.cs.advprog.tutorial0.service;

import id.ac.ui.cs.advprog.tutorial0.model.Course;

import java.util.List;

public interface CourseService {
    public Course create(Course course);
    public List<Course> findAll();
}
