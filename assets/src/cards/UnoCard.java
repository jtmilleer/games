package cards;

public class UnoCard extends AbstractCard{

    private final Color cardColor;
    private final String value;
    private static int count;

    public UnoCard(final Color c, final String value){
        super(c.toString(),"UnoCard_" + ++count);
        this.cardColor = c;
        this.value = value;
    }

    @Override
    public String toString() {
        return cardRep(cardColor.getTitleColor(),value);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {return true;}
        if(!(o instanceof UnoCard u)){return false;}
        return this.getTitleColor().equals(u.getTitleColor()) && this.value.equals(u.value);
    }

    public String getTitleColor(){return this.cardColor.getTitleColor();}

    public enum Color{

        RED("Red"),
        GREEN("Green"),
        BLUE("Blue"),
        YELLOW("Yellow");

        private final String titleColor;

        Color(String color) {
            this.titleColor = color;
        }

        public String getTitleColor(){return this.titleColor;}

    }
}
