/**
 * Created by s168945 on 20-10-2016.
 */
public class BubbleSortUp extends SortAlgorithm {
    void sort(int a[]) {
        boolean isSwapped = true;
        for (int i = 0; i <= a.length - 1; i++) {
            if (!isSwapped) {
                break;
            }
            isSwapped = false;
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int h = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = h;
                    isSwapped = true;
                }
                pause(i, j);
            }
        }
    }
}
