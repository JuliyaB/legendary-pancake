import java.util.*;

public class Homework2_3 {
    public static void main(String[] args){
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Город");
        arrayList.add("Море");
        arrayList.add("Лес");
        arrayList.add("Небо");
        arrayList.add("Море");
        arrayList.add("Солнце");
        arrayList.add("Птица");
        arrayList.add("Корабль");
        arrayList.add("Город");
        arrayList.add("Небо");
        arrayList.add("Небо");
        arrayList.add("Машина");
        arrayList.add("Природа");
        Set<String> set = new HashSet<>(arrayList);
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        for (String word : arrayList) {
            if(!word.equals(arrayList)) {
                Integer count = map.get(word);
                if(count == null) {
                    count = 0;
                }
                map.put(word, ++count);
            }
        }
        for(String word : map.keySet()) {
            System.out.println(word + ": " + map.get(word));
        }

        Phonebook phonebook=new Phonebook();
        phonebook.add("Пушкин", 899456322);
        phonebook.add("Лермонтов", 899456111);
        phonebook.add("Пушкин", 822244455);
        phonebook.add("Достоевский", 888856111);
        phonebook.get("Пушкин");
        phonebook.get("Достоевский");
    }
}
