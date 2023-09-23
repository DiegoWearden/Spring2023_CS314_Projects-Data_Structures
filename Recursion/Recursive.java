/*  Student information for assignment:
 *
 *  On My honor, Diego Wearden,
 *  this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used: 0
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID: Diego Wearden
 *  email address: dialwera@gmail.com
 *  Grader name: Lilly Tian
 *  Section number: 52085
 *
 */


//imports

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

/**
 * Various recursive methods to be implemented.
 * Given shell file for CS314 assignment.
 */
public class Recursive {

    /**
     * Problem 1: convert a base 10 int to binary recursively.
     *   <br>pre: n != Integer.MIN_VALUE<br>
     *   <br>post: Returns a String that represents N in binary.
     *   All chars in returned String are '1's or '0's.
     *   Most significant digit is at position 0
     *   @param n the base 10 int to convert to base 2
     *   @return a String that is a binary representation of the parameter n
     */
    public static String getBinary(int n) {
        if (n == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "getBinary. n cannot equal "
                    + "Integer.MIN_VALUE. n: " + n);
        }
        String binary = "";
        boolean negative = n < 0;
        if (n > 1 || n < -1){
            binary = negative ? getBinary(-n/2) : getBinary(n/2);
        }
        return negative ? "-" + binary + -(n % 2) : binary + (n % 2);
    }


    /**
     * Problem 2: reverse a String recursively.<br>
     *   pre: stringToRev != null<br>
     *   post: returns a String that is the reverse of stringToRev
     *   @param stringToRev the String to reverse.
     *   @return a String with the characters in stringToRev
     *   in reverse order.
     */
    public static String revString(String stringToRev) {
        if (stringToRev == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "revString. parameter may not be null.");
        }
        if (stringToRev.length() == 0) { // base case
            return stringToRev;
        } else {
            return revString(stringToRev.substring(1)) + stringToRev.charAt(0);
        }
    }

    /**
     * Problem 3: Returns the number of elements in data
     * that are followed directly by value that is
     * double that element.
     * pre: data != null
     * post: return the number of elements in data
     * that are followed immediately by double the value
     * @param data The array to search.
     * @return The number of elements in data that
     * are followed immediately by a value that is double the element.
     */
    public static int nextIsDouble(int[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "revString. parameter may not be null.");
        }
        return countDoubles(data, 0);
    }

    /**
     * Recursively counts the number of elements in data that are followed immediately
     * by a value that is double the element.
     * @param data The array to search.
     * @param pos The current position in the array.
     * @return The number of elements in data that are followed immediately by a value
     * that is double the element.
     */
    private static int countDoubles(int[] data, int pos){
        if (pos >= data.length - 1){
            return 0;
        }
        if(data[pos] * 2 == data[pos + 1]){
            return 1 + countDoubles(data, pos + 1);
        }
        else {
            return countDoubles(data, pos + 1);
        }
    }

    /**  Problem 4: Find all combinations of mnemonics
     * for the given number.<br>
     *   pre: number != null, number.length() > 0,
     *   all characters in number are digits<br>
     *   post: see tips section of assignment handout
     *   @param number The number to find mnemonics for
     *   @return An ArrayList<String> with all possible mnemonics
     *   for the given number
     */
    public static ArrayList<String> listMnemonics(String number) {
        if (number == null ||  number.length() == 0 || !allDigits(number)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "listMnemonics");
        }

        ArrayList<String> results = new ArrayList<>(); // to store the mnemonics
        recursiveMnemonics(results, "", number);
        return results;
    }


    /*
     * Helper method for listMnemonics
     * mnemonics stores completed mnemonics
     * mneominicSoFar is a partial (possibly complete) mnemonic
     * digitsLeft are the digits that have not been used
     * from the original number.
     */
    private static void recursiveMnemonics(ArrayList<String> mnemonics,
                    String mnemonicSoFar, String digitsLeft) {
        if (digitsLeft.isEmpty()){
            mnemonics.add(mnemonicSoFar);
        }
        else{
            char digit = digitsLeft.charAt(0);
            String letters = digitLetters(digit);
            // recursively call the recursiveMnemonics method for
            // each letter for all combinations
            for(char c : letters.toCharArray()){
                recursiveMnemonics(mnemonics, mnemonicSoFar + c,
                        digitsLeft.substring(1));
            }
        }
    }

    /* Static code blocks are run once when this class is loaded. 
     * Here we create an unmoddifiable list to use with the phone 
     * mnemonics method.
     */
    private static final List<String> LETTERS_FOR_NUMBER;
    static {
        String[] letters = {"0", "1", "ABC",
                "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        ArrayList<String> lettersAsList = new ArrayList<>();
        for (String s : letters) {
            lettersAsList.add(s);
        }
        LETTERS_FOR_NUMBER = Collections.unmodifiableList(lettersAsList);

    }
    // used by method digitLetters
     


    /* helper method for recursiveMnemonics
     * pre: ch is a digit '0' through '9'
     * post: return the characters associated with
     * this digit on a phone keypad
     */
    private static String digitLetters(char ch) {
        if (ch < '0' || ch > '9') {
            throw new IllegalArgumentException("parameter "
                    + "ch must be a digit, 0 to 9. Given value = " + ch);
        }
        int index = ch - '0';
        return LETTERS_FOR_NUMBER.get(index);
    }


    /* helper method for listMnemonics
     * pre: s != null
     * post: return true if every character in s is
     * a digit ('0' through '9')
     */
    private static boolean allDigits(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "allDigits. String s cannot be null.");
        }
        boolean allDigits = true;
        int i = 0;
        while (i < s.length() && allDigits) {
            allDigits = s.charAt(i) >= '0' && s.charAt(i) <= '9';
            i++;
        }
        return allDigits;
    }


    /**
     * Problem 5: Draw a Sierpinski Carpet.
     * @param size the size in pixels of the window
     * @param limit the smallest size of a square in the carpet.
     */
    public static void drawCarpet(int size, int limit) {
        DrawingPanel p = new DrawingPanel(size, size);
        Graphics g = p.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,size,size);
        g.setColor(Color.WHITE);
        drawSquares(g, size, limit, 0, 0);
    }


    /* Helper method for drawCarpet
     * Draw the individual squares of the carpet.
     * @param g The Graphics object to use to fill rectangles
     * @param size the size of the current square
     * @param limit the smallest allowable size of squares
     * @param x the x coordinate of the upper left corner of the current square
     * @param y the y coordinate of the upper left corner of the current square
     */
    private static void drawSquares(Graphics g, int size, int limit, double x, double y) {
        // base case: if the size of the square is smaller than or equal to the limit, stop
        if (size > limit) {
            // calculate the size of each smaller square
            int numRowsAndCols = 3;
            int smallerSize = size / numRowsAndCols;

            // draw the middle square
            g.fillRect((int) (x + smallerSize), (int) (y + smallerSize), smallerSize, smallerSize);

            // draw squares around middle recursively
            for (int i = 0; i < numRowsAndCols; i++) {
                for (int j = 0; j < numRowsAndCols; j++) {
                    if (i != 1 || j != 1){
                        drawSquares(g, smallerSize, limit, x +
                                (smallerSize * i), y + (smallerSize * j));
                    }
                }
            }
        }
    }


    /**
     * Problem 6: Determine if water at a given point
     * on a map can flow off the map.
     * <br>pre: map != null, map.length > 0,
     * map is a rectangular matrix, 0 <= row < map.length,
     * 0 <= col < map[0].length
     * <br>post: return true if a drop of water starting at the location
     * specified by row, column can reach the edge of the map,
     * false otherwise.
     * @param map The elevations of a section of a map.
     * @param row The starting row of a drop of water.
     * @param col The starting column of a drop of water.
     * @return return true if a drop of water starting at the location
     * specified by row, column can reach the edge of the map, false otherwise.
     */
    public static boolean canFlowOffMap(int[][] map, int row, int col) {
        if (map == null || map.length == 0 || !isRectangular(map)
                || !inbounds(row, col, map)) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "canFlowOffMap");
        }
        int currentElevation = map[row][col];
        if (row == 0 || col == 0 || row == map.length - 1 || col == map[0].length - 1) {
            return true;
        }
        int [][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // if the occurrence of the position after it returns true, return true
            if (currentElevation > map[newRow][newCol] && canFlowOffMap(map, newRow, newCol)){
                return true;
            }
        }
        return false;
    }

    /* helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null,
     */
    private static boolean inbounds(int r, int c, int[][] mat) {
        if (mat == null) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null.");
        }
        return r >= 0 && r < mat.length && mat[r] != null
                && c >= 0 && c < mat[r].length;
    }

    /*
     * helper method for canFlowOfMap - CS314 students you should not have to
     * call this method,
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null "
                    + "and must have at least 1 row.");
        }
        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while (correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }


    /**
     * Problem 7: Find the minimum difference possible between teams
     * based on ability scores. The number of teams may be greater than 2.
     * The goal is to minimize the difference between the team with the
     * maximum total ability and the team with the minimum total ability.
     * <br> pre: numTeams >= 2, abilities != null, abilities.length >= numTeams
     * <br> post: return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability.
     * @param numTeams the number of teams to form.
     * Every team must have at least one member
     * @param abilities the ability scores of the people to distribute
     * @return return the minimum possible difference between the team
     * with the maximum total ability and the team with the minimum total
     * ability. The return value will be greater than or equal to 0.
     */
    public static int minDifference(int numTeams, int[] abilities) {
        if (numTeams < 2 || abilities == null || abilities.length < numTeams){
            throw new IllegalArgumentException("number of teams must be >= 2, " +
                    "array of abilities must not be null, abilities.length must be >= numTeams");
        }
        int[] teamAbilities = new int[numTeams];
        return assignTeams(0, abilities, teamAbilities);
    }

    /**
     * Recursive method to assign players to teams and calculate the minimum difference between the maximum and minimum
     * abilities of each team.
     * @param index the index of the player being assigned to a team
     * @param abilities an array containing the abilities of all players
     * @param teamAbilities an array containing the abilities of each team
     * @return the minimum difference between the maximum and minimum abilities of each team
     */
    private static int assignTeams(int index, int[] abilities, int[] teamAbilities) {
        if (index == abilities.length){
            for (int teamAbility : teamAbilities) {
                if (teamAbility == 0) {
                    return Integer.MAX_VALUE; // invalid set
                }
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int teamAbility : teamAbilities) {
                max = Math.max(teamAbility, max); // valid set
                min = Math.min(teamAbility, min);
            }
            return max-min;
        }

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < teamAbilities.length; i++){
            teamAbilities[i] += abilities[index];
            int difference = assignTeams(index + 1, abilities, teamAbilities);
            // if set invalid, you will compare max value with max value
            minDifference = Math.min(minDifference, difference);
            teamAbilities[i] -= abilities[index];
        }
        return minDifference;
    }


    /**
     * Problem 8: Maze solver.
     * <br>pre: board != null
     * <br>pre: board is a rectangular matrix
     * <br>pre: board only contains characters 'S', 'E', '$', 'G', 'Y', and '*'
     * <br>pre: there is a single 'S' character present
     * <br>post: rawMaze is not altered as a result of this method.
     * Return 2 if it is possible to escape the maze after
     * collecting all the coins.
     * Return 1 if it is possible to escape the maze
     * but without collecting all the coins.
     * Return 0 if it is not possible
     * to escape the maze. More details in the assignment handout.
     * @param rawMaze represents the maze we want to escape.
     * rawMaze is not altered as a result of this method.
     * @return per the post condition
     */
    public static int canEscapeMaze(char[][] rawMaze) {
        int[] start = findStart(rawMaze);
        if (!isValidMaze(start, rawMaze)){
            throw new IllegalArgumentException("Failed precondition: must have a start, " +
                    "contain valid chars, and be rectangular");
        }
        int numCoins = countCoins(rawMaze);
        return findEscape(rawMaze, start, numCoins, 0);
    }

    /**
     *
     * @param start the starting coordinates of the maze
     * @param rawMaze the maze itself represented in a 2d array of chars
     * @return true if maze is valid false if not
     */
    private static boolean isValidMaze(int[] start, char[][] rawMaze){
        return start != null && containsValidCharacters(rawMaze) && isRectangular(rawMaze);
    }

    /**
     * This method checks whether the given maze contains only the valid characters,
     * i.e., 'S', 'E', '$', 'G', 'Y', and '*'.
     * Pre-conditions: maze != null
     * Post-conditions: The method returns true if the maze contains only valid characters; false otherwise.
     * @param maze the maze to check
     * @return true if the maze contains only valid characters; false otherwise.
     */
    public static boolean containsValidCharacters(char[][] maze) {
        // Use HashSet to reduce time complexity from O(N^3) to O(n^2)
        Set<Character> validChars = new HashSet<>(Arrays.asList('S', '*', 'G', 'Y', '$', 'E'));
        for (char[] chars : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                if (!validChars.contains(chars[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * helper method for mazeSolver
     * pre: mat != null, mat.length > 0
     * post: return true if mat is rectangular
     */
    private static boolean isRectangular(char[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("Failed precondition: "
                    + "inbounds. The 2d array mat may not be null "
                    + "and must have at least 1 row.");
        }
        boolean correct = true;
        final int numCols = mat[0].length;
        int row = 0;
        while (correct && row < mat.length) {
            correct = (mat[row] != null) && (mat[row].length == numCols);
            row++;
        }
        return correct;
    }

    /**
     * findEscape is a recursive method that finds the escape path in a given maze.
     * @param rawMaze 2D array of chars
     * @param start starting coordinates (array of size two of ints of row and collumn of starting point)
     * @param numCoins number of coins required to win
     * @param coins the number of coins currently collected
     * @return It returns an integer value which represents
     * the status of the path. (2 for win, 1 for path found, 0 for dead end)
     */
    private static int findEscape(char[][] rawMaze, int[] start, int numCoins, int coins) {
        // Create a copy of the maze to modify the visited positions
        char[][] updatedMaze = getUpdatedMaze(rawMaze);
        int result = 0;
        int row = start[0];
        int col = start[1];
        if (row < 0 || row > updatedMaze.length - 1 || col < 0 || col > updatedMaze[0].length - 1 || updatedMaze[row][col] == '*'){
            return 0;
        }
        else if (updatedMaze[row][col] == 'E'){
            return coins == numCoins ? 2 : 1;
        }
        else {
            coins += updateMaze(updatedMaze, row, col);
        }
        int [][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // Iterate over the directions and recursively call
        // the findEscape method for each new position
        for (int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            int[] newStart = new int[]{newRow, newCol};
            // Recursively call the findEscape method for
            // the new position and if it finds an exit store the result
            int escape = findEscape(updatedMaze, newStart, numCoins, coins);
            if (escape == 2){
                return 2;
            }
            // if result is 1, will store value instead of return in case of better route
            if (escape == 1){
                result = 1;
            }
        }
        return result;
    }

    /**
     * Updates the maze and returns a coin count if a coin was found in the
     * row and col of the maze
     * @param updatedMaze the updated maze being passed through
     * @param row the row of the 2d array chars
     * @param col the column of the 2d array chars
     * @return the number of coins that was found if any
     */
    private static int updateMaze(char[][] updatedMaze, int row, int col) {
        if (updatedMaze[row][col] == '$') {
            updatedMaze[row][col] = 'Y';
            return 1;
        }
        else if (updatedMaze[row][col] == 'G') {
            updatedMaze[row][col] = 'Y';
        }
        else if (updatedMaze[row][col] == 'S') {
            updatedMaze[row][col] = 'G';
        }
        else if (updatedMaze[row][col] == 'Y') {
            updatedMaze[row][col] = '*';
        }
        return 0;
    }

    /**
     * getUpdatedMaze is a helper method that creates a deep copy of the raw maze.
     * @param rawMaze It takes in a 2D character array (the raw maze).
     * @return It returns a new 2D character array (a copy of the raw maze).
     */
    private static char[][] getUpdatedMaze(char[][] rawMaze) {
        char[][] result = new char[rawMaze.length][rawMaze[0].length];
        for (int i = 0; i < rawMaze.length; i++){
            for (int j = 0; j < rawMaze[0].length; j++){
                result[i][j] = rawMaze[i][j];
            }
        }
        return result;
    }

    /**
     * countCoins is a helper method that counts the number of coins in the given maze.
     * @param maze It takes in a 2D character array (the maze).
     * @return It returns an integer value (the count of coins).
     */
    private static int countCoins(char[][] maze) {
        int count = 0;
        for (char[] chars : maze) {
            for (int j = 0; j < maze[0].length; j++) {
                if (chars[j] == '$') {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * findStart is a helper method that finds the starting point in the given maze.
     * @param maze 2D character array (the maze).
     * @return It returns an integer array that contains the starting coordinates (row, column).
     * If the starting point is not found, it returns null.
     */
    private static int[] findStart(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}