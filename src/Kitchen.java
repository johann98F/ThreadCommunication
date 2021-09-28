public class Kitchen implements Runnable
{
    BurgerKing bk;

    String name;

    int speed;

    public Kitchen(BurgerKing bk, String name,int speed)
    {
        this.bk = bk;
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void run() 
    {
        while(true)
        {
            try 
            {
                Thread.sleep(speed*1000);
            } 
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            
            bk.essenFertig(1,name);
            
        }
        
    }
    
}
