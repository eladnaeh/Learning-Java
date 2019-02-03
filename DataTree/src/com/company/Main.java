package com.company;

public class Main {

    public static DataPoint currentDataPoint;

    public static void main(String[] args) {
	    DataPoint top = new DataPoint(1,"first");
	    DataPoint top1Child = new DataPoint(2, "second");
	    DataPoint top2Child = new DataPoint(3, "third");

	    top.addChildren(top1Child);
	    top.addChildren(top2Child);

	    top1Child.addParent(top);
	    top2Child.addParent(top);


	    currentDataPoint = top;


        print();
        move("child", "left");
        print();


//        System.out.println(top.getChildren());
//        System.out.println(top.getParents());
//
//        System.out.println("\n");
//
//        System.out.println(top1Child.getChildren());
//        System.out.println(top1Child.getParents());
//
//        System.out.println("\n");
//
//        System.out.println(top2Child.getChildren());
//        System.out.println(top2Child.getParents());
//
//        System.out.println("\n");
    }

    public static void move(String direction, String side){
        if(direction == "parent"){
            if(side == "right"){
                currentDataPoint = currentDataPoint.getParent(0);
            }
            else if(side == "left"){
                currentDataPoint = currentDataPoint.getParent(1);
            }
            else{
                System.out.println("Problem: no such side");
            }
        }
        else if(direction == "child"){
            if(side == "right"){
                currentDataPoint = currentDataPoint.getChild(1);
            }
            else if(side == "left"){
                currentDataPoint = currentDataPoint.getChild(0);
            }
            else{
                System.out.println("Problem: no such side");
            }
        }
        else{
            System.out.println("Problem: no such direction");
        }

    }
    public static void print(){
        System.out.println(currentDataPoint.getParents().toString());
        System.out.println(currentDataPoint.getChildren().toString());
    }

}
