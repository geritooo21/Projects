import java.util.Scanner;

/**
 * Created by s168945 on 4-11-2016.
 */
public class ToTheMax {
    int a;
    int b;
    int c;
    int max;
    Scanner sc = new Scanner(System.in);

    public void maximum() {
        System.out.println("Type 3 numbers");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

        max = a;

        if (max < b) {
            max = b;
        }

        if (max < c) {
            max = c;
        }

        System.out.println("maximum is " + max);
    }

    public static void main(String[] args) {
        new ToTheMax().maximum();
    }
}
