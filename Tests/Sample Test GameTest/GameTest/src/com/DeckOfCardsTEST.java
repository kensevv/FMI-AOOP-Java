package com;

import cards.Card;
import cards.FaceOfCard;

import java.util.List;

public class DeckOfCardsTEST {
    public static void main(String[] args) {
        System.out.println("TEST 1 - Default constructor, printBySuits.");
        DeckOfCards testDeck = new DeckOfCards();
        testDeck.printBySuits(); // initially should print all cards sorted, as constructed in the default constructor

        System.out.println("TEST 2 - Shuffling the deck and then - printBySuits.");
        testDeck.shuffleCards(); // shuffling our test deck of cards
        testDeck.printBySuits(); // now printing the shuffled deck of cards.

        System.out.println("TEST 3 - Dealing 5 cards and printing them");
        Card[] hand = testDeck.dealFive(); // dealing 5 cards from the deck
        // printing the dealed cards:
        for ( Card card : hand){
            System.out.println(card);
        }

        System.out.println("TEST 4 - getDistinctFaces of the dealed 5 cards");
        List<FaceOfCard> distingFaces = testDeck.getDistinctFaces(hand); //getting the unique faces of our dealed hand.
        // printing them
        for(FaceOfCard face : distingFaces){
            System.out.println(face);
        }

        System.out.println("TEST 5 - sortByFace - print");
        DeckOfCards.sortByFaceCards(testDeck.getCards()); // sorting our deck of cards again and printing it.
    }
}
