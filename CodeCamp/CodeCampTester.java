import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// CodeCamp.java - CS314 Assignment 1 - Tester class

/*
 * Student information for assignment:
 * Name: Diego Wearden
 * email address: dialwera@gmail.com
 * UTEID: daw3784
 * Section 5 digit ID: 52045
 * Grader name: Emma
 * Number of slip days used on this assignment: 0
 */

/*
 * the average number of pairs of people with shared birthdays after
 * 1,000,000 experiments with 365 days per year and 182 people per experiment is 45.114491 pairs
 *
 * Prediction: 183
 *
 * At 23 people the answer exceeds 50%. This answer does surprise me.
 * The actual answer is 160 less than my predicted answer.
 *
Num people: 2, number of experiments with one or more shared birthday: 138, percentage: 0.27599999999999997

Num people: 3, number of experiments with one or more shared birthday: 446, percentage: 0.8920000000000001

Num people: 4, number of experiments with one or more shared birthday: 812, percentage: 1.624

Num people: 5, number of experiments with one or more shared birthday: 1313, percentage: 2.626

Num people: 6, number of experiments with one or more shared birthday: 1974, percentage: 3.948

Num people: 7, number of experiments with one or more shared birthday: 2777, percentage: 5.554

Num people: 8, number of experiments with one or more shared birthday: 3708, percentage: 7.416

Num people: 9, number of experiments with one or more shared birthday: 4610, percentage: 9.22

Num people: 10, number of experiments with one or more shared birthday: 5880, percentage: 11.76

Num people: 11, number of experiments with one or more shared birthday: 7007, percentage: 14.014

Num people: 12, number of experiments with one or more shared birthday: 8326, percentage: 16.652

Num people: 13, number of experiments with one or more shared birthday: 9690, percentage: 19.38

Num people: 14, number of experiments with one or more shared birthday: 11226, percentage: 22.451999999999998

Num people: 15, number of experiments with one or more shared birthday: 12632, percentage: 25.263999999999996

Num people: 16, number of experiments with one or more shared birthday: 14262, percentage: 28.524

Num people: 17, number of experiments with one or more shared birthday: 15706, percentage: 31.412000000000003

Num people: 18, number of experiments with one or more shared birthday: 17340, percentage: 34.68

Num people: 19, number of experiments with one or more shared birthday: 18947, percentage: 37.894

Num people: 20, number of experiments with one or more shared birthday: 20569, percentage: 41.138000000000005

Num people: 21, number of experiments with one or more shared birthday: 22216, percentage: 44.432

Num people: 22, number of experiments with one or more shared birthday: 23580, percentage: 47.160000000000004

Num people: 23, number of experiments with one or more shared birthday: 25327, percentage: 50.653999999999996

Num people: 24, number of experiments with one or more shared birthday: 26928, percentage: 53.856

Num people: 25, number of experiments with one or more shared birthday: 28362, percentage: 56.724

Num people: 26, number of experiments with one or more shared birthday: 30111, percentage: 60.221999999999994

Num people: 27, number of experiments with one or more shared birthday: 31503, percentage: 63.00599999999999

Num people: 28, number of experiments with one or more shared birthday: 32808, percentage: 65.616

Num people: 29, number of experiments with one or more shared birthday: 34192, percentage: 68.384

Num people: 30, number of experiments with one or more shared birthday: 35328, percentage: 70.65599999999999

Num people: 31, number of experiments with one or more shared birthday: 36499, percentage: 72.99799999999999

Num people: 32, number of experiments with one or more shared birthday: 37725, percentage: 75.44999999999999

Num people: 33, number of experiments with one or more shared birthday: 38580, percentage: 77.16

Num people: 34, number of experiments with one or more shared birthday: 39737, percentage: 79.474

Num people: 35, number of experiments with one or more shared birthday: 40658, percentage: 81.316

Num people: 36, number of experiments with one or more shared birthday: 41634, percentage: 83.268

Num people: 37, number of experiments with one or more shared birthday: 42468, percentage: 84.936

Num people: 38, number of experiments with one or more shared birthday: 43145, percentage: 86.29

Num people: 39, number of experiments with one or more shared birthday: 43938, percentage: 87.876

Num people: 40, number of experiments with one or more shared birthday: 44446, percentage: 88.89200000000001

Num people: 41, number of experiments with one or more shared birthday: 45144, percentage: 90.288

Num people: 42, number of experiments with one or more shared birthday: 45719, percentage: 91.438

Num people: 43, number of experiments with one or more shared birthday: 46136, percentage: 92.27199999999999

Num people: 44, number of experiments with one or more shared birthday: 46682, percentage: 93.364

Num people: 45, number of experiments with one or more shared birthday: 47105, percentage: 94.21000000000001

Num people: 46, number of experiments with one or more shared birthday: 47457, percentage: 94.914

Num people: 47, number of experiments with one or more shared birthday: 47755, percentage: 95.50999999999999

Num people: 48, number of experiments with one or more shared birthday: 48034, percentage: 96.068

Num people: 49, number of experiments with one or more shared birthday: 48322, percentage: 96.64399999999999

Num people: 50, number of experiments with one or more shared birthday: 48492, percentage: 96.98400000000001

Num people: 51, number of experiments with one or more shared birthday: 48656, percentage: 97.312

Num people: 52, number of experiments with one or more shared birthday: 48918, percentage: 97.836

Num people: 53, number of experiments with one or more shared birthday: 49022, percentage: 98.044

Num people: 54, number of experiments with one or more shared birthday: 49179, percentage: 98.358

Num people: 55, number of experiments with one or more shared birthday: 49307, percentage: 98.614

Num people: 56, number of experiments with one or more shared birthday: 49465, percentage: 98.92999999999999

Num people: 57, number of experiments with one or more shared birthday: 49540, percentage: 99.08

Num people: 58, number of experiments with one or more shared birthday: 49572, percentage: 99.144

Num people: 59, number of experiments with one or more shared birthday: 49664, percentage: 99.328

Num people: 60, number of experiments with one or more shared birthday: 49713, percentage: 99.426

Num people: 61, number of experiments with one or more shared birthday: 49733, percentage: 99.466

Num people: 62, number of experiments with one or more shared birthday: 49809, percentage: 99.618

Num people: 63, number of experiments with one or more shared birthday: 49844, percentage: 99.688

Num people: 64, number of experiments with one or more shared birthday: 49858, percentage: 99.71600000000001

Num people: 65, number of experiments with one or more shared birthday: 49886, percentage: 99.772

Num people: 66, number of experiments with one or more shared birthday: 49901, percentage: 99.802

Num people: 67, number of experiments with one or more shared birthday: 49927, percentage: 99.854

Num people: 68, number of experiments with one or more shared birthday: 49936, percentage: 99.872

Num people: 69, number of experiments with one or more shared birthday: 49952, percentage: 99.90400000000001

Num people: 70, number of experiments with one or more shared birthday: 49956, percentage: 99.912

Num people: 71, number of experiments with one or more shared birthday: 49957, percentage: 99.914

Num people: 72, number of experiments with one or more shared birthday: 49969, percentage: 99.938

Num people: 73, number of experiments with one or more shared birthday: 49984, percentage: 99.968

Num people: 74, number of experiments with one or more shared birthday: 49974, percentage: 99.94800000000001

Num people: 75, number of experiments with one or more shared birthday: 49985, percentage: 99.97

Num people: 76, number of experiments with one or more shared birthday: 49992, percentage: 99.984

Num people: 77, number of experiments with one or more shared birthday: 49989, percentage: 99.978

Num people: 78, number of experiments with one or more shared birthday: 49988, percentage: 99.976

Num people: 79, number of experiments with one or more shared birthday: 49997, percentage: 99.994

Num people: 80, number of experiments with one or more shared birthday: 49995, percentage: 99.99

Num people: 81, number of experiments with one or more shared birthday: 49996, percentage: 99.992

Num people: 82, number of experiments with one or more shared birthday: 49998, percentage: 99.996

Num people: 83, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 84, number of experiments with one or more shared birthday: 49999, percentage: 99.998

Num people: 85, number of experiments with one or more shared birthday: 49999, percentage: 99.998

Num people: 86, number of experiments with one or more shared birthday: 49997, percentage: 99.994

Num people: 87, number of experiments with one or more shared birthday: 49999, percentage: 99.998

Num people: 88, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 89, number of experiments with one or more shared birthday: 49999, percentage: 99.998

Num people: 90, number of experiments with one or more shared birthday: 49999, percentage: 99.998

Num people: 91, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 92, number of experiments with one or more shared birthday: 49999, percentage: 99.998

Num people: 93, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 94, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 95, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 96, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 97, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 98, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 99, number of experiments with one or more shared birthday: 50000, percentage: 100.0

Num people: 100, number of experiments with one or more shared birthday: 50000, percentage: 100.0
 *
 *
 */

