package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;

public class Gamegogy {
    
    public static String findID(String type, String id) {
        List<String[]> list = CSV.fileReader(file);
        String[] array;
        
        for(int i =0; i < list.size(); i++) {
            array = list.get(i);
            if(id.equals(array[0])) {
                String string = "[" + array[0] + "]";
                for(int j = 1; j < array.length; j++) {
                    string += " " + array[j];
                }
                return string;
            }
        }
        return null;
    }
    
    
    
}