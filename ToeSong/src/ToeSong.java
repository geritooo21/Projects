/**
 * Created by s168945 on 5-11-2016.
 */
public class ToeSong {
    void sing(String bodyPart) {
        if (!bodyPart.equals("toe")) {
            System.out.println(bodyPart + " bone,");
        }

        if (!bodyPart.equals("hip")){
            System.out.print( "The " + bodyPart + " bone’s connected to the ");
        } else {
            System.out.print("Now shake dem skeleton bones!");
        }

        switch (bodyPart) {
            case "toe":
                sing("foot");
                break;
            case "foot":
                sing("ankle");
                break;
            case "ankle":
                sing("leg");
                break;
            case "leg":
                sing("knee");
                break;
            case "knee":
                sing("thigh");
                break;
            case "thigh":
                sing("hip");
                break;
        }
    }

    public static void main(String[] args) {
        new ToeSong().sing("toe");
    }
}
