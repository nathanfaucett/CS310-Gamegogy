package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class CourseGrades {
    private Map<String, Map<String, Integer>> assignments;
    
    public CourseGrades(List<String[]> list) {
        assignments = new HashMap<String, Map<String, Integer>>();
        String[] header = list.get(0);
        String[] info;
        for(int i = 1; i < header.length; i++) {
            Map<String, Integer> studentInfo = new HashMap<String, Integer>();
            for(int j = 1; j < list.size(); j++) {
                info = list.get(j);
                String studentId = info[0];
                studentInfo.put(studentId, Integer.parseInt(info[i]));
            }
            assignments.put(header[i],studentInfo);
        }
        
    }
    
    public String getGrades(String student, String assignment) {
        Map<String, Integer> assignmentInfo = new HashMap<String, Integer>();
        assignmentInfo = assignments.get(assignment);
        int grade = assignmentInfo.get(student);
        return "" + grade;
    }
    
    public String[] getHighest(String assignment) {
        Map<String, Integer> assignmentInfo = new HashMap<String, Integer>();
        assignmentInfo = assignments.get(assignment);
        String id = "";
        int highest = 0;
        
        
        Collection<Integer> coll = assignmentInfo.values();
        List<Integer> list = new ArrayList<>(coll);
        Collections.sort(list);
        highest = list.get(list.size()-1);
        Set<Map.Entry<String, Integer>> set = assignmentInfo.entrySet();
        Map.Entry<String, Integer>[] array = new Map.Entry[set.size()];
        array = set.toArray(array);
        for(int i = 0; i < array.length; i++) {
            if(highest == array[i].getValue()) { id = array[i].getKey(); }
        }
        
        String[] info = {id, "" + highest};
        return info;
    }
}