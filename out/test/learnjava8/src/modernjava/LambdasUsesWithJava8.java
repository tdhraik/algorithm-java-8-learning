package modernjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;


/**
 * Stream API lets us achieve a more declarative, greater flexibility, and parallelism through simple statements.
 *
 * Streams are - a sequence of elements from a source that supports data processing operations.
 *
 * Sequence of elements — Like a collection, a stream provides an interface to a sequenced set of values of a specific element type.
 * Because collections are data structures, they’re mostly about storing and accessing elements with specific time/space complexities (for example, an ArrayList vs. a LinkedList).
 * But streams are about expressing computations such as filter, sorted, and map that you saw earlier.
 * Collections are about data; streams are about computations. We explain this idea in greater detail in the coming sections.
 *
 * Source — Streams consume from a data-providing source such as collections, arrays, or I/O resources.
 * Note that generating a stream from an ordered collection preserves the ordering. The elements of a stream coming from a list will have the same order as the list.
 *
 * Data processing operations — Streams support database-like operations and common operations from functional programming languages to manipulate data,
 * such as filter, map, reduce, find, match, sort, and so on. Stream operations can be executed either sequentially or in parallel.
 *
 * In addition there are two more characteristics of Streams...
 *
 * Pipelining— Many stream operations return a stream themselves, allowing operations to be chained and form a larger pipeline.
 * This enables certain optimizations that we explain in the next chapter, such as laziness and short-circuiting.
 * A pipeline of operations can be viewed as a database-like query on the data source.
 *
 * Internal iteration— In contrast to collections, which are iterated explicitly using an iterator, stream operations do the iteration behind the scenes for you.
 *
 * Collections Vs Streams - Collections are data structure, responsible for storing and accessing data whereas Streams are
 * more focused on computations (such as filter, sort, map, etc...
 *
 * Collections are an in-memory data structure, all elements have to be computed or loaded in memory before actually doing some operation on the collection
 * where as Streams are like computed on-demand.
 *
 *
 */
public class LambdasUsesWithJava8 {

    final static List<Apple> apples = Arrays.asList(new Apple("Green", 2.5, "Royal"), new Apple("Green", 2.2, "Royal"),
            new Apple("Red", 3.0, "Golden"), new Apple("Red", 4.1, "Royal Red"));

    final static List<String> names = Arrays.asList("Tarun", "Mausam", "Ram", "Dhraik", "Leo", "Christiano", "Messi", "Ronaldo");

    public static void main(String[] args) {

        // Building streams
        Stream<String> namesStream = Stream.of("Tarun", "Mausam", "Dhraik");
        Stream<List<String>> namesStreamFromList = Stream.of(names);

        //namesStreamFromList.sorted();

        //lazyNature();
        //streamsCouldBeExecutedOnce();
        //filteringAndSlicing();
        //comparisonOperations();
        //reduceOperations();

        /*modernjava.LambdasUsesWithJava8 staticMyth = new modernjava.LambdasUsesWithJava8();
        staticMyth.flatMapVsMap();*/


    }

    /**
     * LAZY nature of intermediate operations. All intermediate operations could be chained(pipelined) by the terminal
     * operation and can be executed all at once
     */
    private static void lazyNature() {
        List<Integer> lengthOfFilteredNames = names.stream()
                .filter( n ->  {
                    System.out.println(n);
                    return n.startsWith("R");
                })
                .map(String::length)
                .limit(1) // helps achieve short circuiting (the moment first result is matched, the computation stops.
                .collect(Collectors.toList());
    }

    /**
     * distinct(), limit(), skip() intermediate operations
     */
    private static void filteringAndSlicing() {

        names.stream().filter(n->n.startsWith("R")).skip(1).forEach(System.out::println);
        names.stream().filter(n->n.startsWith("R")).distinct().forEach(System.out::println);

        // TODO - Q1) RETURN A LIST OF NAMES WITH UNIQUE FIRST LETTER IN NAME, if there already is a name with say first letter A then no more names starting with A should be allowed


    }

    private void flatMapVsMap() {

        List<String> words = Arrays.asList("Tarun", "Mausam", "Dhraik");

        // TODO - Get all unique characters in the array above, result should be ['T', 'a', 'r', 'u', 'n', 'M', 's', 'D', 'h', 'i', 'k']


        // TODO 1st attempt - the split method returns a String[] and then we apply distinct over String[] and it has no idea about it, hence this ain't working :(
        //words.stream().map(word -> word.split("")).distinct().forEach(System.out::println);


       // words.stream().map(word -> word.split("")).flatMap(Arrays::stream).map(String::toUpperCase).distinct().forEach(System.out::println);


        // TODO - Get all the permutations possible of length 2 i.e. 1,2;1,3;1,4;2,3;2,4;3,4;
        List<Integer> numbers = Arrays.asList(1,2,3,4);

        List<int[]> pAndC = numbers
                .stream()
                .sorted()
                .flatMap(i -> numbers
                        .stream()
                        .filter(j -> !j.equals(i) && j>i)
                        .map(k -> new int[]{i,k}))
                .collect(Collectors.toList());

        pAndC.stream().map(i -> "{" + i[0] + "," + i[1] + "}").forEach(System.out::println);

    }

    /**
     * you reduce the stream into one result after multiple operations. Map - Reduce could be used as well !!!
     */
    private static void reduceOperations() {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        System.out.println(numbers.stream().reduce(0, Integer::sum)); // here reduce operation has a default value of 0 at the beginning, so if numbers is empty result would be 0
        System.out.println(numbers.stream().reduce(1, (a,b) -> a * b));

        // But we can use reduce w/o passing the default value as below cases, but then the result returned is an optional, because it could be possible that the list is empty
        numbers.stream().reduce(Integer::sum).ifPresent(System.out::println); // reduce returns an Optional in this case, hence the ifPresent() method

        // TODO - Of-course OR using lambdas instead of method reference
        numbers.stream().reduce((a,b)-> a+b).ifPresent(System.out::println);

    }

    private static void comparisonOperations() {
        names.sort((a,b) -> a.compareTo(b));
        names.sort(comparing(n -> n.length()));
        names.sort(comparing(String::length).reversed());
        names.parallelStream().forEachOrdered(n -> System.out.println(n));

        apples.sort(comparing(Apple::getColor).thenComparingDouble(Apple::getWeight).reversed());
        apples.stream().forEach(System.out::println);
    }

    // TODO - this will fail, since streams could be consumed only once, you can create a new stream from a given stream and iterate it then, but ONE STREAM.. JUST ONCE
    private static void streamsCouldBeExecutedOnce() {
        Stream<String> namesStream = names.stream();
        namesStream.forEach(System.out::println);
        namesStream.forEach(System.out::println);
    }

    protected static class Apple {
        private String color;
        private Double weight;
        private String type;

        @Override
        public String toString() {
            return String.format("Color = %s, Weight = %s, Type = %s", color, weight, type);
        }

        public Apple(String color, Double weight, String type) {
            this.color = color;
            this.weight = weight;
            this.type = type;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}

