package es.upm.miw.SVC.tielin.jiang.klondike.models;

public class Card {

    public static final int CARD_MAX_VALUE = 13;

    public static final int CARD_MIN_VALUE = 1;

    private CardType type;

    private int value;

    private Boolean isHidden;

    public Card(CardType type, int value, Boolean isHidden) {
        this.type = type;
        this.value = value;
        this.isHidden = isHidden;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public CardType getType() {
        return type;
    }

    public char getCardTypeChar() {
        return type.getCardTypeChar();
    }

    public int getValue() {
        return value;
    }

    private boolean isSuit(Card card) {
        return this.type.toString().equals(card.getType().toString());
    }

    public boolean isAce() {
        return this.value == 1;
    }

    public boolean isKing() {
        return this.value == 13;
    }

    private boolean isBuildDown(Card card) {
        return this.value == card.getValue() - 1;
    }

    private boolean isBuildUp(Card card) {
        return this.value == card.getValue() + 1;
    }

    public boolean isSuitBuildUp(Card card) {
        return this.isSuit(card) && this.isBuildUp(card);
    }

    public boolean isAlternateBuildDown(Card card) {
        return !this.isSuit(card) && this.isBuildDown(card);
    }

}
