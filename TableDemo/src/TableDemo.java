import java.util.Arrays;

public class TableDemo {

    void demo() {
        Table table = new Table();
        table.print();
        String sums = Arrays.toString(table.getColumnSums());
        System.out.println(sums);
        table.printDiagonal();
        table.transpose();
        table.print();

    }

    public static void main(String[] args) {
        (new TableDemo()).demo();
    }
}

class Table {
    int[][] matrix;

    // create a table for testing
    Table() {
        matrix = new int[][]{
                {8, 1, 6},
                {3, 55, 7},
                {4, 9, 2}
        };
    }

    void print() {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.printf("%3d", matrix[r][c]);
            }
            System.out.print("\n");
        }
    }

    void printDiagonal() {
        for (int r = 0; r < matrix.length; r++) {
            System.out.print(matrix[r][r] + " ");
        }
        System.out.println();
    }

    void transpose() {
        int save[][] = new int[matrix.length][matrix.length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                save[r][c] = matrix[c][r];
            }
        }
        matrix = save;
    }

    int[] getColumnSums() {
        int sums[] = new int[matrix.length];

        for (int c = 0; c < matrix.length; c++) {
            for (int r = 0; r < matrix.length; r++) {
                sums[c] = sums[c] + matrix[r][c];
            }
        }

        return sums;
    }
}

