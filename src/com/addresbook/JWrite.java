package com.addresbook;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Jeonghoon Lee on 2017-04-15.
 */
public class JWrite {
    //public static void main(String[] args) {

    public static void savePerson(Vector<Person> entry) {

        JSONObject entryObject = new JSONObject();
        JSONArray entryList = new JSONArray();

        for (int i = 0; i < entry.size(); i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", entry.get(i).getName_());
            jsonObject.put("number", entry.get(i).getNumber_());
            jsonObject.put("email", entry.get(i).getEmail_());

            entryList.add(jsonObject);

        }

        entryObject.put("person", entryList);

        try {
            FileWriter fileWriter = new FileWriter("/Users/seoyulim/IdeaProjects/OODP_term2/entry.json");
            fileWriter.write(entryObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(entryObject);
    }

}
