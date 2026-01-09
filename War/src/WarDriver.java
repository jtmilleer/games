import cards.PlayingCard;
import comparators.WarComparator;
import players.WarPlayer;
import decks.StandardDeck;

import java.util.ArrayList;
import java.util.List;

public class WarDriver {
    public static void main(String[] args) {
        final WarPlayer p1 = new WarPlayer("Player 1");
        final WarPlayer p2 = new WarPlayer("Player 2");
        final StandardDeck d = new StandardDeck();
        d.shuffle();

        d.distributeDeck(d.getCardCount()/2 ,p1,p2);
        System.out.println("Deck distributed. Starting the game!");

        while (true) {
            if (!turn(p1, p2)) break;
        }

        // Print the winner of the game
        if (p1.getNumCardsInHand() == 0 && p2.getNumCardsInHand() == 0) {
            System.out.println("It's a tie! Both players ran out of cards.");
        } else if (p1.getNumCardsInHand() == 0) {
            System.out.println(p2.getUsername() + " wins the game!");
        } else {
            System.out.println(p1.getUsername() + " wins the game!");
        }
    }

    private static boolean turn(final WarPlayer p1, final WarPlayer p2){


        waitForEnter();

        if (p1.getNumCardsInHand() == 0 && !p1.returnCollectedCardsToHand()) {
            System.out.println(p2.getUsername() + " wins the game!");
            return false; // game over
        }
        if (p2.getNumCardsInHand() == 0 && !p2.returnCollectedCardsToHand()) {
            System.out.println(p1.getUsername() + " wins the game!");
            return false; // game over
        }

        final PlayingCard player1Card = p1.playCard();
        final PlayingCard player2Card = p2.playCard();

        System.out.println(p1.getUsername() + " plays\n" + player1Card);
        System.out.println(p2.getUsername() + " plays\n" + player2Card);

        int compared = WarComparator.compare(player1Card, player2Card);

        if (compared > 0) {
            p1.collectCards(player1Card, player2Card);
            System.out.println(p1.getUsername() + " wins this turn!\n");
        } else if (compared < 0) {
            p2.collectCards(player1Card, player2Card);
            System.out.println(p2.getUsername() + " wins this turn!\n");
        } else {
            System.out.println("War!");

            List<PlayingCard> warPile = new ArrayList<>();
            warPile.add(player1Card);
            warPile.add(player2Card);

            boolean warResolved = false;
            while (!warResolved) {
                int cardsNeeded = 3;

                // Each player plays up to 3 face-down cards
                for (int i = 0; i < cardsNeeded; i++) {
                    if (p1.getNumCardsInHand() == 0 && !p1.returnCollectedCardsToHand()) {
                        System.out.println(p2.getUsername() + " wins the game!");
                        return false;
                    }
                    if (p2.getNumCardsInHand() == 0 && !p2.returnCollectedCardsToHand()) {
                        System.out.println(p1.getUsername() + " wins the game!");
                        return false;
                    }

                    warPile.add(p1.playCard());
                    warPile.add(p2.playCard());
                }

                // Flip one more card to resolve WAR
                PlayingCard flip1 = p1.playCard();
                PlayingCard flip2 = p2.playCard();
                warPile.add(flip1);
                warPile.add(flip2);

                System.out.println(p1.getUsername() + " flips " + flip1);
                System.out.println(p2.getUsername() + " flips " + flip2);

                int warResult = WarComparator.compare(flip1, flip2);
                if (warResult > 0) {
                    p1.collectCards(warPile);
                    System.out.println(p1.getUsername() + " wins the WAR!\n");
                    warResolved = true;
                } else if (warResult < 0) {
                    p2.collectCards(warPile);
                    System.out.println(p2.getUsername() + " wins the WAR!\n");
                    warResolved = true;
                } else {
                    System.out.println("WAR continues!");
                    // Loop continues
                }
            }
        }

        return true; // turn completed, game continues
    }

    private static void waitForEnter() {
        System.out.println("Press Enter to play next card...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
