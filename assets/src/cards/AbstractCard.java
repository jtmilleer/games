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
    public void flip(){faceUp = !faceUp;}

    /**
     * Checks if the card is face up.
     * @return true if the card is face up, false if the card is face down.
     */
    public boolean isFaceUp(){return faceUp;}

    public String getName(){return this.name;}

    public void setFace(final Image image){
        this.face = image;
    }

    public void setBack(final Image image){
        this.back = image;
    }

    public Image getFace(){return this.face;}

    public Image getBack(){return this.back;}

    public abstract String toString();


}
