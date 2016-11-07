/* GameOfLife
 * created by Georgi Shishkov and Gergana Goncheva
 * extensions 1, 2
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameOfLife implements ActionListener {

    int[][] reserve = new int[][]{ // reserve initial setup if the file is not found
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    Timer timer;
    int numalive = 0; // number of alive neighbors of a cell
    Scanner sc;
    File source; // file for the initial setup
    String birthFilename = "birth.txt";
    boolean alive; // stores the value of the cell
    int row; // rows in the grid
    int col; // columns in the grid
    Cell grid[][]; // objects of type cell
    String[][] init; // the initial configuration taken from the initial file
    JFrame frame;
    JPanel panel; // panel for the grid
    JPanel buttonPanel;
    JButton start;
    JButton stop;
    JLabel extensionsLabel; // showing the extensions

    /*
     * Method setting the initial logic before pressing start button
     */
    void run() {
        readInitial();
        setup();
    }

    /*
     * This method checks if the timer is running and stop/starts when a button
     * is pressed. Then calls nextGeneration method each time the timer fires
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == (start)) {
            timer.start();
        }
        if (e.getSource() == (stop)) {
            timer.stop();
        }
        if (e.getSource() == (timer)) {
            nextGeneration();
        }
    }

    /*
     * This method reads from the file if it exists and sets the initial
     * configuration in the "init" array
     */
    void readInitial() {
        try {
            row = 13;
            col = 15;
            init = new String[row][col];
            source = new File(birthFilename);
            sc = new Scanner(source);
            row = sc.nextInt();
            col = sc.nextInt();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    init[i][j] = sc.next();
                }
            }
        } catch (FileNotFoundException e) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    init[i][j] = Integer.toString(reserve[i][j]);
                }
            }
        }
    }

    /*
     * This method sets the frame and creates the initial configuration
     */
    void setup() {
        timer = new Timer(750, this);
        buttonPanel = new JPanel();
        start = new JButton("Start");
        stop = new JButton("Stop");
        extensionsLabel = new JLabel("extensions 1 and 2");
        start.addActionListener(this);
        stop.addActionListener(this);
        grid = new Cell[row][col];
        frame = new JFrame("Game of life");
        buttonPanel.add(start);
        buttonPanel.add(stop);
        buttonPanel.add(extensionsLabel);
        extensionsLabel.setOpaque(true);
        frame.add(buttonPanel, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(row, col));

        // calculates the number of neighbors
        // of each cell creates the cells
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int n = 8;
                if (i == 0 && j == 0 || i == 0 && j == col - 1 || i == row - 1 && j == 0
                        || i == row - 1 && j == col - 1) {
                    n = 3;
                } else if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    n = 5;
                }
                if (init[i][j].equals("*") || init[i][j].equals("1")) {
                    alive = true;
                } else
                    alive = false;
                grid[i][j] = new Cell(n, alive);
                panel.add(grid[i][j]);
            }
        }
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     * this method calculates the number of alive neighbors
     */
    void calculateNumNeighbors(int i, int j) {
        int num; // number of neighbors
        numalive = 0; // number of alive neighbors
        num = grid[i][j].returnAmountNeighbors(); // stores the number of neighbors from the cell
        if (num == 3) { // if neighbors are 3
            if (i == 0 && j == 0) { // top left corner cell
                if (grid[i + 1][j].isAlive() == true) {
                    numalive++;
                }
                if (grid[i + 1][j + 1].isAlive() == true) {
                    numalive++;
                }
                if (grid[i][j + 1].isAlive() == true) {
                    numalive++;
                }
            }
            if (i == 0 && j == col - 1) { // top right corner cell
                if (grid[i][j - 1].isAlive() == true) {
                    numalive++;
                }
                if (grid[i + 1][j - 1].isAlive() == true) {
                    numalive++;
                }
                if (grid[i + 1][j].isAlive() == true) {
                    numalive++;
                }
            }
            if (i == row - 1 && j == 0) { // bottom left corner cell
                if (grid[i - 1][j].isAlive() == true) {
                    numalive++;
                }
                if (grid[i - 1][j + 1].isAlive() == true) {
                    numalive++;
                }
                if (grid[i][j + 1].isAlive() == true) {
                    numalive++;
                }
            }
            if (i == row - 1 && j == col - 1) { // bottom right corner cell
                if (grid[i - 1][j].isAlive() == true) {
                    numalive++;
                }
                if (grid[i - 1][j - 1].isAlive() == true) {
                    numalive++;
                }
                if (grid[i][j - 1].isAlive() == true) {
                    numalive++;
                }
            }
        }
        if (num == 5) { // if number of neighbors is 5
            if (i == 0 && j != 0 && j != col - 1) { // top line of cells
                if (grid[i][j - 1].isAlive() == true) {
                    numalive++;
                }
                if (grid[i][j + 1].isAlive() == true) {
                    numalive++;
                }
                for (int k = j - 1; k < j + 2; k++) {
                    if (grid[i + 1][k].isAlive() == true)
                        numalive++;
                }

            }
            if (i == row - 1 && j != 0 && j != col - 1) { // bottom line of cells
                if (grid[i][j - 1].isAlive() == true) {
                    numalive++;
                }
                if (grid[i][j + 1].isAlive() == true) {
                    numalive++;
                }
                for (int k = j - 1; k < j + 2; k++) {
                    if (grid[i - 1][k].isAlive() == true) {
                        numalive++;
                    }
                }
            }
            if (j == 0 && i != 0 && i != row - 1) { // left line of cells
                if (grid[i - 1][j].isAlive() == true) {
                    numalive++;
                }
                if (grid[i + 1][j].isAlive() == true) {
                    numalive++;
                }
                for (int k = i - 1; k < i + 2; k++) {
                    if (grid[k][j + 1].isAlive() == true) {
                        numalive++;
                    }
                }
            }
            if (j == col - 1 && i != 0 && i != row - 1) { // right line of cells
                if (grid[i - 1][j].isAlive() == true) {
                    numalive++;
                }
                if (grid[i + 1][j].isAlive() == true) {
                    numalive++;
                }
                for (int k = i - 1; k < i + 2; k++) {
                    if (grid[k][j - 1].isAlive() == true) {
                        numalive++;
                    }
                }
            }
        }
        if (num == 8) { // if number of neighbors is 8
            for (int k = i - 1; k < i + 2; k++) {
                for (int b = j - 1; b < j + 2; b++) {
                    if (!(k == i && b == j)) {
                        if (grid[k][b].isAlive() == true) {
                            numalive++;
                        }
                    }
                }
            }
        }
    }

    /*
     * this method creates the next generation when the timer fires but first
     * calculates the number of alive neighbors of each cell
     */
    void nextGeneration() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                calculateNumNeighbors(i, j);
                grid[i][j].setNumNeighbors(numalive);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j].update();
            }
        }
    }

    public static void main(String[] args) {
        (new GameOfLife()).run();
    }

}
