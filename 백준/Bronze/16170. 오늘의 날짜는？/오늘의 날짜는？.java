import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();;
        String format = now.format(DateTimeFormatter.ofPattern("yyyy\nMM\ndd"));
        System.out.print(format);
    }
}