package edu.jsu.mcis.gamegogy;

public class Student implements Comparable<Student> {
    private String id;
    private String first;
    private String last;
    private String email;
    
    public Student(String idInfo, String firstNameInfo, String lastNameInfo, String emailInfo) {
        id = idInfo;
        first = firstNameInfo;
        last = lastNameInfo;
        email = emailInfo;
    }

    public Student(String[] info) {
        id = info[0];
        first = info[1];
        last = info[2];
        email = info[3];
    }
    
    public String getID() { return id; }
    public String getFirstName() { return first; }
    public String getLastName() { return last; }
    public String getEmail() { return email; }

    public String toString(){
        String output = "";
        output += "[" + id + "] ";
        output += first + " ";
        output += last + " ";
        output += email + "@jsu.edu";
        return output;
    }
    
    @Override
    public int compareTo(Student otherStudent) {
        int thisID = Integer.parseInt(id);
        int otherID = Integer.parseInt(otherStudent.getID());
        if(thisID < otherID) {
            return -1;
        }
        else if(thisID > otherID) {
            return 1;
        }
        else { return 0; }
    }
}
