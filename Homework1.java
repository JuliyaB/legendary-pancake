public class Homework1 {
    public static void main(String[] args){
        byte q=125;
        short w=0101;
        int a=5;
        long r=8L;
        float t=6.8f;
        double y=34.123;
        boolean u=true;
        char o='B';
        System.out.println("5*(3+(8/4))=" + expression(a,3,8,4));
        System.out.println(from10to20(7,8));
        isPositiveOrNegative(-12);
        System.out.println(isNegative(-10));
        greetings("Juliya");
        leapyear(2000);
    }
    static int expression(int a, int b, int c, int d){
        return a*(b+(c/d));
    }

    static boolean from10to20(int one, int two){
        if(10<=one+two && one+two<=20){
            return true;
        }else {
            return false;
        }
    }

    static void isPositiveOrNegative(int g){
        if(g>=0){
            System.out.println("Число положительно");
        }else {
            System.out.println("Число отрицательное");
        }
    }

    static boolean isNegative(int a){
        return a<0;
    }

    static void greetings(String name){
        System.out.println("Привет, " + name + "!");
    }

    static void leapyear(int x){
        if(x%4==0 && x%100!=0 || x%400==0){
            System.out.println(x+" является високосным");
        }else {
            System.out.println(x+" не является високосным");
        }
    }
}
