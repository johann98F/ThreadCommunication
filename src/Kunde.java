import java.util.Random;

public class Kunde 
{
    Cash c;

    Kunde(Cash c)
    {

        Random r = new Random();

        try 
        {
            c.getOrder(r.nextInt(6) + 1);
        } 
        catch (InterruptedException e) {e.printStackTrace();}
    }
}
