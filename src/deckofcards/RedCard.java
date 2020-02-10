package deckofcards;

import designpatterns.Cake;

import java.util.ArrayList;
import java.util.List;

public class RedCard <T extends Cake> {

    private List<T> cards = new ArrayList<>();

    public List<T> getCards() {
        return cards;
    }

    public void setCards(List<T> cards) {
        this.cards = cards;
    }
}
