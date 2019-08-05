package interfaces;

public interface Pricable extends Deliveable, Orderable {

    default int calcPrice(){
        return calcOrderPrice() + calcDeliveryPrice();
    }

}
