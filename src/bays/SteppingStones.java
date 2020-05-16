package bays;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SteppingStones {


    private static final Pattern pattern = Pattern.compile("\\[(.*)] npc_dota_hero_(.*) buys item item_(.*)");

    private static final Pattern HERO_ITEM_PURCHASED_REGIX = Pattern.compile("\\[(?<timestamp>.*)] npc_dota_hero_(?<hero>.*) buys item item_(?<item>.*)");

    private static final Pattern HERO_SPELLS_REGIX =
            Pattern.compile("\\[(.*)] npc_dota_hero_(?<hero>.*) casts ability (?<spell>.*) \\(lvl (?<level>.*)\\) on (?<target>.*)");

    private static final Pattern DAMAGE_DONE_REGIX =
            Pattern.compile("\\[(?<timestamp>.*)] npc_dota_hero_(?<hero>.*) hits npc_dota_hero_(?<heroDamaged>.*) with (?<ignored1>.*) for (?<damageCount>\\d+) damage (?<ignored2>.*)");




    public static void main(String[] args) {
        String timestamp = "00:37:06.395";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        LocalTime time = LocalTime.parse(timestamp, formatter);
        int hour = time.getHour();
        int minute = time.getMinute();
        int secs = time.getSecond();
        double nano = (time.getNano())/(Math.pow(10,6));
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(secs);
        System.out.println(nano);
    }
}
