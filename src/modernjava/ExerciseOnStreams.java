package modernjava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ExerciseOnStreams {

    public static class Trader{

        private final String name; private final String city;

        public Trader(String n, String c){ this.name = n; this.city = c; }

        public String getName(){ return this.name; }

        public String getCity(){ return this.city; }

        public String toString(){ return "Trader:"+this.name + " in " + this.city; }

    }

    public static class Transaction{

        private final Trader trader;
        private final int year;
        private final int value;

        public Transaction(Trader trader, int year, int value){ this.trader = trader; this.year = year; this.value = value; }

        public Trader getTrader(){ return this.trader; }

        public int getYear(){ return this.year; }

        public int getValue(){ return this.value; }

        public String toString(){ return "{" + this.trader + ", " + "year: "+this.year+", " + "value:" + this.value +"}"; }

    }

    final static Trader raoul = new Trader("Raoul", "Hong Kong");
    final static Trader mario = new Trader("Mario","AC Milan");
    final static Trader alan = new Trader("Alan","New York City");
    final static Trader brian = new Trader("Brian","Himachal Pradesh");

    final static List<Transaction> transactions = Arrays.asList( new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        //problemOne();
        problemTwo();
        //problemThree();
    }

    // TODO -- Find all transactions in the year 2011 and sort them by value (small to high).
    private static void problemOne() {
        transactions.stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        transactions.stream().map(Transaction::getValue).reduce(Integer::max).ifPresent(System.out::println);
    }

    //TODO -- What are all the unique cities where the traders work?
    private static void problemTwo() {
        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
        traders.stream()
                .map(trader -> trader.getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println(traders.stream()
                .flatMap(trader -> Arrays.stream(trader.getCity().split("\\s+")))
                .collect(Collectors.toList()));


    }

    // TODO -- Find all traders from Cambridge and sort them by name.
    private static void problemThree() {
        List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
        traders.stream().filter(t->t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);
    }

}
