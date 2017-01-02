package es.upm.miw.SVC.tielin.jiang.klondike.models;

public class Waste extends Pile {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean isEmpty() {
        return getNotHiddenCardsNum() == 0;
    }
}
