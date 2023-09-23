import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
 *
 * Student information for assignment:
 *
 *  On my honor, Diego Wearden, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: daw3784
 *  email address: dialwera@gmail.com
 *  TA name: Lilly Tian
 *  Number of slip days I am using: 0
 */

public class AnagramFinderTester {


    private static final String testCaseFileName = "testCaseAnagrams.txt";
    private static final String dictionaryFileName = "d3.txt";

    /**
     * main method that executes tests.
     * @param args Not used.
     */
    public static void main(String[] args) {
        cs314StudentTestsForLetterInventory();

        // tests on the anagram solver itself
        boolean displayAnagrams = getChoiceToDisplayAnagrams();
        AnagramSolver solver
                = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
        runAnagramTests(solver, displayAnagrams);
    }

    private static void cs314StudentTestsForLetterInventory() {
        int numTest = 0;
        LetterInventory lets1 = new LetterInventory("1234567890");
        Object expected = 0;
        Object actual = lets1.size();
        showTestResults(expected, actual, numTest++, "LetterInventory constructor with digits");

        try {
            LetterInventory letsNull = new LetterInventory(null);
        } catch (IllegalArgumentException e) {
            showTestResults(expected, actual, numTest++, "LetterInventory constructor with null");
        }

        lets1 = new LetterInventory("!@#$%^&*()");
        expected = 0;
        actual = lets1.size();
        showTestResults(expected, actual, numTest++, "LetterInventory constructor with special characters");


        lets1 = new LetterInventory("hello");
        expected = 0;
        actual = lets1.get('a');
        showTestResults(expected, actual, numTest++, "LetterInventory get for letter not in inventory");


        lets1 = new LetterInventory("hello");
        expected = 1;
        actual = lets1.get('E');
        showTestResults(expected, actual, numTest++, "LetterInventory get for uppercase letter");

        lets1 = new LetterInventory("");
        LetterInventory lets2 = new LetterInventory("");
        expected = "";
        actual = lets1.add(lets2).toString();
        showTestResults(expected, actual, numTest++, "LetterInventory add with empty inventories");


        lets1 = new LetterInventory("");
        lets2 = new LetterInventory("hello");
        expected = "ehllo";
        actual = lets2.add(lets1).toString();
        showTestResults(expected, actual, numTest++, "LetterInventory add with empty inventory");


        lets1 = new LetterInventory("");
        lets2 = new LetterInventory("goodbye");
        expected = null;
        actual = lets1.subtract(lets2);
        showTestResults(expected, actual, numTest++, "LetterInventory subtract from empty inventory");


        lets1 = new LetterInventory("");
        lets2 = new LetterInventory("world");
        expected = "dlorw";
        actual = lets2.subtract(lets1).toString();
        showTestResults(expected, actual, numTest++, "LetterInventory subtract from non-empty inventory");


        lets1 = new LetterInventory("tree");
        lets2 = new LetterInventory("leaf");
        expected = null;
        actual = lets1.subtract(lets2);
        showTestResults(expected, actual, numTest++, "LetterInventory subtract with different inventories");

        lets1 = new LetterInventory("ABCabc");
        expected = 6;
        actual = lets1.size();
        showTestResults(expected, actual, numTest++, "LetterInventory size is correct with uppercase");

        lets1 = new LetterInventory("È");
        expected = 0;
        actual = lets1.size();
        showTestResults(expected, actual, numTest++, "LetterInventory size is correct with other special chars");

        lets1 = new LetterInventory("È");
        expected = 0;
        actual = lets1.size();
        showTestResults(expected, actual, numTest++, "LetterInventory size is correct with other special chars");

        lets1 = new LetterInventory("こんにちは");
        expected = "";
        actual = lets1.toString();
        showTestResults(expected, actual, numTest++, "LetterInventory toString is correct with other special chars");

        lets1 = new LetterInventory(" \t\n\r");
        expected = "";
        actual = lets1.toString();
        showTestResults(expected, actual, numTest++, "LetterInventory toString is correct with other special chars");

        lets1 = new LetterInventory("hello");
        lets2 = new LetterInventory("loleh");
        expected = true;
        actual = lets1.equals(lets2);
        showTestResults(expected, actual, numTest++, "LetterInventory equals is correct with permutated chars");

        lets1 = new LetterInventory("hello");
        lets2 = new LetterInventory("helo");
        expected = false;
        actual = lets1.equals(lets2);
        showTestResults(expected, actual, numTest++, "LetterInventory equals is correct with diff number chars");

        lets1 = new LetterInventory("hello");
        expected = true;
        actual = lets1.equals(lets1);
        showTestResults(expected, actual, numTest++, "LetterInventory equals is correct with other special chars");

        lets1 = new LetterInventory("");
        expected = true;
        actual = lets1.isEmpty();
        showTestResults(expected, actual, numTest++, "LetterInventory isEmpty is correct with nothing");

        lets1 = new LetterInventory("a");
        expected = false;
        actual = lets1.isEmpty();
        showTestResults(expected, actual, numTest++, "LetterInventory isEmpty is correct with valid char");

        lets1 = new LetterInventory("!@#$%^&*()");
        expected = true;
        actual = lets1.isEmpty();
        showTestResults(expected, actual, numTest++, "LetterInventory isEmpty is correct with other special chars");

        lets1 = new LetterInventory("   \n\t\r");
        expected = true;
        actual = lets1.isEmpty();
        showTestResults(expected, actual, numTest++, "LetterInventory isEmpty is correct with other special chars");
    }

