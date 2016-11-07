package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;
import au.com.bytecode.opencsv.*;

public class CSVlocal {
    
    //reconfigure to run on strings instead of files
    public static List<String[]> fileReader(String fileName) {
        CSVParser parser = new CSVParser();
        List<String[]> record = new ArrayList<>();
        
        try {
            BufferedReader bufReader = findFile(fileName);
            String line;

            while ((line = bufReader.readLine()) != null ) {
                String[] lineData = parser.parseLine(line);
                
                record.add(lineData);
            }
            
            return record;
            
        } catch(Exception ex) {
            //ex.printStackTrace();
        }
        return record;
    }
    
    
    private static BufferedReader findFile(String fileName) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        StringBuffer csvContents = new StringBuffer();
        InputStream stream = loader.getResourceAsStream(fileName);
        if (stream == null) {
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader;
    }
}