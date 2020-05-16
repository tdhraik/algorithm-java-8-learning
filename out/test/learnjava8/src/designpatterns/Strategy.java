package designpatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You create one or more strategies of implementing a strategy ;) multiple implementations of an interface and at runtime
 * we decide which implementation to invoke
 */
public class Strategy {

    public static class Apple {
        private String name;

        public Apple(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @FunctionalInterface
    private interface ValidatingString<T extends Apple> {
        boolean validate(T s);
    }

    public static void main(String args[]) {
        Apple apple = new Apple("ROYAL");
        System.out.println(validateString(apple, ((Apple a) -> a.getName().equals("ROYAL"))));


        // TODO - list returned with Arrays.asList is of fixed size, hence adding/removing elements is not supported
        List<String> names = Arrays.asList("Tarun", "Mausam", "Dhraik", "Ram", "Dhraik");
        // names.removeIf(n->n.equals("Dhraik")); // this will not work

        // TODO - with such creation it is now possible to use removeIf, since the list generated is not of fixed size
        List<String> names1 = new ArrayList<>();
        names1.add("Tarun");
        names1.add("Mausam");
        names1.add("Tarun");
        names1.removeIf(n -> n.equals("Tarun"));
        names1.forEach(System.out::println);

    }

    private static boolean validateString(Apple s, ValidatingString predicate) {
        return predicate.validate(s);
    }

    // peek method for debugging lambdas

}
