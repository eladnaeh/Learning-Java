import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List <Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        List<Integer> list = new ArrayList<>(list1);
        System.out.println(list);
    }
}
