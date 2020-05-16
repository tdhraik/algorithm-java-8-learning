package coding_challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// TODO : Print all possible permutations of a string of a given length

// TODO : For ex. "abcde" all permutation of length 3 would be {"abc", "abd", "abe", "acd", "ace", "ade", "bcd", "bce", "bde", "cde"}

public class AllPermutation {

    public static void main(String[] args) {
        System.out.println(getAllPermutations("abcde", 3));
        System.out.println(getAllPermutations("lmnop", 2));
    }
    private static List<String> getAllPermutations(String str, int size) {
        List<String> allPermutations = new ArrayList<>();

        for(int i=0; i <= str.length()-size; i++) {
            for(int j=i+1; j <= str.length()-2; j++) {
                allPermutations.addAll(joinString(String.valueOf(str.charAt(i)) + String.valueOf(str.charAt(j)), str.substring(j+1)));
            }
        }
        return allPermutations;
    }


    private static List<String> joinString(String prefix, String suffixes) {
        List<String> joinedStrings = new ArrayList<>();
        List<String> suffixesList = Arrays.stream(suffixes.split("")).collect(Collectors.toList());
        for(String suffix : suffixesList) {
            joinedStrings.add(prefix + suffix);
        }
        return joinedStrings;
    }

}
