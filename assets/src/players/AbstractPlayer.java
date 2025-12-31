package players;

import cards.AbstractCard;
import cards.PlayingCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractPlayer <T extends AbstractCard> {
    private String username;
    public final int player_ID;
    private static int count;
    final List<T> hand = new ArrayList<>();

    public AbstractPlayer(){
        this.player_ID = ++count;
        this.username = "AbstractPlayer_" + this.player_ID;
    }

    public AbstractPlayer(final String username){
        this.player_ID = ++count;
        this.username = username;
    }


    public final String getUsername(){return this.username;}

    public final void setUsername(){this.username = username;}

    public void addCardToHand(final T card){
        hand.add(card);
    }

    /**
     * Method to remove a Card from players hand.
     * @param card <code>PlayingCard</code> to remove from hand
     */
    public void removeCardFromHand(final T card){
        if(hand.isEmpty()){
            System.err.println("Cannot remove card, hand is empty");
            return;
        }
        for(T c: hand){
            if(c.equals(card)){hand.remove(c);}
            break;
        }
        System.err.println("Card not found in hand, are you sure it's in there??");
    }

    public int getNumCardsInHand(){return this.hand.size();}

    public void shuffleHand(){
        Collections.shuffle(hand);
    }


    public abstract String toString();
}
