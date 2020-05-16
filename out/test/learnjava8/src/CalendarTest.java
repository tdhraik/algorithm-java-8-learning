import java.text.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.*;
import java.util.stream.*;
import java.io.*;

public class CalendarTest {


    public static void main(String args[]) throws Exception {
        Date aDate = null;
        List<String> str = Arrays.asList("a", "b");
        String[] arg = (String[]) str.toArray();

        System.out.println(Stream.of("g", "y", "b").max((s1,s2) -> s1.compareTo(s2))
                .filter(s->s.endsWith("n"))
                .orElse("y"));

        File file = new File("data.txt");
        FileWriter output = new FileWriter(file);
        //Stream.of('0','1').forEach(output::write);
        output.flush();

        int x = -1;
        x = x >>> 0;
        System.out.println(x);

        try {
            aDate = new SimpleDateFormat("yyyy-mm-dd").parse("2012-01015");
            Calendar aCal = Calendar.getInstance();
            aCal.setTime(aDate);
            System.out.println(aCal.get(aCal.DAY_OF_MONTH) + "," + aCal.get(aCal.MONTH));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate bDate = LocalDate.parse("2012-01-15", formatter);
            System.out.println("");

        } catch (ParseException ex) {
            System.out.println("asf");
        }
    catch(DateTimeParseException ex){System.out.println("ewrwer");}
    }
}
