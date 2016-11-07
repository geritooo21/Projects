import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by s168945 on 6-11-2016.
 */
public class InvertedEcho {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> words;
    String last;

    void echo() {
        words = new ArrayList<>();
        last = sc.next();
        while (!last.equals("END")) {
            words.add(last);
            last = sc.next();
        }


        for (int i = words.size() - 1; i >= 0; i--) {
            System.out.print(words.get(i) + " ");
        }
    }

    void echoRecursive() {
        String word = sc.next();
        if (word.equals("END")) {
            System.out.println();
        } else {
            echoRecursive();
            System.out.println(word);
        }

    }

    public static void main(String[] args) {
        new InvertedEcho().echoRecursive();
    }
}
