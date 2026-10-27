package javaDesignPatterns;

/**
 * Problem: Create Car and Bike interfaces with concrete implementations.
 * Use CarFactory and BikeFactory through an abstract VehicleFactory
 * so the client can create vehicles without knowing their concrete classes.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class AbstractFactoryExample {

    // Define the common behavior of cars.
    interface Car {
        void drive();
    }

    // Define the common behavior of bikes.
    interface Bike {
        void ride();
    }

    // Implement the Car interface for a sedan.
    static class Sedan implements Car {
        // Display the sedan operation.
        public void drive() {
            System.out.println("Driving Sedan");
        }
    }

    // Implement the Car interface for an SUV.
    static class SUV implements Car {
        // Display the SUV operation.
        public void drive() {
            System.out.println("Driving SUV");
        }
    }

    // Implement the Bike interface for a sports bike.
    static class SportsBike implements Bike {
        // Display the sports bike operation.
        public void ride() {
            System.out.println("Riding Sports Bike");
        }
    }

    // Implement the Bike interface for a normal bike.
    static class NormalBike implements Bike {
        // Display the normal bike operation.
        public void ride() {
            System.out.println("Riding Normal Bike");
        }
    }

    // Declare the factory methods for vehicle families.
    interface VehicleFactory {
        Car createCar();
        Bike createBike();
    }

    // Create a factory that provides car products.
    static class CarFactory implements VehicleFactory {
        // Create a sedan as the car product.
        public Car createCar() {
            return new Sedan();
        }

        // Create a normal bike as the second product.
        public Bike createBike() {
            return new NormalBike();
        }
    }

    // Create a factory that provides bike-focused products.
    static class BikeFactory implements VehicleFactory {
        // Create an SUV as the car product.
        public Car createCar() {
            return new SUV();
        }

        // Create a sports bike as the bike product.
        public Bike createBike() {
            return new SportsBike();
        }
    }

    // Test the Abstract Factory pattern.
    public static void main(String[] args) {
        // Create the first vehicle factory.
        VehicleFactory carFactory = new CarFactory();

        // Create and use its car.
        Car sedan = carFactory.createCar();
        sedan.drive();

        // Create and use its bike.
        Bike normalBike = carFactory.createBike();
        normalBike.ride();

        // Create the second vehicle factory.
        VehicleFactory bikeFactory = new BikeFactory();

        // Create and use its car.
        Car suv = bikeFactory.createCar();
        suv.drive();

        // Create and use its bike.
        Bike sportsBike = bikeFactory.createBike();
        sportsBike.ride();
    }
}
