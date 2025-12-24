package Thread;
class Consumer extends Thread
{

    // company object
    Company c;

    // constructor
    Consumer(Company c)
    {
        this.c = c;
    }
    public void run()
    {
        while(true)
        {
            this.c.consume_item();
            try{
                Thread.sleep(2000);
            }catch(Exception e){}
        }
    }
}  
