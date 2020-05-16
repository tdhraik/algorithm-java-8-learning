package coding_challenges;

import static java.lang.Math.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: Determine if a given number is prime or not !!

/**
 * Time complexity is O(^N) or O(sqrt(N))
 *
 */
public class PrimeNumber {

    public static void main(String[] args) {
        assertTrue(isPrime(17));
        assertFalse(isPrime(27));
        assertTrue(isPrime(53));
        assertTrue(isPrime_Sqrt(53));
        assertFalse(isPrime_Sqrt(27));
        assertTrue(isPrime_Sqrt(17));
    }

    private static boolean isPrime(int n) {
        for (int x = 2; x * x <= n; x++) {
            if (n % x == 0) return false;
        }
        return true;
    }

    private static boolean isPrime_Sqrt(int n) {
        for (int x = 2; x <= sqrt(n); x++) {
            if (n % x == 0) return false;
        }
        return true;
    }
}
