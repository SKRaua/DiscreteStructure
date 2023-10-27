import java.util.Scanner;

/**
 * The Test class for Matrix
 * 
 * @author XinyangZhou
 * @version 1.0
 */
public class Test {
    /**
     * The main of the test
     * 
     * @param args A reference to a string array containing command-line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Enters the row and column.
        System.out.println("Enter the row of the matrix.");
        int row = input.nextInt();
        System.out.println("Enter the column of the matrix.");
        int column = input.nextInt();

        // Instantiates two matrices.
        MatrixArrayBased matrix1 = new MatrixArrayBased(row, column);
        MatrixArrayBased matrix2 = new MatrixArrayBased(row, column);

        // Assigning values to two matrices.Enter 0 or 1, add a space after each digit,
        // and enter carriage return for each row.
        System.out.println("Enter the value of matrix1.");
        for (int i = 0; i < matrix1.getRow(); i++) {
            for (int j = 0; j < matrix1.getColumn(); j++) {
                int value = input.nextInt();
                if (value == 1) {
                    matrix1.getMatrix()[i][j] = true;
                } else if (value == 0) {
                    matrix1.getMatrix()[i][j] = false;
                }
            }
        }
        System.out.println("Enter the value of matrix2.");
        for (int i = 0; i < matrix2.getRow(); i++) {
            for (int j = 0; j < matrix2.getColumn(); j++) {
                int value = input.nextInt();
                if (value == 1) {
                    matrix2.getMatrix()[i][j] = true;
                } else if (value == 0) {
                    matrix2.getMatrix()[i][j] = false;
                }
            }
        }

        // Tests the meet and join method.
        MatrixArrayBased meetMatrix = matrix1.meet(matrix2);
        MatrixArrayBased joinMatrix = matrix1.join(matrix2);

        // Display the four matrices.
        System.out.println("The matrix1: ");
        matrix1.display();
        System.out.println("The matrix2: ");
        matrix2.display();
        System.out.println("The meetMatrix: ");
        meetMatrix.display();
        System.out.println("The joinMatrix: ");
        joinMatrix.display();

        input.close();
    }
}
