package Task8;

import java.util.*;

public class TaskATM {
static int n[]={50, 100, 500};
static Map<Integer, Integer> kolN= new LinkedHashMap<>();
static List<String> list=new ArrayList<>();
static int sum=0;
static int kol=0;
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        kolN.put(50, 2); kolN.put(100, 1); kolN.put(500, 3);
        System.out.println("Если вы хотите снять деньги введите 1\n Если вы хотите положить деньги введите 2");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                if(withdrawMoney()==true){
                    list.forEach(System.out::println);
                    System.out.println("Заберите деньги!");
                }else {
                    System.out.println("В банкомате недостаточно средств.");
                }
                break;
            case 2:
                putMoney();
                break;
            default:
                System.out.println("Вы ввели не ту цифру!");
        }
    }

    static boolean withdrawMoney() {
        System.out.println("Введите сумму, которую хотите снять. Она должна быть кратна 50!");
        sum = scanner.nextInt();
        if (sum%50!=0){
            do {
                System.out.println("Сумму не кратна 50! Попробуйте еще раз!");
                sum = scanner.nextInt();
            }while (sum%50!=0);
        }
        int maxSum=0;
        for (Map.Entry entry : kolN.entrySet()){
            maxSum +=(Integer) entry.getValue()* (Integer)entry.getKey();
        }
        if (sum>maxSum){
            return false;
        }
        for (int i=3-1; i>=0; i--){
            kol = sum / n[i];
            if ((Integer)kolN.keySet().toArray()[i] > kol && kol<=(Integer)kolN.values().toArray()[i]){
                kol=kol;
            }else if ((Integer)kolN.keySet().toArray()[i] <= kol){
                kol=(Integer)kolN.keySet().toArray()[i];
            }else {
                kol=(Integer)kolN.values().toArray()[i];
            }
            list.add("Выдано " +kol+ " купюр номинала "+n[i]);
            int x=(Integer)kolN.values().toArray()[i];
            kolN.computeIfPresent(i, (key, value) ->value=x-kol);
            sum-=kol*n[i];
            for (Map.Entry entry : kolN.entrySet()){
                if (entry.getValue().equals(0))
                    kolN.remove(entry.getKey());
            }
        }
        return sum==0;
    }

    static void putMoney() {

    }

}
