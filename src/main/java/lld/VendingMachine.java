package lld;

import org.example.hashmap.HashMap;

public class VendingMachine {

}

enum Coin {
    ONE(1), TWO(2), FIVE(5), TEN(10);
    private final int value;

    Coin(int value) {
        this.value = value;
    }

    ;
    public int getValue(){
        return  value;
    }
}

class Item {
    private String name;
    private int price;
    public  Item(String name, int price){
        this.name = name;
        this.price = price;
    }
}

class VendingMachine2 {
    private java.util.HashMap<Item, Integer> inventory = new java.util.HashMap<>();
    private int balance = 0;
    public void addItem(Item item, int quantity){
        this.inventory.put(item, inventory.getOrDefault(item,0)+quantity);
    }

    public void insertCoint(Coin coin){
        this.balance+=coin.getValue();
    }
}
