import java.util.Scanner;

/**
 * Created by s168945 on 4-11-2016.
 */
public class Interest {
    double balance;
    double rate;
    double taxRate;
    Scanner sc = new Scanner(System.in);

    public void calcInterest() {
        System.out.println("Type your saldo");
        balance = sc.nextDouble();
        System.out.println("Type interest rate as percentage");
        rate = sc.nextDouble();

        System.out.println("After an year you get an interest of " + balance * rate / 100);
        System.out.println("Balance after one year is " + (balance+(balance * rate / 100)));

    }

    public void calcTax() {
        System.out.println("Type in tax rate as percentage");
        taxRate = sc.nextDouble();
        System.out.println("The tax you have to pay this year is " + balance * taxRate / 100);
    }

    public void banking() {
        calcInterest();
        calcTax();
    }

    public static void main(String[] args) {
        new Interest().banking();
    }
}
