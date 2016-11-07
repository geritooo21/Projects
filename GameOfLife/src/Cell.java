import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cell extends JLabel implements MouseListener {
    boolean drag;
    boolean alive = false;
    int numNeighbors;
    int amountNeighbors;
    boolean ispressed;

    public Cell(int n, boolean a) {
        alive = a;
        amountNeighbors = n;
        this.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        this.setOpaque(true);
        this.addMouseListener(this);
        if (alive == false) {
            this.setBackground(Color.black);
        } else {
            this.setBackground(Color.white);
        }
    }

    public void mousePressed(MouseEvent e) {
        ispressed = true;
        int g = (alive) ? 1 : 0;
        switch (g) {
            case 0:
                alive = true;

                this.setBackground(Color.white);
                break;
            case 1:
                alive = false;

                this.setBackground(Color.black);
                break;
        }
    }

    /*
     * This method changes the state of the cell
     * 
     */
    void setAlive(boolean state) {
        if (state == true) {
            alive = true;
            this.setBackground(Color.white);
        } else {
            alive = false;
            this.setBackground(Color.black);
        }
    }

    /*
     * This method returns the state of the cell
     */
    boolean isAlive() {
        if (alive == true) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * this method sets numNeighbors of the cell to n;
     */
    void setNumNeighbors(int n) {
        numNeighbors = n;

    }

    /*
     * takes the cell to the next generation:
     * it changes the instance variable alive according to the rules above,
     * using the value of the instance variable numNeighbors and alive
     */
    void update() {
        if (isAlive() == true) {
            if (numNeighbors < 2 || numNeighbors > 3) {
                setAlive(false);
            }
        } else if (numNeighbors == 3) {
            setAlive(true);

        }
    }

    /*
     * these methods aren't used but must exist in the code
     */
    public void mouseReleased(MouseEvent e) {
        ispressed = false;

    }

    public void mouseEntered(MouseEvent e) {
        if (ispressed == true) {
            if (drag == true) {
                this.setBackground(Color.black);
                alive = false;
            }
            this.setBackground(Color.white);
            alive = true;
        }
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {


    }

    public void mouseDragged(MouseEvent e) {

    }

    void storedvalue(boolean n) {
        drag = n;
    }
}