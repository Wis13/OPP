package inheritance;

public class Bus extends FuelAuto{

    private int passengerNumber;

    public Bus(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int passengerNumber) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.passengerNumber = passengerNumber;
        System.out.println("Bus was initialized");
    }

    public void fuelUp(){
        int volume = getTankVolume() - getAvailablePetrol();
        fuelUp(volume);

    }

    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePetrol() + petrolVolume;
        if(volume > getTankVolume()){
            setAvailablePetrol(getTankVolume());
        }
        System.out.println("Adding DIEZEL");
    }

    @Override
    public void start() {
        isRunning =true;
        setCurrentSpeed(10);
        System.out.println("Bus is starting");
    }

    @Override
    public void stop() {
        isRunning =false;
        setCurrentSpeed(0);
        System.out.println("Bus has stopped");
    }


    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public void pickUpPassenger(int passengerNumber){
        this.passengerNumber+=passengerNumber;
        System.out.println("Picking up "+ passengerNumber+ " passengers");
    }

    public void releasePassangers(){
        if(isRunning){
            stop();
        }
        passengerNumber=0;
        System.out.println("Passenger release");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolume()-getAvailablePetrol());
    }
}
