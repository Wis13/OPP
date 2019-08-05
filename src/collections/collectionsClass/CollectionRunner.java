package collections.collectionsClass;

import java.util.*;

public class CollectionRunner {
    public static void main(String[] args) {
        List<collections.collectionsClass.Card> deckOfCard = new ArrayList<>();
        for (collections.collectionsClass.Card.Face face: collections.collectionsClass.Card.Face.values()){
            for (collections.collectionsClass.Card.Suit suit : collections.collectionsClass.Card.Suit.values()){
                deckOfCard.add(new collections.collectionsClass.Card(suit, face));
            }
        }

//        System.out.println("Original deck of cards \n");
//        for (int i = 0; i<deckOfCard.size(); i++){
//            System.out.printf("%-20s %s",deckOfCard.get(i), (i + 1)%4 ==0 ? "\n":"  ");
//        }
        Collections.shuffle(deckOfCard);
        Collections.sort(deckOfCard);

        collections.collectionsClass.Card card = new collections.collectionsClass.Card(collections.collectionsClass.Card.Suit.SPADES, collections.collectionsClass.Card.Face.QUEEN);
        int i = Collections.binarySearch(deckOfCard, card);
        if (i>=0){
            System.out.println(" Card was found at position "+i);
        }else {
            System.out.println("Cart was not found");
        }

        List<collections.collectionsClass.Card> cardList = new ArrayList<>(deckOfCard);
        Collections.fill(cardList, card);
        Collections.addAll(cardList, card, card, card);
        Collections.copy(cardList, deckOfCard);
        int frequency = Collections.frequency(cardList, card);
        System.out.println("Frequency of "+ card +" is " + frequency);
        PrintOutput(cardList);


        System.out.println("\nCard after shiuffle \n");
  //      PrintOutput(deckOfCard);

        Collections.sort(deckOfCard, new CardComparator());
        System.out.println("\nCard after sort \n");
   //     PrintOutput(deckOfCard);
    }

    private static void PrintOutput(List<collections.collectionsClass.Card> deckOfCard) {
        for (int i = 0; i < deckOfCard.size(); i++) {
            System.out.printf("%-20s %s", deckOfCard.get(i), (i + 1) % 4 == 0 ? "\n" : "  ");
        }
    }

}
