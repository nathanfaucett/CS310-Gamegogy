package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class Resource {
    List<String[]> studentInfo;
    List<String[]> courseInfo;
    List<List<String[]>> gradeInfo;
    
    public Resource() {
        this("JSON");
    }
    
    public Resource(String s) {
        studentInfo = new ArrayList<>(); 
        courseInfo = new ArrayList<>(); 
        gradeInfo = new ArrayList<>();
        
        if(s.equals("JSON")) {
            loadFromJSON();
        }
        else if(s.equals("CSV")) {
            loadFromCSV();
        }
    }
    
    private void loadFromCSV() {
        loadStudentsCSV();
        loadCoursesCSV();
        normalize();
    }
    
    private void loadStudentsCSV() {
        studentInfo = CSV.fileReader(new File("src/main/java/resources/students.csv"));
    }
    
    private void loadCoursesCSV() {
        courseInfo = CSV.fileReader(new File("src/main/java/resources/courses.csv"));
        for(int i = 1; i < courseInfo.size(); i++) {
            String[] info = courseInfo.get(i);
            List<String[]> list = CSV.fileReader(new File("src/main/java/resources/courses/" + info[0] + ".csv"));
            gradeInfo.add(list);
        }
    }
    
    private void normalize() {
        studentInfo.remove(0);
        courseInfo.remove(0);
        for(int i = 0; i < gradeInfo.size(); i++) {
            List<String[]> tempList = gradeInfo.remove(i);
            String[] temp = tempList.remove(0);
            String[] headerArray = new String[temp.length-1];
            for(int j = 1; j < temp.length; j++) {
                headerArray[j-1] = temp[j];
            }
            tempList.add(0, headerArray);
            gradeInfo.add(i, tempList);
        }
    }
    
    private void loadFromJSON() {
        loadStudentsJSON();
        loadCoursesJSON();
    }
    
    private void loadStudentsJSON() {
        
    }
    
    private void loadCoursesJSON() {
        
    }
    
    public List<String[]> getStudentInfo() { return studentInfo; }
    public List<String[]> getCourseInfo() { return courseInfo; }
    public List<String[]> getGradeInfo(int index) { return gradeInfo.get(index); }
}