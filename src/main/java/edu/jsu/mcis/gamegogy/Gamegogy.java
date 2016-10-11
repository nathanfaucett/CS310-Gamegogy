package edu.jsu.mcis.gamegogy;

public class Gamegogy {
    Database d = new Database();

    public Object findByID(String type, String id) {
        if (type.equals("student")) {
            Student studentObj = d.getStudent(id);
            return studentObj;
        }else if (type.equals("course")){
            Course courseObj = d.getCourse(id);
            return courseObj;
        }
        return null;
    }

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

    public String toString(Student item){
        String output = "";
        output += "[" + item.getID() + "] ";
        output += item.getFirstName() + " ";
        output += item.getLastName() + " ";
        output += item.getEmail() + "@jsu.edu";
        return output;
    }

    public String toString(Course item){
        String output = "";
        output += "[" + item.getID() + "] ";
        output += item.getSemester() + " ";
        output += item.getYear() + " ";
        output += "(" +item.getEnrolled() + " students)";
        return output;
    }


    public static void main(String[] args) {
       Gamegogy g = new Gamegogy();

        if ((args[0].equals("student")) && (args.length > 1)) {
            Student pulledStudent = (Student)g.findByID(args[0], args[1]);
            System.out.println(g.toString(pulledStudent));
        }else if(args[0].equals("course")&& (args.length > 1)){
            Course pulledCourse = (Course)g.findByID(args[0], args[1]);
            System.out.println(g.toString(pulledCourse));
        }else if(args[0].equals("studentids")){
            Student[] pulledStudentIds = (Student[]) g.findAll("student");
            for(int i = 0; i < pulledStudentIds.length; i++){
                System.out.println(pulledStudentIds[i].getID());
            }
        }else if(args[0].equals("courseids")){
            Course[] pulledCourseIds = (Course[]) g.findAll("course");
            for(int i = 0; i < pulledCourseIds.length; i++){
                System.out.println(pulledCourseIds[i].getID());
            }
        }else{
            System.exit(0);
        }
    }
}
