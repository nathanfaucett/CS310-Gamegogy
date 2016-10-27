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
}
