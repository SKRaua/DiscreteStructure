
/**
 * The MatrixArrayBased class
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class MatrixArrayBased {

    /**
     * The Zero-One matrix stored using boolean array
     */
    private boolean[][] matrix;

    /**
     * The rows of the matrix
     */
    private int row;
    /**
     * The columns of the matrix
     */
    private int column;

    /**
     * Constructs a matrix with the rows and columns
     * 
     * @param row    The rows of the matrix
     * @param column The colums of the matrix
     */
    public MatrixArrayBased(int row, int column) {
        matrix = new boolean[row][column];
        this.row = row;
        this.column = column;
    }

    /**
     * Returns the matrix
     * 
     * @return The matrix
     */
    public boolean[][] getMatrix() {
        return this.matrix;
    }

    /**
     * Returns the column
     * 
     * @return The column
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Returns the row
     * 
     * @return The row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Calculates the meet of two matrices.
     * 
     * @param anotherMatrix Another matrix
     * @return The meet of the two matrices
     */
    public MatrixArrayBased meet(MatrixArrayBased anotherMatrix) {
        // The new matrix to return
        MatrixArrayBased newMatrix = new MatrixArrayBased(row, column);
        // Traverse takes every bit and.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j] && anotherMatrix.matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Calculates the join of two matrices.
     * 
     * @param anotherMatrix Another matrix
     * @return The meet of the two matrices
     */
    public MatrixArrayBased join(MatrixArrayBased anotherMatrix) {
        // The new matrix to return
        MatrixArrayBased newMatrix = new MatrixArrayBased(row, column);
        // Traverse takes every bit or.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j] || anotherMatrix.matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * Diplays the matrix.
     */
    public void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (this.matrix[i][j] == true) {
                    System.out.print(1);
                } else if (this.matrix[i][j] == false) {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
