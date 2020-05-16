package modernjava;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionalInterfaceEx {


    @FunctionalInterface
    private interface Replacer<String> {
        String replace(String s);
    }

    private List<String> replace(List<String> items, Replacer<String> r) {
        List<String> updatedList = new ArrayList<>();
        for(String item : items) {
              updatedList.add(r.replace(item));
        }
        return updatedList;
    }

    @Test
    void shouldReplaceGivenStringFromAllItemsInList() {
        List<String> testList = Arrays.asList("Tarun", "Dhraik", "Mausam", "Dhraik");

        assertEquals(Arrays.asList("TArun", "DhrAik", "MAusAm", "DhrAik"), replace(
                testList, s -> s.replaceAll("a", "A")));


        String str = "Lorem Ipsum is simply dummy text";

        long numberOfWords = Stream.of(str)
                .map(w -> w.split("\\s+"))
                .flatMap(Arrays::stream)
                .filter(w -> w.trim().length() != 0)
                .count();

        System.out.println(numberOfWords);

    }
}
