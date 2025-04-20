package org.example.designPatterns.creational.builder;

public class Builder {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder().setColor("White").setEngine("V8").setWheels(4).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheels());
        System.out.println(car.getColor());
    }
}

class Car {
    private String engine;
    private int wheels;
    private String color;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.color = builder.color;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    public static class CarBuilder {
        private String engine;
        private int wheels;
        private String color;

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
