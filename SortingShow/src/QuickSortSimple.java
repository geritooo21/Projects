class QuickSortSimple extends SortAlgorithm {
    @Override
    void sort(int a[]) {
        sort(a, 0, a.length-1);
    }
    
    // sort the array segment between lo0 and hi0
    void sort(int a[], int lo0, int hi0) {
        int lo = lo0;
        int hi = hi0;
        pause(lo, hi);
        if (lo >= hi) { // nothing to be sorted
            return;
        }
        
        /*
         * So we have at least two elements 
         * Pick a pivot and move it out of the way
         */
        int pivot = a[(lo + hi) / 2];
        a[(lo + hi) / 2] = a[hi];
        a[hi] = pivot;
        
        while( lo < hi ) {
            /*
             * put everything smaller than the pivot before lo 
             * and everything greater after hi
             */
            
            if (a[lo] <= pivot) {
                lo++;
            } else if (pivot <= a[hi]) {
                hi--;
            } else {
                /*
                 *  Swap elements a[lo] and a[hi]
                 */
                int h = a[lo];
                a[lo] = a[hi];
                a[hi] = h;
                pause();
            }
            
            if (stopRequested) {
                return;
            }
        }
        
        /*
         *  Put the pivot in the "center" of the list
         */
        a[hi0] = a[hi];
        a[hi] = pivot;
        
        /*
         *  Recursive calls, elements a[lo0] to a[lo-1] are less than or
         *  equal to pivot, elements a[hi+1] to a[hi0] are greater than
         *  pivot.
         */
        sort(a, lo0, lo-1);
        sort(a, hi+1, hi0);
    }
}

