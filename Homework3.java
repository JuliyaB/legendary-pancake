import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Java. Lesson3. My Homework3.
 *
 * @author Juliya
 * @version dated 1.06.2019
 */
public class Homework3 {

    public static void main(String[] args) {

        int m = getNumber("Если вы хотите поиграть в игру откадай цифру нажмите 1\nЕсли вы хотите поиграть в игру откадай слово нажмите 2", 1, 2);
        if (m == 1) {
            Game();
        }else {
            Word();
        }
    }

    static void Game() {
        Random random = new Random();
        int start = 1;
        while (start == 1) {
            System.out.println("Программа загадала число от 0 до 9.\nВам дается 3 попытки, что бы угадать это число.");
            int x = random.nextInt(10);
            //System.out.println(x);
            int y = getNumber("Введите число: ", 0, 9);
            for (int i = 0; i < 2; i++) {
                if (x == y) {
                    break;
                } else {
                    if (y > x) {
                        System.out.println("Введнное вами число больше заданного.");
                    } else {
                        System.out.println("Введнное вами число меньше заданного.");
                    }
                }
                y = getNumber("Введите число: ", 0, 9);
            }
            if (x != y) {
                System.out.println("Вы проиграли!");
            } else {
                System.out.println("Вы выйграли!");
            }
            int n = getNumber("Повторить игру еще раз? 1 – да / 0 – нет", 0, 1);
            if (n == 1) {
                start = 1;
            } else {
                start = 0;
            }
        }
    }

    static int getNumber(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int x;
        do {
            System.out.println(message);
            x = scanner.nextInt();
        } while (x < min || x > max);
        return x;
    }

    static void Word(){
        Scanner scanner = new Scanner(System.in);
        String[] words = new String[]{"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "\ncarrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "\nmushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        System.out.println(Arrays.toString(words));
        int n = (int) Math.floor(Math.random() * words.length);
        String x = words[n];
        //System.out.println(words[n]);
        System.out.println("Компьютер загадал одно из этих слов. \nВам дается неограниченное колличество попыток!");

        while (true) {
            System.out.println("Введите слово: ");
            String y = scanner.nextLine();
            if (y.equals(x)) {
                System.out.println("Ура! Вы угадали слово!");
                break;
            } else {
                System.out.println("Вы не угадали! Попробуйте еще раз!");
                for (int i = 0; i < 15; i++) {
                    if (i < x.length() && i < y.length() && x.charAt(i) == y.charAt(i)) {
                        System.out.print(x.charAt(i));
                    } else {
                        System.out.print((x.equals(y)) ? "" : "#");
                    }
                }
                System.out.println();
            }
        }
    }

}
