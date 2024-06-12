import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите фамилию, имя, отчество и дату в формате ДД.ММ.ГГГГ");
        Scanner scanner = new Scanner(System.in);
        String surname = scanner.next();
        String name = scanner.next();
        String midname = scanner.next();
        String date = scanner.next();
        System.out.println("Фамилия и инициалы: "+surname+" "+name.charAt(0)+". "+midname.charAt(0)+". ");
        if (midname.endsWith("а"))
            System.out.println("Пол: женский");
        else
            System.out.println("Пол: мужской");

        try {
            SimpleDateFormat df = new java.text.SimpleDateFormat("dd.MM.yyyy");
            df.setLenient(false);
            df.parse(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate startDate = LocalDate.now();
            try {
                LocalDate endDate = LocalDate.parse(date, formatter);
                Period period = Period.between(endDate,startDate);
                if (period.getYears()%10==0 || period.getYears()%10>4 || period.getYears()%100>10 && period.getYears()%100<15)
                    System.out.println("Возраст: "+period.getYears()+" лет");
                else if (period.getYears()%10==1)
                    System.out.println("Возраст: "+period.getYears()+" год");
                else
                    System.out.println("Возраст: "+period.getYears()+" года");
            }catch (DateTimeParseException e) {
                System.out.println("Date in wrong format");
            }
        } catch (java.text.ParseException e) {
            System.out.println("ParseException: Unparseable date");
        }
    }
}