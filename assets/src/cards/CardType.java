package cards;

/**
 * Interface that is used for polymorphism in <code>AbstractCard</code>.
 * Each card has a type, i.e. a suit or a color.
 * This interface is usually implemented by an <code>enum</code>
 * @author Jordan Miller
 */
public interface CardType {


    //TODO both methods needed??
    /**
     * Method to get the card type represented by a <code>String</code>
     * @return <code>String</code> containing information about the card type
     */
    String getCardType();

    String toString();
}
