package edu.jsu.mcis.gamegogy;

public class Gamegogy {
    static Database d = new Database();

    public static Object findByID(String type, String id) {
        if (type.equals("student")) {
            Student studentObj = d.getStudent(id);
            return studentObj;
        }else if (type.equals("course")){
            Course courseObj = d.getCourse(id);
            return courseObj;
        }
        return null;
    }
    /*
    public Object[] findAll(String type){
        if (type.equals("student")) {
            Student[] studentObjects = d.getAllStudents();
            return studentObjects;
        }else if (type.equals("course")){
            Course[] courseObjects = d.getAllCourses();
            return courseObjects;
        }
        return null;
    }
    */
    
    public String toString(Student item){
        String output = "";
        output += item.getID();
        output += item.getFirstName();
        output += item.getLastName();
        output += item.getEmail() + "@jsu.edu";
        return output;   
    }
    
    public String toString(Course item){
        String output = "";
        output += item.getID();
        output += item.getSemester();
        output += item.getYear();
        output += "(" +item.getEnrolled() + " students)";
        return output;   
    }
    

    public static void main(String[] args) {
       if ((args[0].equals("student")) || (args[0].equals("course"))) {
            System.out.println(findByID(args[0], args[1]).toString());
        } else {
            System.exit(0);
        }
    }
}
