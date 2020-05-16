package deckofcards;

import java.util.Arrays;

public enum CardColorEnum {

    RED("red"), BLACK("black");

    private String color;

    CardColorEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public static boolean isValidColor(String colorToCheck) {
        return Arrays.stream(CardColorEnum.values())
                .anyMatch(cardColorEnum -> cardColorEnum.getColor().equals(colorToCheck));
    }
}
