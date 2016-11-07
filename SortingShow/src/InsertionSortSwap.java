/*
/**
 * An insertion sort demonstration algorithm
 * to be used with SortingAlgorithm.java and Sorting.java
 *
 * along the lines of Dale et al in Object-Oriented Data Structures Using Java
 * and also Jason Harrison from the Java sorting applets
 * swaps elements while shifting downwards
 *
 * @author c.huizing@tue.nl
 * @version     1.1, 26 April 2010
 *
 */
class InsertionSortSwap extends SortAlgorithm {
    void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            int inserendus = a[i];  // element to be inserted
            while ((j > 0) && (a[j-1] > inserendus)) {
                if (stopRequested) { return; } // for animation
                int h = a[j];
                a[j] = a[j-1];
                a[j-1] = h;
                j--;
                // give the animation time to draw and the user to watch
                // the blue line is drawn at position i, the red lune at j
                pause(i,j);
            }
        }
    }
}