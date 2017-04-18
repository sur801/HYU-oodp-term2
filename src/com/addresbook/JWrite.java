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

        // 벡터에 담겨있는 Person 객체들을 JSONArray에 담는다.
        for (int i = 0; i < entry.size(); i++) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", entry.get(i).getName_());
            jsonObject.put("number", entry.get(i).getNumber_());
            jsonObject.put("email", entry.get(i).getEmail_());

            entryList.add(jsonObject);

        }

        // key값을 "person"으로 하고 value를 entryList로 하는 JSONObject를 만든다.
        entryObject.put("person", entryList);

        String path = JRead.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
        String personFile = path + "entry.json";

        // 파일에 JSONObject를 쓴다.
        try {
            FileWriter fileWriter = new FileWriter(personFile);
            fileWriter.write(entryObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
