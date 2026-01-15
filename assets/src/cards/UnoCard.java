package cards;

/**
 * Class that represents an Uno Card, extends <code>AbstractCard</code>
 * @author Jordan Miller
 */
public class UnoCard extends AbstractCard{

    private final Color cardColor;
    private final Value type;
    private static int count;


    /**
     * 2 Input Constructor. Makes a card with Color c and Type type.
     * Color must implement <code>CardType</code> and Type must implement <code>CardValue</code>
     * @param c <code>Color</code> that the new card will be.
     * @param type <code></code>
     */
    public UnoCard(final Color c, final Value type){
        //super(c.toString(),"UnoCard_" + ++count);
        super(  c.toString() + type.toString(),
                "UnoCard_" + ++count,
                c,
                type,
                null);
        this.cardColor = c;
        this.type = type;
    }

    /**
     * Method to compare two <code>UnoCards</code> for equality.
     * <p>For a Uno card, two cards are equal iff the colors are equal and the types are equal.
     * @param o the reference object with which to compare.
     * @return true if the cards are equal, false if they are not.
     */
    @Override
    public boolean equals(Object o) {
        if(this == o) {return true;}
        if(!(o instanceof UnoCard u)){return false;}
        return this.getColor().equals(u.getColor()) && this.type.equals(u.type);
    }

    /**
     * Method to get the color of the card.
     * Red, Green, Blue or Yellow
     * @return a <code>String</code> with the color of the card.
     */
    public String getColor(){return this.cardColor.getCardType();}

    /**
     * Enum representing the color of the card.
     */
    public enum Color implements CardType{

        RED("Red"),
        GREEN("Green"),
        BLUE("Blue"),
        YELLOW("Yellow"),
        NONE(" "); // NONE has titleColor of " " in order for substring to work in AbstractCard's toString. I want it to display nothing

        private final String titleColor;

        Color(String color) {
            this.titleColor = color;
        }

        public String getCardType(){
            return this.titleColor;
        }

    }

    /**
     * Enum represeting the Value of the card.
     * Zero-Nine have their name as the value.
     * Reverse -> -1,
     * Draw Two -> -2,
     * Skip -> -3,
     * Draw Four -> -4,
     * Wild -> -5
     *
     */
    public enum Value implements CardValue{
        ZERO(0),
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        REVERSE(-1),
        DRAW_TWO(-2),
        SKIP(-3),
        DRAW_FOUR(-4),
        WILD(-5);


        private final int num;

        Value(final int num){
            this.num = num;
        }

        public int getNumericValue(){return num;}

        public String getCardValue() {
            return switch (this) {
                case ZERO, ONE, TWO, THREE, FOUR,
                     FIVE, SIX, SEVEN, EIGHT, NINE -> String.valueOf(num);

                case SKIP -> "/";
                case REVERSE -> "-><-";
                case DRAW_TWO -> "+2";

                case WILD -> "W";
                case DRAW_FOUR -> "+4";
            };
        }

        public static Value[] numberTypes() {
            return new Value[] {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        }


        public static Value[] actionTypes() {
            return new Value[] {SKIP, REVERSE, DRAW_TWO};
        }

        public static Value[] wildTypes() {
            return new Value[] {WILD, DRAW_FOUR};
        }
    }
}
