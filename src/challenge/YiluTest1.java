package challenge;


import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YiluTest1 {

    public static void main(String args[]) {
        assertEquals(Optional.empty(), firstNonRepeatedChar(null)); // null string
        assertEquals(Optional.empty(), firstNonRepeatedChar("")); // empty string
        assertEquals(Optional.empty(), firstNonRepeatedChar("testertester")); // no unique char
        assertEquals(Optional.of('T'), firstNonRepeatedChar("yiluTestyilu"));
        assertEquals(Optional.of('e'), firstNonRepeatedChar("testingNonChar"));

        // failed attempt with string index and substring
        assertEquals(true, isRotated("Tarun", "arunT"));
        //Assert.assertEquals(true, isRotated("Yilu", "luiY")); // testing failing
        //Assert.assertEquals(true, isRotated_ByStringJoin("DhraikDka", "DkaDhraik")); // test failing
        assertEquals(true, isRotated("TestingRotation", "RotationTesting"));

        // string joining
        assertEquals(true, isRotated_ByStringJoin("DhraikDka", "DkaDhraik"));
        assertEquals(false, isRotated_ByStringJoin("Tarun", "anuRt"));
        assertEquals(false, isRotated_ByStringJoin("Yilu", null));
        assertEquals(false, isRotated_ByStringJoin("Yilu", "Test"));
    }

    /*
     ****** Solution 1 *********
    */
    static Optional<Character> firstNonRepeatedChar(String inputStr) {

        if(inputStr == null) {
            return Optional.empty();
        }

        Map<Character, Integer> charCounts = inputStr.chars()
                .boxed()
                .sequential()
                .collect(Collectors.toMap(
                    k -> (char) k.intValue(),
                    v -> 1,
                    Integer::sum,
                    LinkedHashMap::new // to maintain the insertion order
                ));

        return charCounts.entrySet()
                .stream()
                .filter(e -> e.getValue().equals(1))
                .map(Map.Entry::getKey)
                .findFirst();
    }

    /*
     ****** Solution 2 *********
    */

    // this solution works fine when there is no first letter duplicate in the input string
    static Boolean isRotated(String inputStr, String strToTest) {
        if(inputStr == null || strToTest == null) {
            return false;
        }

        if(inputStr.length() != strToTest.length()) {
            return false;
        }

        if(inputStr.equals(strToTest)) {
            return true;
        }

        int start = strToTest.indexOf(inputStr.charAt(0));
        if(start >= 0) {
            int end = strToTest.length() - start;
            return strToTest.charAt(0) == inputStr.charAt(end)
                        && inputStr.substring(end).equals(strToTest.substring(0, start));
        }
        return false;
    }

    // after failing in one of the tests above and fixing above solution unsuccessfully, figured out this solution below
    static Boolean isRotated_ByStringJoin(String inputStr, String strToTest) {
        if(inputStr == null || strToTest == null) {
            return false;
        }

        if(inputStr.length() != strToTest.length()) {
            return false;
        }

        if(inputStr.equals(strToTest)) {
            return true;
        }

        String joinedInputStr = inputStr + inputStr;
        return joinedInputStr.contains(strToTest);
    }

    /*
     ************ Solution 3 ********************
      I am not aware of the sum type or product type
     */



    /*
     ************ Solution 4 ********************
     */

    static void reduce_map_flatMap() {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        /*
        Reduce is a way to iteratively combine results using some mathematical operator. It can be imagined as repeatedly wrapping a
        long piece of paper through some specific operation until a final desired shape is achieved.
        */
        assertEquals(new Integer(15), numbers.stream().reduce(0, Integer::sum));

        // Map helps to apply a function to each element of a stream

        List<Integer> numbersMultipliedBy2 =
                numbers.stream()
                .map(n -> n*2)
                .collect(Collectors.toList());

        List<String> names = Arrays.asList("Tarun", "Dhraik", "Yilu", "Test");

        /*
         Flat map helps us to map each array not with a stream but by the contents of the stream. All the separate
          streams generated after split operation are combined into one stream using flatMap or 'flattened' into one
         single stream.
        */

        names.stream()
                .map(name -> name.split(""))
                .flatMap(Arrays::stream)
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);

    }

}
