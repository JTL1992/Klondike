package es.upm.miw.SVC.tielin.jiang.klondike.views;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Pile;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;

public class DeckView {

    static DeckView deckView;

    static DeckView instance() {
        if (deckView == null) {
            deckView = new DeckView();
        }
        return deckView;
    }

    private DeckView() {
    }

    public void render(Pile deck) {
        IO io = IO.instance();
        if (deck.isEmpty()) {
            io.writeln("Baraja: <vacío>");
        } else {
            io.writeln("Baraja: [X,X]");
        }
    }
}
