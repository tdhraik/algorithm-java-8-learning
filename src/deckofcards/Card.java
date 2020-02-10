package deckofcards;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Card {

    private CardColorEnum color;

    private Integer number;

    public String getColor() {
        return color.getColor();
    }

    public void setColor(String color) {
        if(!CardColorEnum.isValidColor(color)) {
            throw new InvalidColorException(String.format("Invalid color - {%s}, allowed values are - {%s}",
                    color, Arrays.stream(CardColorEnum.values()).collect(Collectors.toList()).toString()));
        }
        this.color = CardColorEnum.valueOf(color);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        if(number>13) {
            throw new InvalidNumberException(String.format("Invalid number - {%s}. Allowed values are b/w 1 and 52(incl.)", number));
        }
        this.number = number;
    }

    public boolean isKing() {
        return this.getNumber().equals(13);
    }

    public boolean isRed() {
        return this.getColor().equals(CardColorEnum.RED.getColor());
    }

    public boolean isBlack() {
        return this.getColor().equals(CardColorEnum.BLACK.getColor());
    }
}
