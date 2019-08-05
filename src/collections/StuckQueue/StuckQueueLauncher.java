package collections.StuckQueue;

import collections.collectionsClass.Card;
import collections.collectionsClass.CardComparator;

import java.util.*;

public class StuckQueueLauncher {
    public static void main(String[] args) {
       // passengerProcessing();


        Queue<Card> cardDeck = new PriorityQueue<>(52, new CardComparator());
        for (Card.Face face : Card.Face.values()){
            for (Card.Suit suit : Card.Suit.values()){
                cardDeck.offer(new Card(suit, face));
            }
        }

        Deque<Card> cards = new ArrayDeque<>();
        for (int i =0; i<10;i++){
            cards.offerLast(cardDeck.poll());
        }
        for (int i =0; i<10;i++){
            System.out.println(cards.poll());
        }




        for (int i = 0; i<10; i++){
            System.out.println(cardDeck.poll());
        }
        System.out.println("Deck size is "+cardDeck.size());
        System.out.println(cardDeck.peek());
        System.out.println(cardDeck.peek());
    }

    private static void passengerProcessing(){
        Stack<Passenger> bus = new Stack<>();
        Passenger passenger=(new Passenger("Alex", "Vasko"));
        bus.push(new Passenger("Gogi", "Ruchko"));
        bus.push(new Passenger("Max", "Pivko"));
        bus.push(new Passenger("Den", "Bochko"));
        bus.push(passenger);
        bus.push(new Passenger("Ivan", "Sivko"));

        System.out.println("Passenger found at position " +bus.search(passenger));

        System.out.println("Last passenger is: "+ bus.peek());
        while (!bus.empty()){
            System.out.println("Passenger " + bus.pop());
        }


        }


    public static class Passenger {
        private static int number = 1;
        private String name;
        private String surname;

        public Passenger(String name, String surname){
            number++;
            this.name = name;
            this.surname = surname;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public String toString() {
            return "Passenger "  + name + " " + surname;
        }
    }
}
