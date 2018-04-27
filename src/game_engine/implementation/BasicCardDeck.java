package game_engine.implementation;

import java.util.LinkedList;

public class BasicCardDeck extends Deck {

    /**
     * Basic constructor. Initializes a full ordered deck.
     */
    public BasicCardDeck(){
        super();
        init();
        this.type = "BasicCardDeck";
    }

    @Override
    protected void init() {
        for(BasicCard.Suit suit : BasicCard.Suit.values()){
            for(BasicCard.Value value : BasicCard.Value.values()){
                this.addToTop(new BasicCard(suit, value));
            }
        }
    }
}
