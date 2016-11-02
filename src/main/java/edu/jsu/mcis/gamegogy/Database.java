package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class Database {
    private Map<String, Course> courses;
    private Map<String, Student> students;
    private Map<String, CourseGrades> courseGrades;
    
    
    public Database() {
        courses = new HashMap<String, Course>();
        students = new HashMap<String, Student>();
        courseGrades = new HashMap<String, CourseGrades>();
        
        Resource resource = new CSVResource();
        
        List<String[]> studentList = resource.getStudentInfo();
        List<String[]> courseList = resource.getCourseInfo();
        
        String[] info;
        
        for(int i = 0; i < studentList.size(); i++) {
            info = studentList.get(i);
            students.put(info[0], new Student(info));
        }
        
        for(int i = 0; i < courseList.size(); i++) {
            info = courseList.get(i);
            courses.put(info[0], new Course(info));
            List<String[]> gradesList = resource.getGradeInfo(i);
            courseGrades.put(info[0], new CourseGrades(gradesList));
        }
    }
    
    public Student getStudent(String id) {
        return students.get(id);
    }
    
    public Course getCourse(String id) {
        return courses.get(id);
    }
    
    public CourseGrades getGrades(String id) {
        return courseGrades.get(id);
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