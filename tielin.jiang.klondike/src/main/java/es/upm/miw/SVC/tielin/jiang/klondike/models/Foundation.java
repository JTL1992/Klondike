package es.upm.miw.SVC.tielin.jiang.klondike.models;

public class Foundation extends Pile {

    private static final long serialVersionUID = 1L;

    private CardType type;

    public Foundation(CardType cardType) {
        this.type = cardType;
    }

    public CardType getType() {
        return type;
    }

}
