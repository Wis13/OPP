package interfaces;

public class InterfaceRunner {
    public static void main(String[] args) {
        Pricable pizza = new Pizza("Neapolitana", 1, 20,Size.L );
        Pricable phone = new CellPhone("Nokia", "N-95", 2, 290);
        Pricable fridge = new Fridge("Samsung", "E90", 1, 499);


        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);


    }
    private static void printDeliveryPrice(Pricable del){
        System.out.println("Delivery price is "+ del.calcDeliveryPrice());
        System.out.println("Order price " + del.calcOrderPrice());
    }
}
