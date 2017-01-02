package es.upm.miw.SVC.tielin.jiang.klondike.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

import es.upm.miw.SVC.tielin.jiang.klondike.utils.ErrorDialog;

public class Game {

    private Pile deck;

    private ArrayList<Pile> tableaus;

    private Pile waste;

    private HashMap<CardType, Pile> foundations;

    public Game() {
        deck = new Deck();
        tableaus = new ArrayList<Pile>();
        waste = new Waste();
        foundations = new HashMap<CardType, Pile>();
        initPiles();
    }

    private void initPiles() {
        for (CardType cardType : CardType.values()) {
            for (int i = Card.CARD_MIN_VALUE; i <= Card.CARD_MAX_VALUE; i++) {
                deck.push(new Card(cardType, i, true));
            }
            ;
        }
        ;
        Collections.shuffle(deck);

        for (int i = 0; i < Pile.TABLEAU_NUM; i++) {
            tableaus.add(new Tableau());
            for (int j = 0; j < (7 - i); j++) {
                tableaus.get(i).push(deck.pop());
            }
            tableaus.get(i).peek().setIsHidden(false);
        }

        for (CardType cardType : CardType.values()) {
            foundations.put(cardType, new Foundation(cardType));
        }
    }

    public Pile getDeck() {
        return deck;
    }

    public HashMap<CardType, Pile> getFoundations() {
        return foundations;
    }

    public ArrayList<Pile> getTableaus() {
        return tableaus;
    }

    public Pile getWaste() {
        return waste;
    }

    public Card getFoundationCard(CardType cardType) {
        return getFoundationByType(cardType).peek();
    }

    public Card getTableauCard(int index, int num) {
        Pile tableau = getTableauByIndex(index);
        return tableau.get(tableau.size() - num);
    }

    public Card getTableauCard(int index) {
        return getTableauCard(index, 1);
    }

    public int getTableauNotHiddenCardsNum(int index) {
        return getTableauByIndex(index).getNotHiddenCardsNum();
    }

    public boolean canMoveFromDeck() {
        if (deck.isEmpty()) {
            ErrorDialog.instance().renderEmptyError("Baraja");
            return false;
        }
        return true;
    }

    public boolean canMoveToDeck() {
        if (deck.isEmpty()) {
            return true;
        }
        ErrorDialog.instance().renderDeckNotEmpty();
        return false;
    }

    public void moveDeckToWaste() {
        int num = deck.size() >= 3 ? 3 : deck.size();
        setWasteHidden();
        for (int i = 0; i < num; i++) {
            deck.peek().setIsHidden(false);
            waste.push(deck.pop());
        }
    }

    public boolean canMoveFromWaste() {
        if (waste.isEmpty()) {
            ErrorDialog.instance().renderEmptyError("Descarte");
            return false;
        }
        return true;
    }

    private void setWasteHidden() {
        int numWaste = waste.size();
        int numNotHidden = waste.getNotHiddenCardsNum();
        if (!waste.isEmpty()) {
            for (int i = 0; i < numNotHidden; i++) {
                waste.get(numWaste - numNotHidden + i).setIsHidden(true);
                ;
            }
        }
    }

    public void moveWasteToDeck() {
        setWasteHidden();
        moveStackToStack(waste, deck, waste.size());
    }

    public boolean canMoveFromTableau(int index) {
        if (getTableauByIndex(index).isEmpty()) {
            ErrorDialog.instance().renderEmptyError("Escalera " + (index + 1));
            return false;
        }
        if (getTableauByIndex(index).getNotHiddenCardsNum() == 0) {
            ErrorDialog.instance().renderHasNotHiddenCardsError("Escalera " + (index + 1));
            return false;
        }
        return true;
    }

    public boolean turnOutTableauCard(int index) {
        if (getTableauByIndex(index).isEmpty()) {
            ErrorDialog.instance().renderEmptyError("Escalera " + (index + 1));
            return false;
        }
        if (getTableauByIndex(index).getNotHiddenCardsNum() != 0) {
            ErrorDialog.instance().renderCantTurnOutError();
            return false;
        }
        getTableauCard(index).setIsHidden(false);
        return true;
    }

    public boolean canMoveCardToTableau(int index, Card card) {
        Pile tableau = getTableauByIndex(index);
        if (tableau.isEmpty()) {
            if (!card.isKing()) {
                ErrorDialog.instance().renderCantMoveError(card, "escalera " + (index + 1));
                return false;
            }
            return true;
        }
        if (tableau.getNotHiddenCardsNum() == 0 && !tableau.isEmpty()) {
            ErrorDialog.instance().renderCantMoveToHiddenCard();
            return false;
        }
        if (!card.isAlternateBuildDown(tableau.peek())) {
            ErrorDialog.instance().renderCantMoveError(card, tableau.peek());
            return false;
        }
        return true;
    }

    public void moveWasteToFoundation() {
        CardType cardType = waste.peek().getType();
        Pile foundation = getFoundationByType(cardType);
        foundation.push(waste.pop());

    }

    public void moveWasteToTableau(int index) {
        Pile tableau = getTableauByIndex(index);
        tableau.push(waste.pop());
    }

    public boolean canMoveFromFoundation(CardType cardType) {
        if (getFoundationByType(cardType).isEmpty()) {
            ErrorDialog.instance().renderEmptyError("Palo " + cardType.toString());
            return false;
        }
        return true;
    }

    public boolean canMoveCardToFoundation(Card card) {
        CardType cardType = card.getType();
        Pile foundation = getFoundationByType(cardType);
        if (foundation.isEmpty()) {
            if (!card.isAce()) {
                ErrorDialog.instance().renderCantMoveError(card, "Palo " + cardType.toString());
                return false;
            }
            return true;
        }
        if (!card.isSuitBuildUp(foundation.peek())) {
            ErrorDialog.instance().renderCantMoveError(card, foundation.peek());
            return false;
        }
        return true;
    }    

    private Pile getTableauByIndex(int index) {
        return tableaus.get(index);
    }


    private Pile getFoundationByType(CardType cardType) {
        assert cardType != null;
        return foundations.get(cardType);
    }

    public void moveTableauToTableau(int from, int to, int num) {
        assert num != 0;
        Pile origin = getTableauByIndex(from);
        Pile destination = getTableauByIndex(to);
        moveStackToStack(origin, destination, num);
    }

    public void moveTableauToFoundation(int index, int num) {
        assert num != 0;
        CardType cardType = getTableauCard(index, num).getType();
        Pile origin = getTableauByIndex(index);
        Pile destination = getFoundationByType(cardType);
        moveStackToStack(origin, destination, num);
    }

    public void moveFoundationToTableau(CardType cardType, int index, int num) {
        assert num != 0;
        Pile origin = getFoundationByType(cardType);
        Pile destination = getTableauByIndex(index);
        moveStackToStack(origin, destination, num);
    }

    private void moveStackToStack(Pile origin, Pile destination, int num) {
        Stack<Card> cards = new Stack<Card>();
        for (int i = 0; i < num; i++) {
            cards.push(origin.pop());
        }
        for (int i = 0; i < num; i++) {
            destination.push(cards.pop());
        }
    }

}
