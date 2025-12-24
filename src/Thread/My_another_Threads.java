package Thread;
public class My_another_Threads {
    // creating thread using Thread class
    public static class MyAnotherThread extends Thread{
        public void run(){
            // task for thread
            for(int i=10;i>=1;i--){
                System.out.println("Another thread = "  + i);
                try{
                    Thread.sleep(2000);
                }catch(Exception e){}
            }
        }
    }
    public static void main(String[] args) {
        // object of Anotherthread
        MyAnotherThread t2 = new MyAnotherThread();

        t2.start();
    }
}
