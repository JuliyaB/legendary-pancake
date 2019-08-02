package Tasks5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test{
    public static void main(String[] args){
        Tunnel tunnel = new Tunnel();
        ShipGenerator shipGenerator=new ShipGenerator(tunnel, 100);
        Quay quay=new Quay(tunnel, "рыба");
        Quay quay2=new Quay(tunnel, "уголь");
        Quay quay3=new Quay(tunnel, "нефть");
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.execute(shipGenerator);
        executorService.execute(quay);
        executorService.execute(quay2);
        executorService.execute(quay3);
        executorService.shutdown();
    }
}
