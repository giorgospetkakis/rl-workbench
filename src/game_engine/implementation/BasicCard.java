package game_engine.implementation;

public class BasicCard extends Card {

    Suit suit;
    Value value;

    /**
     * Basic Card constructor.
     * @param suit The suit of the card
     * @param value The value of the card
     */
    public BasicCard(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public String toString(){
        return this.value + " of " + this.suit;
    }

    public enum Suit{
        Diamonds,
        Spades,
        Clubs,
        Cups
    }

    public enum Value{
        Ace(1),
        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Six(6),
        Seven(7),
        Eight(8),
        Nine(9),
        Ten(10),
        Jack(10),
        Queen(10),
        King(10);

        private int value;
        Value(int val){
            this.value = val;
        }

        public int getValue(){
            return value;
        }
    }
}
