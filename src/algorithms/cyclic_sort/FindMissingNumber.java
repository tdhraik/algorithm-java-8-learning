package algorithms.cyclic_sort;


/**
 * in a continuous array of numbers one number is missing, find it.
 * can be done using sum of n numbers (n)*(n+1)/2 - actual sum of numbers given
 * OR using the concept of cyclic sort, but this would need us to use extra memory
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = {4,0,1,3,5,2,7};
        System.out.println(findMissingNumberAtConstantSpace(arr));
    }

    // at constant space and linear time
    private static int findMissingNumberAtConstantSpace(int[] arr) {
        int i=0;
        while( i < arr.length ) {
            if( ( arr[i] != i ) && ( arr[i] < arr.length ) ) {
                swap(arr, i, arr[i]);
            } else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if( arr[j] != j ) {
                return j;
            }
        }
        return -1;
    }

    // this uses additional memory
    private static int findMissingNumber(int[] arr) {
        int[] newArr = new int[arr.length+1];
        for (int anArr : arr) {
            newArr[anArr] = anArr;
        }
        for (int i = 0; i < newArr.length; i++) {
            if(i != newArr[i]) {
                return i;
            }
        }
        return -1;
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
