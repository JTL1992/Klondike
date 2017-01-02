package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.ErrorDialog;

public class MoveWasteToDeckController extends Controller {

    public MoveWasteToDeckController(Game game, String option) {
        super(game, option);
    }

    @Override
    public boolean control() {
        if (!game.getDeck().isEmpty()) {
            ErrorDialog.instance().renderDeckNotEmpty();
            return false;
        }
        game.moveWasteToDeck();
        return true;
    }

}
