package es.upm.miw.SVC.tielin.jiang.klondike.controllers;

import es.upm.miw.SVC.tielin.jiang.klondike.models.CardType;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.LimitedIntDialog;

public class MoveFoundationToTableauController extends Controller {

    public MoveFoundationToTableauController(Game game, String option) {
        super(game, option);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean control() {
        int indexPalo = LimitedIntDialog.instance().read("De qué palo", 1, 4);
        CardType cardType = CardType.values()[indexPalo - 1];
        if (!game.canMoveFromFoundation(cardType)) {
            return false;
        }
        int indexTableau = LimitedIntDialog.instance().read("A qué escalera", 1, 7);
        if (!game.canMoveCardToTableau(indexTableau, game.getFoundationCard(cardType))) {
            return false;
        }
        game.moveFoundationToTableau(cardType, indexTableau - 1, 1);
        return true;
    }

}
