package cards;
import javafx.scene.image.Image;

import java.io.InputStream;

public class PlayingCard extends AbstractCard{

    private final String suit;
    private final String rank;

    private static final String backColor = "red";

    private static int count;

    public PlayingCard(String suit, String rank) {
        super(rank + " of " + suit, "PlayingCard_" + ++count);
        this.suit = suit;
        this.rank = rank;

        String frontPath = String.format("images/cards/playingCards/%s_of_%s.png",
                                        rank.toLowerCase(),
                                        suit.toLowerCase());

        String backPath = String.format("images/cards/playingCards/%sBack",
                                        backColor);

        final InputStream frontInputStream = getClass().getResourceAsStream(frontPath);
        final InputStream backInputStream = getClass().getResourceAsStream(backPath);

        if(frontInputStream == null || backInputStream == null){
            System.err.println("Error loading file for card");
        } else{
            this.setFace(new Image(frontInputStream));
            this.setBack(new Image(backInputStream));
        }
    }



    private static void loadFiles(final String suit, final String rank){

    }

}
