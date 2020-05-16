package algorithms.cyclic_sort;


/**
 * this is used when we are given an array of 'n' values and its confirmed that all numbers exist from 1 to n in
 * the array.
 *  https://www.educative.io/courses/grokking-the-coding-interview/YVjXo6J9xN9
 */
public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {4,2,1,3,6,5};
        int i=0;
        while ( i != arr.length ) {
            if(i == (arr[i]-1)) {
                i++;
            } else {
                swap(arr, i, arr[i] - 1);
            }
        }
        display(arr);
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
