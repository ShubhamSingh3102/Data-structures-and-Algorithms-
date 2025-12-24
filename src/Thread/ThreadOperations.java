package Thread;
public class ThreadOperations {
    public static class UserThread extends Thread{
        @Override
        public void run(){
            // task for thread....
            System.out.println("This is user defined thread");
        }
    }
    public static void main(String[] args) {
        System.out.println("Program started...");
        int x = 56+34;
        System.out.println("Sum is " +x);

        // Getting Thread name
        Thread t = Thread.currentThread(); // object of current running thread....
        String tname = t.getName(); // name of the current thread ruuning
        System.out.println("Current thread running is "+tname); 


        // set name
        t.setName("MyMain");
        System.out.println(t.getName());


        // sleep
        try{
            Thread.sleep(5000);
        }catch(Exception e){

        };

        // getId
        System.out.println(t.getId());

        // going to start user defined thread...

        System.out.println("Program ended...");

        UserThread t1 = new UserThread();
        t1.start();
    }
}
