package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;

public class LeaveController extends Controller {

    public LeaveController(Game game, String option) {
        super(game, option);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean control() {
        return false;
    }

    @Override
    public boolean isEnd() {
        IO io = IO.instance();
        io.writeln("Adios!!");
        return true;
    }

}
