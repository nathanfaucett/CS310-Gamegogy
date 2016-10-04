package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        File file = new File("src/main/java/resources/courses.csv");
        System.out.println(Gamegogy.findID(file, "99000"));
    }
}
