package Tasks2;

import java.util.*;

public class WorkingWithStrings {
    static LinkedList<Character> firstList;
    static LinkedList<Character> secondList;

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String first =scanner.nextLine();
        String second =scanner.nextLine();
        System.out.println(isOneEditAway(first, second));

    }

    public static boolean isOneEditAway(String first, String second){
        firstList=new LinkedList<Character>();
        secondList=new LinkedList<Character>();

        for (Character character:first.toCharArray()) firstList.add(character);
        for (Character character:second.toCharArray()) secondList.add(character);

        if (first.equals(second)){return false;}
        if (first.equals("")||second.equals("")){
            return false;
        }

        if (first.length()==second.length()){
            int count=0;
            for (int i=0; i<first.length(); i++){
                if (first.charAt(i)!=second.charAt(i)){
                    count++;
                }
            }
            if (count==1){
                return true;
            }else {
                return false;
            }

        }else if (first.length()-second.length()==1){
            ArrayList<Integer> positions=new ArrayList<Integer>();

            for (int i=0; i<first.length(); i++){
                if (Collections.frequency(firstList, firstList.get(i))!=Collections.frequency(secondList, secondList.get(i)));
            }
        }




            if (first.length()!=second.length()){

        }else if(first.equals(null) && second.equals(null)){
            return true;
        }

    }
}
