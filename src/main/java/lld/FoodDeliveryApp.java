package lld;


import java.util.ArrayList;
import java.util.List;

// Step 1: Order Status Enum
enum OrderStatus {
    PLACED, ACCEPTED, PREPARING, OUT_FOR_DELIVERY, DELIVERED;
}

// Step 2: Observer Pattern for Notifications
interface Observer {
    void update(String message);
}

class User1 implements Observer {
    private String name;

    public User1(String name) {
        this.name = name;
    }

    public void placeOrder(Order order) {
        System.out.println(name + " placed an order: " + order.getOrderId());
        order.setStatus(OrderStatus.PLACED);
    }

    @Override
    public void update(String message) {
        System.out.println("User Notification: " + message);
    }
}

// Step 3: Delivery Partner (Observer)
class DeliveryPartner implements Observer {
    private String name;

    public DeliveryPartner(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Delivery Partner " + name + " Notification: " + message);
    }
}

// Step 4: Restaurant Class
class Restaurant {
    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    public void acceptOrder(Order order) {
        System.out.println(name + " accepted the order: " + order.getOrderId());
        order.setStatus(OrderStatus.ACCEPTED);
    }

    public void prepareOrder(Order order) {
        System.out.println(name + " is preparing the order: " + order.getOrderId());
        order.setStatus(OrderStatus.PREPARING);
    }
}

// Step 5: Order Class with Observer Support
class Order {
    private static int orderCounter = 1;
    private int orderId;
    private OrderStatus status;
    private List<Observer> observers = new ArrayList<>();

    public Order() {
        this.orderId = orderCounter++;
    }

    public int getOrderId() {
        return orderId;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Order " + orderId + " is now " + status);
        }
    }
}

// Step 6: Order Management (Singleton Pattern)
class OrderManager {
    private static OrderManager instance;
    private List<Order> orders = new ArrayList<>();

    private OrderManager() {
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }
}

// Step 7: Testing the Food Delivery App
public class FoodDeliveryApp {
    public static void main(String[] args) {
        User1 user = new User1("Alice");
        DeliveryPartner deliveryPartner = new DeliveryPartner("Bob");
        Restaurant restaurant = new Restaurant("Tasty Bites");

        Order order = new Order();
        order.addObserver(user);
        order.addObserver(deliveryPartner);

        user.placeOrder(order);
        restaurant.acceptOrder(order);
        restaurant.prepareOrder(order);

        // Assign Delivery Partner
        System.out.println("Assigning delivery partner...");
        order.setStatus(OrderStatus.OUT_FOR_DELIVERY);

        // Delivered
        order.setStatus(OrderStatus.DELIVERED);
    }
}

