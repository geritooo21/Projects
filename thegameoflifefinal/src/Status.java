public class Status {
    static boolean status; // dead/alive state of start cell when dragging
    static boolean mousestatus; // LMB is pressed/released

    /*
     * sets the dead/alive state of the cell
     */
    static void setvalue(boolean n) {
        status = n;
    }

    /*
     * returns the dead/alive state of the cell
     */
    static boolean returnvalue() {
        return status;
    }

    /*
     * sets the state of LMB
     */
    static void setmousevalue(boolean n) {
        mousestatus = n;
    }

    /*
     * returns the state of LMB
     */
    static boolean returnmousevalue() {
        return mousestatus;
    }
}