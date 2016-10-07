package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class Database {
    HashMap<String, Course> courses;
    HashMap<String, Student> students;
    
    public Database() {
        courses = new HashMap<String, Course>();
        students = new HashMap<String, Student>();
        
        List<String[]> studentList = CSV.fileReader(new File("src/main/java/resources/students.csv"));
        List<String[]> courseList = CSV.fileReader(new File("src/main/java/resources/courses.csv"));
        
        String[] info;
        
        for(int i = 0; i < studentList.size(); i++) {
            info = studentList.get(i);
            students.put(info[0], new Student(info));
        }
        
        for(int i = 0; i < courseList.size(); i++) {
            info = courseList.get(i);
            courses.put(info[0], new Course(info));
        }
    }
    
    public int[] returnMapSize() {
        int[] array = {students.size(), courses.size()};
        return array;
    }
    
    public Student getStudent(String ID) {
        return students.get(ID);
    }
    
    public Course getCourse(String ID) {
        return courses.get(ID);
    }
}