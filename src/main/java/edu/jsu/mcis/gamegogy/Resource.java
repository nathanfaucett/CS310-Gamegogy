package edu.jsu.mcis.gamegogy;

import java.util.*;

public interface Resource {
    public List<String[]> getStudentInfo();
    public List<String[]> getCourseInfo();
    public List<String[]> getGradeInfo(int index);
}