package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import es.upm.miw.SVC.tielin.jiang.klondike.models.CardType;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Pile;

public abstract class Controller {

    protected Game game;

    protected String option;

    protected Controller(Game game, String option) {
        assert game != null;
        this.game = game;
        this.option = option;
    }

    public Pile refreshDeck() {
        return game.getDeck();
    }

    public Pile refreshWaste() {
        return game.getWaste();
    }

    public ArrayList<Pile> refreshTableaus() {
        return game.getTableaus();
    }

    public HashMap<CardType, Pile> refreshFoundations() {
        return game.getFoundations();
    }

    public String getOption() {
        return this.option;
    }

    public boolean isEnd() {
        return false;
    }

    public abstract boolean control();

}
