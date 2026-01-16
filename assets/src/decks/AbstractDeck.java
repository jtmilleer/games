package decks;

import cards.AbstractCard;
import games.GameObject;
import players.AbstractPlayer;

import java.util.*;

/**
 * Class that represents a basic deck. Each new deck class should extend this class.
 * This deck can hold a specified number of cards, shuffle those cards, and get information about the deck
 * @param <T> Class that extends <code>AbstractCard</code>
 * @author Jordan Miller
 */
public abstract class AbstractDeck<T extends AbstractCard> extends GameObject {
    private final Deque<T> deck = new LinkedList<>();

    public final int capacity;

    /**
     * Initializes an empty deck with capacity <code>capacity</code>.
     * The subclass constructor is responsible for adding cards.
     * @param capacity capacity of the deck. This cannot be changed after construction.
     */
    public AbstractDeck(final int capacity){
        this.capacity = capacity;
    }

    //TODO can this be made a bit more efficient.
    /**
     * Randomly shuffles all cards in deck. This method clears and adds all cards from the Deque each method call.
     */
    public final void shuffle() {
        final List<T> temp = new ArrayList<>(deck);
        Collections.shuffle(temp);
        deck.clear();
        deck.addAll(temp);
    }

    /**
     * Draws the top card of the deck.
     * @throws NoSuchElementException If deck is empty.
     * @return Top card of the deck.
     */
    public final T drawCard(){
        if(deck.isEmpty()){
            //System.err.println("Deck is empty");
            throw new NoSuchElementException("Deck is empty");
        }
        return this.deck.pop();
    }

    /**
     * Adds card to the top of the deck.
     * Deck should be shuffled after card is added if randomness is desired.
     * @throws IllegalStateException If deck is at capacity.
     * @param card Card to be added to the deck.
     */
    public final void addCard(final T card){
        if(deck.size() >= this.capacity){
            throw new IllegalStateException("Deck is full");
        }
        deck.push(card);
    }

    /**
     * Gets the amount of cards currently in the deck. This is not the capacity.
     * @return Current amount of cards in the deck
     */
    public final int getCardCount(){return this.deck.size();}

    /**
     * Method to check if the deck is empty or not.
     * @return true if the deck is empty, false if not.
     */
    public final boolean isEmpty(){return this.deck.isEmpty();}

    /**
     * Method to distribute the deck to a variable number of players.
     * @param numCards number of cards to distribute to each player
     * @param ps list of players
     */
    @SafeVarargs
    public final <P extends AbstractPlayer<T>> void distributeDeck(final int numCards, P ... ps){
        for(int i = 0; i < numCards; i++){
            for(P p: ps){
                try{
                    p.addCardToHand(drawCard());
                } catch (NoSuchElementException e){
                    System.err.println("Deck is empty");
                    return;
                }

            }
        }
    }

}
