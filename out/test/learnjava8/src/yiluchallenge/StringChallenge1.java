package yiluchallenge;

import java.util.stream.IntStream;

// TODO - Check if palindrome
public class StringChallenge1 {

    private final static String WORD_TO_CHECK = "taraT";

    public static void main(String args[]) {
        //boolean isPalindrome = wayOne(WORD_TO_CHECK);
        //boolean isPalindrome = wayTwo(WORD_TO_CHECK);
        boolean isPalindrome = wayThree(WORD_TO_CHECK);
        System.out.println(isPalindrome ? String.format("So, %s is a palindrome !", WORD_TO_CHECK)
                : String.format("So, %s is not a palindrome !", WORD_TO_CHECK));
    }

    // TODO - USING loop with two indices
    private static boolean wayOne(String word) {
        String[] splitWord = word.split("");
        boolean isPalindrome = true;
        for(int i=0, j=splitWord.length-1; i<=j; i++,j--) {
            if(!splitWord[i].toLowerCase().equals(splitWord[j].toLowerCase())) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    // TODO - Using RECURSION
    private static boolean wayTwo(String word) {
        String reversedString = reverseStringByRecursion(word);
        return word.equals(reversedString);
    }

    private static String reverseStringByRecursion(String word) {
        if(null==word || word.length()==0) {
            return word;
        }
        return word.charAt(word.length()-1) + reverseStringByRecursion(word.substring(0, word.length()-1));
    }

    // TODO - USING Streams
    private static boolean wayThree(String word) {
        String allLowerCaseWord = word.toLowerCase();
        return IntStream.rangeClosed(0, allLowerCaseWord.length() / 2)
                .allMatch(i -> allLowerCaseWord.charAt(i) == allLowerCaseWord.charAt(word.length()-i-1));
    }

}