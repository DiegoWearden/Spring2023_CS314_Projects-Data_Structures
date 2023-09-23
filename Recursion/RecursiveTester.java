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


import java.util.ArrayList;
import java.util.Collections;

/**
 * Tester class for the methods in Recursive.java
 * @author scottm
 *
 */
public class RecursiveTester {

    // run the tests
    public static void main(String[] args) {
        studentTests();
    }

    // post: run student test
    private static void studentTests() {
        System.out.println("*I used the methods already in place when making my own tests for mazeSolver, canFlowOffMap, and minDifference*");
        System.out.println("Test getBinary");
        int num = 0;
        String actualBinary = Recursive.getBinary(num);
        String expectedBinary = "0";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test for zero passed. get binary.");
        } else {
            System.out.println("Test for zero failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        num = -13;
        actualBinary = Recursive.getBinary(num);
        expectedBinary = "-1101";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test for negative numbers passed. get binary.");
        } else {
            System.out.println("Test for negative numbers failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        num = 123456;
        actualBinary = Recursive.getBinary(num);
        expectedBinary = "11110001001000000";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test for large positive number passed. get binary.");
        } else {
            System.out.println("Test for large positive number failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        num = Integer.MAX_VALUE;
        actualBinary = Recursive.getBinary(num);
        expectedBinary = "1111111111111111111111111111111";
        if (actualBinary.equals(expectedBinary)) {
            System.out.println("Test for largest possible positive number passed. get binary.");
        } else {
            System.out.println("Test for largest possible positive number failed. get binary. expected: "
                    + expectedBinary + ", actual: " + actualBinary);
        }

        System.out.println();
        System.out.println("Test revString");
        String str = "";
        String actualRev = Recursive.revString(str);
        String expectedRev = "";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test for empty string passed. reverse string.");
        } else {
            System.out.println("Test for empty string failed. reverse string. expected: " +
                    expectedRev + ", actual: " + actualRev);
        }

        str = "a";
        actualRev = Recursive.revString(str);
        expectedRev = "a";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test for single character string passed. reverse string.");
        } else {
            System.out.println("Test for single character string failed. reverse string. expected: " +
                    expectedRev + ", actual: " + actualRev);
        }

        str = "hello world";
        actualRev = Recursive.revString(str);
        expectedRev = "dlrow olleh";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test for string with spaces passed. reverse string.");
        } else {
            System.out.println("Test for string with spaces failed. reverse string. expected: " +
                    expectedRev + ", actual: " + actualRev);
        }

        str = "a@b#c$d%e^f&g*h(i)j";
        actualRev = Recursive.revString(str);
        expectedRev = "j)i(h*g&f^e%d$c#b@a";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test for string with special characters passed. reverse string.");
        } else {
            System.out.println("Test for string with special characters failed. reverse string. expected: " +
                    expectedRev + ", actual: " + actualRev);
        }

