package edu.jsu.mcis.gamegogy;

public class Course {
    private String ID;
    private String Semester;
    private String Year;
    private String Enrolled;
    
    public Course(String[] info) {
        ID = info[0];
        Semester = info[1];
        Year = info[2];
        Enrolled = info[3];
    }
    
    public String getID() { return ID; }    
    public String getSemester() { return Semester; }    
    public String getYear() { return Year; }    
    public String getEnrolled() { return Enrolled; }
}