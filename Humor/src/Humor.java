import java.util.ArrayList;

/**
 * Created by s168945 on 23-10-2016.
 */
public class Humor {
    ArrayList<Joke> issue = new ArrayList<Joke>();

    void add(Joke j) {
        issue.add(j);
    }

    void overview() {
        int totalSpace = 0;
        double totalFunniness = 0;
        for (Joke joke : issue) {
            totalSpace = totalSpace + joke.getSpace();
            totalFunniness = totalFunniness + joke.calculateFunniness();
        }
        System.out.println("The total space needed is " + totalSpace);
        System.out.println("The average funniness of the jokes is " + totalFunniness/issue.size());
    }

    void run() {
        Joke j;
        j = new Joke("Palindrome",
                "A nerdy guy holds a black sign with the text ’Madam, I’m Adam", 30, 25.0);
        add(j);

        Joke k = new InsultingJoke("Pastoorke", "Guus and Theo meet in Stratums Eind...", 120, 10.00, "Brabanders");
        add(k);

        Joke l = new Joke();
        add(l);

        Joke m = new InsultingJoke("Blonds");
        add(m);

        overview();
        j.print();
        k.print();
        l.print();
        m.print();
    }

    public static void main (String args[]) {
        new Humor().run();
    }

}
