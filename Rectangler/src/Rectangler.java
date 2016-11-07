/*
 * Rectangler -- exercise 13.3 -- Exceptions
 * @author kees
 * 
 */

import java.util.Scanner;

class Rectangler {
    Scanner input = new Scanner(System.in);

    void readAndTest() throws IlldefinedRectangleException {
        while (input.hasNextInt()) {
            int rxtop, rytop, rxbtm, rybtm, x, y;
            rxtop = input.nextInt();
            rytop = input.nextInt();
            rxbtm = input.nextInt();
            rybtm = input.nextInt();
            x = input.nextInt();
            y = input.nextInt();
            boolean isInside = isInside(rxtop, rytop, rxbtm, rybtm, x, y);
            if (isInside) {
                System.out.println("inside");
            } else {
                System.out.println("outside");
            }
        }
    }

    boolean isInside(int rxtop, int rytop, int rxbtm, int rybtm, int x, int y) throws IlldefinedRectangleException {
        if (rxtop > rxbtm || rytop > rybtm) {
            throw new IlldefinedRectangleException("dsdads");
        } else {
            return rxtop <= x && x <= rxbtm && rytop <= y && y <= rybtm;
        }
    }

    public static void main(String[] args) {
        try {
            (new Rectangler()).readAndTest();
        } catch (IlldefinedRectangleException e) {
            System.out.println(e.getMessage());
        }
    }
}

class IlldefinedRectangleException extends Exception {
    IlldefinedRectangleException(String msg) { // constructor
        super(msg);
    }
}


