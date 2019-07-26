package Homework2_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phonebook {
    Map<Integer, String> phonebook;

    Phonebook() {
        phonebook = new HashMap<>();
    }

    public void add(String surname, int phone) {
        phonebook.put(phone, surname);
    }

    public void get(String surname) {
        if (phonebook.containsValue(surname)) {
            Set<Map.Entry<Integer, String>> set = phonebook.entrySet();
            for (Map.Entry<Integer, String> temp : set) {
                if (temp.getValue().equals(surname)) {
                    System.out.println(temp.getValue() + ": " + temp.getKey());
                }
            }
        }
    }
}
