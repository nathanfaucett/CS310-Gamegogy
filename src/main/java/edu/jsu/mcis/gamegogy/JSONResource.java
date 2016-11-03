package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class JSONResource implements Resource {
    List<String[]> studentInfo;
    List<String[]> courseInfo;
    List<List<String[]>> gradeInfo;
    
    public JSONResource() {
        studentInfo = new ArrayList<>(); 
        courseInfo = new ArrayList<>(); 
        gradeInfo = new ArrayList<>();
        
        load();
    }
    
    private void load() {
        loadStudents();
        loadCourses();
    }
    
    private void loadStudents() {
        studentInfo = JSONWebservice.getStudent();
    }
    
    private void loadCourses() {
        courseInfo = JSONWebservice.getCourse();
        gradeInfo = JSONWebservice.getGrades();
    }
    
    public List<String[]> getStudentInfo() { return studentInfo; }
    public List<String[]> getCourseInfo() { return courseInfo; }
    public List<String[]> getGradeInfo(int index) { return gradeInfo.get(index); }
}