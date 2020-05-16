package algorithms.sorting;


/**
 * Find the smallest in the array, move it to first position. Then search for second smallest from second position
 * to the last, move it to second position, and so on...
 */

public class SelectionSort {

    public static void main(String[] args) {
        boolean doSwap = false;
        int[] arr = {2,3,9,7,1,5};
        int min, temp, index =0;
        for (int i = 0; i < arr.length; i++) {
            doSwap = false; //optimization
            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if( min > arr[j]) {
                    min = arr[j];
                    index = j;
                    doSwap = true;
                }
            }
            if(doSwap) {
                temp = arr[i];
                arr[i] = min;
                arr[index] = temp;
            }
        }
        for (int ar : arr) {
            System.out.println(ar);
        }
    }
}
