package collections.collectionsClass;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card implements Comparable<Card>{



    public enum Suit{SPADES, HEARTS, CLUMBS, DIMONDS}

    public enum Face{ACE, DEUSE, TREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}

   public final Suit suit;

    private final Face face;

    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    public Suit getSuit() {
        return suit;
    }

    public Face getFace() {
        return face;
    }

    @Override
    public int compareTo(Card card) {
        Face[] values = Face.values();
        List<Face> faces = Arrays.asList(values);
                if (faces.indexOf(this.face)<faces.indexOf(card.getFace()) ){
                    return -1;
                }else if (faces.indexOf(this.face)>faces.indexOf(card.getFace())){
                    return +1;
                }else if (faces.indexOf(this.face)==faces.indexOf(card.getFace())){
                    return String.valueOf(suit).compareTo(String.valueOf(card.getSuit()));
                }
        System.out.println(card);

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit &&
                face == card.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, face);
    }

    @Override
    public String toString() {
        return face + " of "+suit;
    }
}
