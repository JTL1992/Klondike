package es.upm.miw.SVC.tielin.jiang.klondike.models;

import java.util.Stack;

public abstract class Pile extends Stack<Card> {

    private static final long serialVersionUID = 1L;

    public static final int TABLEAU_NUM = 7;

    public int getNotHiddenCardsNum() {
        int num = 0;
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).getIsHidden()) {
                num += 1;
            }
        }
        return num;
    }

}
