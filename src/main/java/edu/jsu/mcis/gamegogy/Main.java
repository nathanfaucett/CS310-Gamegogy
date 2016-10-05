package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        File courses = new File("src/main/java/resources/courses.csv");
        File students = new File("src/main/java/resources/students.csv");
        
        System.out.println(Gamegogy.findID(courses, "99000"));
        System.out.println(Gamegogy.findID(students, "111111"));
    }
}