        str = "racecar";
        actualRev = Recursive.revString(str);
        expectedRev = "racecar";
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test for palindrome string passed. reverse string.");
        } else {
            System.out.println("Test for palindrome string failed. reverse string. expected: " +
                    expectedRev + ", actual: " + actualRev);
        }

        String longString = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(longString);
        }
        actualRev = Recursive.revString(sb.toString());
        StringBuilder expectedSb = new StringBuilder(sb.toString());
        expectedRev = expectedSb.reverse().toString();
        if (actualRev.equals(expectedRev)) {
            System.out.println("Test for very long string passed. reverse string.");
        } else {
            System.out.println("Test for very long string failed. reverse string. expected: "
                    + expectedRev + ", actual: " + actualRev);
        }

        System.out.println();
        System.out.println("Test nextIsDouble");
        int[] numsForDouble = {};
        int actualDouble = Recursive.nextIsDouble(numsForDouble);
        int expectedDouble = 0;
        if (actualDouble == expectedDouble) {
            System.out.println("Test for empty array passed. next is double.");
        } else {
            System.out.println("Test for empty array failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[]{1};
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if (actualDouble == expectedDouble) {
            System.out.println("Test for array with only one element passed. next is double.");
        } else {
            System.out.println("Test for array with only one element failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512};
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 9;
        if (actualDouble == expectedDouble) {
            System.out.println("Test for array where the next double is the last element passed. next is double.");
        } else {
            System.out.println("Test for array where the next double is the last element failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        numsForDouble = new int[]{1, 3, 5, 7, 9, 11};
        actualDouble = Recursive.nextIsDouble(numsForDouble);
        expectedDouble = 0;
        if (actualDouble == expectedDouble) {
            System.out.println("Test for array where there is no next double passed. next is double.");
        } else {
            System.out.println("Test for array where there is no next double failed. next is double. expected: "
                    + expectedDouble + ", actual: " + actualDouble);
        }

        System.out.println();
        System.out.println("Test listMnemonics");
        ArrayList<String> mnemonics = Recursive.listMnemonics("7");
        Collections.sort(mnemonics);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("P");
        expected.add("Q");
        expected.add("R");
        expected.add("S");
        Collections.sort(expected);
        if (mnemonics.equals(expected)) {
            System.out.println("Test for Phone mnemonics with one digit passed.");
        } else {
            System.out.println("Test for Phone mnemonics with one digit failed.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + mnemonics);
        }

        mnemonics = Recursive.listMnemonics("678");
        expected.clear();
        expected.add("MPT");
        expected.add("MPU");
        expected.add("MPV");
        expected.add("MQT");
        expected.add("MQU");
        expected.add("MQV");
        expected.add("MRT");
        expected.add("MRU");
        expected.add("MRV");
        expected.add("MST");
        expected.add("MSU");
        expected.add("MSV");
        expected.add("NPT");
        expected.add("NPU");
        expected.add("NPV");
        expected.add("NQT");
        expected.add("NQU");
        expected.add("NQV");
        expected.add("NRT");
        expected.add("NRU");
        expected.add("NRV");
        expected.add("NST");
        expected.add("NSU");
        expected.add("NSV");
        expected.add("OPT");
        expected.add("OPU");
        expected.add("OPV");
        expected.add("OQT");
        expected.add("OQU");
        expected.add("OQV");
        expected.add("ORT");
        expected.add("ORU");
        expected.add("ORV");
        expected.add("OST");
        expected.add("OSU");
        expected.add("OSV");
        Collections.sort(expected);
        if (mnemonics.equals(expected)) {
            System.out.println("Test with 3 numbers passed");
        } else {
            System.out.println("Test with 3 numbers failed");
        }

        mnemonics = Recursive.listMnemonics("000111");
        expected.clear();
        expected.add("000111");
        if (mnemonics.equals(expected)) {
            System.out.println("Input contains only 0's and 1's passed. listMnemonics");
        } else {
            System.out.println("Input contains only 0's and 1's failed. listMnemonics");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + mnemonics);
        }

        System.out.println();
        System.out.println("Test canFlowOffMap");
        int testNum = 1;

        int[][] world = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                world[i][j] = 100;
            }
        }
        doOneFlowTest(world, 4, 4, false, testNum++);


        world = new int[][]{
                {100, 99, 200, 200, 200, 200, 200, 200, 200, 200},
                {2000, 98, 2000, 200, 200, 200, 200, 200, 200, 200},
                {2000, 97, 96, 200, 200, 200, 200, 200, 200, 200},
                {200, 2000, 95, 200, 200, 200, 85, 84, 83, 200},
                {200, 2000, 94, 93, 92, 200, 86, 2000, 82, 200},
                {200, 150, 200, 2000, 91, 200, 87, 2000, 81, 200},
                {200, 200, 200, 2000, 90, 89, 88, 2000, 80, 200},
                {200, 150, 100, 200, 200, 200, 200, 2000, 79, 200},
                {200, 200, 200, 200, 200, 200, 200, 2000, 78, 77},
                {200, 200, 200, 200, 200, 200, 200, 200, 2000, 76}
        };
        doOneFlowTest(world, 2, 2, true, testNum++);
        doOneFlowTest(world, 3, 0, true, testNum++);
        doOneFlowTest(world, 3, 1, true, testNum++);
        doOneFlowTest(world, 0, 0, true, testNum++);
        doOneFlowTest(world, 6, 1, false, testNum++);

        world = new int[][]{{100, 99, 200, 200, 200},
                {200, 2000, 200, 50, 200},
                {200, 2000, 80, 50, 200},
                {200, 50, 50, 2000, 200},
                {200, 2000, 200, 2000, 200},
                {200, 50, 200, 2000, 200},
                {200, 50, 200, 50, 50}};

        doOneFlowTest(world, 2, 2, false, testNum++);
        doOneFlowTest(world, 3, 0, true, testNum++);
        doOneFlowTest(world, 6, 1, true, testNum++);
        doOneFlowTest(world, 5, 2, false, testNum++);
        doOneFlowTest(world, 5, 3, true, testNum++);

        System.out.println();
        System.out.println("Test minDifference");
        testNum = 1;
        int[] abilities2 = {10, 10, 10, 10, 10, 10};
        showFairTeamsResults(Recursive.minDifference(3, abilities2), 0, testNum++);

        int[] abilities3 = {-5, 10, -3, 8, 2, 0, 7, -1};
        showFairTeamsResults(Recursive.minDifference(4, abilities3), 4, testNum++);

        int[] abilities4 = {-5, -10, -3, -8, -2, -7};
        showFairTeamsResults(Recursive.minDifference(3, abilities4), 1, testNum++);

        try {
            Recursive.minDifference(1, abilities4);
        } catch (IllegalArgumentException e) {
            System.out.println("test number " + testNum++ + " passed. numTeams must be >= 2.");
        }

        int[] abilities5 = {1, 2};
        try {
            Recursive.minDifference(3, abilities5);
        } catch (IllegalArgumentException e) {
            System.out.println("test number " + testNum++ + " passed. abilities.length must " +
                    "be greater than numTeams.");
        }

        System.out.println();
        System.out.println("Test mazeSolver");
        int mazeTestNum = 1;
        String maze = "SGE";
        runMazeTest(maze, 1, 2, mazeTestNum++);
        maze = "S*";
        runMazeTest(maze, 1, 0, mazeTestNum++);
        maze = "SG";
        runMazeTest(maze, 1, 0, mazeTestNum++);
        maze = "SY";
        runMazeTest(maze, 1, 0, mazeTestNum++);
        maze = "S$";
        runMazeTest(maze, 1, 0, mazeTestNum++);
        maze = "S$E";
        runMazeTest(maze, 1, 2, mazeTestNum++);
        maze = "GE$$S$EG";
        runMazeTest(maze, 1, 2, mazeTestNum++);
        maze = "*G*G*SGGGG*Y$EG";
        runMazeTest(maze, 3, 2, mazeTestNum++);
        maze = "SGGY*$GYYE*GYYG";
        runMazeTest(maze, 3, 2, mazeTestNum++);
        maze = "SG$GG$E*GG$G*G";
        runMazeTest(maze, 2, 2, mazeTestNum++);
        maze = "SGY$G*Y$Y*GGE$G*GG";
        runMazeTest(maze, 3, 1, mazeTestNum++);

        maze = "SGY$G*Y$Y*GWE$G*GG";
        System.out.println();
        try{
            runMazeTest(maze, 3, 1, mazeTestNum++);
        } catch (IllegalArgumentException e) {
            System.out.println("mazeSolver test passed. maze cannot have" +
                    " invalid chars");
        }

        maze = "SGY$G*Y$Y*GGE$G*GGG";
        System.out.println();
        try{
            runMazeTest(maze, 3, 1, mazeTestNum++);
        } catch (IllegalArgumentException e) {
            System.out.println("mazeSolver test passed. must be rectangular");
        }

        maze = "GGY$G*Y$Y*GGE$G*GGG";
        System.out.println();
        try{
            runMazeTest(maze, 3, 1, mazeTestNum++);
        } catch (IllegalArgumentException e) {
            System.out.println("mazeSolver test passed. must have a start");
        }
    }

    private static void runMazeTest(String rawMaze, int rows, int expected, int num) {
        char[][] maze = makeMaze(rawMaze, rows);
        System.out.println("Can escape maze test number " + num);
        printMaze(maze);
        int actual = Recursive.canEscapeMaze(maze);
        if (expected == actual) {
            System.out.println("passed test " + num);
        } else {
            System.out.println("FAILED TEST " + num);
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
        System.out.println();
    }

    // print the given maze
    // pre: none
    private static void printMaze(char[][] maze) {
        if (maze == null) {
            System.out.println("NO MAZE GIVEN");
        } else {
            for (char[] row : maze) {
                for (char c : row) {
                    System.out.print(c);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }

    // generate a char[][] given the raw string
    // pre: rawMaze != null, rawMaze.length() % rows == 0
    static char[][] makeMaze(String rawMaze, int rows) {
        if (rawMaze == null || rawMaze.length() % rows != 0) {
            throw new IllegalArgumentException("Violation of precondition in makeMaze."
                            + "Either raw data is null or left over values: ");
        }
        int cols = rawMaze.length() / rows;
        char[][] result = new char[rows][cols];
        int rawIndex = 0;
        for (int r = 0; r < result.length; r++) {
            for (int c = 0; c < result[0].length; c++) {
                result[r][c] = rawMaze.charAt(rawIndex);
                rawIndex++;
            }
        }
        return result;
    }

    // Show the results of a fair teams test by comparing actual and expected result.
    private static void showFairTeamsResults(int actual, int expected, int testNum) {
        if (actual == expected) {
            System.out.println("Test " + testNum + " passed. min difference.");
        } else {
            System.out.println("Test " + testNum + " failed. min difference.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
    }

    private static void doOneFlowTest(int[][] world, int r, int c,
            boolean expected, int testNum) {

        System.out.println("Can Flow Off Map Test Number " + testNum);
        boolean actual = Recursive.canFlowOffMap(world, r, c);
        System.out.println("Start location = " + r + ", " + c);
        System.out.println("Expected result = " + expected + " actual result = " + actual);
        if (expected == actual) {
            System.out.println("passed test " + testNum + " can flow off map.");
        } else {
            System.out.println("FAILED TEST " + testNum + " can flow off map.");
            System.out.println("Expected result: " + expected);
            System.out.println("Actual result  : " + actual);
        }
        System.out.println();
    }

}
