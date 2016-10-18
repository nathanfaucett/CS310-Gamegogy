package edu.jsu.mcis.gamegogy;

public class Gamegogy {
    private Database d = new Database();

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
    /*
    public static void main(String[] args) {
        Gamegogy g = new Gamegogy();
        if (args.length < 1) {
            System.exit(0);
        }else{
            if ((args[0].equals("student")) && (args.length > 1)) {
                Student pulledStudent = (Student)g.findByID(args[0], args[1]);
                if (pulledStudent != null) {
                    System.out.println(pulledStudent.toString());
                }
            }else if(args[0].equals("course")&& (args.length > 1)){
                Course pulledCourse = (Course)g.findByID(args[0], args[1]);
                if (pulledCourse != null) {
                    System.out.println(pulledCourse.toString());
                }
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
	*/
}
