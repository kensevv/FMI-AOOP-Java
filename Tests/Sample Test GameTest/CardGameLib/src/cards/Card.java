package cards;

public class Card {
    private FaceOfCard face;
    private SuitOfCard suit;

    public FaceOfCard getFace() {
        // deep copy
        return FaceOfCard.valueOf(face.name());
    }

    public void setFace(FaceOfCard face) {
        if(face != null){
            this.face = face;
        }
        else {
            this.face = FaceOfCard.ACE;
        }
    }

    public SuitOfCard getSuit() {
        // deep copy
        return SuitOfCard.valueOf(suit.name());
    }

    public void setSuit(SuitOfCard suit) {
        if(suit != null){
            this.suit = suit;
        }
        else {
            this.suit = SuitOfCard.SPADES;
        }
    }

    public Card(FaceOfCard face, SuitOfCard suit) {
        setFace(face);
        setSuit(suit);
    }

    public Card(Card other){
        // get methods return deep copy.
        setFace(other.getFace());
        setSuit(other.getSuit());
    }

    @Override
    public String toString() {
        return String.format("%s of %s",face.getFace(),suit.getSuit());
    }
}
