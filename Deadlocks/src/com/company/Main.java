package com.company;

import java.io.ObjectInputStream;

import static com.company.Main.lock1;
import static com.company.Main.lock2;

public class Main {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {

        new Thread1().start();
        new Thread2().start();

    }


    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 1: waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 1: Has lock 1 and 2");
                }
                System.out.println("Thread 1: released lock2");
            }
            System.out.println("Thread 1: released lock1. Exiting...");
        }
    }

    private static class Thread2 extends Thread{
        public void run(){
            //switch locks lock1 <-> lock2 will cause a deadlock/
            synchronized (lock1){
                System.out.println("Thread 2: Has lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                System.out.println("Thread 2: waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Thread 2: Has lock 1 and 2");
                }
                System.out.println("Thread 2: released lock2");
            }
            System.out.println("Thread 2: released lock1. Exiting...");
            }
    }
}
