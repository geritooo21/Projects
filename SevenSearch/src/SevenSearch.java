/**
 * Created by s168945 on 31-10-2016.
 */
public class SevenSearch {

    boolean has7(int[] a) {
        return has7(a, 0, a.length);
    }

    boolean has7(int[] a, int lo, int hi) {
        if (hi - lo < 1) {
            return false;
        } else if (hi - lo == 1) {
            return a[lo] == 7;
        } else {
            int m = (hi + lo) / 2;
            if (7 < a[m]) {
                return has7(a,lo, m);
            } else {
                if (a[m] < 7) {
                    return has7(a,m, hi);
                } else { // a[m]==7;
                    return true;
                }
            }
        }
    }

    void test() {
        int[] arr = {1, 2, 4, 7, 8, 8, 9};
        System.out.println(has7(arr));
        System.out.println(has7(arr, 0, 7));
        System.out.println(has7(arr, 0, 3));
        System.out.println(has7(arr, 4, 5));
    }

    public static void main(String args[]) {
        new SevenSearch().test();
    }
}