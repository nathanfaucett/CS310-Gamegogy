package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class Database {
    private Map<String, Course> courses;
    private Map<String, Student> students;
    
    
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
    
    public Student[] getAllStudents() {
        Student[] array = new Student[students.size()];
        int initial = 111111;
        
        for(int i = 0; i < array.length; i++) {
            array[i] = getStudent("" + (initial + i));
        }
        
        return array;
    }
    
    public Course[] getAllCourses() {
        Course[] array = new Course[courses.size()];
        int initial = 99000;
        
        for(int i = 0; i < array.length; i++) {
            array[i] = getCourse("" + (initial + i));
        }
        
        return array;
    }
}