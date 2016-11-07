import java.util.Scanner;

/**
 * Created by s168945 on 5-11-2016.
 */
public class Product {
    Scanner sc = new Scanner(System.in);
    int number; //number just read
    int product = 1;

    void doMultiplication() {
        int counter = 0;

        while (sc.hasNextInt()) {
            number = sc.nextInt();
            counter++;
            product = product * number;
        }

        System.out.println("Product is " + product);
        System.out.println("Number of numbers is "+ counter);
    }

    public static void main(String[] args) {
        new Product().doMultiplication();
    }
}
