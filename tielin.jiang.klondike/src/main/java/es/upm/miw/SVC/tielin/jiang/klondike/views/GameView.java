package es.upm.miw.SVC.tielin.jiang.klondike.views;

import es.upm.miw.SVC.tielin.jiang.klondike.controllers.Controller;
import es.upm.miw.SVC.tielin.jiang.klondike.controllers.StartController;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.utils.IO;

public class GameView {

    private Controller controller;

    private MenuView menuView;

    public GameView(Game game) {
        menuView = new MenuView(game);
        controller = new StartController(game, "");
    }

    public void renderView(Game game) {
        boolean ok = true;
        do {
            if (controller.control()) {
                loadPiles();
            }
            controller = menuView.getController();
            ok = !controller.isEnd();
        } while (ok);
    }

    private void loadPiles() {
        IO io = IO.instance();
        io.writeln("===========================");
        DeckView.instance().render(controller.refreshDeck());
        WasteView.instance().render(controller.refreshWaste());
        FoundationView.instance().render(controller.refreshFoundations());
        TableauView.instance().render(controller.refreshTableaus());
        menuView.render();
    }
}
