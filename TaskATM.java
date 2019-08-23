package Task8;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskATM {
    private static volatile int n[] = {50, 100, 500};
    private static volatile Map<Integer, Integer> kolN = new LinkedHashMap<>();
    private static volatile List<String> list = new ArrayList<>();
    private static volatile int sum = 0;
    private static volatile int money = 0;
    private static volatile int kol = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        kolN.put(50, 5);
        kolN.put(100, 4);
        kolN.put(500, 3);
        System.out.println("Если вы хотите снять деньги введите 1\n Если вы хотите положить деньги введите 2");
        int a = scanner.nextInt();
        switch (a) {
            case 1:
                if (withdrawMoney() == true) {
                    list.forEach(System.out::println);
                    System.out.println("Заберите деньги!");
                    System.out.println(kolN);
                } else {
                    System.out.println("В банкомате недостаточно средств.");
                }
                break;
            case 2:
                try {
                    process();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Вы ввели не ту цифру!");
        }
    }
    private static void process() throws IOException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Поток: " + Thread.currentThread().getName());
                putMoney();
            }
        });
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized boolean withdrawMoney() {
        System.out.println("Введите сумму, которую хотите снять. Она должна быть кратна 50!");
        sum = scanner.nextInt();
        if (sum % 50 != 0) {
            do {
                System.out.println("Сумму не кратна 50! Попробуйте еще раз!");
                sum = scanner.nextInt();
            } while (sum % 50 != 0);
        }
        int maxSum = 0;
        for (Map.Entry entry : kolN.entrySet()) {
            maxSum += (Integer) entry.getValue() * (Integer) entry.getKey();
        }
        if (sum > maxSum) {
            return false;
        }
        for (int i = 3 - 1; i >= 0; i--) {
            kol = sum / n[i];
            kol=(Integer) kolN.keySet().toArray()[i] > kol && kol <= (Integer) kolN.values().toArray()[i]? kol:
                    (Integer) kolN.keySet().toArray()[i] <= kol && kol <= (Integer) kolN.values().toArray()[i]?
                            (Integer) kolN.keySet().toArray()[i]:(Integer) kolN.values().toArray()[i];
            list.add("Выдано " + kol + " купюр номинала " + n[i]);
            int x = (Integer) kolN.values().toArray()[i] - kol;
            kolN.computeIfPresent(n[i], (key, value) -> value = x);
            sum -= kol * n[i];
            kolN.values().removeIf(o -> o == 0);
        }
        return sum == 0;
    }

    private static synchronized void putMoney() {
        int start = 1;
        while (start == 1) {
            System.out.println("Введите купюру, которую хотите положить. Принимаются купюры 50, 100, 500!");
            money = scanner.nextInt();
            if (money==50 || money==100|| money==500) {
                kolN.computeIfPresent(money, (key, value) -> value += 1);
                System.out.println("Если хотите положить еще купюру нажмите 1, иначе 0.");
                int n = scanner.nextInt();
                start = n == 1 ? 1 : 0;
            }
        }
        System.out.println("Банкомат успешно пополнен!");
        for (Map.Entry entry : kolN.entrySet()) {
            System.out.println(entry.getValue() + " купюр номинала "
                    + entry.getKey());
        }
    }

}
