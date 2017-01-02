package es.upm.miw.SVC.tielin.jiang.klondike.views;

import java.util.HashMap;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Card;
import es.upm.miw.SVC.tielin.jiang.klondike.models.CardType;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Pile;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;

public class FoundationView {

    static FoundationView foundationView;

    static FoundationView instance() {
        if (foundationView == null) {
            foundationView = new FoundationView();
        }
        return foundationView;
    }

    private FoundationView() {
    }

    public void render(HashMap<CardType, Pile> foundations) {
        IO io = IO.instance();
        for (CardType cardType : CardType.values()) {
            Pile foundation = foundations.get(cardType);
            if (foundation.isEmpty()) {
                io.writeln("Palo " + cardType.toString() + "s: <vacío>");
            } else {
                io.write("Palo " + cardType.toString() + "s: ");
                for (Card card : foundation)
                    CardView.instance().render(card);
                io.writeln();
            }

        }

    }
}
