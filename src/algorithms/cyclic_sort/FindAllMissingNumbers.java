package algorithms.cyclic_sort;


import java.util.ArrayList;
import java.util.List;

/**
 * Find all missing numbers in an continuous array.
 *  This one can not be done using the sum of first n numbers formula, and hence
 *  has to be handled using the cyclic sort routine.
 *
 */
public class FindAllMissingNumbers {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 8, 2, 3, 5, 1};
        List<Integer> allMissingNumbers = findAllMissingNumbers( arr );
        System.out.println(allMissingNumbers);
    }

    private static List<Integer> findAllMissingNumbers( int[] arr ) {
        List<Integer> missingNumbers = new ArrayList<>();
        int i=0;
        while( i < arr.length ) {
            if( arr[i] != arr[arr[i]-1] ) {
                swap(arr, i, arr[i]-1);
            } else {
                i++;
            }
        }
        display(arr);
        return missingNumbers;
    }

    private static void swap( int[] arr, int i, int j ) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void display(int[] arr) {
        for(int anArr : arr) {
            System.out.print(anArr + " => ");
        }
    }

}
