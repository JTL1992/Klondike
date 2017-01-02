package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;

public class StartController extends Controller {

    public StartController(Game game, String option) {
        super(game, option);
    }

    @Override
    public boolean control() {
        return true;
    }

}
