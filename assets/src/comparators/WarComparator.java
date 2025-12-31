package comparators;

import cards.PlayingCard;

import java.util.Comparator;

public final class WarComparator {
    /**
     * Method to compare 2 cards for war
     * @param a card 1 to be compared
     * @param b card 2 to be compared
     * @return positive if a > b, negative if a < b, 0 if a == b
     */
    public static int compare(PlayingCard a, PlayingCard b) {
        return Integer.compare(
                a.getRank().getValue(),
                b.getRank().getValue()
        );
    }
}
