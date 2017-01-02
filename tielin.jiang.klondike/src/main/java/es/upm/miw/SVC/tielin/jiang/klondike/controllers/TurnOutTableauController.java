package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.LimitedIntDialog;

public class TurnOutTableauController extends Controller {

    public TurnOutTableauController(Game game, String option) {
        super(game, option);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean control() {
        int index = LimitedIntDialog.instance().read("Qué escalera", 1, 7);
        return game.turnOutTableauCard(index - 1);
    }

}
