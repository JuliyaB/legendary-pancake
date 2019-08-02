package Tasks5;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    @Override
    public void run() {
        int count=0;
        while (count<shipCount){
            System.out.println();
            count++;
            tunnel.add(new Ships(getRandomName(), getRandomProduct(), getRandomCapacity()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getRandomName(){
        String[] name={"Дункан", "Наутилус", "Пионер", "Призрак", "Цикада", "Стратфорд", "Медуза", "Аляска", "Шхуна"};
        Random random= new Random();
        int pos = random.nextInt(name.length);
        return name[pos];
    }

    private String getRandomProduct(){
        String[] product={"рыба", "уголь", "нефть"};
        Random random= new Random();
        int pos = random.nextInt(product.length);
        return product[pos];
    }

    private int getRandomCapacity(){
        int[] capacity={10, 30, 50};
        Random random= new Random();
        int pos = random.nextInt(capacity.length);
        return capacity[pos];
    }

}
