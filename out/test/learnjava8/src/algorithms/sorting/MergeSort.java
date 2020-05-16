package algorithms.sorting;


/**
 *
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5,2,3,1,9,4,13,7};
        mergeSort(arr, 0, arr.length-1);
        /*for( int anArr : arr ) {
            System.out.println(anArr);
        }*/
    }

    private static void mergeSort(int[] arr, int start, int end ) {
        if(start<end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge( int[] arr, int start, int mid, int end ) {
        System.out.println( " ---- Start => " + start + ", " + " Mid => " + mid + ", " + "End => " + end );
        int temp;
        int k = mid;
        for( int i=start; i<=mid; i++ ) {
            if( arr[i] > arr[k+1] ) {
                temp = arr[i];
                arr[i] = arr[k+1];
                arr[k+1] = temp;
            }
        }
        for( int anArr : arr ) {
            System.out.print(anArr + " => ");
        }
    }
}
