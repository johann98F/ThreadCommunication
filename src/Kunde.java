import java.util.Random;

public class Kunde 
{
    CashRegister c;

    Kunde(CashRegister c)
    {}
        Random r = new Random();

        try 
        {
            c.getOrder(r.nextInt(6) + 1);
        } 
        catch (InterruptedException e) {e.printStackTrace();}
    }
}
