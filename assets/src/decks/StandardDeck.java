package decks;

import cards.PlayingCard;
import cards.Rank;
import cards.Suit;
import players.AbstractPlayer;

public class StandardDeck extends AbstractDeck<PlayingCard>{

    /**
     * Default constructor that initializes the capacity to 52.
     * Initializes deck and shuffles.
     */
    public StandardDeck(){
        super(52);
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                this.addCard(new PlayingCard(suit,rank));
            }
        }
        this.shuffle();
    }

    public <T extends AbstractPlayer> void distributeDeck(final T p1, final T p2, final int numCards){
        for(int i = 0; i < numCards; i++){
            p1.addCardToHand(this.draw());
            p2.addCardToHand(this.draw());
        }
    }

}

