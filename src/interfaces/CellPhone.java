package interfaces;

public class CellPhone extends Electronics implements Deliveable {
    public CellPhone(String make, String model, int quantity, int price){
        super(make, model, quantity, price);
    }

    @Override
    public int calcDeliveryPrice() {
        if (getPrice() >= 300 || getQuantity()> 1){
            return 0;
        } else {
            return 10;
        }


    }
}
