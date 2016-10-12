package edu.jsu.mcis.gamegogy;

public class Course {
    private String id;
    private String semester;
    private String year;
    private String enrolled;
    
    public Course(String idInfo, String semesterInfo, String yearInfo, String enrolledInfo) {
        id = idInfo;
        semester = semesterInfo;
        year = yearInfo;
        enrolled = enrolledInfo;
    }

    public Course(String[] info) {
        id = info[0];
        semester = info[1];
        year = info[2];
        enrolled = info[3];
    }

    public String getID() { return id; }
    public String getSemester() { return semester; }
    public String getYear() { return year; }
    public String getEnrolled() { return enrolled; }

    public String toString(){
        String output = "";
        output += "[" + id + "] ";
        output += semester + " ";
        output += year + " ";
        output += "(" + enrolled + " students)";
        return output;
    }
}
