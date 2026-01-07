package cards;

public enum Rank {
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

    public int getValue() {
        return value;
    }
    public String getRankString(){
        return this.rankString;
    }
}