

public class McDonalds 
{
    int nuggets = 0;
    boolean running = false;

    volatile int queue =0;
    
    Thread k1,k2, c1,c2;

    public McDonalds()
    {
        System.out.println("\n***McDonalds exists**\n");
        System.out.println("+++Geringverdiender kommen (zu spät) zur Arbeit! +++\n");

        k1 = new Thread(new Kitchen(this,"Fritteuse",1));
        k2 = new Thread(new Kitchen(this,"Eismaschine",3));
        c1 = new Thread(new CashRegister(this, "Kasse 1"));
        c2 = new Thread(new CashRegister(this, "Kasse 2"));

        getStaffStatus();
        
        System.out.println("+++ Niederer Pöbel beginnt zu Arbeiten ! +++\n");
        
        k1.start();
        k2.start();
        c1.start();
        c2.start();

        getStaffStatus();

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

    }


    public synchronized void getNuggets(int val,CashRegister cr) throws InterruptedException 
    {   
        queue += val;

        if(nuggets < queue)
        {
            
            System.out.println("\nWarte auf Nachschub (╯°□°）╯︵ ┻━┻ ["+cr.getName()+"]["+cr.getCounter()+"][WAIT] \n");

            //Wait() bewirtk das ein Thread an dieser Stekle stehen bleibt, die Methode jedoch nicht sperrt/lockt
            wait(); //Lässt die aktuellen Zugreifer (zb Kasse 1 oder 2) warten bis Notify() Eintritt

        }
        
        nuggets -= queue;
        queue = 0;
        System.out.println(" \n-- Bestellung ["+cr.getName()+"]["+cr.getCounter()+"] fertig | Vorrat:("+nuggets+")  --\n");
        getStaffStatus();
    }

    public synchronized void essenFertig(int val,String name) 
    { 
        nuggets += val;
        
        System.out.println("Neue Nuggets fertig ! (" + nuggets +"/"+queue+") von "+name);

        

        if(nuggets >= queue && c1.getState().equals(Thread.State.WAITING) )
        {
            notifyAll(); //Alle die in der getNuggets() warten dürfen weiter machen

            System.out.println("\nWarteschlange abgebaut(" + nuggets +") [NOTIFY]\n");
            getStaffStatus();
        }
       
    }

    public void stopRun()
    {
        this.running = false;
    }

    public void getStaffStatus()
    {
        System.out.println("Status Kasse1 : "+c1.getState()+" | Status Kasse2 : "+c2.getState()+"\nStatus Fritteuse : "+k1.getState()+" | Status Eismaschine : "+k2.getState()+"\n");
    }
    
}
