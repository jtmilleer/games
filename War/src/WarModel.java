import players.WarPlayer;
import decks.StandardDeck;
import cards.PlayingCard;
import comparators.WarComparator;

import java.util.ArrayList;
import java.util.List;

public class WarModel {
    private final WarPlayer player1;
    private final WarPlayer player2;
    private final StandardDeck deck;

    private PlayingCard currentCardP1;
    private PlayingCard currentCardP2;

    private List<PlayingCard> warFaceDownP1 = new ArrayList<>();
    private List<PlayingCard> warFaceDownP2 = new ArrayList<>();

    public List<PlayingCard> getWarFaceDownP1() { return warFaceDownP1; }
    public List<PlayingCard> getWarFaceDownP2() { return warFaceDownP2; }

    public WarModel() {
        this.player1 = new WarPlayer("Player 1");
        this.player2 = new WarPlayer("Player 2");
        this.deck = new StandardDeck();
        this.deck.shuffle();
        this.deck.distributeDeck(deck.getCardCount() / 2, player1, player2);
    }

    public PlayingCard getCurrentCardP1() { return currentCardP1; }
    public PlayingCard getCurrentCardP2() { return currentCardP2; }

    public String playRound() {
        // Clear war cards from previous round
        warFaceDownP1.clear();
        warFaceDownP2.clear();

        // Refill hand from collected cards if empty
        if (player1.isHandEmpty() && !player1.returnCollectedCardsToHand()) {
            return player2.getUsername() + " wins the game!";
        }
        if (player2.isHandEmpty() && !player2.returnCollectedCardsToHand()) {
            return player1.getUsername() + " wins the game!";
        }

        currentCardP1 = player1.playCard();
        currentCardP2 = player2.playCard();

        int compared = WarComparator.compare(currentCardP1, currentCardP2);

        List<PlayingCard> warPile = new ArrayList<>();
        warPile.add(currentCardP1);
        warPile.add(currentCardP2);

        if (compared > 0) {
            player1.collectCards(warPile);
            return player1.getUsername() + " wins the round!";
        } else if (compared < 0) {
            player2.collectCards(warPile);
            return player2.getUsername() + " wins the round!";
        } else {
            return resolveWar(warPile);
        }
    }

    private String resolveWar(List<PlayingCard> warPile) {
        boolean warResolved = false;
        String result = "WAR!";

        while (!warResolved) {
            int cardsNeeded = 3;

            // Place face-down cards
            for (int i = 0; i < cardsNeeded; i++) {
                if (player1.isHandEmpty() && !player1.returnCollectedCardsToHand()) {
                    return player2.getUsername() + " wins the game!";
                }
                if (player2.isHandEmpty() && !player2.returnCollectedCardsToHand()) {
                    return player1.getUsername() + " wins the game!";
                }

                PlayingCard card1 = player1.playCard();
                PlayingCard card2 = player2.playCard();

                warFaceDownP1.add(card1);
                warFaceDownP2.add(card2);
                warPile.add(card1);
                warPile.add(card2);
            }

            // Flip the final card
            if (player1.isHandEmpty() && !player1.returnCollectedCardsToHand()) {
                return player2.getUsername() + " wins the game!";
            }
            if (player2.isHandEmpty() && !player2.returnCollectedCardsToHand()) {
                return player1.getUsername() + " wins the game!";
            }

            PlayingCard flip1 = player1.playCard();
            PlayingCard flip2 = player2.playCard();
            warPile.add(flip1);
            warPile.add(flip2);

            // Update current cards to show the flipped cards
            currentCardP1 = flip1;
            currentCardP2 = flip2;

            int warResult = WarComparator.compare(flip1, flip2);
            if (warResult > 0) {
                player1.collectCards(warPile);
                result = player1.getUsername() + " wins the WAR!";
                warResolved = true;
            } else if (warResult < 0) {
                player2.collectCards(warPile);
                result = player2.getUsername() + " wins the WAR!";
                warResolved = true;
            } else {
                result = "WAR continues!";
                // War continues, loop will repeat
            }
        }
        return result;
    }

    public int getPlayer1HandSize() {
        return player1.getNumCardsInHand();
    }

    public int getPlayer2HandSize() {
        return player2.getNumCardsInHand();
    }

    public boolean isGameOver() {
        return (player1.isHandEmpty() && !player1.returnCollectedCardsToHand()) ||
                (player2.isHandEmpty() && !player2.returnCollectedCardsToHand());
    }

    public String getWinner() {
        if (player1.getNumCardsInHand() > player2.getNumCardsInHand()) {
            return player1.getUsername() + " wins the game!";
        }
        if (player1.getNumCardsInHand() < player2.getNumCardsInHand()) {
            return player2.getUsername() + " wins the game!";
        }
        return "It's a draw!";
    }
}