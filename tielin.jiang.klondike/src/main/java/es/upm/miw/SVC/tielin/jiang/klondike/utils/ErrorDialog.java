package es.upm.miw.SVC.tielin.jiang.klondike.utils;

import es.upm.miw.SVC.tielin.jiang.klondike.models.Card;
import es.upm.miw.SVC.tielin.jiang.klondike.views.CardView;

public class ErrorDialog {

    public static ErrorDialog errorDialog;

    private IO io = IO.instance();

    public static ErrorDialog instance() {
        if (errorDialog == null) {
            errorDialog = new ErrorDialog();
        }
        return errorDialog;
    }

    private ErrorDialog() {

    }

    public void renderCantMoveError(Card origin, Card destination) {
        io.write("ERROR!!! No se puede poner ");
        CardView.instance().render(origin);
        io.write(" sobre ");
        CardView.instance().render(destination);
        io.writeln();
    }

    public void renderCantMoveError(Card origin, String title) {
        io.write("ERROR!!! No se puede poner ");
        CardView.instance().render(origin);
        io.write(" sobre " + title);
        io.writeln();
    }

    public void renderEmptyError(String title) {
        io.writeln("ERROR!!! " + title + " está vacío");
    }

    public void renderHasNotHiddenCardsError(String title) {
        io.writeln("ERROR!!! " + title + " no tiene cartas que se pueden mover");
    }

    public void renderSamePileError() {
        io.writeln("ERROR!!! No se puede mover cartas desde una escalera a su misma");
    }

    public void renderDeckNotEmpty() {
        io.writeln("ERROR!!! No está vacío baraja");
    }

    public void renderCantTurnOutError() {
        io.writeln("ERROR!!! No hay carta para voltear");
    }

    public void renderCantMoveToHiddenCard() {
        io.writeln("ERROR!!! No se puede mover cartas to cartas ocultadas");
    }
}
