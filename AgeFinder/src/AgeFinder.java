import java.util.Scanner;

/**
 * Created by s168945 on 31-10-2016.
 */
public class AgeFinder {
    int dateOfBirth;
    int currentDate;
    int years;
    Scanner sc = new Scanner(System.in);

    void calculate() {
        System.out.println("Type your date of birth (yyyymmdd)");
        dateOfBirth = sc.nextInt();
        System.out.println("Type the current date (yyyymmdd)");
        currentDate = sc.nextInt();

        years = (currentDate / 10000 - dateOfBirth / 10000);
        if ((currentDate % 10000 - dateOfBirth % 10000) < 0) {
            years--;
        }

        System.out.println("You are " + years + " years old.");
    }

    public static void main(String args[]) {
        new AgeFinder().calculate();
    }
}
