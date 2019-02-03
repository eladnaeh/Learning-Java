package com.company;

public class Main {

    public static void main(String[] args) {
	    Thread anotherThread = new anotherThread();
	    anotherThread.setName("== another thread ==");
	    anotherThread.start();
	    //anonymous class thread
	    new Thread(){
	        public void run(){
                System.out.println("hello from anon");
            }
        }.start();

        System.out.println("hello again");

//we cant guarantee the order in which threads will execute

        //Thread myRunnableThread = new Thread(new myRunnable());
        //myRunnableThread.start();

        Thread myRunnableThread = new Thread(new myRunnable() {
            @Override
            public void run() {
                System.out.println("I am here ");
                try{
                    System.out.println("------");
                    anotherThread.join();
                    //anotherThread.join(10000);
                    System.out.println("anotherThread terminated or timed out, back again");
                }
                catch (InterruptedException e){
                    System.out.println("was Interrupted");
                }
            }
        });

        myRunnableThread.start();
        //anotherThread.interrupt();
    }
}
