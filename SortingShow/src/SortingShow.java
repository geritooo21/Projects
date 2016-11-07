/* DISCLAIMER
 * Don't look at this code as example Java code.
 * It was developed long ago when not all Java features we have now were available.
 * Originally it was an applet. Kees Huizing made some adaptations to make it run standalone.
 */ 

import javax.swing.*;
import java.util.Scanner;

public class SortingShow {
    JFrame frame = new JFrame();
    SortingPanel panel = new SortingPanel();
    String algName;
    Scanner scanner;

    public SortingShow() {
        frame.setSize(600, 600); // was 300x300
        frame.add(panel);
        frame.setVisible(true);        
    }
    
    public void setAlgorithm(String algName) throws ClassNotFoundException {
        SortAlgorithm algorithm = null;
        System.err.println("trying "+algName+" ...");
        try {
            algorithm = (SortAlgorithm)Class.forName(algName).newInstance();
        } catch( InstantiationException|IllegalAccessException e ) { 
            System.err.println("Problem creating algorithm instance; using InsertionSortSwap instead");
            algorithm = new InsertionSortSwap();
        }
        panel.setAlgorithm( algorithm );
        frame.setTitle(algName);

    }
    
    public void readAlgorithm() {
        if (scanner==null) scanner = new Scanner( System.in );
        boolean isSet = false;
        do {
            try {
                System.out.println("Give the class name of a sorting algortihm"+ 
                    " (Enter gives InsertionSortSwap)");
                algName = scanner.nextLine(); 
                if (algName.isEmpty() ) algName = "InsertionSortSwap";
                setAlgorithm(algName);
                isSet = true;
            } catch (ClassNotFoundException e) {
                System.err.println("Algorithm class "+algName+" not found.\n"+
                    "Is it in the right folder? Is it compiled?\n"+e);
            } catch (Exception e) {
                System.err.println("Problem creating sorting algorithm.\n"+e);
            }
        } while (!isSet);
        System.out.println("Sorting algorithm set to "+algName);
        System.out.println("Click to start sorting");
    }
    
    public static void main(String[] args) throws Exception {
        SortingShow ss = new SortingShow();
        if (args.length>0) {
            ss.setAlgorithm(args[0]);
        } else {
            ss.readAlgorithm();
        }
    }    
}