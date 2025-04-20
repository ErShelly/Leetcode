package org.example.designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    static interface StockObserver{
        void update(String stockSymbol, int price);
    }

    static class Investor implements StockObserver{
        private String name;
        public Investor(String name){
            this.name = name;
        }

        @Override
        public void update(String stockSymbol, int price) {
            System.out.println(name + " received an update");
        }
    }

    static interface StockMarket{
        void registerObserver(StockObserver observer);
        void unregisterObserver(StockObserver observer);
        void notifyObservers(String stockSymbol, int stockPrice);
    }

    static class StockMarketImp implements StockMarket{
        private List<StockObserver> observerList = new ArrayList<>();
        @Override
        public void registerObserver(StockObserver observer) {
            observerList.add(observer);
        }

        @Override
        public void unregisterObserver(StockObserver observer) {
            observerList.remove(observer);
        }

        @Override
        public void notifyObservers(String stockSymbol, int stockPrice) {
            for(StockObserver observer: observerList){
                observer.update(stockSymbol, stockPrice);
            }
        }

        public void setStockPrice(String stockSymbol,int price){
            this.notifyObservers(stockSymbol, price);
        }
    }

    public static void main(String[] args){
        Investor investor = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        StockMarketImp stockMarketImp = new StockMarketImp();
        stockMarketImp.registerObserver(investor);
        stockMarketImp.registerObserver(investor2);

        stockMarketImp.setStockPrice("Wipro", 850);
    }
}
