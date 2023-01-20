package id.ac.ui.cs.advprog.tutorial0.repository;

import id.ac.ui.cs.advprog.tutorial0.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentInMemory = new ArrayList<>();

    public Student create(Student student) {
        studentInMemory.add(student);
        return student;
    }

    public Iterator<Student> findAll(){
        return studentInMemory.iterator();
    }
}
