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
        for(PlayingCard.Suit suit: PlayingCard.Suit.values()){
            for(PlayingCard.Rank rank: PlayingCard.Rank.values()){
                this.addCard(new PlayingCard(suit,rank));
            }
        }
        this.shuffle();
    }



}

