package cards;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.Objects;

/**
 * Class that represents a standard playing card from a 52-card deck. Has a suit and a rank.
 * <p>Extends <code>AbstractClass</code>
 * @author Jordan Miller
 */
public class PlayingCard extends AbstractCard{

    private final Suit suit;
    private final Rank rank;

    private static final String backColor = "red";
    private static final String backColorPath = String.format("/images/cards/playingCards/%sBack.png",backColor);

    private static int count;


    private static final Image backImage = new Image(Objects.requireNonNull(PlayingCard.class.getResourceAsStream(backColorPath)));

    public PlayingCard(final Suit suit, final Rank rank) {
        super(rank + " of " + suit, "PlayingCard_" + ++count,suit,rank,
                backImage);
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

    /**
     * Method to get the <code>Suit</code> of the class.
     * <code>Suit</code> implements <code>CardType</code>
     * @return <code>Suit</code> of the card
     */
    public Suit getSuit(){return this.suit;}

    /**
     * Method to get the <code>Rank</code> of the class.
     * <code>Rank</code> implements <code>CardValue</code>
     * @return <code>Rank</code> of the card
     */
    public Rank getRank(){return this.rank;}

    /**
     * Method to compare two <code>PlayingCards</code> for equality.
     * <p>For a playing card, two cards are equal iff the ranks are the same and the suits are the same
     * @param o the reference object with which to compare.
     * @return true if the cards are equal, false if they are not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayingCard p)) return false;
        return rank == p.rank && suit == p.suit;
    }


    /**
     * Enum that represents all rank possibilities.
     * Two-Ten have numerical values equal to their name,
     * then Jack, Queen, King and Ace have 11,12,13,14 for values respectively.
     */
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

    /**
     * enum that represents all possible suits of a card.
     * <p>Clubs, Diamonds, Hearts and Spades are the possible values.
     */
    public enum Suit implements CardType{
        CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

        private final String suit;

        Suit(final String suit){
            this.suit = suit;
        }

        public String getCardType(){return this.suit;}
    }
}
