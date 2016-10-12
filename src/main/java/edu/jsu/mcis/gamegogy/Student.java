package edu.jsu.mcis.gamegogy;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    
    public Student(String idInfo, String firstNameInfo, String lastNameInfo, String emailInfo) {
        id = idInfo;
        firstName = firstNameInfo;
        lastName = lastNameInfo;
        email = emailInfo;
    }

    public Student(String[] info) {
        id = info[0];
        firstName = info[1];
        lastName = info[2];
        email = info[3];
    }
    
    public String getID() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    public String toString(){
        String output = "";
        output += "[" + id + "] ";
        output += firstName + " ";
        output += lastName + " ";
        output += email + "@jsu.edu";
        return output;
    }
}
