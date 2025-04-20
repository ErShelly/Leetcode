package org.example.designPatterns.creational.factoryMethod;


public class FactoryMethod {
    //Driver
    public static void main(String[] args) {
        VehicleFactory twoWheelerFactory = new TwoWheelerFactory();
        Client twoWheelerClient = new Client(twoWheelerFactory);
        Vehicle twoWheeler = twoWheelerClient.getVehicle();
        twoWheeler.printVehicle();

        VehicleFactory fourWheelerFactory = new FourWheelerFactory();
        Client fourWheelerClient = new Client(fourWheelerFactory);
        Vehicle fourWheeler = fourWheelerClient.getVehicle();
        fourWheeler.printVehicle();
    }

}


//Product interface
abstract class Vehicle {
    public abstract void printVehicle();
}

//Concrete product class
class TwoWheelerVehicle extends Vehicle {
    @Override
    public void printVehicle() {
        System.out.println("I am a two-wheeler vehicle");
    }
}

//Concrete product class
class FourWheelerVehicle extends Vehicle {
    @Override
    public void printVehicle() {
        System.out.println("I am a four-wheeler vehicle");
    }
}

//Factory Interface
interface VehicleFactory {
    Vehicle createVehicle();
}

//Product Factory
class TwoWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        TwoWheelerVehicle twoWheelerVehicle = new TwoWheelerVehicle();
        return twoWheelerVehicle;
    }
}

//Product Factory
class FourWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        FourWheelerVehicle fourWheelerVehicle = new FourWheelerVehicle();
        return fourWheelerVehicle;
    }
}


//Client Class
class Client {
    private Vehicle pVehicle;

    public Client(VehicleFactory factory) {
        this.pVehicle = factory.createVehicle();
    }

    public Vehicle getVehicle() {
        return pVehicle;
    }
}

