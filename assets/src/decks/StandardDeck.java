package decks;

import cards.PlayingCard;

/**
 * Class that represents a standard deck of playing cards.
 * @author Jordan Miller
 */
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

