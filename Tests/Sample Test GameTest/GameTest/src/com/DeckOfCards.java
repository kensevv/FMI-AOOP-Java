package com;

import cards.Card;
import cards.FaceOfCard;
import cards.SuitOfCard;

import java.util.*;

public class DeckOfCards {
    private ArrayList<Card> cards;
    private int currentCard;

    private Random randomNumbers; // random number generator
    private final int NUMBER_OF_CARDS = 52; // constant number of Cards

    public DeckOfCards() {
        this.cards = fillDefaultDeck();
        this.currentCard = 0;
        randomNumbers = new Random();
    }

    public ArrayList<Card> getCards() {
        //creating deep copy arraylist of our deck and returning it as a result.
        ArrayList<Card> cardsCopy = new ArrayList<>(cards.size());
        for (Card card : cards){
            cardsCopy.add(new Card(card));
        }
        return cardsCopy;
    }

    private ArrayList<Card> fillDefaultDeck(){
        ArrayList<Card> defaultDeck = new ArrayList<>(NUMBER_OF_CARDS);
        for (FaceOfCard face : FaceOfCard.values()) {
            for (SuitOfCard suit : SuitOfCard.values()) {
                defaultDeck.add(new Card(FaceOfCard.valueOf(face.name()),
                        SuitOfCard.valueOf(suit.name())));
            }
        }
        return defaultDeck;
    }

    public void shuffleCards(){
        // after shuffling, dealing should start at deck[ 0 ] again
        currentCard = 0;

        // for each Card, pick another random Card and swap them
        for ( int first = 0; first < cards.size(); first++ )
        {
            // select a random number between 0 and 51
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            // swap current Card with randomly selected Card
            Collections.swap(cards, first, second);
        }
    }
    public Card[] dealFive(){
        Card[] hand = new Card[5];

        for (int i = 0; i < 5; i++) {
            // making sure the current card is in bounds
            if(this.currentCard < NUMBER_OF_CARDS) {
                hand[i] = new Card(cards.get(this.currentCard)); // will set deep copy of original card
                this.currentCard++;
            }
            // if its not we fill the remaining with nulls as said in the description
            else {
                hand[i] = null;
            }
        }
        return hand; // returning the deep copy of 5 cards
    }

    public static void sortByFaceCards(ArrayList<Card> cardList){
        ArrayList<Card> sortedCards = new ArrayList<>(cardList.size());
        for (FaceOfCard face : FaceOfCard.values()){
            for (Card card : cardList){
                if(card.getFace().equals(face)){
                    sortedCards.add(card);
                }
            }
        }
        // printing sorted cardList
        cardList = sortedCards;
        for (Card card : cardList){
            System.out.println(card);
        }
    }

    public void printBySuits(){
        for(SuitOfCard suit : SuitOfCard.values()){
            System.out.println(suit.getSuit() + ":");
            for(Card card : this.cards){
                if (card.getSuit().equals(suit)){
                    System.out.println(card);
                }
            }
            System.out.println(); // new line
        }
    }
    public List<FaceOfCard> getDistinctFaces (Card[] hand){
        List<FaceOfCard> result = new ArrayList<>(12);
        for(FaceOfCard face : FaceOfCard.values()){
            for(Card card : hand){
                if(card.getFace().equals(face)){
                    result.add(card.getFace());
                    break;
                }
            }
        }
        return result;
    }
}
