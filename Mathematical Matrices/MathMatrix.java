import java.util.Arrays;

// MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
 *
 *  On my honor, Diego Wearden, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: daw3784
 *  email address: dialwera@gmail.com
 *  Unique section number: 52045
 *  Number of slip days I am using: 0
 */

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {

    // instance variable
    private final int[][] matrix;

    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        matrix = new int[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++){
            for (int c = 0; c < mat[0].length; c++){
                matrix[r][c] = mat[r][c];
            }
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns.
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        matrix = new int[numRows][numCols];
        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                matrix[r][c] = initialVal;
            }
        }
    }

    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
        return matrix.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns(){
        return matrix[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     * @param  row  0 <= row < getNumRows()
     * @param  col  0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        return matrix[row][col];
    }


    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns
     * in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide){
        int[][] newMatrix = new int[getNumRows()][getNumColumns()];
        for (int r = 0; r < getNumRows(); r++){
            for (int c = 0; c < getNumColumns(); c++){
                newMatrix[r][c]  = this.getVal(r, c) + rightHandSide.getVal(r, c);
            }
        }
        return new MathMatrix(newMatrix);
    }


    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     * rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide
     * from this MathMatrix. The number of rows in the returned MathMatrix is equal to the number
     * of rows in this MathMatrix.The number of columns in the returned MathMatrix is equal to
     * the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide){
        int[][] newMatrix = new int[getNumRows()][getNumColumns()];
        for (int r = 0; r < getNumRows(); r++){
            for (int c = 0; c < getNumColumns(); c++){
                newMatrix[r][c]  = getVal(r, c) - rightHandSide.getVal(r, c);
            }
        }
        return new MathMatrix(newMatrix);
    }


    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide != null, rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying
     * this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows
     * in this MathMatrix. The number of columns in the returned MathMatrix is equal to the number
     * of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide){
        int[][] newMatrix = new int[getNumRows()][rightHandSide.getNumColumns()];
        for(int i = 0; i < getNumRows(); i++){
            for(int j = 0; j < rightHandSide.getNumColumns(); j++){
                for(int k = 0; k < getNumColumns(); k++){
                    int leftHandSideNum = getVal(i, k);
                    int rightHandSideNum = rightHandSide.getVal(k, j);
                    newMatrix[i][j] += leftHandSideNum * rightHandSideNum;
                }
            }
        }
        return new MathMatrix(newMatrix);
    }


    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix
     * multiplied by factor.
     * In other words after this method has been called
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
        int[][] scaledMatrix = new int[getNumRows()][getNumColumns()];
        for(int i = 0; i < getNumRows(); i++){
            for(int j = 0; j < getNumColumns(); j++){
                scaledMatrix[i][j] = getVal(i, j) * factor;
            }
        }
        return new MathMatrix(scaledMatrix);
    }


    /**
     * accessor: get a transpose of this MathMatrix.
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        int[][] transposedMatrix = new int[getNumColumns()][getNumRows()];
        for(int i = 0; i < getNumColumns(); i++){
            for(int j = 0; j < getNumRows(); j++){
                transposedMatrix[i][j] = getVal(j, i);
            }
        }
        return new MathMatrix(transposedMatrix);
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
        /* CS314 Students. The following is standard equals
         * method code. We will learn about in the coming weeks.
         *
         * We use getClass instead of instanceof because we only want a MathMatrix to equal
         * another MathMatrix as opposed to any possible sub classes. We would
         * use instance of if we were implementing am interface and wanted to equal
         * other objects that are instances of that interface but not necessarily
         * MathMatrix objects.
         */

        if (rightHandSide == null || this.getClass() != rightHandSide.getClass()) {
            return false;
        }
        // We know rightHandSide refers to a non-null MathMatrix object, safe to cast.
        MathMatrix otherMathMatrix = (MathMatrix) rightHandSide;
        // Now we can access the private instance variables of otherMathMatrix
        // and / or call MathMatrix methods on otherMathMatrix.
            MathMatrix otherMatrix = (MathMatrix) rightHandSide;
            if (this.getNumRows() != otherMatrix.getNumRows() || this.getNumColumns() != otherMatrix.getNumColumns()) {
                return false;
            }
            for (int i = 0; i < this.getNumRows(); i++) {
                for (int j = 0; j < this.getNumColumns(); j++) {
                    if (this.getVal(i, j) != otherMatrix.getVal(i, j)) {
                        return false;
                    }
                }
            }
            return true;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix.
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString() {
        int longestElementLength = getLongestElementLength() + 1;
        StringBuilder matrixString = new StringBuilder();
        for(int i = 0; i < getNumRows(); i++){
            matrixString.append("|");
            for(int j = 0; j < getNumColumns(); j++){
                matrixString.append(String.format("%" + longestElementLength + "d", getVal(i, j)));
            }
            matrixString.append("|\n");
        }
        return matrixString.toString();
    }

    /**
     * returns the length of the longest number in the matrix
     * @return the length of the longest number in the matrix
     */
    private int getLongestElementLength() {
        int max = 0;
        for(int i = 0; i < getNumRows(); i++){
            for (int j = 0; j < getNumColumns(); j++){
                int length = ("" + getVal(i, j)).length();
                if (length > max){
                    max = length;
                }
            }
        }
        return max;
    }


    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise.
     */
    public boolean isUpperTriangular(){
        if (getNumRows() != getNumColumns()){
            return false;
        }
        for(int i = 0; i < getNumColumns(); i++){
            for (int j = i + 1; j < getNumRows(); j++){
                if (getVal(j, i) != 0){
                    return false;
                }
            }
        }
        return true;
    }

    // method to ensure mat is rectangular. It is public so that
    // tester classes can use it.
    // pre: mat != null, mat has at least one row
    // return true if all rows in mat have the same
    // number of columns false otherwise.
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null and must "
                    + " have at least one row. mat = " + Arrays.toString(mat));
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }

}