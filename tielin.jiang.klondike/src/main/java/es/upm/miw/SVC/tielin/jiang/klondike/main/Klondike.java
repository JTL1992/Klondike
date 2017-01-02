package es.upm.miw.SVC.tielin.jiang.klondike.main;
import es.upm.miw.SVC.tielin.jiang.klondike.models.Game;
import es.upm.miw.SVC.tielin.jiang.klondike.views.GameView;

public class Klondike {

    public static void main(String[] args) {
        Game game = new Game();
        GameView gameView = new GameView(game);
        gameView.renderView(game);
    }
}
