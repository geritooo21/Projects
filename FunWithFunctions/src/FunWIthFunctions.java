import java.util.Scanner;

/**
 * Created by s168945 on 6-11-2016.
 */
public class FunWIthFunctions {
    double a;
    double b;
    double c;

    Scanner sc = new Scanner(System.in);

    double f(double x) {
        return a * x * x + b * x + c;
    }

    void table() {
        double start = -3.0;

        System.out.println("x      f(x)");
        System.out.println("-----------");

        while (start <= 3.0) {
            System.out.println(start + "   " + f(start));
            start = start + 0.5;
        }
    }

    void game() {
        double guess;
        int counter = 0;

        System.out.println("Give values for a, b, c");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();

        System.out.println("Give a value for x to make the function f(x) = (" + a + ")(x^2) + " +
                "(" + b + ")x + (" + c + ") equal to zero.");
        guess = sc.nextDouble();

        while (f(guess) < -0.001 || f(guess) > 0.001) {
            counter++;
            System.out.println("f(" + guess + ") = " + f(guess));
            System.out.println("Try again!");
            guess = sc.nextDouble();
        }

        counter++;
        System.out.println("You figured it out! Number of guesses is " + counter);


    }

    public static void main(String[] args) {
        new FunWIthFunctions().game();
    }
}
