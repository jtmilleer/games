package decks;

import cards.PlayingCard;
import cards.Rank;
import cards.Suit;

public class StandardDeck extends AbstractDeck<PlayingCard>{

    /**
     * Default constructor that initializes the capacity to 52.
     */
    public StandardDeck(){
        super(52);
    }

    /**
     * Adds all standard cards to the deck, then shuffles them.
     */
    @Override
    public void initalizeDeck() {
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                this.addCard(new PlayingCard(suit.name(),rank.name()));
            }
        }
        this.shuffle();
    }


}

