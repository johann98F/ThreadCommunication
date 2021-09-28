import java.util.Random;
import java.util.jar.Attributes.Name;

public class CashRegister implements Runnable
{
    private McDonalds mc;
    private int counter = 0;
    private String name ;
    private boolean running = true;
    
    public CashRegister(McDonalds bk,String name)
    {
        this.mc = bk;
        this.name = name;
    }

    @Override
    public void run() 
    {
        Random r = new Random();

        

        while(running)
        {
            try 
            {
                Thread.sleep(r.nextInt(6)*1000);
                new Kunde(this);
            } 
            catch (InterruptedException e){e.printStackTrace();}
            
        }
        
    }

    
    public void kill()
    {
        System.err.println(name + "funktionert nicht mehr !");
        running = false;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public synchronized void getOrder(int val) throws InterruptedException
    {
        counter++;
        System.out.println("\n++ ["+name+"]["+counter+"] Bestellung : " + val + "x ++\n");
        mc.getNuggets(val,this);
    }
}
