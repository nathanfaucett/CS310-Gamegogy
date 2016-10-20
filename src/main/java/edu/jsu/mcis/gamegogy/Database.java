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
        
        for(int i = 1; i < studentList.size(); i++) {
            info = studentList.get(i);
            students.put(info[0], new Student(info));
        }
        
        for(int i = 1; i < courseList.size(); i++) {
            info = courseList.get(i);
            courses.put(info[0], new Course(info));
            /*
                TODO: load grades into course object
            */
        }
    }
    
    public int[] returnMapSize() {
        int[] array = {students.size(), courses.size()};
        return array;
    }
    
    public Student getStudent(String id) {
        return students.get(id);
    }
    
    public Course getCourse(String id) {
        return courses.get(id);
    }
    
    public Student[] getAllStudents() {
        Student[] array = new Student[students.size()];
        Collection<Student> coll = students.values();
        List<Student> list = new ArrayList<>(coll);
        Collections.sort(list);
        array = list.toArray(array);
        return array;
    }
    
    public Course[] getAllCourses() {
        Course[] array = new Course[courses.size()];
        Collection<Course> coll = courses.values();
        List<Course> list = new ArrayList<>(coll);
        Collections.sort(list);
        array = list.toArray(array);
        return array;
    }
}