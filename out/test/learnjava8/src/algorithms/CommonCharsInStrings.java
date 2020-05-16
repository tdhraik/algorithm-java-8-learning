package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CommonCharsInStrings {

    public static void main(String[] args) {
        String first = "tarundhraik";
        String second = "dhraik";

        Map<Character, Integer> charFreqFirstStr = first.chars().boxed()
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum,
                        HashMap::new
                ));
        Map<Character, Integer> charFreqSecondStr = second.chars().boxed()
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum,
                        HashMap::new
                ));

        int countOfCommonChars = 0;
        if(first.length() <= second.length()){
            countOfCommonChars = getCountOfCommonChars(charFreqFirstStr, charFreqSecondStr, countOfCommonChars);
        } else {
            countOfCommonChars = getCountOfCommonChars(charFreqSecondStr, charFreqFirstStr, countOfCommonChars);
        }
        System.out.println(countOfCommonChars);
    }

    private static int getCountOfCommonChars(Map<Character, Integer> charFreqToFind, Map<Character, Integer> charFreqToIterate, int countOfCommonChars) {
        for(Character key : charFreqToIterate.keySet()) {
            if(charFreqToFind.get(key) != null) {
                if(charFreqToFind.get(key).intValue() < charFreqToIterate.get(key).intValue()){
                    countOfCommonChars += charFreqToFind.get(key).intValue();
                } else {
                    countOfCommonChars += charFreqToIterate.get(key).intValue();
                }
            }
        }
        return countOfCommonChars;
    }
}
