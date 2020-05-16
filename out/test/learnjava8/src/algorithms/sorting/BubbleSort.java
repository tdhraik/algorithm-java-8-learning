package algorithms.sorting;


/**
 * Repeated swapping of peers in the array. At the end of each pass the largest number is at the end...
 * first pass - first largest number will be at the end,
 * second pass - second largest number will be at the end, and so on...
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {8,2,1,9,4};
        int temp;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length -1; j++) {
                if(arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
