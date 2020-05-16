package coding_challenges;

import java.util.*;

public class SortMapByKeysOrValue {

    public static void main(String[] args) {
        Map<String, String> mapToSort = new HashMap<>();
        mapToSort.put("a", "8");
        mapToSort.put("c", "3");
        mapToSort.put("b", "2");
        System.out.println(sortByKeys(mapToSort));
        System.out.println(sortByValues(mapToSort));
    }


    private static <K extends Comparable, V extends Comparable>
            Map<K,V> sortByKeys(Map<K,V> mapToSort) {
        List<K> keys = new LinkedList<>(mapToSort.keySet());
        keys.sort(Comparator.naturalOrder());

        Map<K,V> sortedMap = new LinkedHashMap<>();
        for(K key : keys) {
            sortedMap.put(key, mapToSort.get(key));
        }
        return sortedMap;
    }

    private static <k extends Comparable, v extends Comparable>
            Map<k,v> sortByValues(Map<k,v> mapToSort) {
        List<Map.Entry<k,v>> mapToList = new LinkedList<>(mapToSort.entrySet());
        mapToList.sort(Comparator.comparing(Map.Entry::getValue));

        Map<k,v> sortedMap = new LinkedHashMap<>();
        for(Map.Entry key : mapToList) {
            sortedMap.put((k) key.getKey(), (v) key.getValue());
        }
        return sortedMap;
    }
}
