package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.LimitedIntDialog;

public class MoveWasteToTableauController extends Controller {

    public MoveWasteToTableauController(Game game, String option) {
        super(game, option);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean control() {
        if (!game.canMoveFromWaste()) {
            return false;
        }
        int index = LimitedIntDialog.instance().read("A qué escalera", 1, 7);
        if (!game.canMoveCardToTableau(index - 1, game.getWaste().peek())) {
            return false;
        }
        game.moveWasteToTableau(index - 1);
        return true;
    }

}
