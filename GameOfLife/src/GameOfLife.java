import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;
import java.awt.event.*;


public class GameOfLife implements ActionListener {
    boolean drag = false;
    Timer timer;
    int numalive = 0;
    Scanner sc;
    File source;
    String birthFileSource = "C:\\Users\\s168945\\Desktop\\Projects\\GameOfLife\\src\\birth.txt";
    boolean alive = false;
    int row;
    int col;
    int[] a = new int[100];
    public Cell grid[][];
    String[][] init;
    JFrame frame;
    JPanel panel;
    JPanel buttonpanel;
    JButton start;
    JButton stop;

    void run() {
        readInitial();
        setup();
    }

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
     * This method reads from the file
	 */
    void readInitial() {
        try {
            source = new File(birthFileSource);
            sc = new Scanner(source);
            row = sc.nextInt();
            col = sc.nextInt();
            init = new String[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    init[i][j] = sc.next();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file due to");
            System.out.println(e);
        }
    }

    /*
     * this method sets the frame
     */
    void setup() {
        timer = new Timer(750, this);
        buttonpanel = new JPanel();
        start = new JButton("Start");
        stop = new JButton("Stop");
        start.addActionListener(this);
        stop.addActionListener(this);
        grid = new Cell[row][col];
        frame = new JFrame("Game of life");
        buttonpanel.add(start);
        buttonpanel.add(stop);
        frame.add(buttonpanel, BorderLayout.NORTH);
        panel = new JPanel();
        panel.setLayout(new GridLayout(row, col));
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int n = 8;
                if (i == 0 && j == 0 || i == 0 && j == col - 1 ||
                        i == row - 1 && j == 0 || i == row - 1 && j == col - 1) {
                    n = 3;
                } else if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    n = 5;
                }
                if (init[i][j].equals("*")) {
                    alive = true;
                } else alive = false;
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
     * this method calculates the number of neighbors
     */
    void calculateNumNeighbors(int i, int j) {
        int num;
        numalive = 0;
        num = grid[i][j].amountNeighbors;
        if (num == 3) {
            if (i == 0 && j == 0) {
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
            if (i == 0 && j == col - 1) {
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
            if (i == row - 1 && j == 0) {
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
            if (i == row - 1 && j == col - 1) {
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
        if (num == 5) {
            if (i == 0 && j != 0 && j != col - 1) {
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
            if (i == row - 1 && j != 0 && j != col - 1) {
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
            if (j == 0 && i != 0 && i != row - 1) {
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
            if (j == col - 1 && i != 0 && i != row - 1) {
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
        if (num == 8 && i != 0 && j != 0 && j != col - 1 && i != row - 1) {
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
     * this method creates the next generation when the timer fires
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

    /*
     * This method checks on which cell is clicked and stores its alive value in the other cells in the
     * "drag" variable via storedvalue method in Cell
     */
    void mouseDragged(MouseEvent e) {
        boolean n;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (e.getSource() == grid[i][j]) ;
                n = grid[i][j].isAlive();
                for (int k = 0; k < row && k != i; k++) {
                    for (int l = 0; l < col && l != i; l++)
                        grid[k][l].storedvalue(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        (new GameOfLife()).run();
    }

}
