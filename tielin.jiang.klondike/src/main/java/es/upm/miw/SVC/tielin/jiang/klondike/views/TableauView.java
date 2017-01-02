package es.upm.miw.SVC.tielin.jiang.klondike.views;

import java.util.ArrayList;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Card;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Pile;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;

public class TableauView {

    static TableauView tableauView;

    static TableauView instance() {
        if (tableauView == null) {
            tableauView = new TableauView();
        }
        return tableauView;
    }

    private TableauView() {
    }

    public void render(ArrayList<Pile> tableaus) {
        IO io = IO.instance();
        for (int index = 0; index < tableaus.size(); index++) {
            if (tableaus.get(index).isEmpty()) {
                io.writeln("Escalera " + (index + 1) + ": <vacío>");
            } else {
                io.write("Escalera " + (index + 1) + ":");
                for (Card card : tableaus.get(index)) {
                    CardView.instance().render(card);
                }
                if (tableaus.get(index).peek().getIsHidden()) {
                    io.write("X,X]");
                }
                io.writeln();
            }
        }
    }
}
