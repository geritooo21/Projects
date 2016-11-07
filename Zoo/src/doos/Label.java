package doos;

public class Label {
       private int   labPriv;
       private int[] privateArray = new int[3];
               int   labNone;
               protected void  labProt() {}; 
        public void  labPub() {}
        public int[] getPrivateArray() { return privateArray; }
}