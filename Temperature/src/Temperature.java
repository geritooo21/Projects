import java.util.Scanner;

/**
 * Created by s168945 on 5-11-2016.
 */
public class Temperature {
    double temp;
    double newTemp;
    String choice;
    Scanner sc = new Scanner(System.in);

    public void convert() {
        System.out.println("Give tempretaure in Fahrenheit or Celsius or type a");

        while (sc.hasNextDouble()) {
            temp = sc.nextDouble();
            choice = sc.next();

            if (choice.equals("F")) {
                newTemp = (temp - 32) / 1.8;
                System.out.println(temp + " degrees Fahrenheit = " + newTemp + " degrees Celsius");
                System.out.println("Give temperature in Fahrenheit or Celsius or type a");
            }

            if (choice.equals("C")) {
                newTemp = (temp * 1.8) + 32;
                System.out.println(temp + " degrees Celsius = " + newTemp + " degrees Fahrenheit");
                System.out.println("Give temperature in Fahrenheit or Celsius or type a");
            }
        }
    }

    public static void main(String[] args) {
        new Temperature().convert();
    }
}
