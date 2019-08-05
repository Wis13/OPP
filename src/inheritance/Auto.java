package inheritance;

public abstract class Auto {

    private String producer;
    private String model;
    private Engine engine;
    private int currentSpeed;
    protected boolean isRunning;

    public Auto(String producer, String model, Engine engine) {
        this.producer = producer;
        this.model = model;
        this.engine = engine;
        System.out.println("Auto was initialized");
    }

    public abstract void energize();

    public void start(){
        isRunning =true;
        currentSpeed =10;
        System.out.println("Auto is started");
    }

    public void stop(){
        System.out.println("Auto has stopped");
    }

    public void accelrating(int kmPerHour){
        currentSpeed+=kmPerHour;
        System.out.println("Accelrating. Current speed is " +currentSpeed+ " km in hour");
    }

    public String getProducer() {
        return producer;
    }


    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}
