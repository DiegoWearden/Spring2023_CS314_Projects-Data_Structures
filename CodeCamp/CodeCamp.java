//  CodeCamp.java - CS314 Assignment 1

/*  Student information for assignment:
 *
 *  replace <NAME> with your name.
 *
 *  On my honor, Diego Wearden, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Diego Wearden
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  Section 5 digit ID: 52045
 *  Grader name: Emma
 *  Number of slip days used on this assignment: 0
 */

import java.util.Arrays;

public class CodeCamp {

    /**
     * Determine the Hamming distance between two arrays of ints.
     * Neither the parameter <tt>aData</tt> or
     * <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null, aData.length == aData.length
     * @param bData != null
     * @return the Hamming Distance between the two arrays of ints.
     */
    public static int hammingDistance(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null || aData.length != bData.length) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "hammingDistance. neither parameter may equal null, arrays" +
                    " must be equal length.");
        }

        int hammingDistance = 0;
        for (int i = 0; i < aData.length; i++){
            if (aData[i] != bData[i]){
                hammingDistance++;
            }
        }
        return hammingDistance;

    }


    /**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>aData</tt> or
     * the parameter <tt>bData</tt> are altered as a result of this method.<br>
     * @param aData != null
     * @param bData != null
     * @return <tt>true</tt> if aData is a permutation of bData,
     * <tt>false</tt> otherwise
     *
     */
    public static boolean isPermutation(int[] aData, int[] bData) {
        // check preconditions
        if (aData == null || bData == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isPermutation. neither parameter may equal null.");
        }
        if (aData.length != bData.length){
            return false;
        }
        for (int i = 0; i < aData.length; i++){
            int frequencyA = getFrequency(aData, aData, i);
            int frequencyB = getFrequency(aData, bData, i);
            if(frequencyA != frequencyB){
                return false;
            }
        }
        return true;
    }

    private static int getFrequency(int[] aData, int[] bData, int i){
        int num = aData[i];
        int frequency = 0;
        for (int j = 0; j < aData.length; j++){
            if (num == bData[j]){
                frequency++;
            }
        }
        return frequency;
    }


    /**
     * Determine the index of the String that
     * has the largest number of vowels.
     * Vowels are defined as <tt>'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o',
     * 'U', and 'u'</tt>.
     * The parameter <tt>arrayOfStrings</tt> is not altered as a result of this method.
     * <p>pre: <tt>arrayOfStrings != null</tt>, <tt>arrayOfStrings.length > 0</tt>,
     * there is an least 1 non null element in arrayOfStrings.
     * <p>post: return the index of the non-null element in arrayOfStrings that has the
     * largest number of characters that are vowels.
     * If there is a tie return the index closest to zero.
     * The empty String, "", has zero vowels.
     * It is possible for the maximum number of vowels to be 0.<br>
     * @param arrayOfStrings the array to check
     * @return the index of the non-null element in arrayOfStrings that has
     * the largest number of vowels.
     */
    public static int mostVowels(String[] arrayOfStrings) {
        // check preconditions
        if (arrayOfStrings == null || arrayOfStrings.length == 0
                || !atLeastOneNonNull(arrayOfStrings)) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "mostVowels. parameter may not equal null and must contain " +
                    "at least one none null value.");
        }

        String vowels = "AEIOU";
        int index = 0;
        int max = -1;
        for (int i = 0; i < arrayOfStrings.length; i++){
            int numVowels = 0;
            if (arrayOfStrings[i] != null){
                for (int j = 0; j < arrayOfStrings[i].length(); j++){
                    for (int k = 0; k < vowels.length(); k++){
                        if (arrayOfStrings[i].toUpperCase().charAt(j) == vowels.charAt(k)){
                            numVowels++;
                        }
                    }
                }
                if (numVowels > max){
                    max = numVowels;
                    index = i;
                }
            }
        }
        return index;
    }



    /**
     * Perform an experiment simulating the birthday problem.
     * Pick random birthdays for the given number of people.
     * Return the number of pairs of people that share the
     * same birthday.<br>
     * @param numPeople The number of people in the experiment.
     * This value must be > 0
     * @param numDaysInYear The number of days in the year for this experiement.
     * This value must be > 0
     * @return The number of pairs of people that share a birthday
     * after running the simulation.
     */
    public static int sharedBirthdays(int numPeople, int numDaysInYear) {
        // check preconditions
        if (numPeople <= 0 || numDaysInYear <= 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "sharedBirthdays. both parameters must be greater than 0. " +
                    "numPeople: " + numPeople +
                    ", numDaysInYear: " + numDaysInYear);
        }

        int pairs = 0;
        int[] count = new int[numDaysInYear];
        for (int i = 0; i < numPeople; i++){
            int randomBirthday = (int) (Math.random() * (numDaysInYear));
            count[randomBirthday]++;
        }

        for (int i = 0; i < count.length; i++){
            int numBirthdaysOnDay = count[i];
            pairs += (numBirthdaysOnDay * (numBirthdaysOnDay - 1))/2;
        }

        return pairs;
    }

    /**
     * Determine if the chess board represented by board is a safe set up.
     * <p>pre: board != null, board.length > 0, board is a square matrix.
     * (In other words all rows in board have board.length columns.),
     * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
     * represent open spaces.<br>
     * <p>post: return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     * the parameter <tt>board</tt> is not altered as a result of
     * this method.<br>
     * @param board the chessboard
     * @return true if the configuration of board is safe,
     * that is no queen can attack any other queen on the board.
     * false otherwise.
     */
    public static boolean queensAreSafe(char[][] board) {
        char[] validChars = {'q', '.'};
        // check preconditions
        if (board == null || board.length == 0 || !isSquare(board)
                || !onlyContains(board, validChars)) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "queensAreSafe. The board may not be null, must be square, " +
                    "and may only contain 'q's and '.'s");
        }

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] == 'q' && !safeQueen(board, r, c)){
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * checks if a queen is safe or not
     * @param board
     * @param r
     * @param c
     * @return true if queen is safe, false if not
     */
    private static boolean safeQueen(char[][] board, int r, int c) {
        int numDirections = 8;
        int[] rowDirections = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
        int[] columnDirections = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        for (int i = 0; i < numDirections; i++){
            int j = 1;
            int rowDirectionToCheck = rowDirections[i];
            int columnDirectionToCheck = columnDirections[i];
            boolean inBoard = true;
            while(inBoard){
                int rowToCheck = (r + (j * rowDirectionToCheck));
                int columnToCheck = (c + (j * columnDirectionToCheck));
                inBoard = checkIfInBoard(rowToCheck, columnToCheck, board);
                if (inBoard){
                    if (board[rowToCheck][columnToCheck] == 'q'){
                        return false;
                    }
                    else{
                        j++;
                    }
                }
            }
        }
        return true;
    }

    /**
     * checks if next spot to check is a place on the board
     * @param rowToCheck
     * @param columnToCheck
     * @param board
     * @return true if next checking spot exist on board fasle if not
     */
    private static boolean checkIfInBoard(int rowToCheck, int columnToCheck, char[][] board) {
        return (rowToCheck < board.length && rowToCheck >= 0)
                && (columnToCheck < board.length && columnToCheck >= 0);
    }


    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectangle must be at least 1 by 1.
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.<br>
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.
     */
    public static int getValueOfMostValuablePlot(int[][] city) {
        // check preconditions
        if (city == null || city.length == 0 || city[0].length == 0
                || !isRectangular(city) ) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "getValueOfMostValuablePlot. The parameter may not be null," +
                    " must value at least one row and at least" +
                    " one column, and must be rectangular.");
        }

        int max = city[0][0];
        int sum = 0;
        for (int upperLeftRow = 0; upperLeftRow < city.length; upperLeftRow++){
            for (int upperLeftColumn = 0; upperLeftColumn < city[0].length; upperLeftColumn++){
                for (int lowerRightRow = 0; lowerRightRow < city.length; lowerRightRow++){
                    for (int lowerRightColumn = 0; lowerRightColumn < city[0].length; lowerRightColumn++){
                        for (int row = upperLeftRow; row <= lowerRightRow; row++){
                            for (int column = upperLeftColumn; column <= lowerRightColumn; column++){
                                sum += city[row][column];
                                if (sum > max){
                                    max = sum;
                                }
                            }
                        }
                        sum = 0;
                    }
                }
            }
        }
        return max;
    }


    // !!!!! ***** !!!!! ***** !!!!! ****** !!!!! ****** !!!!! ****** !!!!!!
    // CS314 STUDENTS: Put your birthday problem experiment code here:

    /**
     * gets the average number of pairs of people with shared birthdays
     * @param numPeople
     * @param numDaysInYear
     * @param numExperiments
     */
    public static void getAverage(int numPeople, int numDaysInYear, int numExperiments) {
        int total = 0;
        for (int i = 0; i < numExperiments; i++) {
            total += sharedBirthdays(numPeople, numDaysInYear);
        }
        System.out.println();
        System.out.println("Average: " + (double) total / numExperiments);
    }

    /**
     * gets the percentage of pairs of people with shared birthdays
     * @param numPeople
     * @param numDaysInYear
     * @param numExperiments
     */
    public static void getPercentage(int numPeople, int numDaysInYear, int numExperiments){
        int numPairs;
        int experimentWithPair = 0;
        for (int i = 0; i < numExperiments; i++){
            numPairs = sharedBirthdays(numPeople, numDaysInYear);
            if (numPairs > 0){
                experimentWithPair++;
            }
        }
        System.out.println();
        System.out.println("Num people: " + numPeople + ", number of " +
                "experiments with one or more shared birthday: " + experimentWithPair +
                ", percentage: " + ((double) experimentWithPair/numExperiments) * 100);
    }


    /*
     * pre: arrayOfStrings != null
     * post: return true if at least one element in arrayOfStrings is
     * not null, otherwise return false.
     */
    private static boolean atLeastOneNonNull(String[] arrayOfStrings) {
        // check precondition
        if (arrayOfStrings == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "atLeastOneNonNull. parameter may not equal null.");
        }
        boolean foundNonNull = false;
        int i = 0;
        while( !foundNonNull && i < arrayOfStrings.length ) {
            foundNonNull = arrayOfStrings[i] != null;
            i++;
        }
        return foundNonNull;
    }


    /*
     * pre: mat != null
     * post: return true if mat is a square matrix, false otherwise
     */
    private static boolean isSquare(char[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isSquare. Parameter may not be null.");
        }
        final int numRows = mat.length;
        int row = 0;
        boolean isSquare = true;
        while (isSquare && row < numRows) {
            isSquare = ( mat[row] != null) && (mat[row].length == numRows);
            row++;
        }
        return isSquare;
    }


    /*
     * pre: mat != null, valid != null
     * post: return true if all elements in mat are one of the
     * characters in valid
     */
    private static boolean onlyContains(char[][] mat, char[] valid) {
        // check preconditions
        if (mat == null || valid == null) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "onlyContains. Parameters may not be null.");
        }
        String validChars = new String(valid);
        int row = 0;
        boolean onlyContainsValidChars = true;
        while (onlyContainsValidChars && row < mat.length) {
            int col = 0;
            while(onlyContainsValidChars && col < mat[row].length) {
                int indexOfChar = validChars.indexOf(mat[row][col]);
                onlyContainsValidChars = indexOfChar != -1;
                col++;
            }
            row++;
        }
        return onlyContainsValidChars;
    }


    /*
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        // check preconditions
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Violation of precondition: " +
                    "isRectangular. Parameter may not be null and must contain" +
                    " at least one row.");
        }
        boolean correct = mat[0] != null;
        int row = 0;
        while(correct && row < mat.length) {
            correct = (mat[row] != null)
                    && (mat[row].length == mat[0].length);
            row++;
        }
        return correct;
    }

    // make constructor private so no instances of CodeCamp can not be created
    private CodeCamp() {

    }
}