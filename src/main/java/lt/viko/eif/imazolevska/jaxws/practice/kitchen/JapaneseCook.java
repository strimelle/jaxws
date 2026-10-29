package lt.viko.eif.imazolevska.jaxws.practice.kitchen;

import org.springframework.stereotype.Service;


public class JapaneseCook implements Cook {
    @Override
    public void virejas(String dish){
        System.out.println("Japanese cook makes " + dish);
    }

}
