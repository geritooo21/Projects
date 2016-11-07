import java.util.Scanner;

/**
 * Created by s168945 on 4-11-2016.
 */
public class Repetition {
    Scanner sc = new Scanner(System.in);

    public void calculate() {
        int product = 1;
        int number;

        System.out.println("Type your numbers terminated by 0");

        number = sc.nextInt();
        while(number!=0) {
            product = product * number;
            number = sc.nextInt();
        }

        System.out.println("Product is " + product );
    }

    public static void main(String args[]) {
        new Repetition().calculate();
    }
}
