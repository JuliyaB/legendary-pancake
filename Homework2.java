import java.util.Arrays;
import java.lang.String;
/*
 *Java. Lesson2. My Homework2.
 *
 *@auhor Juliya
 *@version dated 25.05.2019
 */
public class Homework2 {
    public static void main(String[] args) {
        int[] replace = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < replace.length; i++) {
            replace[i] = (replace[i] > 0) ? 0 : 1;
        }
        System.out.println(Arrays.toString(replace));

        int[] arr = new int[8];
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s;
            s += 3;
        }
        System.out.println(Arrays.toString(arr));

        int[] minsix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < minsix.length; i++) {
            if (minsix[i] < 6) {
                minsix[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(minsix));

        int[][] mas = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    mas[i][j] += 1;
                }
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        int[] maxnin = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int max = 0;
        int min = maxnin[0];
        for (int i = 0; i < maxnin.length; i++) {
            if (maxnin[i] > max) {
                max = maxnin[i];
            }
            if (maxnin[i] < min) {
                min = maxnin[i];
            }
        }
        System.out.println("max=" + max);
        System.out.println("min=" + min);

        int[] mas1 = {1, 2, 3, 3, 2, 1};
        System.out.println(sum(mas1));

        int[] mas2 = {1, 2, 3, 3, 2, 1};
        int[] out1 = arrayNOffset(mas2, -2);
        printOut(out1);
    }

    static boolean sum(int[] mas) {
        int left = 0, right = 0;
        int length = mas.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                left += mas[j];
            }
            for (int l = i + 1; l < length; l++) {
                right += mas[l];
            }
            if (left == right) {
                return true;
            }
        }
        return false;
    }


    static int[] arrayNOffset(int[] array2, int n) {
        if (n < 0) {
            negativeArrayNOffset(array2, n);
        } else {
            positiveArrayNOffset(array2, n);
        }
        return array2;
    }

    private static int[] negativeArrayNOffset(int[] array2, int n) {
        int length = array2.length;
        int current;
        int next;
        n *= -1;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < length - 1; k++) {
                current = array2[k];
                next = k + 1;

                if (k + 1 > length - 1) {
                    next = 0;
                }
                array2[k] = array2[next];
                array2[next] = current;
            }
        }
        return array2;
    }

    private static int[] positiveArrayNOffset(int[] array2, int n) {
        int length = array2.length - 1;
        int current;
        int prev;

        for (int i = 0; i < n; i++) {
            for (int k = length; 0 <= k; k--) {
                current = array2[k];
                prev = k - 1;

                if (k - 1 < 0) {
                    prev = 0;
                }
                array2[k] = array2[prev];
                array2[prev] = current;
            }

        }
        return array2;
    }

    public static void printOut(int[] incomingArray){
        for(int item: incomingArray){
            System.out.print(item + " ");
        }

        System.out.println();
    }
}
