package com.addresbook;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Jeonghoon Lee on 2017-04-15.
 */
public class JRead {
    //public static Vector<Person> readPerson(String[] args) {
    public static void main(String[] args) {

        JSONParser parser = new JSONParser();
        Vector<Person> persons = new Vector<Person>();

        try {
            Object object = parser.parse(new FileReader("/Users/seoyulim/IdeaProjects/OODP_term2/data.json"));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray personArray = (JSONArray) jsonObject.get("person");

            for (int i = 0; i < personArray.size(); i++) {

                JSONObject personObject = (JSONObject) personArray.get(i);
                String name = (String) personObject.get("name");
                String number = (String) personObject.get("number");
                String email = (String) personObject.get("email");

                Person newPerson = new Person(name, number, email);

                persons.add(newPerson);

                System.out.println(name);
                System.out.println(number);
            }

            /*
            JSONArray msg = (JSONArray)jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();

            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        // return persons;
    }

    public static Vector<Call> readCall() {

        JSONParser parser = new JSONParser();
        Vector<Call> calls = new Vector<Call>();

        try {
            Object object = parser.parse(new FileReader("/Users/seoyulim/IdeaProjects/OODP_term2/data.json"));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray callArray = (JSONArray) jsonObject.get("call");

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

        try {
            Object object = parser.parse(new FileReader("/Users/seoyulim/IdeaProjects/OODP_term2/data.json"));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray smsArray = (JSONArray) jsonObject.get("sms");

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
