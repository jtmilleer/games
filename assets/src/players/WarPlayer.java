package players;

import cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class representing a Player for the game War.
 * Each player has a hand, and a Stack of cards that they have won playing war.
 * When their hand runs out, the stack of cards should be put back in their hand.
 * @author Jordan Miller
 */
public class WarPlayer extends AbstractPlayer<PlayingCard>{

    private static int count;

    private final List<PlayingCard> collectedCards = new ArrayList<>();

    /**
     * Default constructor, sets username to WarPlayer_count, where count is the number of
     * <code>WarPlayers</code> existing.
     */
    public WarPlayer() {
        super("WarPlayer_" + ++count);
    }

    /**
     * Constructor that sets the username to <code>name</code>
     * @param name username to be set.
     */
    public WarPlayer(final String name){
        super(name);
        count++;
    }


    /**
     * method to add 2 cards to the players stack of collected cards.
     * @param c1 first card to be added
     * @param c2 second card to be added
     */
    public void collectCards(final PlayingCard c1, final PlayingCard c2){
        this.collectedCards.add(c1);
        this.collectedCards.add(c2);
    }

    /**
     * Method to add a list of cards to the players stack of collected cards.
     * @param l <code>List</code> of cards, all cards get added.
     */
    public void collectCards(final List<PlayingCard> l){
        this.collectedCards.addAll(l);
    }


    /**
     * Method to return all the cards won from war back to original hand.
     * @return true if the player's hand is not empty, i.e. something was returned.
     */
    public boolean returnCollectedCardsToHand(){
        while(!collectedCards.isEmpty()){
            this.hand.add(collectedCards.removeFirst());
        }
        shuffleHand();
        return !this.hand.isEmpty();
    }

    @Override
    public String toString() {
        return getUsername() + "(WarPlayer):" + player_ID;
    }
}
