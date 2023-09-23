/* CS 314 STUDENTS: FILL IN THIS HEADER.
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

import java.text.DecimalFormat;
import java.util.*;

/**
 * Some test cases for CS314 Binary Search Tree assignment.
 *
 */
public class BSTTester {

    /**
     * The main method runs the tests.
     * @param args Not used
     */

    /**
     * Random Integers:
     *BinarySearchTree Class:

     N = 1000

     Average height: 21
     Min. Height: 8
     Average time: 0.0006 seconds
     Average size: 1000

     N = 2000

     Average height: 23
     Min. Height: 9
     Average time: 0.00022 seconds
     Average size: 2000

     N = 4000

     Average height: 26
     Min. Height: 10
     Average time: 0.00044 seconds
     Average size: 4000

     N = 8000

     Average height: 29
     Min. Height: 11
     Average time: 0.00111 seconds
     Average size: 8000

     N = 16000

     Average height: 33
     Min. Height: 12
     Average time: 0.00223 seconds
     Average size: 16000

     N = 32000

     Average height: 34
     Min. Height: 13
     Average time: 0.0048 seconds
     Average size: 31999

     N = 64000

     Average height: 37
     Min. Height: 14
     Average time: 0.01036 seconds
     Average size: 63999

     N = 128000

     Average height: 40
     Min. Height: 15
     Average time: 0.02832 seconds
     Average size: 127997

     N = 256000

     Average height: 45
     Min. Height: 16
     Average time: 0.06545 seconds
     Average size: 255991

     N = 512000

     Average height: 45
     Min. Height: 17
     Average time: 0.15257 seconds
     Average size: 511969

     N = 1024000

     Average height: 48
     Min. Height: 18
     Average time: 0.42917 seconds
     Average size: 1023877

     TreeSet Class:

     N = 1000

     Average time: 5.900E-4 seconds

     N = 2000

     Average time: 3.75E-4 seconds

     N = 4000

     Average time: 6.019E-4 seconds

     N = 8000

     Average time: 0.0011 seconds

     N = 16000

     Average time: 0.0023 seconds

     N = 32000

     Average time: 0.0054 seconds

     N = 64000

     Average time: 0.0114 seconds

     N = 128000

     Average time: 0.0313 seconds

     N = 256000

     Average time: 0.081 seconds

     N = 512000

     Average time: 0.192 seconds

     N = 1024000

     Average time: 0.496 seconds

     Comparison: The TreeSet class times are generally faster than the BinarySearchTree class times.

     Integers in Ascending order:
     BinarySearchTree Class:

     N = 1000

     Average height: 999
     Average time: 0.00159 seconds
     Average size: 1000

     N = 2000

     Average height: 1999
     Average time: 0.00355 seconds
     Average size: 2000

     N = 4000

     Average height: 3999
     Average time: 0.01418 seconds
     Average size: 4000

     N = 8000

     Average height: 7999
     Average time: 0.0558 seconds
     Average size: 8000

     N = 16000

     Average height: 15999
     Average time: 0.21103 seconds
     Average size: 16000

     N = 32000

     Average height: 31999
     Average time: 0.80938 seconds
     Average size: 32000

     N = 64000

     Average height: 63999
     Average time: 3.3669 seconds
     Average size: 64000

     Predictions:

     Based on the results of the experiment, we can observe that as the value of N doubles, the average time to
     add the elements into the tree increases by a factor of approximately 4.

     We can predict that it would take approximately:

     3.25 * 4 = 13.02 seconds to add 128,000 sorted integers
     13.02 * 4 = 52.08 seconds to add 256,000 sorted integers
     52.08 * 4 = 208.32 seconds to add 512,000 sorted integers

     TreeSet Class:

     N = 1000

     Average time: 5.005E-4 seconds

     N = 2000

     Average time: 3.334E-4 seconds

     N = 4000

     Average time: 2.9927E-4 seconds

     N = 8000

     Average time: 5.229E-4 seconds

     N = 16000

     Average time: 0.00106 seconds

     N = 32000

     Average time: 0.00216 seconds

     N = 64000

     Average time: 0.00480 seconds

     Comparison: The TreeSet class is faster than the BinarySearchTree class. I think this is because
     of the TreeSets class is using red-black tree implementation which would give it faster adding times.
     */
    public static void main(String[] args) {
        // experiment code
//        int n = 1000;
//        for (int i = 0; i < 11; i++) {
//            double times = 0;
//            int heights = 0;
//            int sizes = 0;
//            int minHeight = 0;
//            for(int j = 1; j <= 10; j++){
//                Stopwatch st = new Stopwatch();
//                st.start();
//                BinarySearchTree<Integer> b = new BinarySearchTree<>();
//                for(int k = 1; k <= n; k++) {
//                    b.iterativeAdd(k);
//                }
//                st.stop();
//                times += st.time();
//                heights += n - 1;
//                sizes += n;
//            }
//            System.out.println();
//            System.out.println("N = " + n);
//            System.out.println();
//            DecimalFormat decimalFormat = new DecimalFormat("#.#####");
//            System.out.println("Average height: " + heights / 10);
//            System.out.println("Average time: " + decimalFormat.format(times / 10) + " seconds");
//            System.out.println("Average size: " + sizes / 10);
//            n = n * 2;
//        }
        addTests();
        removeTests();
        isPresentTests();
        sizeTests();
        heightTests();
        getAllTests();
        maxTests();
        minTests();
        iterativeAddTests();
        testGet();
        testGetAllGreaterThan();
        testGetAllLessThan();
        testNumNodesAtDepth();
    }
    public static void testGet() {
        System.out.println();
        System.out.println("get Tests");
        System.out.println();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(4);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(7);

        showTestResults(bst.get(0) == 1, 1);
        showTestResults(bst.get(3) == 4, 2);
        showTestResults(bst.get(6) == 7, 3);
        showTestResults(bst.get(5) == 6, 4);
    }