public class CodeCampTester {

    public static void main(String[] args) {
        final String newline = System.getProperty("line.separator");

        // test 1, hamming distance
        int[] h1 = { 1, 2, 7, 4, 49, 4, 3, 2, 1 };
        int[] h2 = { 10, 9, 4, 1, 85, 0, 50, -10, 9 };
        int expected = 9;
        int actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println("Test 1 hamming distance: expected value: " + expected
                + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 1, hamming distance");
        } else {
            System.out.println(" ***** FAILED ***** test 1, hamming distance");
        }

        // test 2, hamming distance
        h1 = new int[] {};
        h2 = new int[] {};
        expected = 0;
        actual = CodeCamp.hammingDistance(h1, h2);
        System.out.println("\nTest 2 hamming distance: expected value: " + expected
                + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 2, hamming distance");
        } else {
            System.out.println(" ***** FAILED ***** test 2, hamming distance");
        }


        // test 3, isPermutation
        int[] a = { 83, 49, 45 };
        int[] b = { 49, 83, 45 };
        boolean expectedBool = true;
        boolean actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 3 isPermutation: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 3, isPermutation");
        } else {
            System.out.println(" ***** FAILED ***** test 3, isPermutation");
        }

        // test 4, is Permutation
        b = new int[] { 49, 83, 48 };
        expectedBool = false;
        actualBool = CodeCamp.isPermutation(a, b);
        System.out.println(newline + "Test 4 isPermutation: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 4, isPermutation");
        } else {
            System.out.println(" ***** FAILED ***** test 4, isPermutation");
        }

        // test 5, mostVowels
        String[] arrayOfStrings = { "", "" };
        int expectedResult = 0;
        int actualResult = CodeCamp.mostVowels(arrayOfStrings);
        System.out.println(newline + "Test 5 mostVowels: expected result: " + expectedResult
                + ", actual result: " + actualResult);
        if (actualResult == expectedResult) {
            System.out.println("passed test 5, mostVowels");
        } else {
            System.out.println("***** FAILED ***** test 5, mostVowels");
        }

        // test 6, mostVowels
        arrayOfStrings = new String[] { "euioeoeiua", null, "DiegoWearden" };
        expectedResult = 0;
        actualResult = CodeCamp.mostVowels(arrayOfStrings);
        System.out.println(newline + "Test 6 mostVowels: expected result: " + expectedResult
                + ", actual result: " + actualResult);
        if (actualResult == expectedResult) {
            System.out.println("passed test 6, mostVowels");
        } else {
            System.out.println("***** FAILED ***** test 16, mostVowels");
        }

        // test 7, sharedBirthdays, simple test
        int pairs = CodeCamp.sharedBirthdays(678, 1);
        System.out.println(newline + "Test 7 shared birthdays: expected: 0, actual: " + pairs);
        int expectedShared = 229503;
        if (pairs == expectedShared) {
            System.out.println("passed test 7, shared birthdays");
        } else {
            System.out.println("***** FAILED ***** test 7, shared birthdays");
        }

        // test 8, sharedBirthdays, simple test
        pairs = CodeCamp.sharedBirthdays(67, 934);
        System.out.println(newline + "Test 8 shared birthdays: expected: "
                + "a value of 1 or more, actual: " + pairs);
        if (pairs > 0) {
            System.out.println("passed test 8, shared birthdays");
        } else {
            System.out.println("***** FAILED ***** test 8, shared birthdays");
        }

        // test 9, queensAreASafe
        char[][] board = { { 'q' } };

        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 9 queensAreSafe: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 9, queensAreSafe");
        } else {
            System.out.println(" ***** FAILED ***** test 9, queensAreSafe");
        }

        // test 10, queensAreASafe
        board = new char[][] {
                {'.', 'q', '.', '.', '.', '.', '.', '.', '.'
                        , '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', 'q', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', 'q', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', 'q', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', 'q', '.', '.', '.' },
                {'.', '.', '.', 'q', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        'q', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', 'q', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', 'q', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                {'.', '.', '.', '.', '.', '.', '.', '.', '.',
                        '.', '.', 'q', '.', '.', '.', '.', '.', '.', '.', '.' },};
        expectedBool = true;
        actualBool = CodeCamp.queensAreSafe(board);
        System.out.println(newline + "Test 10 queensAreSafe: expected value: " + expectedBool
                + ", actual value: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println(" passed test 10, queensAreSafe");
        } else {
            System.out.println(" ***** FAILED ***** test 10, queensAreSafe");
        }

        // test 11, getValueOfMostValuablePlot
        int[][] city = { { 4, 8, 2, 7, 9 },
                { -2, -1, -3, -4, -5 },
                { -3, -5, -7, -8, -9 },
                { -1, -2, -3, -4, -5 },
                { 1, 2, 3, 4, 5 } };

        expected = 30;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 11 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 11, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 11, getValueOfMostValuablePlot");
        }

        // test 12, getValueOfMostValuablePlot
        city = new int[][]{{1, 15},
                            {16, 40}};
        expected = 72;
        actual = CodeCamp.getValueOfMostValuablePlot(city);
        System.out.println(newline + "Test 12 getValueOfMostValuablePlot: expected value: "
                + expected + ", actual value: " + actual);
        if (expected == actual) {
            System.out.println(" passed test 12, getValueOfMostValuablePlot");
        } else {
            System.out.println(" ***** FAILED ***** test 12, getValueOfMostValuablePlot");
        }

} // end of main method

// pre: list != null
    private static int[] intListToArray(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("list parameter may not be null.");
        }
        int[] result = new int[list.size()];
        int arrayIndex = 0;
        for (int x : list) {
            result[arrayIndex++] = x;
        }
        return result;
    }
}