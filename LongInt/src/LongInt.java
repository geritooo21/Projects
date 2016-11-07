/**
 * Created by s168945 on 5-11-2016.
 */
public class LongInt {
    public static void main(String[] args) {
        int maximum = Integer.MAX_VALUE;
        int minimum = Integer.MIN_VALUE;
        System.out.println(maximum);
        System.out.println(minimum);

        int positiveNumber = 0;
        int negativeNumber = 0;

        while (positiveNumber+1>=0) {
            positiveNumber++;
        }

        while (negativeNumber-1<=0) {
            negativeNumber--;
        }

        long n = 1234567890;

        System.out.println(positiveNumber);
        System.out.println(negativeNumber);
        System.out.println(n+n);
    }
}
