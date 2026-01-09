package players;

import cards.PlayingCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WarPlayer extends AbstractPlayer<PlayingCard>{

    private static int count;

    private final List<PlayingCard> collectedCards = new ArrayList<>();

    public WarPlayer() {
        super("WarPlayer_" + ++count);
    }

    public WarPlayer(final String name){
        super(name);
        count++;
    }



    public void collectCards(final PlayingCard c1, final PlayingCard c2){
        this.collectedCards.add(c1);
        this.collectedCards.add(c2);
    }

    public void collectCards(final List<PlayingCard> l){
        this.collectedCards.addAll(l);
    }

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
