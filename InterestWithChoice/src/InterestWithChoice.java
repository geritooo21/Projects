import java.util.Scanner;

/**
 * Created by s168945 on 4-11-2016.
 */
public class InterestWithChoice {
    double balance;
    double interest = 2.5;
    double bonus = 0.5;
    double penalty = 0.5;
    Scanner sc = new Scanner(System.in);

    public void calculate() {
        System.out.println("Type balance");
        balance = sc.nextDouble();

        if(balance<0) {
            balance = balance - balance*penalty/100;
        } else {
            if(balance>=10000) {
                balance = balance + balance*(interest+bonus)/100;
            } else {
                balance = balance + balance*interest/100;
            }
        }

        System.out.println("New balance is " + balance);
    }

    public static void main(String[] args) {
        new InterestWithChoice().calculate();
    }
}
