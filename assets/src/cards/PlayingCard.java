package cards;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.Objects;

public class PlayingCard extends AbstractCard{

    private final Suit suit;
    private final Rank rank;

    private static final String backColor = "red";
    private static final String backColorPath = String.format("images/cards/playingCards/%sBack",backColor);

    private static int count;


    private static final Image backImage = new Image(Objects.requireNonNull(PlayingCard.class.getResourceAsStream(backColorPath)));

    public PlayingCard(final Suit suit, final Rank rank) {
        super(rank + " of " + suit, "PlayingCard_" + ++count,suit,rank);
        this.suit = suit;
        this.rank = rank;


        String frontPath = String.format("/images/cards/playingCards/%s_of_%s.png",
                                        rank.toString().toLowerCase(),
                                        suit.toString().toLowerCase());

        final InputStream frontInputStream = getClass().getResourceAsStream(frontPath);

        if(frontInputStream == null){
            System.err.printf("Error loading front file for %s of %s\n", rank.toString().toLowerCase(), suit.toString().toLowerCase());
        }
        else{
            this.setFace(new Image(frontInputStream));
            //System.out.printf("Created card %s of %s\n",rank,suit);
        }

    }

    public Suit getSuit(){return this.suit;}
    public Rank getRank(){return this.rank;}

    @Override
    public Image getImage(){
        return isFaceUp() ? this.getFace() : backImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayingCard p)) return false;
        return rank == p.rank && suit == p.suit;
    }


    public enum Rank implements CardValue{
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14);

        private final int value;

        private final String rankString;

        Rank(int value) {
            if(value < 11){
                this.rankString = Integer.toString(value);
            }
            else{
                switch(value){
                    case 11:{
                        this.rankString = "J";
                        break;
                    }
                    case 12:{
                        this.rankString = "Q";
                        break;
                    }
                    case 13:{
                        this.rankString = "K";
                        break;
                    }
                    case 14:{
                        this.rankString = "A";
                        break;
                    }
                    default:{
                        throw new IllegalArgumentException("Rank not set");
                    }
                }
            }

            this.value = value;
        }

        /**
         * PlayingCard's implementation of getCardValue() returns the Rank of the card.
         * {[1,10],J,Q,K,A} are possible values.
         * @return <code>String</code> of the card's rank.
         */
        public String getCardValue() {return rankString;}

        public int getNumericValue(){return this.value;}

    }

    public enum Suit implements CardType{
        CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

        private final String suit;

        private Suit(final String suit){
            this.suit = suit;
        }

        public String getCardType(){return this.suit;}
    }
}
