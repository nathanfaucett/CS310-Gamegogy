package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;
import au.com.bytecode.opencsv.*;

public class CSVlocal {

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
        }
        return record;
    }


    private static BufferedReader findFile(String fileName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader;
    }
}
