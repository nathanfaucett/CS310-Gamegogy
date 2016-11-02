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
        normalize();
    }
    
    private void loadStudents() {
        /* *move to JSONWebservice*
        String studentList = Connection.createConnection("studentlist");
        JSONArray ids = JSON.makeArray(studentList)
        for(String id : ids) {
            JSONString student = Connection.createConnection("student/" + id);
            String[] array = JSON.getStudent(student);
            studentInfo.add(array);
        }
        */
    }
    
    private void loadCourses() {
        
    }
    
    private void normalize() {
        
    }
    
    public List<String[]> getStudentInfo() { return studentInfo; }
    public List<String[]> getCourseInfo() { return courseInfo; }
    public List<String[]> getGradeInfo(int index) { return gradeInfo.get(index); }
}