package cards;

public class UnoCard extends AbstractCard{

    private final Color cardColor;
    private final Type type;
    private static int count;

    public UnoCard(final Color c, final Type type){
        //super(c.toString(),"UnoCard_" + ++count);
        super(  c.toString() + type.toString(),
                "UnoCard_" + ++count,
                c,
                type);
        this.cardColor = c;
        this.type = type;
    }
    /*
    @Override
    public String toString() {
        final String cardColorFormatted = cardColor.getCardValue().substring(0,1);
        return cardRep(cardColorFormatted,type.toString());
    }
     */

    @Override
    public boolean equals(Object o) {
        if(this == o) {return true;}
        if(!(o instanceof UnoCard u)){return false;}
        return this.getTitleColor().equals(u.getTitleColor()) && this.type.equals(u.type);
    }

    public String getTitleColor(){return this.cardColor.getCardType();}

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

    public enum Type implements CardValue{
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

        Type(final int num){
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

        public static Type[] numberTypes() {
            return new Type[] {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        }


        public static Type[] actionTypes() {
            return new Type[] {SKIP, REVERSE, DRAW_TWO};
        }

        public static Type[] wildTypes() {
            return new Type[] {WILD, DRAW_FOUR};
        }
    }
}
