import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell extends JLabel implements MouseListener {

    boolean alive = false; // dead/alive state of the cell
    int numNeighbors; // number of alive neighbors
    int amountNeighbors; // number of neighbors

    /*
     * Cell constructor
     */
    public Cell(int n, boolean a) { // n is the amount of neighbors and a is the alive state
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
     * This method changes the state of the cell
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
     * this method sets numNeighbors of the cell to n
     */
    void setNumNeighbors(int n) {
        numNeighbors = n;
    }

    /*
     * takes the cell to the next generation: it changes the instance variable
     * alive according to the rules above, using the value of the instance
     * variable numNeighbors and alive
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
     * this method returns the amount of neighbors of the cell
     */
    int returnAmountNeighbors() {
        return amountNeighbors;
    }

    /*
    * when LMB is pressed stores the value of this cell in Status class when
    * the LMB is pressed stores true in Status class also changes the
    * dead/alive status of the cell
    */
    public void mousePressed(MouseEvent e) {
        Status.setvalue(!alive);
        Status.setmousevalue(true);
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
     * when LMB is released stores false value in Status class
     */
    public void mouseReleased(MouseEvent e) {
        Status.setmousevalue(false);
    }

    /*
     * if LMB is pressed changes the color of the cells over which the mouse is
     * dragged
     */
    public void mouseEntered(MouseEvent e) {
        if (Status.returnmousevalue() == true) {
            if (Status.returnvalue() == false) {
                this.setBackground(Color.black);
                alive = false;
            }
            if (Status.returnvalue() == true) {
                this.setBackground(Color.white);
                alive = true;
            }
        }
    }

    /*
     * these methods aren't used but must exist in the code
     */
    public void mouseExited(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }
}