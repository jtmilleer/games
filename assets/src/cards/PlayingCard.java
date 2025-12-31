package cards;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.Objects;

public class PlayingCard extends AbstractCard{

    private final Suit suit;
    private final Rank rank;

    private static final String backColor = "red";

    private static int count;

    public PlayingCard(final Suit suit, final Rank rank) {
        super(rank + " of " + suit, "PlayingCard_" + ++count);
        this.suit = suit;
        this.rank = rank;



        String frontPath = String.format("/images/cards/playingCards/%s_of_%s.png",
                                        rank.toString().toLowerCase(),
                                        suit.toString().toLowerCase());
        //System.out.println(frontPath);

        String backPath = String.format("/images/cards/playingCards/%sBack",
                                        backColor);

        final InputStream frontInputStream = getClass().getResourceAsStream(frontPath);
        final InputStream backInputStream = getClass().getResourceAsStream(backPath);

        if(frontInputStream == null){
            System.err.printf("Error loading front file for %s of %s\n", rank.toString().toLowerCase(), suit.toString().toLowerCase());
        }
        else{
            this.setFace(new Image(frontInputStream));
            //System.out.printf("Created card %s of %s\n",rank,suit);
        }
        if(backInputStream == null){
            //System.err.printf("Error loading back file for %s\n",backColor);
        }
        else{
            this.setBack(new Image(backInputStream));
        }
    }

    public Suit getSuit(){return this.suit;}
    public Rank getRank(){return this.rank;}

    @Override
    public String toString(){
        return this.rank + " of " + this.suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayingCard p)) return false;
        return rank == p.rank && suit == p.suit;
    }

}
