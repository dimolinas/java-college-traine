package model;

import java.util.ArrayList;
import java.util.UUID;

public class Course {
    private UUID uuid;
    private String name;
    private String classRoom;
    private Professor professor;
    private ArrayList<Student> students;
}
