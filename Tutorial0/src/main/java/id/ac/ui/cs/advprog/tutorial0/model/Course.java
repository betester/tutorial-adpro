package id.ac.ui.cs.advprog.tutorial0.model;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Course {
    private String courseId;
    private String name;
    private boolean status = true;
}
