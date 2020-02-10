package yiluchallenge;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

// TODO - Remove a given word from a string
public class StringChallenge2 {

    private final static String TEST_STRING = "My name is Tarun Dhraik";
    private final static String WORD_TO_REMOVE = "is";
    private final static Character CHARACTER_TO_REMOVE = 'a';
    public static void main(String... args) {
        wayOne();
    }

    // TODO - remove word
    private static String wayOne() {
        String[] words = TEST_STRING.split(" ");
        List<String> wordsList = new ArrayList<>();
        Collections.addAll(wordsList, words);
        wordsList.removeIf(word -> word.equals(WORD_TO_REMOVE));
        wordsList.forEach(w -> System.out.print(w + " "));
        assertEquals(wordsList.size(), 4);
        assertEquals(false, wordsList.contains(WORD_TO_REMOVE));
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : wordsList) {
            stringBuilder.append(word + " ");
        }
        return stringBuilder.toString().trim();
    }

    // TODO - remove Character
    private static void wayTwo() {
        Stream<String> wordStream = Stream.of(TEST_STRING);
        //wordStream.flatMap(n -> )
    }

    @Test
    public void whenWayOneIsCalledWithValidWordToRemove_thenReturnStringWithWordRemoved() {
        System.out.println(wayOne());
    }
}
