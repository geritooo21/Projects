import javax.swing.*;

/**
 * Created by s168945 on 18-10-2016.
 */
public class ParamTester {
    MyButton button = new MyButton();

    void run() {
        button.printParamString();
    }
    public static void main(String[] args) {
        new ParamTester().run();
    }
}

class MyButton extends JButton {
    void printParamString() {
        String text = new MyButton().paramString();
        System.out.println(text);
    }
}
