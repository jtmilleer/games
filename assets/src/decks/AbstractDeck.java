package decks;

import cards.AbstractCard;

import java.util.*;


abstract class AbstractDeck<T extends AbstractCard> {
    private final Deque<T> deck = new LinkedList<>();

    private final int capacity;

    public AbstractDeck(final int size){
        this.capacity = size;
    }

    public void shuffle() {
        final List<T> temp = new ArrayList<>(deck);
        Collections.shuffle(temp);
        deck.clear();
        deck.addAll(temp);
    }

    public T draw(){
        if(deck.isEmpty()){
            System.err.println("Deck is empty");
            throw new NoSuchElementException("Deck is empty");
        }
        return this.deck.pop();
    }

    public void addCard(final T card){
        if(deck.size() >= this.capacity){
            throw new IllegalStateException("Deck is full");
        }
        deck.push(card);
    }

    public int getCapacity(){return this.capacity;}

    public int getCardCount(){return this.deck.size();}

    public boolean isEmpty(){return this.deck.isEmpty();}

    /**
     * Abstract method that will allow subclasses to initialize the deck.
     */
    public abstract void initalizeDeck();
}
