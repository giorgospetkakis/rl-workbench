package game_engine.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/**
 * @author giorgospetkakis
 * The Hand class represents a sequence of cards a Player holds.
 */
public class Hand extends PlayerComponent {

    private static final String ALIAS = "HAND";

    private LinkedHashMap<Integer, Card> cardsInHand;
    private int maxHandSize = 100;

    /**
     * Constructor with hand size limit.
     * @param maxHandSize the maximum hand size
     */
    public Hand(int maxHandSize){
        this();
        this.maxHandSize = maxHandSize;
    }

    /**
     * Core constructor.
     */
    public Hand(){
        this.cardsInHand = new LinkedHashMap<>(maxHandSize);
    }

    /**
     * @return an ordered collection of the cards in hand
     */
    public Collection<Card> getCards(){
        return cardsInHand.values();
    }

    /**
     * Adds a card to the hand.
     * @param card the card being added
     * @return true if card added, false if at max hand capacity
     */
    public boolean addCard(Card card){
        // Game should not continue running if hand-size exceeds max.
        assert(cardsInHand.size() <= maxHandSize);
        if (cardsInHand.size() == maxHandSize) {
            return false;
        } else {
            cardsInHand.put(card.hashCode(), card);
            return true;
        }
    }

    /**
     * Removes the selected card.
     * @param card the card to remove
     */
    public void removeCard(Card card){
        if (cardsInHand.containsValue(card)){
            cardsInHand.remove(card.hashCode());
        } else {
            throw new NoSuchElementException();
        }
    }
}
