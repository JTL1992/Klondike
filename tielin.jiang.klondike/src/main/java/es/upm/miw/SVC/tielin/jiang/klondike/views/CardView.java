package es.upm.miw.SVC.tielin.jiang.klondike.views;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Card;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;

public class CardView {

    private static CardView cardView;

    private static final String[] cardValue = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public static CardView instance() {
        if (cardView == null) {
            cardView = new CardView();
        }
        return cardView;
    }

    private CardView() {
    }

    public void render(Card card) {
        IO io = IO.instance();
        if (!card.getIsHidden()) {
            io.write("[" + cardValue[card.getValue() - 1] + "," + card.getCardTypeChar() + "]");
        } else {
            io.write("[");
        }
    }
}
