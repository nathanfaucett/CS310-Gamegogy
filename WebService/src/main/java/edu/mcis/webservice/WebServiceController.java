package edu.jsu.mcis.webservice;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import edu.jsu.mcis.gamegogy.*;


@RestController
public class WebServiceController {
    private Database database = new Database(new CSVResource());

    @RequestMapping("/studentlist")
    public String[] studentlist() {
        Student[] array = database.getAllStudents();
        String[] ids = new String[array.length];
        for(int i = 0; i < array.length; i++) {
            ids[i] = array[i].getID();
        }
		return ids;
    }

    @RequestMapping("/courselist")
    public String[] courselist() {
        Course[] array = database.getAllCourses();
        String[] ids = new String[array.length];
        for(int i = 0; i < array.length; i++) {
            ids[i] = array[i].getID();
        }
		return ids;
    }

    @RequestMapping("/student/{id}")
    public Student getstudent(@PathVariable(value = "id") String id) {
        return database.getStudent(id);
    }

    @RequestMapping("/course/{id}")
    public CourseJSON getcourse(@PathVariable(value = "id") String id) {
        return new CourseJSON(database.getCourse(id), database.getGrades(id));
    }

    public class CourseJSON {
        private String id, term, year;
        private int size;
        private GradesJSON grades;

        public CourseJSON(Course course, CourseGrades g) {
            id = course.getID();
            term = course.getSemester();
            year = course.getYear();
            size = Integer.parseInt(course.getEnrolled());
            grades = new GradesJSON(g);
        }

        public String getID() { return id; }
        public String getTerm() { return term; }
        public String getYear() { return year; }
        public int getSize() { return size; }
        public GradesJSON getGrades() { return grades; }
    }

    public class GradesJSON {
        private String[] colHeaders, rowHeaders;
        private float[][] data;

        public GradesJSON(CourseGrades g) {
            colHeaders = g.getAssignments();
            List<String[]> list = g.getAll(colHeaders[0]);
            rowHeaders = new String[list.size()];
            for(int i = 0; i < list.size(); i++) {
                rowHeaders[i] = list.get(i)[0];
            }
            data = new float[rowHeaders.length][colHeaders.length];
            for(int i = 0; i < rowHeaders.length; i++) {
                for(int j = 0; j < colHeaders.length; j++) {
                    data[i][j] = Float.parseFloat(g.getGrades(rowHeaders[i], colHeaders[j]));
                }
            }
        }

        public String[] getColHeaders() { return colHeaders; }
        public String[] getRowHeaders() { return rowHeaders; }
        public float[][] getData() { return data; }
    }
}
