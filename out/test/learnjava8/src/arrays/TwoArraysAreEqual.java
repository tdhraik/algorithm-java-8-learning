package arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;

class TwoArraysAreEqual {

    private boolean checkIfEqual(int[] a1, int[] a2) {
        int index = 0;
        if(a1.length != a2.length){
            return false;
        }
        while(index < a1.length) {
            if(a1[index] != a2[index]) {
                return false;
            }
            index++;
        }
        return true;
    }

    @Test
    void shouldBeEqual() {
        int[] a1 = {1,4,2,5,7};
        int[] a2 = {1,4,2,8,9};

        assertFalse(checkIfEqual(a1, a2));

        IntStream intStream = Arrays.stream(a1);
        System.out.println(intStream.boxed().reduce(0, (a,b) -> a + b));

    }
}
