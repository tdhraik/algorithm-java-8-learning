package concepts;

import java.util.*;

public class MapVsFlatMap {

    public static void main(String[] args) {

       int [] a = {1,4,2,-2,5};
       int [] b = {7,-2,-2,2,5};   // 2

//        int [] a = {3,2,6};
//       int [] b = {4,1,6};    // 0
//  int [] a = {2,-2,-3,3};
//        int [] b = {0,0,4,-4};    // 1

        int sumA = Arrays.stream(a).reduce(0, Integer::sum);
        int sumB = Arrays.stream(b).reduce(0, Integer::sum);

        if(sumA != sumB) {
            System.out.println(0);
        }
        if(sumA%2 != 0) {
            sumA +=1;
        }
        int halfSumA = sumA/2;
        int halfSumB = sumB/2;
        if(halfSumA==halfSumB) {
            System.out.println(a.length/2 - 1);
        }
        sumA=0;
        sumB=0;
        int count = 0;
        for(int index = 0; index < a.length; index++) {
            sumA+=a[index];
            sumB+=b[index];
            if(sumA==sumB && sumA==halfSumA) {
                count++;
            }
        }

        System.out.println(count);
    }
}
