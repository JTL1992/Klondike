package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;

public class MoveDeckToWasteController extends Controller {

    public MoveDeckToWasteController(Game game, String option) {
        super(game, option);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean control() {
        if (!game.canMoveFromDeck()) {
            return false;
        }
        game.moveDeckToWaste();
        return true;
    }

}
