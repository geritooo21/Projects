/*
 * @(#)SortingPanel.java     1.17f 95/04/10 James Gosling
 * was: SortItem.java
 *
 * Copyright (c) 1994-1995 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL or COMMERCIAL purposes and
 * without fee is hereby granted. 
 *
 * And modiifed it was
 * Kees Huizing -- 2010/04/26 - 2013/09/26
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.io.InputStream;
//import java.net.*;


/**
 * A simple class to demonstrate a sort algorithm.
 * You can specify a sorting algorithm using the "algorithm"
 * attribute. When you click on the panel, a thread is
 * forked which animates the sorting algorithm.
 *
 * @author James Gosling
 * @version     1.17f, 10 Apr 1995
 */
public class SortingPanel extends JPanel implements Runnable, MouseListener {
    /**
     * The thread that is sorting (or null).
     */
    private Thread kicker;

    /**
     * The array that is being sorted.
     */
    int arr[];

    /**
     * The high water mark.
     */
    int h1 = -1;

    /**
     * The low water mark.
     */
    int h2 = -1;

    /**
     * The name of the algorithm.
     */
    String algName;

    /**
     * The sorting algorithm (or null).
     */
    SortAlgorithm algorithm;
    
    /**
     * The vertical height of a line
     * not used yet
     * now it is --KH
     */
    int VSIZE = 2;
    
    /**
     * KH
     * duration of sleep during pause in ms
     */
    long PAUSETIME = 20;
    
    /**
     * to draw message when sorting not started yet
     */
    boolean started = false;
    
   /**
    * Initialize
    */
    public SortingPanel(String at) {
        if (at == null) {
            at = "BubbleSort";
        }

        algName = at;
        scramble();

        setSize(100, 100);
        
        this.addMouseListener(this);
    }
    
    public SortingPanel () {
        this("BubbleSort2");
    }

    /**
     * Fill the array with random numbers from 0..n-1.
     */
    void scramble() {
        int a[] = new int[getSize().height / (2*VSIZE)];
        double f = getSize().width / (double) a.length;
        for (int i = a.length; --i >= 0;) {
            a[i] = (int)(a.length * f * Math.random());
/*jh: fill the array with numbers from 0..n-1, not a scrambled
  set of 0..n-1 unique numbers.  So duplicates will occur in
  in most cases */
/*          a[i] = (int)(i * f);*/
        }

/*jh: we don't shuffle the array anymore*/
/*
        for (int i = a.length; --i >= 0;) {
            int j = (int)(i * Math.random());
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        */
        arr = a;
    }
    
    void setAlgorithm(SortAlgorithm alg) {
        algorithm = alg;
        algorithm.setParent(this);
    }

    // KH: pause with less than 2 params doesn't seem to be used
    // and it seems wrong to set the watermark back to -1
    /**
     * Pause a while.
     * @see SortAlgorithm
     */
    void pause() {
        pause(-1, -1);
    }

    /**
     * Pause a while, and draw the high water mark.
     * @see SortAlgorithm
     */
    void pause(int H1) {
        pause(H1, -1);
    }

    /**
     * Pause a while, and draw the low&high water marks.
     * @see SortAlgorithm
     */
    void pause(int H1, int H2) {
        h1 = H1;
        h2 = H2;
        if (kicker != null) {
            repaint();
        }
        try {Thread.sleep(PAUSETIME);} catch (InterruptedException e){}
    }

    /**
     * Paint the array of numbers as a list
     * of horizontal lines of varying lenghts.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent( g );
        int a[] = arr;
        int y = getSize().height - 1;
        
        // Initial message
        if ( !started ) {
            g.drawString( "If you want to resize, do it before starting", 20, getHeight()/2 - 20 );
            g.drawString( "Click to start", 20, getHeight()/2 );
        }
                
        // Erase old lines
        // apparently not needed anymore, because of super.paintComponent
//        g.setColor(Color.lightGray);
//        for (int i = a.length; --i >= 0; y -= 2*VSIZE) {
//            //g.drawLine(arr[i], y, getWidth(), y);
//            drawFatLine(g, arr[i], y, getWidth(), y);
//        }

        // Draw new lines
        g.setColor(Color.black);
        y = getHeight() - 1;
        for (int i = a.length; --i >= 0; y -= 2*VSIZE) {
            //g.drawLine(0, y, arr[i], y);
            drawFatLine(g, 0, y, arr[i], y);
        }

        if (h1 >= 0) {
            g.setColor(Color.red);
            y = h1 * 2 * VSIZE + VSIZE + 1;
            //g.drawLine(0, y, getWidth(), y);
            drawFatLine(g, 0, y, getWidth(), y);
        }
        if (h2 >= 0) {
            g.setColor(Color.blue);
            y = h2 * 2 *  VSIZE + VSIZE + 1;
            //g.drawLine(0, y, getWidth(), y);
            drawFatLine(g, 0, y, getWidth(), y);
        }
    }
    
    //KH
    // uses VSIZE
    void drawFatLine(Graphics g, int xL, int yL, int xR, int yR) {
        g.fillRect(xL, yL, xR-xL, VSIZE);
    }
    

    /**
     * Update without erasing the background.
     */
    // public void update(Graphics g) {
//         paint(g);
//     }

    /**
     * Run the sorting algorithm. This method is
     * called by class Thread once the sorting algorithm
     * is started.
     * @see Thread#run
     * @see SortItem#mouseUp
     */
    public void run() {
        if (algorithm == null) {
            System.err.println("No sorting algortihm has been set");
            return;
        }
        algorithm.init();
        algorithm.sort(arr);    
    }

    /**
     * Stop the applet. Kill any sorting algorithm that
     * is still sorting.
     */
    public synchronized void stop() {
        /* if (kicker != null) {
            try {
                kicker.stop();
            } catch (IllegalThreadStateException e) {
                // ignore this exception
            }
            kicker = null;
        }
        */
        if (algorithm != null){
            try {
                algorithm.stop();
            } catch (IllegalThreadStateException e) {
                // ignore this exception
            }
        }
    }


    /**
     * For a Thread to actually do the sorting. This routine makes
     * sure we do not simultaneously start several sorts if the user
     * repeatedly clicks on the sort item.  It needs to be
     * synchronoized with the stop() method because they both
     * manipulate the common kicker variable.
     */
    private synchronized void startSort() {
        if (kicker == null || !kicker.isAlive()) {
            started = true;
            scramble();
            repaint();
            kicker = new Thread(this);
            kicker.start();
        }
    }


    /**
     * The user clicked in the applet. Start the clock!
     */
    public void mouseReleased(MouseEvent e) {
        startSort();
    }
    
    public void mousePressed(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    
}
