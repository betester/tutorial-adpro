package id.ac.ui.cs.advprog.tutorial0.repository;

import id.ac.ui.cs.advprog.tutorial0.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courseInMemory = new ArrayList<>();

    public Course create(Course course) {
        courseInMemory.add(course);
        return course;
    }

    public Iterator<Course> findAll() {
        return courseInMemory.iterator();
    }
}
