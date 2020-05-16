package coding_challenges;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


// TODO : Calculate factorial of a given number

/**
 * Time complexity for recursive one is 2^n
 */
public class Factorial_Streams {

    public static void main(String[] args) {
        assertEquals(120, factorial(5));
        assertEquals(720, factorial(6));
        assertEquals(120, factorial_streams(5));
        assertEquals(720, factorial_streams(6));
    }

    // this is a straight recursion from n to n-1 to n-2 and so on till 1
    private static long factorial(int n) {
        if(n==1) {
            return n;
        }
        return n * factorial(n-1);
    }

    // using java 8
    private static long factorial_streams(int n) {
        return LongStream.rangeClosed(1,n)
                .boxed().reduce(1L, (a,b) -> a * b);
    }
}
