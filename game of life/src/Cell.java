/**
 * Created by s168945 on 15-10-2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JLabel implements MouseListener {

    boolean alive;
    int numNeighbors;

    public Cell() {
        setAlive(false);
        //boolean alive;
        //int numNeighbors;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setOpaque(true);
    }

    void setAlive(boolean state) {
        alive = state;
        setColor();
    }

    void setColor() {
        if (alive) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.WHITE);
        }
        repaint();
    }

    boolean isAlive() {
        return alive;
    }

    void setNumNeighbors(int n) {
        numNeighbors = n;
    }

    void update() {
        if(isAlive()) {
            if (numNeighbors == 2 || numNeighbors == 3) {
                setAlive(true);
            } else {
                setAlive(false);
            }
        } else {
            if (numNeighbors == 3) {
                setAlive(true);
            } else {
                setAlive(false);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
