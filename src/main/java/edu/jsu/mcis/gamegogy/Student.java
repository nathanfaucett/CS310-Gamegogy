package edu.jsu.mcis.gamegogy;

public class Student {
    private String ID;
    private String FirstName;
    private String LastName;
    private String Email;
    
    public Student(String[] info) {
        ID = info[0];
        FirstName = info[1];
        LastName = info[2];
        Email = info[3];
    }
    
    public String getID() { return ID; }    
    public String getFirstName() { return FirstName; }    
    public String getLastName() { return LastName; }    
    public String getEmail() { return Email; }
}