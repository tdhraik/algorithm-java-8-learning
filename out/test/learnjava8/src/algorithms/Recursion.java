package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {
        //basicRecursion();
        int sizeOfList = recursiveLength(new ArrayList<>(Arrays.asList("Tarun", "Mausam", "Dhraik")));
        System.out.println(sizeOfList);
//        int recursiveSum = sum();
//        System.out.println(recursiveSum);
    }

    private static int sum() {
        int[] arr = {2,4,6,8};
        return recursiveSum(arr);
    }

    private static int recursiveSum(int[] arr) {
        if(arr.length==1) {
            return arr[0];
        }else {
            int[] newArr = new int[arr.length - 1];
            for(int i=1;i<arr.length;i++){
                newArr[i-1] = arr[i];
            }
            return arr[0] + recursiveSum(newArr);
        }
    }

    private static void basicRecursion() {
        printNumber(10);
    }

    private static void printNumber(int n){
        if(n<1) return;
        else printNumber(n-1);
        System.out.println(n);
    }

    private static int recursiveLength( List<String> names ) {
        List<String> updatedList;
        if( names.size() == 1 ) {
            return 1;
        } else {
            names.remove(0);
            updatedList = names;
            return 1 + recursiveLength( updatedList );
        }
    }
}
