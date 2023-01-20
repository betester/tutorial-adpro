package id.ac.ui.cs.advprog.tutorial0.exception;

public class DuplicateStudentNameException extends RuntimeException{
    public DuplicateStudentNameException(String studentName) {
        super(String.format("The student name %s is a duplicate" , studentName));
    }
}
