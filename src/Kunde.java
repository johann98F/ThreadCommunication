import java.util.Random;

public class Kunde {
    Cash c;

    Kunde(Cash c)
    {

        Random r = new Random();

        try {
            
            c.bestellung(r.nextInt(6) + 1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
