package cards;

public class Card {
    private int face;
    private int suit;

    //public static final String faces[] = {"ACE", "KING", "QUEEN", "JACK", "TEN", "NINE", "EIGHT", "SEVEN"};
    //public static final String suits[] = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};

    public static final Face[] faces = {Face.ACE, Face.KING, Face.QUEEN, Face.JACK, Face.TEN, Face.NINE, Face.EIGHT, Face.SEVEN };
    public static final Suit[] suits = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        if(face >= 0 && face < 8){
            this.face = face;
        }
        else {
            this.face = 0;
        }
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        if(face >= 0 && face < 4){
            this.suit = suit;
        }
        else {
            this.suit = 0;
        }
    }

    public Card(int face, int suit) {
        setFace(face);
        setSuit(suit);
    }

    public String getSuitName(){
        return new String(suits[suit].name());
    }

    public String getFaceName(){
        return new String(faces[face].name());
    }

    @Override
    public String toString() {
        return String.format("%s of %s", faces[face].name(), suits[suit].name());
    }
}
