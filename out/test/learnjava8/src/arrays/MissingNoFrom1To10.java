package arrays;


import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNoFrom1To10 {

    private static int[] numbers;

    static {
        numbers = new int[]{1,4,3,5,8,9,7,6};
    }

    public static void main(String[] args) {

        int correctSum = IntStream.rangeClosed(1,9)
                .sum();
        int actualSum = Arrays.stream(numbers)
                .sum();
        System.out.println(correctSum-actualSum);
    }
}