import java.util.stream.IntStream;

/**
 * Using parallel stream and leveraging multi threading is really simple with java 8. The number of threads
 * used by default equals the number of available processors in the machine. Dual core(2), quad core(4), etc.
 * We can customize the number of threads like this -
 * System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12"); but the system default is
 * fine for most of the cases.
 */

public class ParallelStreams {

    public static void main(String args[]) {
        System.out.println(IntStream.rangeClosed(Integer.valueOf(args[0]), Integer.valueOf(args[1])).parallel().sum());
    }




}
