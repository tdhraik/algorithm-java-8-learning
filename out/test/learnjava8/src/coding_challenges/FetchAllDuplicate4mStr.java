package coding_challenges;


// TODO : Fetch all duplicate character from a string

import java.util.*;
import java.util.stream.Collectors;

public class FetchAllDuplicate4mStr {

    public static void main(String[] args) {
        System.out.println(fetchAllDuplicates("Tarun Dhraik Mausam Dhraik Tarun Dhraik Mausam Dhraik Tarun Dhraik Mausam Dhraik Tarun Dhraik Mausam Dhraik"));
        System.out.println(fetchAllDuplicates_HashMap("Tarun Dhraik Mausam Dhraik Tarun Dhraik Mausam Dhraik Tarun Dhraik Mausam Dhraik Tarun Dhraik Mausam Dhraik"));
    }


    // TODO : Much efficient solution
    private static List<Character> fetchAllDuplicates_HashMap(String inputStr) {

        long start = System.currentTimeMillis();
        List<Character> duplicateChars;
        Map<Character, Integer> countChars = inputStr.chars().boxed()
                .parallel()
                .filter(c -> c != 32)
                .collect(Collectors.toMap(
                        k -> (char) k.intValue(),
                        v -> 1,
                        Integer::sum,
                        LinkedHashMap::new
                ));

        duplicateChars = countChars.entrySet()
                .parallelStream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.println("Time taken to execute (ms) - " + (end-start));

        return duplicateChars;
    }

    private static List<Character> fetchAllDuplicates(String inputStr) {

        long start = System.currentTimeMillis();

        List<Character> duplicates = new ArrayList<>();
        List<Character> allDistinctChars = inputStr.chars().boxed()
                .sequential()
                .filter(c -> c != 32)
                .map(c -> (char) c.intValue())
                .distinct()
                .collect(Collectors.toList());

        for(Character distinctChar : allDistinctChars) {
            if(checkIfCharPresent(distinctChar, inputStr.substring(inputStr.indexOf(distinctChar) + 1))) {
                duplicates.add(distinctChar);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken to execute (ms) - " + (end-start));
        return duplicates;
    }

    private static boolean checkIfCharPresent(Character c, String inputStr) {
        return inputStr.contains(c.toString());
    }

}
