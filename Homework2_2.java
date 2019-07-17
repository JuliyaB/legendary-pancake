public class Homework2_2 {
    public static void main(String[] args) {
        String[][] mas = new String[4][4];
        mas[0][0] = "1";
        mas[0][1] = "2";
        mas[0][2] = "3";
        mas[0][3] = "4";
        mas[1][0] = "E";
        mas[1][1] = "6";
        mas[1][2] = "G";
        mas[1][3] = "8";
        mas[2][0] = "9";
        mas[2][1] = "j";
        mas[2][2] = "k";
        mas[2][3] = "l";
        mas[3][0] = "1";
        mas[3][1] = "s";
        mas[3][2] = "1";
        mas[3][3] = "z";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mas[i][j] + "\t");
            }
            System.out.println();
        }
        twoDimensionalArray(mas);
    }

    static void twoDimensionalArray(String[][] mas) {
        try {
            if (mas.length != 16) {
                throw new ArraySizeException("Массив не 4х4");
            }
            int[][] mas1 = new int[4][4];
            int sum=0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    mas1[i][j] = Integer.parseInt(mas[i][j]);
                    sum+=mas1[i][j];
                }
            }
            System.out.println(sum);

        } catch (MyArrayDataException e) {
            System.out.println("Ошибка MyArrayDataException");
        }
    }

}