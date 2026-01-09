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
        if(!hand.remove(card)){System.err.println("Card not found in hand, are you sure it's in there??");}
    }

    public int getNumCardsInHand(){return this.hand.size();}

    public void shuffleHand(){
        Collections.shuffle(hand);
    }

    public T playCard(){
        return this.hand.removeFirst();
    }


    public abstract String toString();

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
