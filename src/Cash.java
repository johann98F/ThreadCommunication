import java.util.Random;

public class Cash implements Runnable
{
    private BurgerKing bk;
    private int counter = 0;
    private String name ;
    
    public Cash(BurgerKing bk,String name)
    {
        this.bk = bk;
        this.name = name;
    }

    @Override
    public void run() 
    {
        Random r = new Random();

        while(true)
        {
            try 
            {
                Thread.sleep(r.nextInt(6)*1000);
                new Kunde(this);
            } 
            catch (InterruptedException e){e.printStackTrace();}
            
        }
        
    }

    public synchronized void getOrder(int val) throws InterruptedException
    {
        counter++;
        System.out.println("\n++ ["+counter+"] Bestellung : " + val + "x von " + name+ " ++\n");
        bk.getNuggets(val);
    }
}
