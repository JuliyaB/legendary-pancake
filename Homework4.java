import java.util.Random;
import java.util.Scanner;
/**
 * Java. Lesson4. My Homework4.
 *
 * @author Juliya
 * @version dated 3.06.2019
 */

public class Homework4 {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int x_user;
    public static int y_user;

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Ура! Вы победили!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Твой компьютер умнее тебя, ты проиграл!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья.");
                break;
            }
        }
        System.out.println("Игра окончена!");
    }

    public static boolean checkWin(char symb) {
        int r = 0, l = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) r++;
            if (map[SIZE - i - 1][i] == symb) l++;
        }
        if (r == DOTS_TO_WIN || l == DOTS_TO_WIN) return true;

        int r2 = 0, l2 = 0, r3 = 0, l3 = 0;
        for (int d = 1, j = 0; d < SIZE; d++, j++) {
            if (map[j][d] == symb) l2++;
            if (map[d][j] == symb) r2++;
            if (map[SIZE - j - 1][d] == symb) l3++;
            if (map[SIZE - d - 1][j] == symb) r3++;
        }
        if (r2 == DOTS_TO_WIN || l2 == DOTS_TO_WIN || r3 == DOTS_TO_WIN || l3 == DOTS_TO_WIN) return true;

        for (int x = 0; x < SIZE; x++) {
            int r1 = 0, l1 = 0;
            for (int y = 0; y < SIZE; y++) {
                if (map[x][y] == symb) r1++;
                if (map[y][x] == symb) l1++;
            }
            if (r1 == DOTS_TO_WIN || l1 == DOTS_TO_WIN) return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        int one, two;
        do {
            x = x_user;
            y = y_user;
            one = rand.nextInt(3);
            two = rand.nextInt(3);
            if (one == 0)
                x--;
            else if (one == 2)
                x++;
            if (two == 0)
                y--;
            else if (two == 2)
                y++;
            while (!isCellValid(x, y)){
                    Random rnd = new Random();
                    x = rnd.nextInt(SIZE);
                    y = rnd.nextInt(SIZE);
                }
        } while (x >= SIZE || x < 0 || y >= SIZE || y < 0);
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в форме X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
        x_user = x;
        y_user = y;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
