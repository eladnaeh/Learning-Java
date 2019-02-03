package com.company;

import java.awt.image.renderable.RenderableImageProducer;

public class Main {

    public static void main(String[] args) {
        final BankAccount account = new BankAccount("12345-678", 1000.00);

//        Thread trThread1 = new Thread(){
//            public void run(){
//                account.deposit(300);
//                account.withdraw(50);
//            }
//        };
//
//
//        Thread trThread2 = new Thread(){
//            public void run(){
//                account.deposit(203.75);
//                account.withdraw(100);
//            }
//        };

        Thread trThread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
            }
        });

        Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
            }
        });




        trThread1.start();
        trThread2.start();
    }
}
