package modernjava;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class StreamsCollector {

    private static class Dish {
        private String name;
        private boolean isVeg;
        private Double calorie;

        @Override
        public String toString() {
            return "[ Name = " + name + ", isVeg = " + isVeg + ", calorie = " + calorie + " ]";
        }

        public Dish(String name, boolean isVeg, Double calorie) {
            this.name = name;
            this.isVeg = isVeg;
            this.calorie = calorie;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isVeg() {
            return isVeg;
        }

        public void setVeg(boolean veg) {
            isVeg = veg;
        }

        public Double getCalorie() {
            return calorie;
        }

        public void setCalorie(Double calorie) {
            this.calorie = calorie;
        }
    }

    public static void main(String args[]) {
        // grouping by n - level grouping
        List<Dish> dishes = Arrays.asList(new Dish("beef", false, 1000.00),
                                            new Dish("pork", false, 1000.00),
                                            new Dish("chicken", false, 5000.00),
                                            new Dish("capsicum", true, 2000.00),
                                            new Dish("ginger", true, 2000.00),
                                            new Dish("broccoli", true, 120.00));

        Map<Character, List<Dish>> dishesGroupedByFirstLetter = dishes.stream().sorted(comparing(Dish::getName)).collect(groupingBy(d -> d.getName().charAt(0)));
        //dishesGroupedByFirstLetter.forEach( (k,v) -> System.out.println("" + k + " -> " + v.stream().map(Dish::toString).collect(joining(","))));


        // 2 - level grouping by
        Map<Boolean, Map<Double, List<Dish>>> groupByIsVegAndThenByCalorie = dishes.stream()
                .collect(groupingBy(Dish::isVeg, groupingBy((Dish::getCalorie))));
        groupByIsVegAndThenByCalorie.forEach( (k,v) -> { System.out.println("" + k + " -> " + v.toString()); });

        // partitioning by
        groupByIsVegAndThenByCalorie = dishes.stream()
                .collect(partitioningBy(Dish::isVeg, groupingBy((Dish::getCalorie))));
        groupByIsVegAndThenByCalorie.forEach( (k,v) -> { System.out.println("" + k + " -> " + v.toString()); });


        // TODO - isPrime implementation using streams
        //System.out.println(isPrime(37156667));

    }


    private static boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);
        return IntStream.rangeClosed(2, sqrt)
                .noneMatch(i -> number % i == 0);
    }
}
