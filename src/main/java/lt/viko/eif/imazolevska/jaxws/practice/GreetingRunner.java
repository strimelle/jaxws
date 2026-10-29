package lt.viko.eif.imazolevska.jaxws.practice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

public class GreetingRunner implements CommandLineRunner {
    private final Greeter greeter;


    public GreetingRunner(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    public void run(String... args) throws Exception {
        greeter.greet("Ieva");
    }
}
