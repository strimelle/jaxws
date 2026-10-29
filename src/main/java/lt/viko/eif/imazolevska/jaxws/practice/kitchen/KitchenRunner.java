package lt.viko.eif.imazolevska.jaxws.practice.kitchen;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


public class KitchenRunner implements CommandLineRunner {

    private final Cook cook;
    public KitchenRunner(Cook cook){
        this.cook = cook;
    }

    @Override
    public void run(String... args) throws Exception {
        cook.virejas("pizza");
    }
}
