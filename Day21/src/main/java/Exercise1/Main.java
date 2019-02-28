package Exercise1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate birth = LocalDate.of(1997,04,18);
        System.out.println("Age:");
        System.out.println("In years: " + ChronoUnit.YEARS.between(birth,LocalDate.now()));
        System.out.println("In months: " + ChronoUnit.MONTHS.between(birth,LocalDate.now()));
        System.out.println("In days: " + ChronoUnit.DAYS.between(birth,LocalDate.now()) + "\n");

        int monCount = 0, tueCount = 0, wedCount = 0, thuCount = 0, friCount = 0, satCount = 0, sunCount = 0;

        for (int i = 0; i <= 21; i++){
            if (i < 21) {
                System.out.println("Birthday nr. " + (21 - i) + ": " + birth.minusYears(i).getDayOfWeek());
            }
            else{
                System.out.println("Born on a " + birth.minusYears(i).getDayOfWeek() + "\n");
            }
            switch (birth.minusYears(i).getDayOfWeek()){
                case MONDAY: monCount++; break;
                case TUESDAY: tueCount++; break;
                case WEDNESDAY: wedCount++; break;
                case THURSDAY: thuCount++; break;
                case FRIDAY: friCount++; break;
                case SATURDAY: satCount++; break;
                case SUNDAY: sunCount++; break;
            }
        }
        System.out.println("Birthdays on Monday: " + monCount);
        System.out.println("Birthdays on Tuesday: " + tueCount);
        System.out.println("Birthdays on Wednesday: " + wedCount);
        System.out.println("Birthdays on Thursday: " + thuCount);
        System.out.println("Birthdays on Friday: " + friCount);
        System.out.println("Birthdays on Saturday: " + satCount);
        System.out.println("Birthdays on Sunday: " + sunCount);
    }
}
