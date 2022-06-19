package cards;

public enum SuitOfCard {
    CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"),
    SPADES("Spades");

    private final String suit;

    private SuitOfCard(String suit) {
        this.suit=suit;
    }

    public String getSuit() {
        return suit;
    }
}
