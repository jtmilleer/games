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
        this.suit = suit.toLowerCase();
        this.rank = rank.toLowerCase();



        String frontPath = String.format("/images/cards/playingCards/%s_of_%s.png",
                                        rank.toLowerCase(),
                                        suit.toLowerCase());
        System.out.println(frontPath);

        String backPath = String.format("/images/cards/playingCards/%sBack",
                                        backColor);

        final InputStream frontInputStream = getClass().getResourceAsStream(frontPath);
        final InputStream backInputStream = getClass().getResourceAsStream(backPath);

        if(frontInputStream == null){
            System.err.printf("Error loading front file for %s of %s\n", rank.toLowerCase(), suit.toLowerCase());
        }
        else{
            this.setFace(new Image(frontInputStream));
            System.out.printf("Created card %s of %s\n",rank,suit);
        }
        if(backInputStream == null){
            //System.err.printf("Error loading back file for %s\n",backColor);
        }
        else{
            this.setBack(new Image(backInputStream));
        }
    }

    public String getSuit(){return this.suit;}
    public String getRank(){return this.rank;}

    @Override
    public String toString(){
        return this.rank + " of " + this.suit;
    }

}
