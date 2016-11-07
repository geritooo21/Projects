import java.util.Scanner;

/**
 * Created by s168945 on 4-11-2016.
 */
public class LeapYear {
    Scanner sc = new Scanner(System.in);

    public void isLeapYear() {
        int year;
        //boolean isLeapYear;

        System.out.println("Type an year");
        year = sc.nextInt();
        //isLeapYear = year % 100 != 0 && year % 4 == 0;
        //System.out.println(isLeapYear);
        System.out.println(year % 100 != 0 && year % 4 == 0);
    }

    public static void main(String[] args) {
        new LeapYear().isLeapYear();
    }
}
