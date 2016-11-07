/*
 * @(#)SortAlgorithm.java       1.6f 95/01/31 James Gosling
 *
 * Copyright (c) 1994-1995 Sun Microsystems, Inc. All Rights Reserved.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL or COMMERCIAL purposes and
 * without fee is hereby granted. 
 * Please refer to the file http://java.sun.com/copy_trademarks.html
 * for further important copyright and trademark information and to
 * http://java.sun.com/licensing.html for further important licensing
 * information for the Java (tm) Technology.
 */

/**
 * A generic sort demonstration algorithm
 * SortAlgorithm.java, Thu Oct 27 10:32:35 1994
 * 
 * removed Exceptions from interfaces; pause now throws RuntimeException :-)
 *
 * @author James Gosling
 * @author Kees Huizing
 * @version     2.0, 26 April 2010
 */

public abstract class SortAlgorithm {
    /**
     * The sorting panel.
     */
    private SortingPanel parent;

    /**
     * When true stop sorting.
     */
    protected boolean stopRequested = false;

    /**
     * Set the parent.
     */
    public void setParent(SortingPanel p) {
        parent = p;
    }

    /**
     * Pause for a while.
     */
    protected void pause() {
        this.pause(-1, -1);
    }

    /**
     * Pause for a while and mark item 1.
     */
    protected void pause(int H1) {
        this.pause(H1, -1);
    }

    /**
     * Pause for a while and mark item 1 & 2.
     */
    protected void pause(int H1, int H2) {
        if (stopRequested) {
            throw new RuntimeException("Sort Algorithm");
        }
        if (parent != null) { // only pause if not standalone
            if (H1==-1) H1 = parent.h1;
            if (H2==-1) H2 = parent.h2;
            parent.pause(H1, H2);
        }
    }

    /**
     * Stop sorting.
     */
    public void stop() {
        stopRequested = true;
    }

    /**
     * Initialize
     */
    public void init() {
        stopRequested = false;
    }

    /**
     * This method will be called to
     * sort an array of integers.
     * Exception need not be thrown by overriding method
     */
    abstract void sort(int a[]);
}
