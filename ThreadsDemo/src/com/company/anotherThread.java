package com.company;

public class anotherThread extends Thread {
    @Override
    public void run() {
        System.out.println("hello world from " + currentThread().getName());
        try{
            Thread.sleep(3000);
            //Thread.sleep(0, 2);
        }
        catch (InterruptedException e){
            System.out.println("in catch block");
            return;
        }
        System.out.println("the sleep time passed");

    }

}

