package com.addresbook;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.Vector;

/**
 * Created by Jeonghoon Lee on 2017-04-15.
 */
public class JRead {


    public static Vector<Person> readPerson() {

        JSONParser parser = new JSONParser();
        Vector<Person> persons = new Vector<Person>();
        String path = JRead.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
        String personFile = path + "entry.json";

        try {
            // person이라는 key값의 JSONArray를 불러온다.
            Object object = parser.parse(new FileReader(personFile));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray personArray = (JSONArray) jsonObject.get("person");

            // personArray에 담겨 있는 JSONObect들을 객체로 만들어 벡터에 담는다.
            for (int i = 0; i < personArray.size(); i++) {

                JSONObject personObject = (JSONObject) personArray.get(i);
                String name = (String) personObject.get("name");
                String number = (String) personObject.get("number");
                String email = (String) personObject.get("email");

                Person newPerson = new Person(name, number, email);

                persons.add(newPerson);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        // Person 객체들이 담긴 벡터를 리턴한다.
        return persons;
    }

    public static Vector<Call> readCall() {

        JSONParser parser = new JSONParser();
        Vector<Call> calls = new Vector<Call>();

        String path = JRead.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
        String dataFile = path + "data.json";

        try {
            // call이라는 key값의 JSONArray를 불러온다.
            Object object = parser.parse(new FileReader(dataFile));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray callArray = (JSONArray) jsonObject.get("call");

            // callArray에 담겨 있는 JSONObect들을 객체로 만들어 벡터에 담는다.
            for (int i = 0; i < callArray.size(); i++) {

                JSONObject callObject = (JSONObject) callArray.get(i);
                String time = (String) callObject.get("time");
                String number = (String) callObject.get("number");
                String duration = (String) callObject.get("duration");
                String status = (String) callObject.get("status");

                Call newCall = new Call(time, number, duration, status);

                calls.add(newCall);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return calls;
    }

    public static Vector<Sms> readSms() {

        JSONParser parser = new JSONParser();
        Vector<Sms> msgs = new Vector<Sms>();

        String path = JRead.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
        String dataFile = path + "data.json";

        try {
            // sms이라는 key값의 JSONArray를 불러온다.
            Object object = parser.parse(new FileReader(dataFile));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray smsArray = (JSONArray) jsonObject.get("sms");

            // smsArray에 담겨 있는 JSONObect들을 객체로 만들어 벡터에 담는다.
            for (int i = 0; i < smsArray.size(); i++) {

                JSONObject smsObject = (JSONObject) smsArray.get(i);
                String time = (String) smsObject.get("time");
                String number = (String) smsObject.get("number");
                String text = (String) smsObject.get("text");
                String status = (String) smsObject.get("status");

                Sms newMsg = new Sms(time, number, text, status);

                msgs.add(newMsg);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        return msgs;
    }
}
