/**
 * Created by s168945 on 15-10-2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GameOfLife extends JFrame implements ActionListener {

    public static void main(String[] args) {
        new GameOfLife().run();
    }

    Cell[][] grid;
    String birthFilename = "C:\\Users\\s168945\\Desktop\\Projects\\game of life\\src\\birth.txt";
    Scanner scanner;
    File file = new File(birthFilename);
    javax.swing.Timer timer;
    int numRows;
    int numCols;
    JFrame frame;
    JPanel panelButtons;
    JPanel panelGrid;
    JButton buttonStart;
    JButton buttonStop;

    public void run () {
        readInitial();
        build();
    }

    public void build() {
        super.repaint();
        frame = new JFrame("Game of Life");
        timer = new Timer(200, this);
        panelButtons = new JPanel();
        panelGrid = new JPanel();
        buttonStart = new JButton("Start");
        buttonStart.addActionListener(this);
        buttonStop = new JButton("Stop");
        buttonStop.addActionListener(this);
        panelGrid.setLayout(new GridLayout(numRows, numCols));
        frame.add(panelButtons, BorderLayout.NORTH);
        frame.add(panelGrid, BorderLayout.CENTER);
        panelButtons.add(buttonStart, BorderLayout.WEST);
        panelButtons.add(buttonStop, BorderLayout.EAST);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                panelGrid.add(grid[i][j]);
            }
        }
    }


    void calculateNumNeighbors() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int numNeighbors = 0;
                for (int x = (i - 1); x <= (i + 1); x++) {
                    for (int y = (j - 1); y <= (j + 1); y++) {
                        if (grid[x][y].isAlive() && !((x == i) && (y == j))) {
                            numNeighbors++;
                        }
                    }
                }
                grid[i][j].setNumNeighbors(numNeighbors);
            }
        }
    }

    void readInitial() {

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        numRows = scanner.nextInt();
        numCols = scanner.nextInt();

        //panelGrid.setLayout(new GridLayout(numRows, numCols));
        grid = new Cell[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j] = new Cell();
            }
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                String s = scanner.next();
                if (s.equals(".")) {
                    grid[i][j].setAlive(false);
                }
                if (s.equals("*")) {
                    grid[i][j].setAlive(true);
                }
            }
        }

    }

    void nextGeneration() {
        calculateNumNeighbors();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                grid[i][j].update();
            }

        }

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == timer) {
            nextGeneration();
        }
        if (actionEvent.getActionCommand().equals("Start")) {
            this.timer.start();
        }
        if (actionEvent.getActionCommand().equals("Stop")) {
            this.timer.stop();
        }
    }



}
