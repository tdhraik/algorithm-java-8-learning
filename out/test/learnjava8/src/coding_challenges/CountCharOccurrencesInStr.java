package coding_challenges;


// TODO : Count all occurrences of a particular character in a string

public class CountCharOccurrencesInStr {

    public static void main(String[] args) {
        System.out.println(countCharOccurrencesInString('a', "Tarun"));
        System.out.println(countCharOccurrencesInString('M', "MausaM"));
    }

    private static long countCharOccurrencesInString(Character toCount, String inputStr) {

        return inputStr.chars().boxed()
                .filter(c -> ((char) c.intValue()) == toCount)
                .count();
    }
}
