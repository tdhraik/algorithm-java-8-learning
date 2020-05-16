package deckofcards;

import java.util.Collections;
import java.util.List;

public class Trigger {

    private static volatile int a = 0;


    public static void main(String args[]) {

        BlackCard blackCard = new BlackCard();
        List<BlackCard> blackCards = Collections.singletonList(blackCard);

        RedCard redCard = new RedCard();

        redCard.setCards(blackCards);

        blackCards.stream().forEach( bc -> { a = a + bc.getNumber(); } );


    }
}
