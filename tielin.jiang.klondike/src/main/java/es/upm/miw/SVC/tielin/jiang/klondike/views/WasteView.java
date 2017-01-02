package es.upm.miw.SVC.tielin.jiang.klondike.views;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Card;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Pile;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;

public class WasteView {

    static WasteView wasteView;

    static WasteView instance() {
        if (wasteView == null) {
            wasteView = new WasteView();
        }
        return wasteView;
    }

    private WasteView() {
    }

    public void render(Pile waste) {
        IO io = IO.instance();
        int numWaste = waste.size();
        int numNotHidden = waste.getNotHiddenCardsNum();
        if (waste.isEmpty()) {
            io.writeln("Descarte: <vacío>");
        } else {
            io.write("Descarte: ");
            for (int i = 0; i < numNotHidden; i++) {
                Card card = waste.get(numWaste - numNotHidden + i);
                CardView.instance().render(card);
            }
            io.writeln();
        }
    }
}
