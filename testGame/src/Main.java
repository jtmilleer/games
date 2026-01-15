import decks.StandardDeck;
import cards.PlayingCard;

public class Main {
    public static void main(String[] args) {
        StandardDeck deck = new StandardDeck();
        deck.initalizeDeck();

        PlayingCard playingCard = deck.drawCard();
        System.out.println(playingCard);
    }
}