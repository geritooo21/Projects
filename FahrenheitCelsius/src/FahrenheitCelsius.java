import java.util.Scanner;

/**
 * Created by s168945 on 4-11-2016.
 */
public class FahrenheitCelsius {
    double fahrenheit;
    double celsius;
    Scanner sc = new Scanner(System.in);

    public void convert() {
        System.out.println("Type in temperature in Fahrenheit");
        fahrenheit = sc.nextDouble();
        celsius = (fahrenheit - 32)/1.8;
        System.out.println(fahrenheit + "degrees Fahrenheit = " + celsius + " degrees in Celsius");
    }

    public static void main(String args[]){
        new FahrenheitCelsius().convert();
    }
}
