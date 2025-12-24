package Thread;
class Company {

    int n;
    
    boolean f = false;
    // f = false : chance : producer
    // f = true : chance : consumer
    synchronized public void produce_item(int n) /// data laega...
    {
        if(f){
            try{
                wait();
            }catch(Exception e){}
        }
        this.n = n;
        System.out.println("Produced :"+this.n);
        f=true;
        notify(); // notify krega ki mera kaam khatam hogya...
    }

    synchronized public int consume_item()
    {
        if(!f){
            try{
                wait();
            }catch(Exception e){}
        }
        System.out.println("Consumed:"+this.n);
        f=false;
        notify(); // notify kr dega ki mera kaam khatam hogya...
        return this.n;
    }
}
public class Producer_Consumer {
    public static void main(String[] args)
    {
        // object....
        Company comp = new Company();
        Producer p = new Producer(comp);
        Consumer c = new Consumer(comp);
        
        p.start();
        c.start();
    }
}