    private static boolean getChoiceToDisplayAnagrams() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter y or Y to display anagrams during tests: ");
        String response = console.nextLine();
        console.close();
        return response.length() > 0
                && response.toLowerCase().charAt(0) == 'y';
    }

    private static boolean showTestResults(Object expected, Object actual,
            int testNum, String featureTested) {

        System.out.println("Test Number " + testNum + " testing "
                + featureTested);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + actual);
        boolean passed = (actual == null && expected == null)
                || (actual != null && actual.equals(expected));
        if (passed) {
            System.out.println("Passed test " + testNum);
        } else {
            System.out.println("!!! FAILED TEST !!! " + testNum);
        }
        System.out.println();
        return passed;
    }

    /**
     * Method to run tests on Anagram solver itself.
     * pre: the files d3.txt and testCaseAnagrams.txt are in the local directory
     *
     * assumed format for file is
     * <NUM_TESTS>
     * <TEST_NUM>
     * <MAX_WORDS>
     * <PHRASE>
     * <NUMBER OF ANAGRAMS>
     * <ANAGRAMS>
     */
    private static void runAnagramTests(AnagramSolver solver,
            boolean displayAnagrams) {

        int solverTestCases = 0;
        int solverTestCasesPassed = 0;
        Stopwatch st = new Stopwatch();
        try {
            Scanner sc = new Scanner(new File(testCaseFileName));
            final int NUM_TEST_CASES = Integer.parseInt(sc.nextLine().trim());
            System.out.println(NUM_TEST_CASES);
            for (int i = 0; i < NUM_TEST_CASES; i++) {
                // expected results
                TestCase currentTest = new TestCase(sc);
                solverTestCases++;
                st.start();
                // actual results
                List<List<String>> actualAnagrams
                    = solver.getAnagrams(currentTest.phrase, currentTest.maxWords);
                st.stop();
                if(displayAnagrams) {
                    displayAnagrams("actual anagrams", actualAnagrams);
                    displayAnagrams("expected anagrams", currentTest.anagrams);
                }


                if(checkPassOrFailTest(currentTest, actualAnagrams))
                    solverTestCasesPassed++;
                System.out.println("Time to find anagrams: " + st.time());
                /* System.out.println("Number of calls to recursive helper method: "
                        + NumberFormat.getNumberInstance(Locale.US).format(AnagramSolver.callsCount));*/
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("\nProblem while running test cases on AnagramSolver. Check" +
                            " that file testCaseAnagrams.txt is in the correct location.");
            System.out.println(e);
            System.out.println("AnagramSolver test cases run: " + solverTestCases);
            System.out.println("AnagramSolver test cases failed: "
                        + (solverTestCases - solverTestCasesPassed));
        }
        System.out.println("\nAnagramSolver test cases run: " + solverTestCases);
        System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
    }
    private static void displayAnagrams(String type,
                    List<List<String>> anagrams) {

        System.out.println("Results for " + type);
        System.out.println("num anagrams: " + anagrams.size());
        System.out.println("anagrams: ");
        for (List<String> singleAnagram : anagrams) {
            System.out.println(singleAnagram);
        }
    }


    // determine if the test passed or failed
    private static boolean checkPassOrFailTest(TestCase currentTest,
                    List<List<String>> actualAnagrams) {

        boolean passed = true;
        System.out.println();
        System.out.println("Test number: " + currentTest.testCaseNumber);
        System.out.println("Phrase: " + currentTest.phrase);
        System.out.println("Word limit: " + currentTest.maxWords);
        System.out.println("Expected Number of Anagrams: "
                    + currentTest.anagrams.size());
        if(actualAnagrams.equals(currentTest.anagrams)) {
            System.out.println("Passed Test");
        } else {
            System.out.println("\n!!! FAILED TEST CASE !!!");
            System.out.println("Recall MAXWORDS = 0 means no limit.");
            System.out.println("Expected number of anagrams: "
                        + currentTest.anagrams.size());
            System.out.println("Actual number of anagrams:   "
                        + actualAnagrams.size());
            if(currentTest.anagrams.size() == actualAnagrams.size()) {
                System.out.println("Sizes the same, "
                        + "but either a difference in anagrams or"
                        + " anagrams not in correct order.");
            }
            System.out.println();
            passed = false;
        }
        return passed;
    }

    // class to handle the parameters for an anagram test
    // and the expected result
    private static class TestCase {

        private int testCaseNumber;
        private String phrase;
        private int maxWords;
        private List<List<String>> anagrams;

        // pre: sc is positioned at the start of a test case
        private TestCase(Scanner sc) {
            testCaseNumber = Integer.parseInt(sc.nextLine().trim());
            maxWords = Integer.parseInt(sc.nextLine().trim());
            phrase = sc.nextLine().trim();
            anagrams = new ArrayList<>();
            readAndStoreAnagrams(sc);
        }

        // pre: sc is positioned at the start of the resulting anagrams
        // read in the number of anagrams and then for each anagram:
        //  - read in the line
        //  - break the line up into words
        //  - create a new list of Strings for the anagram
        //  - add each word to the anagram
        //  - add the anagram to the list of anagrams
        private void readAndStoreAnagrams(Scanner sc) {
            int numAnagrams = Integer.parseInt(sc.nextLine().trim());
            for (int j = 0; j < numAnagrams; j++) {
                String[] words = sc.nextLine().split("\\s+");
                ArrayList<String> anagram = new ArrayList<>();
                for (String st : words) {
                    anagram.add(st);
                }
                anagrams.add(anagram);
            }
            assert anagrams.size() == numAnagrams
                    : "Wrong number of angrams read or expected";
        }
    }
}
