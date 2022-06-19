package com.decks;

public class Card {
    private String face; // face of card ("Ace", "Deuce", ...)
    private String suit; // suit of card ("Hearts", "Diamonds", ...)

    public Card(String cardFace, String cardSuit)
    {
        face = cardFace;
        suit = cardSuit;
    }

    public String getFace() {
        return face;
    }

    public String getSuit(){
        return suit;
    }

    public String toString()
    {
        return face + " of " + suit;
    }
}
