package lt.viko.eif.imazolevska.jaxws.practice.kitchen;


import org.springframework.stereotype.Service;

//@Service
public class ItalianCook implements Cook{

    @Override
    public void virejas(String dish){
        System.out.println("Italian cook makes " + dish);
    }
}
