package id.ac.ui.cs.advprog.tutorial0.service;

import id.ac.ui.cs.advprog.tutorial0.exception.DuplicateStudentNameException;
import id.ac.ui.cs.advprog.tutorial0.model.Student;
import id.ac.ui.cs.advprog.tutorial0.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student student) {
        validateName(student);
        generateNPM(student);
        studentRepository.create(student);
        return student;
    }

    private void validateName(Student student) {
        List<Student> allStudent = findAll();
        for (Student dbStudent : allStudent) {
            if (dbStudent.getName().equals(student.getName())) {
                throw new DuplicateStudentNameException(student.getName());
            }
        }
    }

    private void generateNPM(Student student) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char letter : student.getName().toCharArray()) {
            stringBuilder.append(String.valueOf((int) letter));
        }

        String npm = stringBuilder.toString();
        student.setNpm(npm);
    }

    @Override
    public List<Student> findAll() {
        Iterator<Student> studentIterator = studentRepository.findAll();
        List<Student> allStudent = new ArrayList<>();
        studentIterator.forEachRemaining(allStudent::add);
        return allStudent;
    }
}
