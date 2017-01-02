package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.LimitedIntDialog;

public class MoveTableauToFoundationController extends Controller {

    public MoveTableauToFoundationController(Game game, String option) {
        super(game, option);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean control() {
        int indexTableau = LimitedIntDialog.instance().read("De qué escalera", 1, 7);

        if (!game.canMoveFromTableau(indexTableau - 1)) {
            return false;
        }
        if (!game.canMoveCardToFoundation(game.getTableauCard(indexTableau - 1))) {
            return false;
        }
        game.moveTableauToFoundation(indexTableau - 1, 1);
        return true;
    }

}
