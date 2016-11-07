/**
 * Created by s168945 on 20-10-2016.
 */
public class BidirectionalBubbleSort extends SortAlgorithm {
    @Override
    void sort(int[] a) {
        int end = a.length - 1;
        for (int i = 0; i <= end; i++) {
            for (int j = 1; j < end; j++) {
                if (a[j] > a[j + 1]) {
                    int h = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = h;
                }
                pause(i, end);
            }

            end--;

            for (int j = end; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int h = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = h;
                }
                pause(i, end);
            }
        }
    }
}
