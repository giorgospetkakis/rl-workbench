package game_engine.implementation;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/**
 * @author giorgospetkakis
 * The Hand class represents a sequence of cards a Player holds.
 */
public class Hand extends PlayerComponent {

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
        this.type = "Hand";
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
     */
    public void addCard(Card card){
        if (cardsInHand.size() < maxHandSize)
            cardsInHand.put(card.hashCode(), card);
    }

    public void drawFrom(Deck deck){
        if (cardsInHand.size() > maxHandSize)
            addCard(deck.draw());
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
