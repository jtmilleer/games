package decks;

import cards.UnoCard;

public class UnoDeck extends AbstractDeck<UnoCard> {



    public UnoDeck() {
        super(108);
        for (UnoCard.Color color : UnoCard.Color.values()) {
            if (color == UnoCard.Color.NONE) continue;
            addCard(new UnoCard(color, UnoCard.Type.ZERO));
            for (UnoCard.Type type : UnoCard.Type.numberTypes()) {
                addCard(new UnoCard(color, type));
                addCard(new UnoCard(color, type));
            }
            for (UnoCard.Type type : UnoCard.Type.actionTypes()) {
                addCard(new UnoCard(color, type));
                addCard(new UnoCard(color, type));
            }
        }

        for (int i = 0; i < 4; i++) {
            addCard(new UnoCard(UnoCard.Color.NONE, UnoCard.Type.WILD));
        }
    }
}
