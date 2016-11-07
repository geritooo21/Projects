/**
 * Created by s168945 on 18-10-2016.
 */
public class CircularPrimers {

    int counter;

    boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        if (n != 1) return true;
        else return false;
    }

    int largestPowerOfTen(int n) {
        int power = 0;
        int i = 10;
        while (n / i != 0) {
            i = i * 10;
            power++;
        }
        if (power == 0) {
            return 1;
        } else {
            return (int) Math.pow(10, power);
        }
    }



    boolean CircularPrime(int n) {
        int power = largestPowerOfTen(n);
        int number = n;

        do {
            if (isPrime(number)) {
                number = number / power + (number % power)*10;
            } else {
                return false;
            }
        }
        while (number != n);
        return true;
    }

    void run() {
        for (int i = 1; i <= 1000; i++) {
            if (CircularPrime(i)) {
                System.out.println(i);
                counter++;
            }
        }
        System.out.println(counter);
    }

    public static void main(String[] args) {
        new CircularPrimers().run();
    }
}
