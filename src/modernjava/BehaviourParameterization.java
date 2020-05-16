package modernjava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Behavior parameterization is a software development pattern that lets you handle frequent requirement changes.
 * In a nutshell, it means taking a block of code and making it available without executing it.
 * This block of code can be called later by other parts of your programs,
 * which means that you can defer the execution of that block of code.
 * For instance, you could pass the block of code as an argument to another method that will execute it later.
 * As a result, the method’s behavior is parameterized based on that block of code.
 *
 * TODO COPING WITH CHANGING REQUIREMENTS IS THE GOAL OF THIS CLASS AND PATTERN
 *
 */
public class BehaviourParameterization {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red", 10.00, "himachal", "royal"));
        apples.add(new Apple("green", 10.00, "uttrakhand", "golden"));
        apples.add(new Apple("pink", 12.00, "himachal", "richard"));
        System.out.println(filterStuff(apples, apple -> apple.getColor().equals("red")).toString());
        System.out.println(filterStuff(apples, apple -> apple.getWeight() == 10.00).toString());
    }

    // So a farmer wants to filter his list of inventories on the basis of color (green)
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        return inventory.stream().filter(i -> i.getColor().equals("green")).collect(Collectors.toList());
    }

    /* now he wants to filter it on the basis of color but now red.. so a smart solution in current situation could be
     * to add a parameter to above method which sends the color :)
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        return inventory.stream().filter(i -> i.getColor().equals(color)).collect(Collectors.toList());
    }

    /**
     * Great ! but unfortunately the farmer now wants to filter it on the basis of color and weight as well,
     * so return all apples with weight greater than weight passed in the parameter
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, Double weight) {
        return inventory.stream().filter(i -> i.getWeight().compareTo(weight) > 0).collect(Collectors.toList());
    }

    /**
     * As this solution looks okay.. but still there is a lot of duplicate code (DRY violated!!!)  also what if
     * other means of filters are requested for we will not be adding more methods similar to this and repeating the
     * code. Duplicated code here is iterating the stream in the similar fashion and collecting the list.
     */

    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    public class GreenApplePredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getColor().equals("green");
        }
    }

    public class HeavyWeightPredicate implements ApplePredicate {
        public boolean test(Apple apple) {
            return apple.getWeight().compareTo(100.00) > 0;
        }
    }

    /**
     * the behavior of the filterApples method depends on the code you pass to it via the ApplePredicate object.
     * In other words, you’ve parameterized the behavior of the filterApples method!
     * @param inventories
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> inventories, ApplePredicate predicate) {
        List<Apple> filteredApples = new ArrayList<>();
        for(Apple apple : inventories) {
            if(predicate.test(apple)) {
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }

    // TODO - NOW ITS ABOUT TACKLING VERBOSITY... LAMBDAS comes into picture


    public interface Predicate<T> {
        boolean test(T t);
    }

    public static <T> List<T> filterStuff(List<T> inventories, Predicate<T> predicate) {
        List<T> filteredInventory = new ArrayList<>();
        for(T inventory : inventories) {
            if(predicate.test(inventory)) {
                filteredInventory.add(inventory);
            }
        }
        return filteredInventory;
    }

    /** now any type of lists could be passed over to this filterStuff method... and the predicate should suffice the
        functional interface signature i.e. (T t) -> return some boolean and you can send this as second parameter while
        calling the filterStuff method
     **/




    public static class Apple {
        private String color;
        private Double weight;
        private String origin;
        private String type;

        public Apple(String color, Double weight, String origin, String type) {
            this.color = color;
            this.weight = weight;
            this.origin = origin;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    ", origin='" + origin + '\'' +
                    ", type='" + type + '\'' +
                    '}';
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

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
