package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter 10 numbers: ");
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<10; i++){
            numbers.add(scanner.nextInt());
            scanner.nextLine();
        }


        System.out.println(numbers);
        scanner.close();
    }
}
