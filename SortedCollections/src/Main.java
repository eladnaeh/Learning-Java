import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static StockList stockList = new StockList();
    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.items().keySet()){
            System.out.println(s);
        }


        Basket timsBasket = new Basket("Tim");

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        //System.out.println(stockList);

        //the block of code below shows that ypu cant enter items into the stocklist directly, only with our method. // the Map of items is a unmodifiable map.
        //start code
        //temp = new StockItem("pen", 1.12);
        //stockList.items().put(temp.getName(), temp);
        //end code

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(timsBasket, "car", 1);
        removeItem(timsBasket, "cup", 9);
        removeItem(timsBasket, "car", 1);
        System.out.println("cars removed " + removeItem(timsBasket, "car", 1)); //should not remove any
        System.out.println(timsBasket);

        //remove all items from tim's basket:
        removeItem(timsBasket, "bread", 1);
        removeItem(timsBasket, "cup", 3);
        removeItem(timsBasket, "juice", 4);
        removeItem(timsBasket, "cup", 3);

        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        for(Map.Entry<String, Double> price: stockList.PriceList().entrySet()){
            System.out.println(price.getKey() + " costs" + price.getValue());
        }

        checkOut(timsBasket);
        System.out.println(timsBasket);

    }

    public static int sellItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("we dont sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0){
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if(stockItem == null){
            System.out.println("we dont sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity){
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket){
        for(Map.Entry<StockItem, Integer> item: basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
