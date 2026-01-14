package decks;

import cards.UnoCard;

public class UnoDeck extends AbstractDeck<UnoCard> {



    public UnoDeck() {
        super(108);
        for (UnoCard.Color color : UnoCard.Color.values()) {
            if (color == UnoCard.Color.NONE) continue;
            addCard(new UnoCard(color, UnoCard.Value.ZERO));
            for (UnoCard.Value value : UnoCard.Value.numberTypes()) {
                addCard(new UnoCard(color, value));
                addCard(new UnoCard(color, value));
            }
            for (UnoCard.Value type : UnoCard.Value.actionTypes()) {
                addCard(new UnoCard(color, type));
                addCard(new UnoCard(color, type));
            }
        }

        for (int i = 0; i < 4; i++) {
            addCard(new UnoCard(UnoCard.Color.NONE, UnoCard.Value.WILD));
        }
    }
}
