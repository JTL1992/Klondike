package es.upm.miw.SVC.tielin.jiang.klondike.views;

import java.util.ArrayList;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.Controller;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.LeaveController;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.MoveDeckToWasteController;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.MoveFoundationToTableauController;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.MoveTableauToFoundationController;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.MoveTableauToTableau;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.MoveWasteToDeckController;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.MoveWasteToFoundationController;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.MoveWasteToTableauController;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.TurnOutTableauController;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.LimitedIntDialog;

public class MenuView {

    private ArrayList<Controller> menuList = new ArrayList<Controller>();

    private IO io = IO.instance();

    public MenuView(Game game) {
        menuList.add(new MoveDeckToWasteController(game, "1. Mover de baraja a descarte"));
        menuList.add(new MoveWasteToDeckController(game, "2. Mover de descarte a baraja"));
        menuList.add(new MoveWasteToFoundationController(game, "3. Mover de descarte a palo"));
        menuList.add(new MoveWasteToTableauController(game, "4. Mover de descarte a escalera"));
        menuList.add(new MoveTableauToFoundationController(game, "5. Mover de escalera a palo"));
        menuList.add(new MoveTableauToTableau(game, "6. Mover de escalera a escalera"));
        menuList.add(new MoveFoundationToTableauController(game, "7. Mover de palo a escalera"));
        menuList.add(new TurnOutTableauController(game, "8. Voltear en escalera"));
        menuList.add(new LeaveController(game, "9. Salir"));
    }

    public void render() {
        io.writeln("---------------------------");
        for (Controller m : this.menuList) {
            io.writeln(m.getOption());
        }
    }

    public int readOption() {
        return LimitedIntDialog.instance().read("Opción", 1, 9);
    }

    public Controller getController() {
        return menuList.get((readOption() - 1));
    }

}
