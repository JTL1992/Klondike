package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;

public class MoveWasteToFoundationController extends Controller {

    public MoveWasteToFoundationController(Game game, String option) {
        super(game, option);
    }

    @Override
    public boolean control() {
        if (!game.canMoveFromWaste()) {
            return false;
        }
        if (!game.canMoveCardToFoundation(game.getWaste().peek())) {
            return false;
        }
        game.moveWasteToFoundation();
        return true;
    }

}
