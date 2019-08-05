package inheritance;

import java.util.List;

public class InheritanceMain {
    public static void main(String[] args) {

        Engine truckEngine = new Engine(6.0,EngineType.DIESEL,900);
        Engine busEngine = new Engine(3.5,EngineType.DIESEL,350);
        Auto bus = new Bus("Mercedes","Sprinter",busEngine,30,75, 12);
        Auto truck = new Truck("Volvo", "VNL 300", truckEngine, 500,1000);
        Auto car = new ElectricCar("Tes", "Model S", 1050, 4);
        //Auto auto = new Auto("Mazda", "CX-9", busEngine);

        runCar(bus);
        runCar(truck);
        runCar(car);
       // runCar(auto);

    }
    private static void runCar(Auto auto){
        auto.start();
        auto.stop();
        auto.energize();
    }

}
