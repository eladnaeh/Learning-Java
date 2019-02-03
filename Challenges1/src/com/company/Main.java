package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<50; i++){
            arrayList.add(random.nextInt(100));
        }
        System.out.println("unsorted: " + arrayList);
        sort(arrayList);
        System.out.println("sorted: " + arrayList);

        setArray();
        filterOutStrings();
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> array){
        //System.out.println("unsorted array: " + array);
        for (int i=0; i<array.size(); i++){
            for (int j=i; j<array.size(); j++){
                if(i != j){
                    if(array.get(j) <= array.get(i)){
                        int temp = array.get(i);
                        array.set(i, array.get(j));
                        array.set(j, temp);
                    }
                }
            }
        }
        //System.out.println("sorted arrat: " + array);
        return array;
    }

    public static void setArray(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(23);
        arrayList.set(1, 10);
        arrayList.add(6);
        System.out.println(arrayList.indexOf(10));
        System.out.println(arrayList);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("in thread");
//            }
//        }).start();
    }

    public static void filterOutStrings(){
        System.out.println("-----------------------");
        char a = 'A';

        String[] array = {"1", "a", "2", "b", "c", "3", "abc", "12a"};
        for (int i=0; i<array.length; i++){
            char[] arr = array[i].toCharArray();
            for (char ch : arr){
                if(ch == '0' ||
                        ch == '1' ||
                        ch == '2' ||
                        ch == '3' ||
                        ch == '4' ||
                        ch == '5' ||
                        ch == '6' ||
                        ch == '7' ||
                        ch == '8' ||
                        ch == '9' ){
                    System.out.println(array[i]);
                    //add to list a\nd delete duplicates
                }
            }
        }

    }
}
