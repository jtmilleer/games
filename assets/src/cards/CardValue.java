package cards;

/**
 * Interface that is used for polymorphism in <code>AbstractCard</code>.
 * Each card has a value, usually a numeric value, or the card does something special, i.e. uno reverse card.
 * <p>The card will have an int value tied to the card, in the case of the numeric value, the int is the corresponding number.
 * In the case of a non-numeric value, a negative integer is usually tied to it.
 * This interface is usually implemented by an <code>enum</code>
 * @author Jordan Miller
 */
public interface CardValue {
    /**
     * Method to get the card value in a <code>String</code>
     * @return <code>String</code> containing information about the card value
     */
    String getCardValue();

    String toString();

    /**
     * Method to get the numerical value associated with each card value.
     * @return <code>int</code> value of card.
     */
    int getNumericValue();
}
