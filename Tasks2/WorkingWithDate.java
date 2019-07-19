package Tasks2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class WorkingWithDate {
    static Calendar calendar = Calendar.getInstance();
    static DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    static DateFormat date = new SimpleDateFormat("dd.MM.yyyy");
    static DateFormat time = new SimpleDateFormat("HH:mm:ss");
    static String q=df.format(calendar.getTime());
    static String w=date.format(calendar.getTime());
    static String t=time.format(calendar.getTime());
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите цифру\n1(формат 21.4.2014 15:56:45)\n2(формат 21.4.2014)\n3(формат 15:56:45)");
        int a=scanner.nextInt();
        switch (a){
            case 1:
                printDate(df.format(calendar.getTime()));
                break;
            case 2:
                printDate(date.format(calendar.getTime()));
                break;
            case 3:
                printDate(time.format(calendar.getTime()));
                break;
                default:
                    System.out.println("Вы ввели не ту цифру!");
        }
    }

    static void printDate(String x){
        String s=(calendar.get(Calendar.AM_PM)==0)? "AM":"PM";
        if(x.equals(q)){
            System.out.println("День: "+calendar.get(Calendar.DATE));
            System.out.println("День недели: "+calendar.get(Calendar.DAY_OF_WEEK));
            System.out.println("День месяца: "+calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: "+calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: "+calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: "+calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: "+calendar.get(Calendar.MONTH));
            System.out.println("Год: "+calendar.get(Calendar.YEAR));
            System.out.println("AM или PM: "+s);
            System.out.println("Часы: "+calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: "+calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: "+calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: "+calendar.get(Calendar.SECOND));
        }else if (x.equals(w)){
            System.out.println("День: "+calendar.get(Calendar.DATE));
            System.out.println("День недели: "+calendar.get(Calendar.DAY_OF_WEEK));
            System.out.println("День месяца: "+calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: "+calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: "+calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: "+calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: "+calendar.get(Calendar.MONTH));
            System.out.println("Год: "+calendar.get(Calendar.YEAR));
        }else if (x.equals(t)){
            System.out.println("AM или PM: "+s);
            System.out.println("Часы: "+calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: "+calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: "+calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: "+calendar.get(Calendar.SECOND));
        }
    }
}
