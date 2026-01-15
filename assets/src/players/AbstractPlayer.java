package players;

import cards.AbstractCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that represents a basic player. Has a name and a hand.
 * @param <T> Card that extends <code>AbstractCard</code>
 * @author Jordan Miller
 */
public abstract class AbstractPlayer <T extends AbstractCard> {
    private String username;
    public final int player_ID;
    private static int count;
    final List<T> hand = new ArrayList<>();


    /**
     * Default constructor, sets username to "AbstractPlayer_playerID"
     * where playerID is unique id for object.
     */
    public AbstractPlayer(){
        this.player_ID = ++count;
        this.username = "AbstractPlayer_" + this.player_ID;
    }

    /**
     * Constructor that sets username to specified value
     * @param username username for the player
     */
    public AbstractPlayer(final String username){
        this.player_ID = ++count;
        this.username = username;
    }

    /**
     * Getter for username
     * @return the username of the player
     */
    public final String getUsername(){return this.username;}

    /**
     * Setter for username
     * @param username <code>String</code> holding new username
     */
    public final void setUsername(final String username){this.username = username;}

    /**
     * Adds given card to hand
     * @param card card to add to hand.
     */
    public void addCardToHand(final T card){
        hand.add(card);
    }

    public boolean isHandEmpty(){return this.hand.isEmpty();}

    /**
     * Method to remove a Card from players hand.
     * @param card <code>PlayingCard</code> to remove from hand
     */
    public void removeCardFromHand(final T card){
        if(hand.isEmpty()){
            System.err.println("Cannot remove card, hand is empty");
            return;
        }
        if(!hand.remove(card)){System.err.println("Card not found in hand, are you sure it's in there??");}
    }

    /**
     * Gets the current number of cards in the player hand.
     * @return number of cards in hand.
     */
    public int getNumCardsInHand(){return this.hand.size();}

    /**
     * Method to shuffle the hand in place.
     */
    public void shuffleHand(){
        Collections.shuffle(hand);
    }


    //TODO overload to take int to specify what card to play?
    /**
     * Method to play the first card in the hand.
     * @return the played card, gets removed from hand.
     */
    public T playCard(){
        return this.hand.removeFirst();
    }

    /**
     * abstract toString. All subclasses must implement.
     * @return <code>String</code> representation of the Player.
     */
    public abstract String toString();

    /**
     * Method to print the players hand horizontally in the console.
     */
    public void printHandHorizontal() {
        if (hand.isEmpty()) {
            System.out.println("(Empty hand)");
            return;
        }

        final int cardHeight = 8; // same as AbstractCard.cardRep
        String[] lines = new String[cardHeight];

        for (int i = 0; i < cardHeight; i++) lines[i] = "";

        for (int index = 0; index < hand.size(); index++) {
            T card = hand.get(index);

            String top = card.getName();
            String center = "chage me AbstractPlayer line 75";

            String[] repLines = card.toString().split("\n");
            //String[] repLines = AbstractCard.cardRep(top, center).split("\n");

            for (int i = 0; i < cardHeight; i++) {
                lines[i] += repLines[i] + "  ";
            }
        }

        for (String line : lines) {
            System.out.println(line);
        }

        // print indices for player input
        for (int i = 0; i < hand.size(); i++) {
            System.out.print("    " + (i + 1) + "       "); // align with card width
        }
        System.out.println();
    }
}
