import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by s168945 on 5-11-2016.
 */
public class EchoPit {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> words;
    String n;

    void echo() {
        words = new ArrayList<>();
        n = sc.next();

        while (!n.equals("END")) {
            words.add(n);
            n = sc.next();
        }

        for (int i = words.size() - 1; 0 <= i; i--) {
            System.out.println(words.get(i));
        }
    }

    public static void main(String[] args) {
        new EchoPit().echo();
    }
}
