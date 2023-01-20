package id.ac.ui.cs.advprog.tutorial0.service;

import id.ac.ui.cs.advprog.tutorial0.model.Course;
import id.ac.ui.cs.advprog.tutorial0.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course create(Course course) {
        generateId(course);
        courseRepository.create(course);
        return course;
    }

    private void generateId(Course course) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : course.getName().toCharArray()) {
            stringBuilder.append(String.valueOf((int) letter));
        }

        String courseId = stringBuilder.toString();
        course.setCourseId(courseId);
    }

    @Override
    public List<Course> findAll() {
        Iterator<Course> courseIterator = courseRepository.findAll();
        List<Course> allCourses = new ArrayList<>();
        courseIterator.forEachRemaining(allCourses::add);
        return allCourses;
    }

}
