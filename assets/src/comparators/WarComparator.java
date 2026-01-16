package comparators;

import cards.PlayingCard;

import java.util.Comparator;

/**
 * Utility class that holds one method to compare 2 playing cards for war.
 */
public final class WarComparator {
    /**
     * Method to compare 2 cards for war
     * @param a card 1 to be compared
     * @param b card 2 to be compared
     * @return positive if <code>a > b</code>, negative if <code>a &lt; b</code>, 0 if <code>a == b</code>
     */
    public static int compare(PlayingCard a, PlayingCard b) {
        return Integer.compare(
                a.getRank().getNumericValue(),
                b.getRank().getNumericValue()
        );

    }
}
