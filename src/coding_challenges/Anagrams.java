package coding_challenges;

// TODO : Anagram are two words that have same set of characters but in different order ex. timet and mitte

// TODO : Algorithm could be to convert string to char[] then sort the two arrays and then then use Arrays.equals(a,b)

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagrams {

    public static void main(String[] args) {
        System.out.println(areAnagrams("time", "mite"));
        System.out.println(areAnagrams("mitters", "tsrimets"));
        System.out.println(isAnagram("mitsters", "tsrimets"));
    }

    // TODO : MUCH MUCH efficient than the other one below (areAnagrams(..))
    private static boolean isAnagram(String word, String anagram){
        long start = System.currentTimeMillis();
        char[] charFromWord = word.toCharArray();
        char[] charFromAnagram = anagram.toCharArray();
        Arrays.sort(charFromWord);
        Arrays.sort(charFromAnagram);
        boolean isAnagram = Arrays.equals(charFromWord, charFromAnagram);
        long end = System.currentTimeMillis();
        System.out.println("Time taken - " + (end-start));
        return isAnagram;
    }

    private static boolean areAnagrams(String firstStr, String secondStr) {

        long start = System.currentTimeMillis();
        boolean areAnagrams = true;
        if(firstStr ==null || secondStr == null) {
            areAnagrams = false;
        }
        if(firstStr.length() != secondStr.length()) {
            areAnagrams = false;
        }

        Map<Character, Integer> charCountsFirstStr = firstStr.chars().boxed()
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum,
                        IdentityHashMap::new
                ));

        Map<Character, Integer> charCountsSecondStr = firstStr.chars().boxed()
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum,
                        IdentityHashMap::new
                ));

        if(!charCountsFirstStr.equals(charCountsSecondStr)) {
            areAnagrams = false;
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken - " + (end-start));

        return areAnagrams;
    }

}
