public class Kitchen implements Runnable
{
    McDonalds mc;
    String name;
    int speed;
    private boolean running = true;

    public Kitchen(McDonalds bk, String name,int speed)
    {
        this.mc = bk;
        this.name = name;
        this.speed = speed;
    }

    @Override
    public void run() 
    {
        if(name.contains("Eismaschine"))
            {
                kill();
            }
        while(running)
        {
            

            try 
            {
                Thread.sleep(speed*1000);
            } 
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            
            mc.essenFertig(1,name);
            
        }
        
    }

    public void kill()
    {
        System.err.println("\n"+name + " funktionert nicht mehr !\n");
        running = false;
    }
    
}
