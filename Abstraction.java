abstract class Vehicle {
    abstract void start();

    void fuel() {
        System.out.println("Filling petro/Diesel");
    }

}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike started with kick");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Vehicle v = new Bike();
        v.start();
        v.fuel();
    }

}
