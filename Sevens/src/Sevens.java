/**
 * Created by s168945 on 3-11-2016.
 */
public class Sevens {

    int lastDigit(int n) {
        int lastDigit = n % 10;
        return lastDigit;
    }

    int chop(int n) {
        int chopped = n / 10;
        return chopped;
    }

//    int sevencount(int n) {
//        if (n == 0) {
//            return counter;
//        } else {
//            if (n % 10 == 7) {
//                counter++;
//            }
//            sevencount(n / 10);
//        }
//        return counter; //?
//    }

    int sevencount(int n){
        int counter = 0;

        if (n == 0) {
            return counter;
        } else {
            if (n % 10 == 7) {
                counter++;
            }
            return counter + sevencount(n / 10);
        }
    }

    int drop7(int n) {
        if (n == 0) {
            return 0;
        } else {
            if (lastDigit(n) == 7) {
                return drop7(chop(n));
            } else {
                return 10 * drop7(chop(n)) + lastDigit(n);
            }
        }
    }

    public void demo() {
        System.out.println(chop(4));
        System.out.println(lastDigit(774));
        System.out.println(sevencount(77174));
        System.out.println(drop7(178));
    }

    public static void main(String[] args) {
        new Sevens().demo();
    }
}
