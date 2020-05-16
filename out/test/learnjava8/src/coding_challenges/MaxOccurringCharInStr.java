package coding_challenges;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// TODO : Return the character that has occured for the maximum number of times in a string

public class MaxOccurringCharInStr {

    public static void main(String[] args) {
        System.out.println(getMaxOccurringChar("TarunDhraik"));
        System.out.println(getMaxOccurringChar("CodingMaximumNumberOfCharacter"));
    }

    private static List<Character> getMaxOccurringChar(String inputStr) {

        long startTime = System.nanoTime();

        // store each unique char and their counts in a hash map
        Map<Character, Integer> charCount = inputStr.chars().boxed()
                    .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum,
                        HashMap::new
                    ));

        // take out the maximum occurrence figure
        final int maximumOccurrences = charCount.entrySet().stream()
                .map(Map.Entry::getValue)
                .max(Comparator.naturalOrder())
        .orElse(0);

        // take out the maximum occurrence key from Map using value
        List<Character> chars = charCount.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maximumOccurrences))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Character " + chars.toString() + " has occurred " + maximumOccurrences + " time (maximum)");


        long endTime = System.nanoTime();
        System.out.println("time taken - " + (endTime - startTime));

        return chars;
    }

}
