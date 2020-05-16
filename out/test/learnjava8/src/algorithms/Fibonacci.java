package algorithms;

/**
 * 1,1,2,3,5,8,13,21,34....
 */
public class Fibonacci {

    public static void main(String[] args) {
        printXFibonacci(10);
        printXFibonacciRecursively(10);
    }

    // O(n) => linear time
    private static void printXFibonacci( int x ) {
        int[] fibArr = new int[x];
        int first = 1, second = 1;
        fibArr[0] = first;
        fibArr[1] = second;
        for (int i = 2; i < x; i++) {
            fibArr[i] = first + second;
            first = second;
            second = fibArr[i];
        }
        for( int fib : fibArr ) {
            System.out.print( fib + "->" );
        }
        System.out.println("?");
    }

    // O(n) => recursive
    private static void printXFibonacciRecursively( int x ) {
        System.out.print("1->1->");
        printFibRecursively(x,1,1);
        System.out.print("?");
    }

    private static void printFibRecursively(int x, int first, int second) {
        if(x>2) {
            System.out.print(first + second + "->");
            printFibRecursively(--x, second, first + second);
        }
    }
}
