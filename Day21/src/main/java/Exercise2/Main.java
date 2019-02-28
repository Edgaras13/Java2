package Exercise2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter start date:");
        LocalDate start = LocalDate.parse(scn.nextLine());
        System.out.println("Enter end date:");
        LocalDate end = LocalDate.parse(scn.nextLine());

        for (LocalDate date = start; date.isBefore(end);date = date.plusDays(1)){
            if (date.getDayOfMonth() * date.getMonthValue() == Integer.parseInt(date.format(DateTimeFormatter.ofPattern("yy")))){
                System.out.println(date);
            }
        }
    }
}