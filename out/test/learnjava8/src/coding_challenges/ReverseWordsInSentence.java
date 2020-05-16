package coding_challenges;

// TODO : Ex. "Write this program" should become "program this Write"

public class ReverseWordsInSentence {

    public static void main(String[] args) {
        System.out.println(reverseWordsInSentence("Write this program"));
    }

    private static String reverseWordsInSentence(String sentence) {
        String[] splitByWords = sentence.split("\\s+");
        return reverseWords(splitByWords);
    }

    private static String reverseWords(String[] words) {
        StringBuilder reverseString = new StringBuilder();
        for(int i=words.length-1; i>=0; i--) {
            reverseString.append(words[i]).append(" ");
        }
        return reverseString.toString();
    }
}

