package coding_challenges;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTripletsWithStreams {

    public static void main(String[] args) {

        Stream<int[]> triplets = IntStream.rangeClosed(1,100)
                .boxed()
                .flatMap( x ->
                    IntStream.rangeClosed(1,x)
                            .filter(y -> (Math.sqrt(Math.pow(x, 2) + Math.pow(y,2)) % 1 == 0))
                            .mapToObj(y -> new int[] {y, x, (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y,2))})
                );
        triplets.limit(5).forEachOrdered(x -> System.out.println(x[0] + " " + x[1] + " " + x[2]));
    }
}
