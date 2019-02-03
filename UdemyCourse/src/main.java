import java.util.Scanner;

public class main {

    public static void main(String[] args){

        //MyLinkedList tree = new MyLinkedList(null);

        SearchTree tree = new SearchTree(null);

        tree.traverse(tree.getRoot());

        String stringData = "5 7 3 9 8 2 1 0 4 6";

        String[] data = stringData.split(" ");
        for (String s : data){
            //create new item with value and set to the string s
            tree.addItem(new Node(s));
        }

        tree.traverse(tree.getRoot());


    }

}
