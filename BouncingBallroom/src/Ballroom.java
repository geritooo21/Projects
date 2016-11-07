// Ballroom - student version for exam Nov 2014 

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ballroom extends JPanel implements ActionListener {
    JFrame frame;
    Timer timer;
    Timer timerBlink;
    Ball ball;
    Ball ball2;
    RedBall redBall;
    BlinkingBall blinkBall;

    void buildIt() {
        frame = new JFrame("Ballroom");
        frame.add(this);

        timer = new Timer(100, this);
        timerBlink = new Timer(100, this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocation(200, 200);
        frame.setVisible(true);

        ball = new Ball(getWidth() / 2, 20);
        ball2 = new Ball(getWidth() / 2 + 80, 20);
        redBall = new RedBall(getWidth() / 2 - 80, 20);
        blinkBall = new BlinkingBall(getWidth() / 2 - 40, 20);
        timer.start();
        timerBlink.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        ball2.draw(g);
        redBall.draw(g);
        blinkBall.draw(g);
    }

    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == timer)&& maximum =  {
            ball.step();
            ball2.step();
            redBall.step();
            blinkBall.step();
            repaint();
        }
        if (e.getSource() == timerBlink) {
            blinkBall.changeColor();
            repaint();
        }
    }


    public static void main(String[] args) {
        new Ballroom().buildIt();
    }
}

class Ball {
    int x, y;     // position of center in pixels
    int size;     // diameter in pixels
    int step = 5; // displacement at time step (~speed)
    int maximum;

    public Ball() {
        size = 30;
    }

    public Ball(int startx, int starty) {
        x = startx;
        y = starty;
        size = 30;
    }

    public void step() {
        y += step;
        maximum = y;
    }

    void draw(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }
}

class RedBall extends Ball {
    public RedBall(int startx, int starty) {
        super(startx, starty);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }
}

class BlinkingBall extends Ball {
    Color color = Color.RED;

    public BlinkingBall(int startx, int starty) {
        super(startx, starty);
    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }

    void changeColor() {
        if (color.equals(Color.RED)) {
            color = Color.BLUE;
        } else {
            color = Color.RED;
        }

    }
}
