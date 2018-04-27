package game_engine.implementation;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Deck extends GameComponent {

    protected ArrayList<Card> deck;

    /**
     * Basic constructor.
     */
    public Deck(){
        this.deck = new ArrayList<>();
    }

    /**
     * Constructor with specific initial size.
     * @param size the size of the deck
     */
    public Deck(int size){
        this.deck = new ArrayList<>(size);
    }

    /**
     * Initializes the deck.
     */
    protected abstract void init();

    /**
     * Draws a card from the deck.
     * @return the card drawn- null if deck is empty
     */
    public Card draw(){
        if(!deck.isEmpty()) {
            return deck.remove(deck.size()-1);
        } else {
            return null;
        }
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle(){
        Collections.shuffle(deck);
    }

    /**
     * Returns the size of the deck.
     * @return the size
     */
    public int size(){
        return this.deck.size();
    }

    /**
     * Adds a specific card to the selected index.
     * @param index The index to add the card to
     * @param card The card to add
     */
    public void addAt(int index, Card card){
        deck.add(index, card);
    }

    public void addToTop(Card card){
        addAt(deck.size(), card);
    }

    /**
     * Adds a card to a random spot in the deck.
     * @param card The card to add
     */
    public void addToRandomPosition(Card card){
        addAt((int)(Math.random() * deck.size()), card);
    }
}