    public static void testGetAllLessThan() {
        System.out.println();
        System.out.println("getAllLessThan Tests");
        System.out.println();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(4);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(7);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);

        List<Integer> actual = bst.getAllLessThan(4);

        showTestResults(actual.equals(expected), 1);

        expected.clear();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        actual = bst.getAllLessThan(6);

        showTestResults(actual.equals(expected), 2);
    }

    public static void testGetAllGreaterThan() {
        System.out.println();
        System.out.println("getAllGreaterThan Tests");
        System.out.println();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.add(4);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(7);

        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(6);
        expected.add(7);

        List<Integer> actual = bst.getAllGreaterThan(4);

        showTestResults(actual.equals(expected), 1);

        expected.clear();
        expected.add(7);

        actual = bst.getAllGreaterThan(6);

        showTestResults(actual.equals(expected), 2);
    }

    public static void testNumNodesAtDepth() {
        System.out.println();
        System.out.println("numNodesAtDepth Tests");
        System.out.println();

        // Test 1: test empty tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        showTestResults(bst.numNodesAtDepth(0) == 0, 1);

        // Test 2: test negative input
        showTestResults(bst.numNodesAtDepth(-1) == 0, 2);

        // Test 3: test with multiple elements
        bst.add(4);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(7);

        showTestResults(bst.numNodesAtDepth(0) == 1, 3);
        showTestResults(bst.numNodesAtDepth(1) == 2, 4);
        showTestResults(bst.numNodesAtDepth(2) == 4, 5);
        showTestResults(bst.numNodesAtDepth(3) == 0, 6);
    }

    public static void iterativeAddTests() {
        System.out.println();
        System.out.println("iterativeAdd Tests");
        System.out.println();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        // Test 1: with a single element
        showTestResults(bst.iterativeAdd(5), 1);
        showTestResults(!bst.iterativeAdd(5), 2);
        showTestResults(bst.size() == 1, 3);

        // Test 2: with multiple elements
        showTestResults(bst.iterativeAdd(7), 4);
        showTestResults(bst.iterativeAdd(3), 5);
        showTestResults(bst.iterativeAdd(10), 6);
        showTestResults(bst.iterativeAdd(1), 7);
        showTestResults(bst.iterativeAdd(6), 8);
        showTestResults(bst.iterativeAdd(8), 9);
        showTestResults(bst.iterativeAdd(12), 10);
        showTestResults(!bst.iterativeAdd(6), 11);
        showTestResults(!bst.iterativeAdd(10), 12);

        // Test 3: with duplicate elements
        showTestResults(!bst.iterativeAdd(3), 13);
        showTestResults(!bst.iterativeAdd(8), 14);
        showTestResults(!bst.iterativeAdd(12), 15);

        // Test 4: with null element
        try {
            bst.iterativeAdd(null);
            showTestResults(false, 17);
        } catch (IllegalArgumentException e) {
            showTestResults(true, 17);
        }

    }

        public static void maxTests() {
            System.out.println();
        System.out.println("max Tests");
        System.out.println();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Test 1: with a single element
        bst.add(5);
        showTestResults(bst.max() == 5, 1);

        // Test 2: with multiple elements
        bst.add(7);
        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.add(8);
        bst.add(12);
        showTestResults(bst.max() == 12, 2);

        // Test 3: with duplicates
        bst.add(10);
        bst.add(12);
        bst.add(5);
        showTestResults(bst.max() == 12, 3);

        // Test 4: with negative elements
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.add(-5);
        bst2.add(-7);
        bst2.add(-3);
        bst2.add(-1);
        bst2.add(-6);
        showTestResults(bst2.max() == -1, 4);
    }


    /**
     * Tests the min method in BinarySearchTree.
     */
    public static void minTests() {
        System.out.println();
        System.out.println("min Tests");
        System.out.println();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Test 1: with a single element
        bst.add(5);
        showTestResults(bst.min() == 5, 1);

        // Test 2: with multiple elements
        bst.add(7);
        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.add(8);
        bst.add(12);
        showTestResults(bst.min() == 1, 2);

        // Test 3: with duplicates
        bst.add(1);
        bst.add(3);
        bst.add(5);
        showTestResults(bst.min() == 1, 3);

        // Test 4: with negative elements
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.add(-5);
        bst2.add(-7);
        bst2.add(-3);
        bst2.add(-1);
        bst2.add(-6);
        showTestResults(bst2.min() == -7, 4);
    }


    private static void getAllTests() {
        System.out.println();
        System.out.println("getAll Tests");
        System.out.println();

        // Test 1: test getAll with empty tree
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        List<Integer> list = tree.getAll();
        showTestResults(list.isEmpty(), 7);

        // Test 2: test getAll with one element
        tree = new BinarySearchTree<>();
        tree.add(5);
        list = tree.getAll();
        showTestResults(list.size() == 1 && list.get(0) == 5, 8);

        // Test 3: test getAll with multiple elements
        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        list = tree.getAll();
        showTestResults(list.size() == 7 && list.get(0) == 1 && list.get(1) == 3 && list.get(2) == 4 && list.get(3) == 5 && list.get(4) == 6 && list.get(5) == 7 && list.get(6) == 8, 9);

    }

    private static void heightTests() {
        System.out.println();
        System.out.println("height Tests");
        System.out.println();

        // Test 1: test height with empty tree
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        showTestResults(tree.height() == -1, 4);

        // Test 2: tests height with one item
        tree = new BinarySearchTree<>();
        tree.add(5);
        showTestResults(tree.height() == 0, 5);

        // Test 3: height with multiple items
        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        showTestResults(tree.height() == 2, 6);

    }

    private static void sizeTests() {
        System.out.println();
        System.out.println("size Tests");
        System.out.println();

        // Test 1: test size with empty tree
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        showTestResults(tree.size() == 0, 1);

        // Test 2: tests size with one item
        tree = new BinarySearchTree<>();
        tree.add(5);
        showTestResults(tree.size() == 1, 2);

        // Test 3: size with multiple items
        tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(8);
        showTestResults(tree.size() == 7, 3);

    }

    public static void addTests() {
        System.out.println();
        System.out.println("add Tests");
        System.out.println();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Test 1: Adding the root node
        showTestResults(tree.add(10), 1);
        showTestResults(tree.size() == 1, 2);

        // Test 2: Adding a node as the left child of the root
        showTestResults(tree.add(5), 3);
        showTestResults(tree.size() == 2, 4);

        // Test 3: Adding a node as the right child of the root
        showTestResults(tree.add(15), 5);
        showTestResults(tree.size() == 3, 6);

        // Test 4: Adding a node as the left child of a leaf
        showTestResults(tree.add(2), 7);
        showTestResults(tree.size() == 4, 8);

        // Test 5: Adding a node as the right child of a leaf
        showTestResults(tree.add(7), 9);
        showTestResults(tree.size() == 5, 10);

        // Test 6: Adding a duplicate node
        showTestResults(!tree.add(10), 11);
        showTestResults(tree.size() == 5, 12);
    }

    public static void removeTests() {
        System.out.println();
        System.out.println("remove Tests");
        System.out.println();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);

        // Test 1: Removing a leaf node
        showTestResults(tree.remove(2), 13);
        showTestResults(tree.size() == 4, 14);

        // Test 2: Removing a node with one child
        showTestResults(tree.remove(5), 15);
        showTestResults(tree.size() == 3, 16);

        // Test 3: Removing the root node
        showTestResults(tree.remove(10), 17);
        showTestResults(tree.size() == 2, 18);

        // Test 4: Removing a node that is not in the tree
        showTestResults(!tree.remove(20), 19);
        showTestResults(tree.size() == 2, 20);
    }

    public static void isPresentTests() {
        System.out.println();
        System.out.println("isPresent Tests");
        System.out.println();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);

        // Test 1: Searching for a leaf node
        showTestResults(tree.isPresent(2), 21);

        // Test 2: Searching for a node with one child
        showTestResults(tree.isPresent(5), 22);

        // Test 3: Searching for the root node
        showTestResults(tree.isPresent(10), 23);

        // Test 4: Searching for a node that is not in the tree
        showTestResults(!tree.isPresent(20), 24);
    }
    private static void showTestResults(boolean passed, int testNum) {
        if (passed) {
            System.out.println("Test " + testNum + " passed.");
        } else {
            System.out.println("TEST " + testNum + " FAILED.");
        }
    }
}
