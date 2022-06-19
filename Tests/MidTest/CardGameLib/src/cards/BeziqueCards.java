package cards;

import java.util.Random;

public class BeziqueCards {
    private Card[] cards; // масив от всички карти в тестето от карти
    private Card[] hand; // текущо изтеглена ръка от най- много 14 карти
    private Suit trump; // цвят, избран за Коз на играта
    private Random random; // генератор на случайни числа
    int currentCard; // брой карти изтеглени текущо от cards

    private final int NUMBER_OF_CARDS = 64;

    public BeziqueCards(){
        currentCard = 0;
        random = new Random();
        cards = new Card[NUMBER_OF_CARDS];
        hand = new Card[14];
        trump = Card.suits[random.nextInt(3)];

        fill64DefaultCards();
    }
    private void fill64DefaultCards(){
        int cardIndex = 0;
        for (int i = 0; i < Card.suits.length; i++) {
            for (int j = 0; j < Card.faces.length; j++) {
                cards[cardIndex] = new Card(j,i);
                cardIndex++;
            }
            for (int j = 0; j < Card.faces.length; j++) {
                cards[cardIndex] = new Card(j,i);
                cardIndex++;
            }
        }
    }

    public Suit getTrump(){
        return Suit.valueOf(trump.name()); // returning deep copy
    }

    public void shuffleCards(){
        currentCard = 0;

        for ( int first = 0; first < cards.length; first++ )
        {
            int second = random.nextInt(NUMBER_OF_CARDS);
            Card temp = cards[first];
            cards[first] = cards[second];
            cards[second] = temp;
        }
    }

    public String printCards(){
        String result = "";

        int counter = 0;
        for (int i = 0; i < hand.length; i++) {
            if(counter == 3){
                result += "\n";
                counter = 0;
            }
            if(hand[i] != null) {
                result += hand[i].toString() + ", ";
                counter++;
            }
            else {
                break;
            }
        }
        return result;
    }

    public boolean dealHand(){
        hand = new Card[14]; // resetting hand
        // dealing 14 cards
        for (int i = 0; i < 14; i++) {
            if(currentCard == cards.length){
                break;
            }
            hand[i] = cards[currentCard];
            currentCard++;
        }

        if (currentCard < NUMBER_OF_CARDS){
            return true;
        }
        return false;
    }

    public boolean hasMarriage(){
        boolean hasKFromTrump = false;
        boolean hasQFromTrump = false;

        for (int i = 0; i < hand.length; i++) {
            if(hand[i] == null){
                break;
            }
            if(Card.faces[hand[i].getFace()].name().equals("KING") &&
            Card.suits[hand[i].getSuit()].equals(trump)){
                hasKFromTrump = true;
            }
            if(Card.faces[hand[i].getFace()].name().equals("QUEEN") &&
                    Card.suits[hand[i].getSuit()].equals(trump)){
                hasQFromTrump = true;
            }
        }
        if(hasKFromTrump == true && hasQFromTrump == true){
            return true;
        }
        return false;
    }

    public boolean hasAKQJ10(){
        boolean hasACE = false;
        boolean hasKING = false;
        boolean hasQUEEN = false;
        boolean hasJACK = false;
        boolean hasTEN = false;

        for (int i = 0; i < hand.length; i++) {
            if(hand[i] == null){
                break;
            }
            if( Card.faces[hand[i].getFace()].name().equals("ACE")
            && Card.suits[hand[i].getSuit()].equals(trump)){
                hasACE = true;
            }

            if( Card.faces[hand[i].getFace()].name().equals("KING")
                    && Card.suits[hand[i].getSuit()].equals(trump)){
                hasKING = true;
            }

            if( Card.faces[hand[i].getFace()].name().equals("QUEEN")
                    && Card.suits[hand[i].getSuit()].equals(trump)){
                hasQUEEN = true;
            }

            if( Card.faces[hand[i].getFace()].name().equals("JACK")
                    && Card.suits[hand[i].getSuit()].equals(trump)){
                hasJACK = true;
            }

            if( Card.faces[hand[i].getFace()].name().equals("TEN")
                    && Card.suits[hand[i].getSuit()].equals(trump)){
                hasTEN = true;
            }

        }

        return hasACE == true &&
                hasKING == true &&
                hasQUEEN == true &&
                hasJACK == true &&
                hasTEN == true;
    }
}
