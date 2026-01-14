package cards;
import games.GameObject;
import javafx.scene.image.Image;

//TODO implement a playable interface?
/**
 * Class that represents properties that any card will have. Extends <code>GameObject</code>.
 * Each new card must extend this class.
 * @author Jordan Miller
 */
public abstract class AbstractCard extends GameObject{
    private boolean faceUp;
    private final String name;

    private Image face;

    //private Image image;

    private static int count;

    //TODO remove this constructor??
    /**
     * 3 param Constructor for <code>AbstractCard</code>
     * @param name name for Card, gets passed into <code>GameObject</code> constructor
     * @param type Some object that implements <code>CardType</code>, usually an enum
     * @param value Some object that implements <code>CardValue</code>, usually an enum
     */
    public AbstractCard(String name, final CardType type, final CardValue value) {
        super(name,"AbstractCard_" + ++count);
        this.cardType = type;
        this.cardValue = value;
        this.name = name;
        faceUp = true;
    }

    /**
     * 4 param Constructor for <code>AbstractCard</code>. This constructor should be the one used, as an
     * id should always be specified, not using the AbstractCard id.
     * @param name name for Card, gets passed into <code>GameObject</code> constructor
     * @param id id for card, usually created in constructor of subclass
     * @param type Some object that implements <code>CardType</code>, usually an enum
     * @param value Some object that implements <code>CardValue</code>, usually an enum
     */
    public AbstractCard(String name, String id, final CardType type, final CardValue value){
        super(name,id);
        this.cardType = type;
        this.cardValue = value;
        this.name = name;
        faceUp = false;
        count++;
    }

    /**
     * The top left corner
     */
    private final CardType cardType;
    /**
     * The middle
     */
    private final CardValue cardValue;

    /**
     * Getter for CardType
     * @return Object that implements CardType
     */
    public CardType getCardType(){return this.cardType;}

    /**
     * Getter for CardValue
     * @return Object that implements CardValue
     */
    public CardValue getCardValue(){return this.cardValue;}

    /**
     * Method to flip the card.
     */
    public final void flip(){faceUp = !faceUp;}

    /**
     * Checks if the card is face up.
     * @return true if the card is face up, false if the card is face down.
     */
    public final boolean isFaceUp(){return faceUp;}

    /**
     * Getter for the name of this card
     * @return <code>String</code> with name of the card
     */
    public final String getName(){return this.name;}

    /**
     * Method to set the face image of the card
     * @param image <code>Image</code> to set to the face.
     */
    public final void setFace(final Image image){
        this.face = image;
    }

    /**
     * Method to get the current face image of the card
     * @return <code>Image</code> object containing the face of the card.
     */
    public final Image getFace(){return this.face;}

    /**
     * Abstract equals method that each subclass must define.
     * @param o the reference object with which to compare.
     * @return true if the objects are equivalent objects by the subclass definition. false if they are not.
     */
    public abstract boolean equals(Object o);

    private static final int cardMiddleLength = 10;

    /*
    public static String cardRep(final String top, final String center) {
        final int leftPadding = (cardMiddleLength - center.length()) / 2;
        final int rightPadding = cardMiddleLength - center.length() - leftPadding;

        return "+" + "-".repeat(cardMiddleLength) + "+\n" +
                "|" + top + " ".repeat(cardMiddleLength - top.length()) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(leftPadding) + center + " ".repeat(rightPadding) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "+" + "-".repeat(cardMiddleLength) + "+";
    }
     */

    /**
     * <code>toString</code> method that returns a basic representation of the card for
     * outputting with <code>System.out</code>
     * @return a <code>String</code> representation of the card.
     */
    @Override
    public String toString(){
        final String top = this.cardType.getCardType().substring(0,1);
        final String center = this.cardValue.getCardValue();
        final int leftPadding = (cardMiddleLength - center.length()) / 2;
        final int rightPadding = cardMiddleLength - center.length() - leftPadding;

        return "+" + "-".repeat(cardMiddleLength) + "+\n" +
                "|" + top + " ".repeat(cardMiddleLength - top.length()) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(leftPadding) + center + " ".repeat(rightPadding) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "+" + "-".repeat(cardMiddleLength) + "+";
    }

    /**
     * Each subclass must define <code>getImage</code>. This usually will be
     * @return <code>Image</code> object for JavaFX to display. This usually means checking if the card is
     * face up, and return the static subclass variable for the back if the card is not face up, and
     * the face if the card is face up.
     */
    /*
        I wish I could define this method here, but I cannot access the subclass back variables.
     */
    public abstract Image getImage();



}
