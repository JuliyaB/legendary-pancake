import java.util.Arrays;

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
    }

    static boolean sum(int[] mas) {
        int left = 0, right = 0;
        int length = mas.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                left += mas[j];
            }
            for (int l = i+1; l < length; l++) {
                right += mas[l];
            }
            if (left == right) {
                return true;
            }
        }
        return false;
    }
}
