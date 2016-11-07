/**
 * Created by s168945 on 24-10-2016.
 */
public class InsultingJoke extends Joke {
    String socialGroup;

    InsultingJoke(String n, String d, int s, double fF, String sG) {
        super(n, d, s, fF);
        socialGroup = sG;
    }

    InsultingJoke(String sG) {
        this.socialGroup = sG;
    }

    @Override
    double calculateFunniness() {
        if(socialGroup == "Limburgians") {
            return funFactor*2/space;
        } else {
            return funFactor*1.5/space;
        }
    }

    @Override
    void print() {
        super.print();
        System.out.println(socialGroup);
    }
}
