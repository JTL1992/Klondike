package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.LimitedIntDialog;

public class MoveTableauToTableau extends Controller {

    public MoveTableauToTableau(Game game, String option) {
        super(game, option);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean control() {
        int indexTableauOrigin = LimitedIntDialog.instance().read("De qué escalera", 1, 7);
        if (!game.canMoveFromTableau(indexTableauOrigin - 1)) {
            return false;
        }
        int num = game.getTableauNotHiddenCardsNum(indexTableauOrigin - 1);
        if (num > 1) {
            num = LimitedIntDialog.instance().read("Cuántas cartas", 1, num);
        }
        int indexTableauDestination = LimitedIntDialog.instance().read("A qué escalera", 1, 7);
        if (!game.canMoveCardToTableau(indexTableauDestination - 1, game.getTableauCard(indexTableauOrigin - 1, num))) {
            return false;
        }
        game.moveTableauToTableau(indexTableauOrigin - 1, indexTableauDestination - 1, num);
        return true;
    }

}
