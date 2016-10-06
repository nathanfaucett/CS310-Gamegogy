package edu.jsu.mcis.gamegogy;

public class Database {
    
    
    public Database() {
        
    }
    
    public Student getStudent(String ID) {
        String[] info = {"","","",""};
        Student student = new Student(info);
        
        return student;
    }
    
    public Course getCourse(String ID) {
        String[] info = {"","","",""};
        Course course = new Course(info);
        
        return course;
    }
}