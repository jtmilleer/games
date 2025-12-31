package cards;

public enum Suit {
    CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades");

    private final String suit;

    private Suit(final String suit){
        this.suit = suit;
    }

    public String getSuit(){return this.suit;}
}