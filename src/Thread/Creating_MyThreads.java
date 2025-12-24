package Thread;

import Thread.My_another_Threads.MyAnotherThread;

public class Creating_MyThreads {
    // creating our thread using Runnable Interface
    public static class MyThread implements Runnable {
        @Override
        public void run(){
            // task for thread....
            for(int i=0;i<=10;i++){
                System.out.println("Value of i is " + i);
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
                }
            }
        }
    public static void main(String[] args) {
        // create object of Mythread class
        MyThread t1 = new MyThread();
        // helper class object
        Thread thr = new Thread(t1);


        // objcect of MyAnotherThread\
        // MyAnotherThread t2 = new MyAnotherThread();
        
        thr.start();

        // t2.start();
    }
}