package decks;

import cards.AbstractCard;
import players.AbstractPlayer;

import java.util.*;


abstract class AbstractDeck<T extends AbstractCard> {
    private final Deque<T> deck = new LinkedList<>();

    private final int capacity;

    public AbstractDeck(final int size){
        this.capacity = size;
    }

    public final void shuffle() {
        final List<T> temp = new ArrayList<>(deck);
        Collections.shuffle(temp);
        deck.clear();
        deck.addAll(temp);
    }

    public final T draw(){
        if(deck.isEmpty()){
            //System.err.println("Deck is empty");
            throw new NoSuchElementException("Deck is empty");
        }
        return this.deck.pop();
    }

    public final void addCard(final T card){
        if(deck.size() >= this.capacity){
            throw new IllegalStateException("Deck is full");
        }
        deck.push(card);
    }

    public final int getCapacity(){return this.capacity;}

    public final int getCardCount(){return this.deck.size();}

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
                    p.addCardToHand(draw());
                } catch (NoSuchElementException e){
                    System.err.println("Deck is empty");
                    return;
                }

            }
        }
    }

}
