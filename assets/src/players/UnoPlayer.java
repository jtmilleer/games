package players;

import cards.UnoCard;

import java.util.List;

public class UnoPlayer extends AbstractPlayer<UnoCard> {

    private static int count;

    public UnoPlayer(final String name){
        super(name);
        count++;
    }

    @Override
    public String toString() {
        return getUsername() + "(UnoPlayer)" + player_ID;
    }


}
