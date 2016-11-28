package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class CourseGrades {
    private Map<String, Map<String, Float>> assignments;
    private String[] header;
    
    public CourseGrades(List<String[]> list) {
        assignments = new HashMap<String, Map<String, Float>>();
        header = list.get(0);
        String[] info;
        for(int i = 0; i < header.length; i++) {
            Map<String, Float> studentInfo = new HashMap<String, Float>();
            for(int j = 1; j < list.size(); j++) {
                info = list.get(j);
                String studentId = info[0];
                studentInfo.put(studentId, Float.parseFloat(info[i+1]));
            }
            assignments.put(header[i],studentInfo);
        }
        
    }
    
    public String[] getAssignments() {
        return header;
    }
    
    public String getGrades(String student, String assignment) {
        Map<String, Float> assignmentInfo = new HashMap<String, Float>();
        assignmentInfo = assignments.get(assignment);
        float grade = assignmentInfo.get(student);
        return "" + grade;
    }
    
    @SuppressWarnings("unchecked") 
    public String[] getHighest(String assignment) {
        Map<String, Float> assignmentInfo = new HashMap<String, Float>();
        assignmentInfo = assignments.get(assignment);
        String id = "";
        float highest = 0;
        
        
        Collection<Float> coll = assignmentInfo.values();
        List<Float> list = new ArrayList<>(coll);
        Collections.sort(list);
        highest = list.get(list.size()-1);
        Set<Map.Entry<String, Float>> set = assignmentInfo.entrySet();
        Map.Entry<String, Float>[] array = new Map.Entry[set.size()];
        array = set.toArray(array);
        for(int i = 0; i < array.length; i++) {
            if(highest == array[i].getValue()) { id = array[i].getKey(); }
        }
        
        String[] info = {id, "" + highest};
        return info;
    }
    
    public List<String[]> getAll(String assignment) {
        Map<String, Float> assignmentInfo = new HashMap<String, Float>();
        assignmentInfo = assignments.get(assignment);
        String id = "";
        float highest = 0;
        List<String[]> infoList = new ArrayList<>();
        
        
        Collection<Float> coll = assignmentInfo.values();
        List<Float> list = new ArrayList<>(coll);
        Collections.sort(list);
        
        Set<Map.Entry<String, Float>> set = assignmentInfo.entrySet();
        List<Map.Entry<String, Float>> mapList = new ArrayList<>(set);
        
        while(list.size() >= 1) {
            highest = list.remove(list.size()-1);
            int index = 0;
            for(int i = 0; i < mapList.size(); i++) {
                if(highest == mapList.get(i).getValue()) {
                    index = i;
                }
            }
            Map.Entry<String, Float> ME = mapList.get(index);
            String[] info = {ME.getKey(), "" + highest};
            infoList.add(info);
            mapList.remove(index);
        }
        
        
        return infoList;
    }
}