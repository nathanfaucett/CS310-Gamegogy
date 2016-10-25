package edu.jsu.mcis.gamegogy;

import java.util.*;

public class CourseGrades {
    private Map<String, Map<String, Float>> assignments;
    private String[] header;
    
    public CourseGrades(List<String[]> list) {
        assignments = new HashMap<String, Map<String, Float>>();
        String[] array = list.get(0);
        header = new String[array.length-1];
        String[] info;
        for(int i = 1; i < array.length; i++) {
            Map<String, Float> studentInfo = new HashMap<String, Float>();
            for(int j = 1; j < list.size(); j++) {
                info = list.get(j);
                String studentId = info[0];
                studentInfo.put(studentId, Float.parseFloat(info[i]));
            }
            header[i-1] = array[i];
            assignments.put(array[i],studentInfo);
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
        
        while(list.size() >= 1) {
            highest = list.remove(list.size()-1);
            Set<Map.Entry<String, Float>> set = assignmentInfo.entrySet();
            Map.Entry<String, Float>[] array = new Map.Entry[set.size()];
            array = set.toArray(array);
            for(int i = 0; i < array.length; i++) {
                if(highest == array[i].getValue()) { id = array[i].getKey(); }
            }
            String[] info = {id, "" + highest};
            infoList.add(info);
        }
        
        
        return infoList;
    }
}