package cards;
import games.GameObject;
import javafx.scene.image.Image;
public abstract class AbstractCard extends GameObject{
    private boolean faceUp;
    private final String name;

    private Image face;
    private Image back;

    private static int count;

    public AbstractCard(String name) {
        super(name,"AbstractCard_" + ++count);
        this.name = name;
        faceUp = false;
    }

    public AbstractCard(String name, String id){
        super(name,id);
        this.name = name;
        faceUp = false;
    }


    /**
     * Method to flip the card.
     */
    public final void flip(){faceUp = !faceUp;}

    /**
     * Checks if the card is face up.
     * @return true if the card is face up, false if the card is face down.
     */
    public final boolean isFaceUp(){return faceUp;}

    public final String getName(){return this.name;}

    public final void setFace(final Image image){
        this.face = image;
    }

    public final void setBack(final Image image){
        this.back = image;
    }

    public final Image getFace(){return this.face;}

    public final Image getBack(){return this.back;}

    public abstract String toString();

    public abstract boolean equals(Object o);

    private static final int cardMiddleLength = 10;

    static String cardRep(final String top, final String center){
        final String topFormatted = top.substring(0,1);
        return "+" + "-".repeat(cardMiddleLength) + "+\n" +
                "|" + topFormatted + " ".repeat(cardMiddleLength - 1) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(cardMiddleLength/2) + center +  " " .repeat(cardMiddleLength/2 - 1) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "|" + " ".repeat(cardMiddleLength) + "|\n" +
                "+" + "-".repeat(cardMiddleLength) + "+";
    }


}
