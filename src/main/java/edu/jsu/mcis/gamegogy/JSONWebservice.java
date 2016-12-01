package edu.jsu.mcis.gamegogy;

import java.io.*;
import java.util.*;
import org.json.*;

public class JSONWebservice {

    public static List<String[]> getStudent() {
        String idList = Connection.createConnection("studentlist");
        JSONArray ids = new JSONArray(idList);
        List<String[]> list = new ArrayList<>();

        for(Object id : ids) {
            String student = Connection.createConnection("student/" + id);
            JSONObject obj = new JSONObject(student);
            String[] array = {obj.getString("id"), obj.getString("first"),
                              obj.getString("last"), obj.getString("email")};
            list.add(array);
        }
        return list;
    }

    public static List<String[]> getCourse() {
        String idList = Connection.createConnection("courselist");
        JSONArray ids = new JSONArray(idList);
        List<String[]> list = new ArrayList<>();

        for(Object id : ids) {
            String course = Connection.createConnection("course/" + id);
            JSONObject obj = new JSONObject(course);
            String[] array = {obj.getString("id"), obj.getString("term"),
                              obj.getString("year"), "" + obj.getInt("size")};
            list.add(array);
        }
        return list;
    }

    public static List<List<String[]>> getGrades() {
        String idList = Connection.createConnection("courselist");
        JSONArray ids = new JSONArray(idList);
        List<List<String[]>> grades = new ArrayList<>();

        for(Object id : ids) {
            List<String[]> list = new ArrayList<>();
            String course = Connection.createConnection("course/" + id);
            JSONObject temp = new JSONObject(course);
            JSONObject obj = temp.getJSONObject("grades");

            JSONArray headerTemp = obj.getJSONArray("colHeaders");
            JSONArray idTemp = obj.getJSONArray("rowHeaders");
            JSONArray dataTemp = obj.getJSONArray("data");

            String[] header = new String[headerTemp.length()];
            int k = 0;
            for(Object col : headerTemp) {
                header[k++] = "" + col;
            }
            list.add(header);

            for(int i = 0; i < idTemp.length(); i++) {
                JSONArray subTemp = dataTemp.getJSONArray(i);
                String[] data = new String[subTemp.length()+1];
                data[0] = idTemp.getString(i);
                for(int j = 0; j < subTemp.length(); j++) {
                    data[j+1] = "" + subTemp.getDouble(j);
                }
                list.add(data);
            }
            grades.add(list);
        }
        return grades;
    }

}
