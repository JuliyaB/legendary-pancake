package Tasks5;

public class Quay implements Runnable{
    private Tunnel tunnel;
    private String product;

    public Quay(Tunnel tunnel, String product){
        this.tunnel=tunnel;
        this.product=product;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                Ships ships = tunnel.get(product);
                if (ships != null) {
                    while (ships.countCheck()) {
                        Thread.sleep(1000);
                        ships.add(10);
                    }
                    System.out.println("Корабль: " + ships.getName() + " загружен.");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
