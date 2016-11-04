package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class CSVResource implements Resource {
    List<String[]> studentInfo;
    List<String[]> courseInfo;
    List<List<String[]>> gradeInfo;
    
    public CSVResource() {
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
    
    private void loadStudents() { //need to un hard code later
        studentInfo = CSVlocal.fileReader("students.csv");
    }
    
    private void loadCourses() {
        courseInfo = CSVlocal.fileReader("courses.csv");
        for(int i = 1; i < courseInfo.size(); i++) {
            String[] info = courseInfo.get(i);
            List<String[]> list = CSVlocal.fileReader("courses/" + info[0] + ".csv");
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
    
    public List<String[]> getStudentInfo() { return studentInfo; }
    public List<String[]> getCourseInfo() { return courseInfo; }
    public List<String[]> getGradeInfo(int index) { return gradeInfo.get(index); }
}