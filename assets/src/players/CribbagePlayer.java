package players;

import cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class CribbagePlayer extends AbstractPlayer<PlayingCard>{

    public CribbagePlayer(){}

    @Override
    public void addCardToHand(final PlayingCard card){
        if(hand.size() <= 6){
            System.err.println("Cannot add card, hand is full");
            return;
        }
        hand.add(card);
    }





    public static int countHand(final List<PlayingCard> hand, final PlayingCard flippedCard){
        if(flippedCard == null || hand == null){throw new IllegalArgumentException("Hand and flipped card cannot be null");}

        if(hand.size() != 4){throw new IllegalArgumentException("Hand must be size 4 to count");}




        return -1;


    }

    @Override
    public String toString() {
        return getUsername() + "(CribbagePlayer):" + player_ID;
    }
}
