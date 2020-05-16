package coding_challenges;

// TODO : reverse a string

public class ReverseStringRecursively {

    public static void main(String[] args) {
        String name = "tarun";
        System.out.println(reverseRecursively(name));
    }

    private static String reverseRecursively(String str) {
        if(str.length() < 2) {
            return str;
        }
        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }
}
