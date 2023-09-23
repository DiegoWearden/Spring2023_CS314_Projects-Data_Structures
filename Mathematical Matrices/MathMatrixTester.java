import java.util.Objects;
import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: daw3784
 *  email address: dialwera@gmail.com
 *  Unique section number: 52045
 *  Number of slip days I am using: 0
 */



/* CS314 Students. Put your experiment results and
 * answers to questions here.
 * 1. I think it would take 243 seconds to run the add method again if I doubled the dimensions
 * 2. The Big O of the add operation given two N by N matrices based on an analysis of my code is O(N^2).
 * My timing data roughly supports this by increasing from 4.8 seconds to 15.6 seconds by increasing the
 * matrix dimension from 1400 to 2800. My first doubling however does not support my data as when I increased
 * the matrix dimension from 700 to 1400 the time increased from 1.2 seconds to 4.8 seconds
 * 3. If I doubled the dimension size of the MathMatrix objects again I think it would take 103, 823 seconds
 * to  run the multiply operation
 * 4. the Big O of the multiply operation given two N by N matrices based on analysis of my code is O(n^3).
 * My timing data does not support this because when I increased the matrix dimensions from 300 to 600 the time
 * increased from 1.97 seconds to 47.82. Since the operation is O(N^3) I would expect the increment of matrix dimensions
 * to be 7.6 seconds since that is 1.97 cubed, but instead it is 47.82 which is way more than O(N^3).
 * 5. I can go up to 100000 before getting a heap error
 */

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        int[][] data1 = { {1, 2, 3},
                {2, 3, 4}};
        int[][] data2 = { {2, 1, 1},
                {2, 3, 1}};
        int[][] e1;

        MathMatrix mat1;
        MathMatrix mat2;
        MathMatrix mat3;

        //tests 1, addition
        data1 = new int[][] { {5, 4, 3}, {2, 1, 0} };
        data2 = new int[][] { {1, 2, 3}, {4, 5, 6}};
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.add(mat2);
        int[][] expectedResult = new int[][] { {6, 6, 6}, {6, 6, 6} };
        printTestResult(get2DArray(mat3), expectedResult, 1, "add method. Testing mat1 and mat2 add correctly.");

        // test 2, addition
        data1 = new int[][] { {-50, -30}, {-84, -69} };
        data2 = new int[][] { {100, -20}, {37, -20} };
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.add(mat2);
        expectedResult = new int[][] { {50, -50}, {-47, -89} };
        printTestResult(get2DArray(mat3), expectedResult, 2, "add method. Testing mat1 and mat2 add correctly.");

        //test 3, multiply method
        data1 = new int[][] { {2} };
        data2 = new int[][] { {3} };
        mat1 = new MathMatrix(data2);
        mat2 = new MathMatrix(data1);
        mat3 = mat1.multiply(mat2);
        expectedResult = new int[][] { {6} };
        printTestResult( get2DArray(mat3), expectedResult, 3, "multiply method");

        // test 4, multiply method
        data1 = new int[][] { {-28, -5, -22, -91}, {21, 53, 22, 94}, {-98, 24, 0, 59}};
        data2 = new int[][] { {33, -78, -19}, {-49, 29, -77} };
        mat1 = new MathMatrix(data2);
        mat2 = new MathMatrix(data1);
        mat3 = mat1.multiply(mat2);
        expectedResult = new int[][] { {-700, -4755, -2442, -11456}, {9527, -66, 1716, 2642} };
        printTestResult( get2DArray(mat3), expectedResult, 4, "multiply method");

        // test 5, subtraction
        mat1 = new MathMatrix(3, 3, 0);
        mat2 = new MathMatrix(3, 3, 0);
        mat3 = mat1.subtract(mat2);
        expectedResult = new int[][] { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} };
        printTestResult(get2DArray(mat3), expectedResult, 5, "subtract method. Testing mat1 and mat2 subtract correctly.");

        // test 6, subtraction
        data1 = new int[][] { {456, 23, 7}, {36, 6, 5}, {35, 498, 720} };
        data2 = new int[][] { {38, 35, 203}, {395, 23, 209}, {374, 84, 143} };
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        mat3 = mat1.subtract(mat2);
        expectedResult = new int[][] { {418, -12, -196}, {-359, -17, -204}, {-339, 414, 577} };
        printTestResult(get2DArray(mat3), expectedResult, 6, "subtract method. Testing mat1 and mat2 subtract correctly.");

        // test 7, scaled method
        mat1 = new MathMatrix(3, 3, 5);
        mat3 = mat1.getScaledMatrix(6);
        expectedResult = new int[][] { {30, 30, 30}, {30, 30, 30}, {30, 30, 30} };
        printTestResult(get2DArray(mat3), expectedResult, 7, "getScaledMethod method. Testing if mat1 scaled correctly.");

        // test 8, scaled method
        data1 = new int[][] { {456, 23, 7}, {36, 6, 5}, {35, 498, 720} };
        mat1 = new MathMatrix(data1);
        mat3 = mat1.getScaledMatrix(-10);
        expectedResult = new int[][] { {-4560, -230, -70}, {-360, -60, -50}, {-350, -4980, -7200} };
        printTestResult(get2DArray(mat3), expectedResult, 8, "getScaledMethod method. Testing if mat 1 scaled correctly correctly.");

        // test 9, transpose method
        mat1 = new MathMatrix(3, 2, 0);
        mat3 = mat1.getTranspose();
        expectedResult = new int[][] { {0, 0, 0}, {0, 0, 0} };
        printTestResult(get2DArray(mat3), expectedResult, 9, "getTranspose method. Testing if mat1 is transposed correctly.");

        // test 10, transpose method
        data1 = new int[][] { {3795, 10923, 8092, 85, 2890, 91872}, {20985, 1982, 89035, 18907, 89053, 7819}, {7928, 7534, 7892, 923, 7284, 132} };
        mat1 = new MathMatrix(data1);
        mat3 = mat1.getTranspose();
        expectedResult = new int[][] { {3795, 20985, 7928}, {10923, 1982, 7534}, {8092, 89035, 7892}, {85, 18907, 923}, {2890, 89053, 7284}, {91872, 7819, 132}};
        printTestResult(get2DArray(mat3), expectedResult, 10, "getTranspose method. Testing if mat1 is transposed correctly.");

        // test 11, equals method
        mat1 = new MathMatrix(3, 3, 9);
        mat2 = new MathMatrix(3, 3, 9);
        boolean actualBoolean = mat1.equals(mat2);
        boolean expectedBoolean = true;
        if (actualBoolean == expectedBoolean){
            System.out.println("Test number 11 tests the equals method. Testing if mat1 is transposed correctly.. The test passed");
        }
        else{
            System.out.println("Test number 11 tests the equals method. Testing if mat1 is transposed correctly.. The test failed");

        }

        // test 12, equals method
        data1 = new int[][] { {3795, 10923, 8092, 85, 2890, 91872}, {20985, 1982, 89035, 18907, 89053, 7819}, {7928, 7534, 7892, 923, 7284, 132} };
        data2 = new int[][] { {3795, 10923, 8091, 85, 2890, 91872}, {20985, 1982, 89035, 18907, 89053, 7819}, {7928, 7534, 7892, 923, 7284, 132} };
        mat1 = new MathMatrix(data1);
        mat2 = new MathMatrix(data2);
        actualBoolean = mat1.equals(mat2);
        expectedBoolean = false;
        if (actualBoolean == expectedBoolean){
            System.out.println("Test number 12 tests the equals method. Testing if mat1 is equal to mat2.. The test passed");
        }
        else{
            System.out.println("Test number 12 tests the equals method. Testing if mat1 is equal to mat2.. The test failed");

        }

        // test 13, toString
        String expectedString = "|  3795 10923  8092    85  2890 91872|\n" +
                "| 20985  1982 89035 18907 89053  7819|\n" +
                "|  7928  7534  7892   923  7284   132|\n";
        String actualString = mat1.toString();
        if (actualString.equals(expectedString)){
            System.out.println("Test number 13 tests the toString method. Testing if mat1 toString is correct.. The test passed");
        }else{
            System.out.println("Test number 13 tests the toString method. Testing if mat1 toString is correct.. The test failed");
        }

        // test 14, toString
        data1 = new int[][]{{}};
        mat1 = new MathMatrix(data1);
        expectedString = "||\n";
        actualString = mat1.toString();
        if (actualString.equals(expectedString)){
            System.out.println("Test number 14 tests the toString method. Testing if mat1 toString is correct.. The test passed");
        }else{
            System.out.println("Test number 14 tests the toString method. Testing if mat1 toString is correct.. The test failed");
        }

        // test 15, getNumRows
        data1 = new int[][] { {3795, 10923, 8092, 85, 2890, 91872}, {20985, 1982, 89035, 18907, 89053, 7819}, {7928, 7534, 7892, 923, 7284, 132} };
        mat1 = new MathMatrix(data1);
        int actualInt = mat1.getNumRows();
        int expectedInt = 3;
        if (actualInt == expectedInt){
            System.out.println("Test number 15 tests the getNumRows method. Testing if mat1 getNumRows is correct.. The test passed");
        }
        else{
            System.out.println("Test number 15 tests the getNumRows method. Testing if mat1 getNumRows is correct.. The test failed");
        }

        // test 16, getNumRows
        mat1 = new MathMatrix(1000, 2, 0);
        actualInt = mat1.getNumRows();
        expectedInt = 1000;
        if (actualInt == expectedInt){
            System.out.println("Test number 16 tests the getNumRows method. Testing if mat1 getNumRows is correct.. The test passed");
        }
        else{
            System.out.println("Test number 16 tests the getNumRows method. Testing if mat1 getNumRows is correct.. The test failed");
        }

        // test 17, getNumCols
        data1 = new int[][]{{}};
        int h = data1[0].length;
        mat1 = new MathMatrix(data1);
        actualInt = mat1.getNumColumns();
        expectedInt = 0;
        if (actualInt == expectedInt){
            System.out.println("Test number 17 tests the getNumCols method. Testing if mat1 getNumCols is correct.. The test passed");
        }
        else{
            System.out.println("Test number 17 tests the getNumCols method. Testing if mat1 getNumCols is correct.. The test failed");
        }

        // test 18, getNumCols
        mat1 = new MathMatrix(2, 10000, 0);
        actualInt = mat1.getNumColumns();
        expectedInt = 10000;
        if (actualInt == expectedInt){
            System.out.println("Test number 18 tests the getNumCols method. Testing if mat1 getNumCols is correct.. The test passed");
        }
        else{
            System.out.println("Test number 18 tests the getNumCols method. Testing if mat1 getNumCols is correct.. The test failed");
        }

        // test 19, getVal
        data1 = new int[][] { {3795, 10923, 8092, 85, 2890, 91872}, {20985, 1982, 89035, 18907, 89053, 7819}, {7928, 7534, 7892, 923, 7284, 132} };
        mat1 = new MathMatrix(data1);
        actualInt = mat1.getVal(1, 4);
        expectedInt = 89053;
        if (actualInt == expectedInt){
            System.out.println("Test number 19 tests the getVal method. Testing if mat1 getVal is correct.. The test passed");
        }
        else{
            System.out.println("Test number 19 tests the getVal method. Testing if mat1 getVal is correct.. The test failed");
        }

        // test 20, getVal
        data1 = new int[][] { {-700, -4755, -2442, -11456}, {9527, -66, 1716, 2642} };
        mat1 = new MathMatrix(data1);
        actualInt = mat1.getVal(0, 3);
        expectedInt = -11456;
        if (actualInt == expectedInt){
            System.out.println("Test number 20 tests the getVal method. Testing if mat1 getVal is correct.. The test passed");
        }
        else{
            System.out.println("Test number 20 tests the getVal method. Testing if mat1 getVal is correct.. The test failed");
        }

        // test 21, isUpperTriangular
        mat1 = new MathMatrix(100, 100, 0);
        actualBoolean = mat1.isUpperTriangular();
        expectedBoolean = true;
        if (actualBoolean == expectedBoolean){
            System.out.println("Test number 21 tests the isUpperTriangular method. Testing if mat1 isUpperTriangular is correct.. The test passed");
        }
        else{
            System.out.println("Test number 21 tests the isUpperTriangular method. Testing if mat1 isUpperTriangular is correct.. The test failed");
        }

        // test 22, isUpperTriangular
        data1 = new int[][] { {-700, -4755, -2442, -11456}, {0, 577, 346, 2642}, {0, 0, 346, 2642}, {0, 0, 0, 2642} };
        mat1 = new MathMatrix(data1);
        actualBoolean = mat1.isUpperTriangular();
        expectedBoolean = true;
        if (actualBoolean == expectedBoolean){
            System.out.println("Test number 22 tests the isUpperTriangular method. Testing if mat1 isUpperTriangular is correct.. The test passed");
        }
        else{
            System.out.println("Test number 22 tests the isUpperTriangular method. Testing if mat1 isUpperTriangular is correct.. The test failed");
        }

        // test 23, isUpperTriangular
        data1 = new int[][] { {-700, -4755, -2442, -11456}, {0, 577, 346, 2642}, {0, 0, 346, 2642}, {0, 0, 2642, 2642}};
        mat1 = new MathMatrix(data1);
        actualBoolean = mat1.isUpperTriangular();
        expectedBoolean = false;
        if (actualBoolean == expectedBoolean){
            System.out.println("Test number 23 tests the isUpperTriangular method. Testing if mat1 isUpperTriangular is correct.. The test passed");
        }
        else{
            System.out.println("Test number 23 tests the isUpperTriangular method. Testing if mat1 isUpperTriangular is correct.. The test failed");
        }
        // CS314 Students. When ready delete the above tests
        // and add your 22 tests here.
    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        }
        int result = 0;
        final int ROWS =  mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
                                       int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        } else if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum,
                                        String testingWhat) {
        System.out.print("Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if  ((m == null) || (m.getNumRows() == 0)
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException("Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for(int r = 0; r < result.length; r++) {
            for(int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if((data1 == null) || (data1.length == 0)
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                ||  (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException( "Violation of precondition: " +
                    "equals check on 2d arrays of ints");
        }
        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null"
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }

//    private static void experiments(){
//        Stopwatch st = new Stopwatch();
//        int rows = 10000;
//        int cols = 10000;
//        int[][] array1 = new int[rows][cols];
//        int[][] array2 = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                array1[i][j] = (int) (Math.random() * 10);
//                array2[i][j] = (int) (Math.random() * 10);
//            }
//        }
//        MathMatrix matrix1 = new MathMatrix(array1);
//        MathMatrix matrix2 = new MathMatrix(array2);
//
//        st.start();
//        for(int i = 0; i < 700; i++){
//            matrix1.add(matrix2);
//        }
//        st.stop();
//        System.out.println(st.toString());
//        st.start();
//        for(int i = 0; i < 1400; i++){
//            matrix1.add(matrix2);
//        }
//        st.stop();
//        System.out.println(st.toString());
//        st.start();
//        for(int i = 0; i < 2800; i++){
//            matrix1.add(matrix2);
//        }
//        st.stop();
//        System.out.println(st.toString());
//        st.start();
//        for(int i = 0; i < 300; i++){
//            matrix1.multiply(matrix2);
//        }
//        st.stop();
//        System.out.println(st.toString());
//        st.start();
//        for(int i = 0; i < 600; i++){
//            matrix1.multiply(matrix2);
//        }
//        st.stop();
//        System.out.println(st.toString());
//    }
}
