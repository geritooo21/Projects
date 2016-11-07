/**
 * Created by s168945 on 19-10-2016.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FadingCell extends Cell implements ActionListener {
    Timer timer;
    int age = 100;
    Color color;

    public FadingCell(int n, boolean a) {
        super(n, a);
        timer = new Timer(750, this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            if (age == 0) {
                update();
            } else {
                setAlive(alive);
            }
        }
    }


    @Override
    public void update() {
        this.setBackground(Color.black);
    }

    @Override
    public void setAlive(boolean n) {
        age = age - 10;
        color = new Color(age, age, age);
        this.setBackground(color);
    }
}
