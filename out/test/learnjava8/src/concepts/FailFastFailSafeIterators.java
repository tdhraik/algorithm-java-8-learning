package concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafeIterators {

    public static void main(String[] args) {
        List<String> namesFailSafe = new CopyOnWriteArrayList<>();
        namesFailSafe.add("Tarun");
        namesFailSafe.add("Mausam");
        namesFailSafe.add("Ram");
        namesFailSafe.add("Bimla");
        namesFailSafe.add("Dhraik");

        List<String> namesFailFast = new ArrayList<>();
        namesFailFast.add("Tarun");
        namesFailFast.add("Mausam");
        namesFailFast.add("Ram");
        namesFailFast.add("Bimla");
        namesFailFast.add("Dhraik");


        // fail safe
        for(String name:namesFailSafe) {
            if(name.startsWith("T")){
                namesFailSafe.remove(name);
            }
        }
        System.out.println(namesFailSafe);

        // fail fast
        for(String name:namesFailFast) {
            if(name.startsWith("T")){
                namesFailFast.remove(name); // will throw concurrent modification exception
            }
        }

        System.out.println(namesFailFast);
    }
}
