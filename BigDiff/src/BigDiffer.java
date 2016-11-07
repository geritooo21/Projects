import java.util.Scanner;

class BigDiffer {
    Scanner sc = new Scanner(System.in);
    int[] nums;
    int bigDiff;

    void readArray() {
        int n;
        System.out.println("How many values?");
        n = sc.nextInt();
        nums = new int[n];

        System.out.println("Enter values");
        /** @inv i numbers from input read and stored in nums[0..i-1] is  */
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
    }

    void calculateBigDiff() {
        int max = nums[0]; //guaranteed to exist
        int min = nums[0];
        /** @inv max = max(nums[0..i-1]) &&
         *      min = min(nums[0..i-1]) */
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        bigDiff = max - min;
    }

    void printResult() {
        System.out.println("The biggest difference in these values is: ");
        System.out.println(bigDiff);
    }

    void run() {
        readArray();
        calculateBigDiff();
        printResult();
    }

    public static void main(String[] a) {
        (new BigDiffer()).run();
    }
}
        
        
    