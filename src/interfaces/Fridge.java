package interfaces;

public class Fridge extends Electronics implements Pricable {

    public Fridge(String make, String model, int quantity, int price){
        super(make, model, quantity, price);
    }

    @Override
    public int calcDeliveryPrice() {
        if (getPrice() >= 500){
            return 0;
        }else {
            return 25;
            }

    }
}
