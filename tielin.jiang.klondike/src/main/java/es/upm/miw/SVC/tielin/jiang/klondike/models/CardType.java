package es.upm.miw.SVC.tielin.jiang.klondike.models;

public enum CardType {
    
    ORO('o'), COPA('c'), ESPADA('e'), BASTO('b');

    private final char s;

    CardType(char s) {
        this.s = s;
    }

    public char getCardTypeChar() {
        return s;
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
