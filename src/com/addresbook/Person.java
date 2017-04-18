package com.addresbook;


import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;

/**
 * Created by USER on 2017-04-15.
 */
public class Person {

    // Constructor
    Person () { }

    // Constructor overloading
    Person (String name, String number, String email) {
        this.name_ = name;
        this.number_ =  number;
        this.email_ = email;
    }

    // getters
    public String getName_() {
        return name_;
    }

    public String getNumber_() {
        return number_;
    }

    public String getEmail_() {
        return email_;
    }


    // 벡터에 담긴 Person 객체들을 이름을 기준으로 오름차순으로 정렬한다.
    public static Vector<Person> sortEntry (Vector<Person> entry) {
        Collections.sort(entry, new PersonComparator());

        return entry;
    }

    // 벡터에 담긴 Person 객체 중 인자로 받아온 이름값과 일치하는 객체를 찾는다.
    public static Person findPersonByName (Vector<Person> entry, String name) {
        int left = 0;
        int right = entry.size() - 1;
        Person p = new Person();

        // 이진 탐색으로 찾기!
        while (left <= right) {
            int mid = (left + right) / 2;
            if (entry.elementAt(mid).getName_().equals(name)) {
                p = entry.elementAt(mid);
                return p;

            } else if (entry.elementAt(mid).getName_().compareTo(name) < 0) {
                left = mid + 1;
            } else if (entry.elementAt(mid).getName_().compareTo(name) > 0) {
                right = mid - 1;
            }
        }

        return null;
    }

    // 벡터에 담긴 Person 객체 중 인자로 받아온 이름값과 일치하는 객체를 지워준다.
    public static Vector<Person> deleteByName (Vector<Person> entry, String name) {
        Person p = new Person();
        p = findPersonByName(entry, name);

        if (p != null) {
            entry.removeElement(p);
            return entry;
        } else
            return null;


    }

    // Person 객체를 정렬할 때 비교하기 위해 사용
    static class PersonComparator implements Comparator<Person> {
        public int compare (Person left, Person right) {
            return left.getName_().compareTo(right.getName_());
        }
    }

    // 해쉬 맵은 키 값에 매칭해서 바로 value를 가져오는 구조이다. 그러므로 시간복잡도는 상수이다.
    public static HashMap<String, Person> createNumberMap(Vector<Person> entry) {
        HashMap<String, Person> numberMap = new HashMap<String, Person>();
        for (int i = 0; i < entry.size(); i++) {
            numberMap.put(entry.elementAt(i).getNumber_(), entry.elementAt(i));
        }

        return numberMap;
    }

    private String name_;
    private String number_;
    private String email_;
}


