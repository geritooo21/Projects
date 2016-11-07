/**
 * Created by s168945 on 23-10-2016.
 */
public class Joke {
    String name;
    String description;
    int space;
    double funFactor;


    Joke(String n, String d, int s, double fF) {
        name = n;
        description = d;
        space = s;
        funFactor = fF;
    }

    Joke() {
        name = "Mathematics for blonds";
        description = "Why does a blond stand in the corner of the room when it is cold?" +
                " Because there it is 90 degrees.";
        space = 100;
        funFactor = 10.7;
    }

    int getSpace() {
        return space;
    }

    double calculateFunniness () {
        return this.funFactor/this.space;
    }

    void print() {
        System.out.println(name);
        System.out.println(description);
        System.out.println(space);
        System.out.println(funFactor);
    }

}
