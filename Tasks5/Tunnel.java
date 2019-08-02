package Tasks5;

import java.util.ArrayList;
import java.util.List;

public class Tunnel {
    private static final int maxShips = 5;
    private static final int minShips = 0;
    private volatile int count = 0;
    private volatile List<Ships> ships;

    public Tunnel() {
        ships = new ArrayList<>();
    }

    public synchronized boolean add(Ships i) {
        try {
            if (count < maxShips) {
                notifyAll();
                ships.add(i);
                System.out.println("Корабль " + i.getName() + ", перевозит товар: " + i.getProduct() + ", вместимость: " + i.getCapacity() + ". В туннеле.");
                count++;
            } else {
                System.out.println("Корабль " +i.getName() +" подплывает к туннелю.");
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Ships get(String product) {
        try {
            if (count > minShips) {
                notifyAll();
                for (Ships i : ships) {
                    if (i.getProduct() == product) {
                        count--;
                        System.out.println("Корабль " + i.getName() + " покинул туннель");
                        ships.remove(i);
                        return i;
                    }
                }
            }
            System.out.println("В туннеле нет кораблей.");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
