/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Diego Wearden
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  Section 5 digit ID: 52085
 *  Grader name: Lilly Tian
 *  Number of slip days used on this assignment: 2
 */

/* Experiment results. CS314 students, place your experiment
 *  results here:
 *
 * Number of times test run: 100
Adding at end: ArrayList
N = 30000, total time:  0.0239
N = 60000, total time:  0.0497
N = 120000, total time:  0.1097
N = 240000, total time:  0.1851
N = 480000, total time:  0.6139


Number of times test run: 100
Adding at end: LinkedList
N = 30000, total time:  0.0268
N = 60000, total time:  0.0420
N = 120000, total time:  0.0821
N = 240000, total time:  0.1903
N = 480000, total time:  0.3490


Number of times test run: 100
Adding at front: ArrayList
N = 2000, total time:  0.0125
N = 4000, total time:  0.0434
N = 8000, total time:  0.1673
N = 16000, total time:  0.7168
N = 32000, total time:  3.3668


Number of times test run: 100
Adding at front: LinkedList
N = 10000, total time:  0.0060
N = 20000, total time:  0.0114
N = 40000, total time:  0.0229
N = 80000, total time:  0.0450
N = 160000, total time:  0.0920


Number of times test run: 100
Removing from front: ArrayList
N = 2000, total time:  0.0101
N = 4000, total time:  0.0373
N = 8000, total time:  0.1436
N = 16000, total time:  0.6514
N = 32000, total time:  3.1322


Number of times test run: 100
removing from front: LinkedList
N = 5000, total time:  0.0012
N = 10000, total time:  0.0020
N = 20000, total time:  0.0075
N = 40000, total time:  0.0205
N = 80000, total time:  0.0471


Number of times test run: 100
Getting random: ArrayList
N = 10000, total time:  0.0108
N = 20000, total time:  0.0225
N = 40000, total time:  0.0533
N = 80000, total time:  0.1557
N = 160000, total time:  0.3996


Number of times test run: 100
Getting random: LinkedList
N = 1000, total time:  0.0503
N = 2000, total time:  0.2182
N = 4000, total time:  0.8974
N = 8000, total time:  3.7127
N = 16000, total time: 14.6671


Number of times test run: 100
Getting all using iterator: ArrayList
N = 50000, total time:  0.0075
N = 100000, total time:  0.0130
N = 200000, total time:  0.0269
N = 400000, total time:  0.0560
N = 800000, total time:  0.1130


Number of times test run: 100
Getting all using iterator: LinkedList
N = 50000, total time:  0.0108
N = 100000, total time:  0.0250
N = 200000, total time:  0.0563
N = 400000, total time:  0.1168
N = 800000, total time:  0.2287


Number of times test run: 100
Getting all using get method: ArrayList
N = 100000, total time:  0.0096
N = 200000, total time:  0.0189
N = 400000, total time:  0.0452
N = 800000, total time:  0.0905
N = 1600000, total time:  0.1734


Number of times test run: 100
Getting all using get method: LinkedList
N = 1000, total time:  0.0499
N = 2000, total time:  0.2204
N = 4000, total time:  0.9214
N = 8000, total time:  3.6818
N = 16000, total time: 14.7185
 *
 * Adding an element at the end of a list is faster in the ArrayList than the LinkedList
 * for all values of N.
 * Adding an element at the front of a list is faster in the LinkedList than the ArrayList
* for all values of N.
* Removing an element from the front of a list is faster in the LinkedList than the ArrayList
* for all values of N.
* Getting an element at a random index is faster in the ArrayList than the LinkedList for all
* values of N.
* Getting all elements of the list using an iterator is faster in the ArrayList than the LinkedList
* for all values of N.
* Getting all elements of the list using the get method is faster in the ArrayList than the LinkedList
* for all values of N.
*
* In general, the ArrayList is faster than the LinkedList for operations that involve random access
* to elements, while the LinkedList is faster for operations that involve adding or removing
* elements at the beginning of the list. This is because the ArrayList has constant-time
* access to elements using their index, while the LinkedList needs to traverse the list to
* find an element at a given index. On the other hand, the LinkedList has constant-time
* insertion and deletion at the front of the list, while the ArrayList needs to shift all
* elements to make room for a new element.
 *  
 */


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.HashSet;

public class LinkedListTester {


    public static void main(String[] args) {

        // LinkedList<>(), addLast(), size(), toString(), iterator() tested through other tests
        // test 1 addFirst method
        System.out.println("Test 1 addFirst method");
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("A");
        String listString = list.toString();
        if (listString.equals("[A]")) {
            System.out.println("Passed test 1.1");
        } else {
            System.out.println("FAILED test 1.1");
        }

        list.addFirst("B");
        listString = list.toString();
        if (listString.equals("[B, A]")) {
            System.out.println("Passed test 1.2");
        } else {
            System.out.println("FAILED test 1.2");
        }

        list.addFirst("C");
        listString = list.toString();
        if (listString.equals("[C, B, A]")) {
            System.out.println("Passed test 1.3");
        } else {
            System.out.println("FAILED test 1.3");
        }

        // test 2 add/addLast method
        System.out.println();
        System.out.println("Test 2 add/addLast method");
        list.makeEmpty();
        list.add("A");
        listString = list.toString();
        if (listString.equals("[A]")) {
            System.out.println("Passed test 2.1");
        } else {
            System.out.println("FAILED test 2.1");
        }

        list.add("B");
        listString = list.toString();
        if (listString.equals("[A, B]")) {
            System.out.println("Passed test 2.2");
        } else {
            System.out.println("FAILED test 2.2");
        }

        list.add("C");
        listString = list.toString();
        if (listString.equals("[A, B, C]")) {
            System.out.println("Passed test 2.3");
        } else {
            System.out.println("FAILED test 2.3");
        }

        for (int i = 68; i < 91; i++) {
            String letter = "" + (char) i;
            list.addLast(letter);
        }
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]")) {
            System.out.println("Passed test 2.4");
        } else {
            System.out.println("FAILED test 2.4");
        }

        // test 3 removeFirst method
        System.out.println();
        System.out.println("Test 3 removeFirst method");
        Object returnValue = list.removeFirst();
        ;
        listString = list.toString();
        if (listString.equals("[B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("A") && list.size() == 25) {
            System.out.println("Passed test 3.1");
        } else {
            System.out.println("FAILED test 3.1");
        }

        returnValue = list.removeFirst();
        listString = list.toString();
        if (listString.equals("[C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("B") && list.size() == 24) {
            System.out.println("Passed test 3.2");
        } else {
            System.out.println("FAILED test 3.2");
        }

        list.makeEmpty();
        list.add("A");
        returnValue = list.removeFirst();
        listString = list.toString();
        if (listString.equals("[]") && returnValue.equals("A") && list.size() == 0) {
            System.out.println("Passed test 3.3");
        } else {
            System.out.println("FAILED test 3.3");
        }

        System.out.println();
        System.out.println("Test 4 removeLast method");
        list.add("A");
        returnValue = list.removeLast();
        listString = list.toString();
        if (listString.equals("[]") && returnValue.equals("A") && list.size() == 0) {
            System.out.println("Passed test 4.1");
        } else {
            System.out.println("FAILED test 4.1");
        }

        for (int i = 65; i < 91; i++) {
            String letter = "" + (char) i;
            list.addLast(letter);
        }
        returnValue = list.removeLast();
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y]") && returnValue.equals("Z") && list.size() == 25) {
            System.out.println("Passed test 4.2");
        } else {
            System.out.println("FAILED test 4.2");
        }

        returnValue = list.removeLast();
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X]") && returnValue.equals("Y") && list.size() == 24) {
            System.out.println("Passed test 4.3");
        } else {
            System.out.println("FAILED test 4.3");
        }

        for (int i = 0; i < 24; i++) {
            returnValue = list.removeLast();
        }
        listString = list.toString();
        if (listString.equals("[]") && returnValue.equals("A") && list.size() == 0) {
            System.out.println("Passed test 4.4");
        } else {
            System.out.println("FAILED test 4.4");
        }

        // add method calls addLast
        // test 5 insert method
        System.out.println();
        System.out.println("Test 5 insert method");
        list.insert(0, "A");
        listString = list.toString();
        if (listString.equals("[A]")) {
            System.out.println("Passed test 5.1");
        } else {
            System.out.println("FAILED test 5.1");
        }

        list.insert(0, "B");
        listString = list.toString();
        if (listString.equals("[B, A]")) {
            System.out.println("Passed test 5.2");
        } else {
            System.out.println("FAILED test 5.2");
        }

        list.insert(1, "C");
        listString = list.toString();
        if (listString.equals("[B, C, A]")) {
            System.out.println("Passed test 5.3");
        } else {
            System.out.println("FAILED test 5.3");
        }

        list.insert(3, "C");
        listString = list.toString();
        if (listString.equals("[B, C, A, C]")) {
            System.out.println("Passed test 5.4");
        } else {
            System.out.println("FAILED test 5.4");
        }

        // test 6 set method
        System.out.println();
        System.out.println("Test 6 set method");

        returnValue = list.set(2, "D");
        listString = list.toString();
        if (listString.equals("[B, C, D, C]") && returnValue.equals("A")) {
            System.out.println("Passed test 6.1");
        } else {
            System.out.println("FAILED test 6.1");
        }

        returnValue = list.set(0, "D");
        listString = list.toString();
        if (listString.equals("[D, C, D, C]") && returnValue.equals("B") && list.size() == 4) {
            System.out.println("Passed test 6.2");
        } else {
            System.out.println("FAILED test 6.2");
        }

        returnValue = list.set(3, "D");
        listString = list.toString();
        if (listString.equals("[D, C, D, D]") && returnValue.equals("C") && list.size() == 4) {
            System.out.println("Passed test 6.3");
        } else {
            System.out.println("FAILED test 6.3");
        }

        // test 7 get method
        System.out.println();
        System.out.println("Test 7 get method");
        returnValue = list.get(0);
        listString = list.toString();
        if (listString.equals("[D, C, D, D]") && returnValue.equals("D") && list.size() == 4) {
            System.out.println("Passed test 7.1");
        } else {
            System.out.println("FAILED test 7.1");
        }

        returnValue = list.get(1);
        listString = list.toString();
        if (listString.equals("[D, C, D, D]") && returnValue.equals("C") && list.size() == 4) {
            System.out.println("Passed test 7.2");
        } else {
            System.out.println("FAILED test 7.2");
        }

        returnValue = list.get(list.size() - 1);
        listString = list.toString();
        if (listString.equals("[D, C, D, D]") && returnValue.equals("D") && list.size() == 4) {
            System.out.println("Passed test 7.3");
        } else {
            System.out.println("FAILED test 7.3");
        }

        // test 8 remove method
        System.out.println();
        System.out.println("Test 8 remove method");
        returnValue = list.remove(list.size() - 1);
        listString = list.toString();
        if (listString.equals("[D, C, D]") && returnValue.equals("D") && list.size() == 3) {
            System.out.println("Passed test 8.1");
        } else {
            System.out.println("FAILED test 8.1");
        }


        returnValue = list.remove(0);
        listString = list.toString();
        if (listString.equals("[C, D]") && returnValue.equals("D") && list.size() == 2) {
            System.out.println("Passed test 8.2");
        } else {
            System.out.println("FAILED test 8.2");
        }

        returnValue = list.remove(1);
        listString = list.toString();
        if (listString.equals("[C]") && returnValue.equals("D") && list.size() == 1) {
            System.out.println("Passed test 8.3");
        } else {
            System.out.println("FAILED test 8.3");
        }

        addAllChars(list);
        list.remove(9);
        returnValue = list.remove(9);
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("K") && list.size() == 24) {
            System.out.println("Passed test 8.4");
        } else {
            System.out.println("FAILED test 8.4");
        }

        System.out.println();
        System.out.println("Test 9 getSublist method");
        addAllChars(list);
        returnValue = list.getSubList(0, 0).toString();
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("[]") && list.size() == 26) {
            System.out.println("Passed test 9.1");
        } else {
            System.out.println("FAILED test 9.1");
        }

        returnValue = list.getSubList(9, 9).toString();
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("[]") && list.size() == 26) {
            System.out.println("Passed test 9.2");
        } else {
            System.out.println("FAILED test 9.2");
        }

        returnValue = list.getSubList(9, 16).toString();
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("[J, K, L, M, N, O, P]") && list.size() == 26) {
            System.out.println("Passed test 9.3");
        } else {
            System.out.println("FAILED test 9.3");
        }

        returnValue = list.getSubList(9, 26).toString();
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("[J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && list.size() == 26) {
            System.out.println("Passed test 9.4");
        } else {
            System.out.println("FAILED test 9.4");
        }

        // test 10 indexOf(E item)
        System.out.println();
        System.out.println("Test 10 indexOf(E item)");
        returnValue = list.indexOf("J");
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(9) && list.size() == 26) {
            System.out.println("Passed test 10.1");
        } else {
            System.out.println("FAILED test 10.1");
        }

        returnValue = list.indexOf("Z");
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(25) && list.size() == 26) {
            System.out.println("Passed test 10.2");
        } else {
            System.out.println("FAILED test 10.2");
        }

        returnValue = list.indexOf("w");
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(-1) && list.size() == 26) {
            System.out.println("Passed test 10.3");
        } else {
            System.out.println("FAILED test 10.3");
        }

        returnValue = list.indexOf("A");
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(0) && list.size() == 26) {
            System.out.println("Passed test 10.4");
        } else {
            System.out.println("FAILED test 10.4");
        }

        list.set(9, "A");
        returnValue = list.indexOf("A");
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(0) && list.size() == 26) {
            System.out.println("Passed test 10.5");
        } else {
            System.out.println("FAILED test 10.5");
        }

        // test 10 indexOf(E item)
        System.out.println();
        System.out.println("Test 11 indexOf(E item, int pos)");
        returnValue = list.indexOf("A", 1);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(9) && list.size() == 26) {
            System.out.println("Passed test 11.1");
        } else {
            System.out.println("FAILED test 11.1");
        }

        returnValue = list.indexOf("A", 10);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(-1) && list.size() == 26) {
            System.out.println("Passed test 11.2");
        } else {
            System.out.println("FAILED test 11.2");
        }

        returnValue = list.indexOf("Z", 25);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(25) && list.size() == 26) {
            System.out.println("Passed test 11.3");
        } else {
            System.out.println("FAILED test 11.3");
        }

        returnValue = list.indexOf("A", 0);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(0) && list.size() == 26) {
            System.out.println("Passed test 11.4");
        } else {
            System.out.println("FAILED test 11.4");
        }

        returnValue = list.indexOf("A", 0);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(0) && list.size() == 26) {
            System.out.println("Passed test 11.4");
        } else {
            System.out.println("FAILED test 11.4");
        }

        System.out.println();
        System.out.println("Test 12 makeEmpty method");
        list.makeEmpty();
        listString = list.toString();
        if (listString.equals("[]") && returnValue.equals(0) && list.size() == 0) {
            System.out.println("Passed test 12.1");
        } else {
            System.out.println("FAILED test 12.1");
        }

        listString = list.toString();
        if (listString.equals("[]") && returnValue.equals(0) && list.size() == 0) {
            System.out.println("Passed test 12.2");
        } else {
            System.out.println("FAILED test 12.2");
        }

        listString = list.toString();
        if (listString.equals("[]") && returnValue.equals(0) && list.size() == 0) {
            System.out.println("Passed test 12.3");
        } else {
            System.out.println("FAILED test 12.3");
        }

        // test 13 equals method
        System.out.println();
        LinkedList<String> list2 = new LinkedList<>();
        addAllChars(list);
        addAllChars(list2);
        System.out.println("Test 13 equals method");
        listString = list.toString();
        returnValue = list.equals(list2);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(true) && list.size() == 26) {
            System.out.println("Passed test 13.1");
        } else {
            System.out.println("FAILED test 13.1");
        }

        list.removeLast();
        listString = list.toString();
        returnValue = list.equals(list2);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y]") && returnValue.equals(false) && list.size() == 25) {
            System.out.println("Passed test 13.2");
        } else {
            System.out.println("FAILED test 13.2");
        }

        list.makeEmpty();
        list2.makeEmpty();
        listString = list.toString();
        returnValue = list.equals(list2);
        if (listString.equals("[]") && returnValue.equals(true) && list.size() == 0) {
            System.out.println("Passed test 13.3");
        } else {
            System.out.println("FAILED test 13.3");
        }

        listString = list.toString();
        returnValue = list.equals(null);
        if (listString.equals("[]") && returnValue.equals(false) && list.size() == 0) {
            System.out.println("Passed test 13.4");
        } else {
            System.out.println("FAILED test 13.4");
        }

        addAllChars(list);
        listString = list.toString();
        returnValue = list.equals(list);
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(true) && list.size() == 26) {
            System.out.println("Passed test 13.5");
        } else {
            System.out.println("FAILED test 13.5");
        }

        // test 14
        System.out.println();
        System.out.println("test 14 removeRange method");
        list.removeRange(6, 6);
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(true) && list.size() == 26) {
            System.out.println("Passed test 14.1");
        } else {
            System.out.println("FAILED test 14.1");
        }

        list.removeRange(0, 26);
        listString = list.toString();
        if (listString.equals("[]") && returnValue.equals(true) && list.size() == 0) {
            System.out.println("Passed test 14.2");
        } else {
            System.out.println("FAILED test 14.2");
        }

        addAllChars(list);
        list.removeRange(9, 19);
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, T, U, V, W, X, Y, Z]") && returnValue.equals(true) && list.size() == 16) {
            System.out.println("Passed test 14.3");
        } else {
            System.out.println("FAILED test 14.3");
        }

        addAllChars(list);
        list.removeRange(9, 26);
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I]") && returnValue.equals(true) && list.size() == 9) {
            System.out.println("Passed test 14.4");
        } else {
            System.out.println("FAILED test 14.4");
        }

        addAllChars(list);
        list.removeRange(0, 9);
        listString = list.toString();
        if (listString.equals("[J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(true) && list.size() == 17) {
            System.out.println("Passed test 14.5");
        } else {
            System.out.println("FAILED test 14.5");
        }

        System.out.println();
        System.out.println("Test 15 remove (boolean) method");
        addAllChars(list);
        returnValue = list.remove("j");
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(false) && list.size() == 26) {
            System.out.println("Passed test 15.1");
        } else {
            System.out.println("FAILED test 15.1");
        }

        returnValue = list.remove("J");
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(true) && list.size() == 25) {
            System.out.println("Passed test 15.2");
        } else {
            System.out.println("FAILED test 15.2");
        }

        returnValue = list.remove("Z");
        listString = list.toString();
        if (listString.equals("[A, B, C, D, E, F, G, H, I, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y]") && returnValue.equals(true) && list.size() == 24) {
            System.out.println("Passed test 15.3");
        } else {
            System.out.println("FAILED test 15.3");
        }

        returnValue = list.remove("A");
        listString = list.toString();
        if (listString.equals("[B, C, D, E, F, G, H, I, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y]") && returnValue.equals(true) && list.size() == 23) {
            System.out.println("Passed test 15.4");
        } else {
            System.out.println("FAILED test 15.4");
        }

        System.out.println();
        System.out.println("********** Iterator methods **********");

        System.out.println();
        System.out.println("Test 16 hasNext method");
        LinkedList<String> list1 = new LinkedList<>();
        Iterator<String> iterator = list1.iterator();
        returnValue = iterator.hasNext();
        if (list1.toString().equals("[]") && returnValue.equals(false) && list1.size() == 0) {
            System.out.println("Passed test 16.1");
        } else {
            System.out.println("FAILED test 16.1");
        }

        addAllChars(list1);
        Iterator<String> iterator2 = list1.iterator();
        returnValue = iterator2.hasNext();
        if (list1.toString().equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals(true) && list1.size() == 26) {
            System.out.println("Passed test 16.2");
        } else {
            System.out.println("FAILED test 16.2");
        }

        while (iterator2.hasNext()){
            iterator2.next();
            iterator2.remove();
            returnValue = iterator2.hasNext();
        }
        if (list1.toString().equals("[]") && returnValue.equals(false) && list1.size() == 0) {
            System.out.println("Passed test 16.3");
        } else {
            System.out.println("FAILED test 16.3");
        }

        // test 17 next method
        System.out.println();
        System.out.println("Test 17 next method");
        LinkedList<String> list3 = new LinkedList<>();
        addAllChars(list3);
        Iterator<String> iterator3 = list3.iterator();
        returnValue = iterator3.next();
        if (list3.toString().equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("A") && list3.size() == 26) {
            System.out.println("Passed test 17.1");
        } else {
            System.out.println("FAILED test 17.1");
        }

        returnValue = iterator3.next();
        if (list3.toString().equals("[A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("B") && list3.size() == 26) {
            System.out.println("Passed test 17.2");
        } else {
            System.out.println("FAILED test 17.2");
        }

        iterator3.remove();
        returnValue = iterator3.next();
        if (list3.toString().equals("[A, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("C") && list3.size() == 25) {
            System.out.println("Passed test 17.3");
        } else {
            System.out.println("FAILED test 17.3");
        }

        while (iterator3.hasNext()){
            returnValue = iterator3.next();
        }
        if (list3.toString().equals("[A, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("Z") && list3.size() == 25) {
            System.out.println("Passed test 17.4");
        } else {
            System.out.println("FAILED test 17.4");
        }

        System.out.println();
        System.out.println("Test 18 remove method");
        LinkedList<String> list4 = new LinkedList<>();
        addAllChars(list4);
        Iterator<String> iterator4 = list4.iterator();
        returnValue = iterator4.next();
        iterator4.remove();
        if (list4.toString().equals("[B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("A") && list4.size() == 25) {
            System.out.println("Passed test 18.1");
        } else {
            System.out.println("FAILED test 18.1");
        }

        for(int i = 0; i < 6; i++){
            returnValue = iterator4.next();
        }
        iterator4.remove();
        if (list4.toString().equals("[B, C, D, E, F, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z]") && returnValue.equals("G") && list4.size() == 24) {
            System.out.println("Passed test 18.2");
        } else {
            System.out.println("FAILED test 18.2");
        }

        while (iterator4.hasNext()) {
            returnValue = iterator4.next();
        }
        iterator4.remove();
        if (list4.toString().equals("[B, C, D, E, F, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y]") && returnValue.equals("Z") && list4.size() == 23) {
            System.out.println("Passed test 18.3");
        } else {
            System.out.println("FAILED test 18.3");
        }

        LinkedList<String> list5 = new LinkedList<>();
        addAllChars(list5);
        Iterator<String> iterator5 = list5.iterator();
        while (iterator5.hasNext()){
            iterator5.next();
            iterator5.remove();
        }
        if (list5.toString().equals("[]") && returnValue.equals("Z") && list5.size() == 0) {
            System.out.println("Passed test 18.4");
        } else {
            System.out.println("FAILED test 18.4");
        }

//        comparison();
    }

    private static void addAllChars(LinkedList<String> list) {
        list.makeEmpty();
        for (int i = 65; i < 91; i++) {
            String letter = "" + (char) i;
            list.addLast(letter);
        }
    }

    /*
     * Runs very basic tests on the LinkedList class for
     * CS314 assignment 4.
     */
    private static void basicTests() {

        System.out.println("****** BASIC TESTS *******\n");
        LinkedList<String> list = new LinkedList<>();

        // test 0
        System.out.println("\nTest 0: initial list is empty");
        if (list.toString().equals("[]")) {
            System.out.println("Passed test 0");
        } else {
            System.out.println("Failed test 0");
        }

        // test 0.1
        System.out.println("\nTest 0.1: add to end");
        list.add("A");
        if (list.get(0).equals("A")) {
            System.out.println("Passed test 0.1");
        } else {
            System.out.println("Failed test 0.1");
        }

        // test 0.2
        System.out.println("\nTest 0.2: size");
        if (list.size() == 1) {
            System.out.println("Passed test 0.2");
        } else {
            System.out.println("Failed test 0.2");
        }

        // test 0.3
        System.out.println("\nTest 0.3: remove from position 0");
        String removed = list.remove(0);
        if (removed.equals("A")) {
            System.out.println("Passed test 0.31");
        } else {
            System.out.println("Failed test 0.31");
        }

        System.out.println("\nTest 0.31: toString after remove");

        // test 0.31
        if (list.toString().equals("[]")) {
            System.out.println("Passed test 0.3");
        } else {
            System.out.println("Failed test 0.3");
        }

        // test 0.4
        System.out.println("\nTest 0.4: size");
        if (list.size() == 0) {
            System.out.println("Passed test 0.4");
        } else {
            System.out.println("Failed test 0.4");
        }

        // test 0.5
        System.out.println("\nTest 0.5: add and toString");
        list.add("A");
        list.add("B");
        if (list.toString().equals("[A, B]")) {
            System.out.println("Passed test 0.5");
        } else {
            System.out.println("Failed test 0.5");
        }

        // test 0.6
        System.out.println("\nTest 0.6: size");
        if (list.size() == 2) {
            System.out.println("Passed test 0.6");
        } else {
            System.out.println("Failed test 0.6");
        }

        // test 0.7
        System.out.println("\nTest 0.7: makeEmpty");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 0.7");
        } else {
            System.out.println("Failed test 0.7");
        }

      // test 0.8
        System.out.println("\nTest 0.8: makeEmpty on empty list");
        list.makeEmpty();
        if (list.size() == 0) {
            System.out.println("Passed test 0.8");
        } else {
            System.out.println("Failed test 0.8");
        }


        // test 1
        System.out.println("\nTest 1: Adding at end");
        list = new LinkedList<>();
        list.add("A");
        Object[] actual = toArray(list);
        Object[] expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 1");
        } else {
            System.out.println("Failed test 1");
        }


        // test 2
        System.out.println("\nTest 2: making empty");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 2");
        } else {
            System.out.println("Failed test 2");
        }

        // test 3
        System.out.println("\nTest 3: Adding at pos 0 in empty list");
        list.insert(0, "A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 3");
        } else {
            System.out.println("Failed test 3");
        }

        //test 4
        System.out.println("\nTest 4: Adding at front");
        list = new LinkedList<>();
        list.addFirst("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 4");
        } else {
            System.out.println("Failed test 4");
        }


        // test 5
        System.out.println("\nTest 5: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 5");
        } else {
            System.out.println("Failed test 5");
        }


        // test 6
        list = new LinkedList<>();
        System.out.println("\nTest 6: Adding at end");
        list.addLast("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 6");
        } else {
            System.out.println("Failed test 6");
        }


        // test 7
        System.out.println("\nTest 7: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 7");
        } else {
            System.out.println("Failed test 7");
        }

        // test 8
        System.out.println("\nTest 8: Adding at middle");
        list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.insert(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 8");
        } else {
            System.out.println("Failed test 8");
        }


        // test 9
        System.out.println("\nTest 9: Setting");
        list = new LinkedList<>();
        list.add("A");
        list.add("D");
        list.add("C");
        String oldValue = list.set(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected) ) {
            System.out.println("Passed test 9.1");
        } else {
            System.out.println("Failed test 9.1");
        }
        if (oldValue.equals("D")) {
            System.out.println("Passed test 9.2");
        } else {
            System.out.println("Failed test 9.2");
        }


        // test 10
        System.out.println("\nTest 10: Removing");
        list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.remove(0);
        list.remove( list.size() - 1 );
        actual = toArray(list);
        expected = new Object[] {"B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 10");
        } else {
            System.out.println("Failed test 10");
        }
    }


    // constants for the maximum length of the lists used in the tests as well as
    // the number of times each method should be tested
    private static final int MAX_LENGTH = 15;
    private static final int NUM_TESTS_PER_METHOD = 50;

    // From Spring 2021 students:
    // Tests use randomness to find edge cases,
    // so the test numbering is irrelevant, each test being different every time the
    // program is run.
    private static void spring2021StressTests() {
        System.out.println("\n****** SPRING 2021 RANDOM STRESS TESTS *******\n");

        // performs all the tests. The console displays some private methods I have as
        // well, but it isn't actually directly calling those private methods. It merely
        // sets the conditions to where those methods would be called in my personal
        // program. It still is useful to test for edge cases

        final String methodNamesRaw = "void addFirst(E item)\r\n" + "void addLast(E item)\r\n" + "E removeFirst()\r\n"
                + "E removeLast()\r\n" + "void add(E item)\r\n" + "void insert(int pos, E item)\r\n"
                + "void insertBeforeLast(E item)\r\n" + "void insertAfterFirst(E item)\r\n" + "E set(pos, E item)\r\n"
                + "E get(int pos)\r\n" + "E remove(int pos)\r\n" + "E removeAFterFirst()\r\n"
                + "E removeBeforeLast()\r\n" + "boolean remove(E obj)\r\n"
                + "Ilist<E> getSubList(int start, int stop)\r\n" + "int size()\r\n" + "int indexOf(E item)\r\n"
                + "int indexOf(E item, int pos)\r\n" + "void makeEmpty()\r\n"
                + "void removeRange(int start, int stop)\r\n" + "string tosString()\r\n" + "boolean equals(other)\r\n"
                + "ITERATOR LLIterator()\r\n" + "ITERATOR boolean hasNext()\r\n" + "ITERATOR E next()\r\n"
                + "ITERATOR void remove()\r\n";
        final String[] methodNames = methodNamesRaw.split("\r\n");
        String methodName = methodNames[0];
        int methodNum = 0;
        LinkedList<String> testList = new LinkedList<>();
        int numTestsFailed = 0;
        HashSet<String> failedTests = new HashSet<>();
        // void addFirst(E item)
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            testList.addFirst(methodName);
            toCompare.add(0, methodName);
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void addLast(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.addLast(methodName);
            toCompare.add(methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeFirst();
            toCompare.remove(0);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.removeLast();
            toCompare.remove(toCompare.size() - 1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void add(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.add(methodName);
            toCompare.add(methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insert(int pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int randomPos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.insert(randomPos, methodName);
            toCompare.add(randomPos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void insertBeforeLast(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void insertAfterFirst(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = 1;

            // perform actions here
            testList.insert(pos, methodName);
            toCompare.add(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E set(pos, E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.set(pos, methodName);
            toCompare.set(pos, methodName);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // E get(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here

            String expected = toCompare.get(pos);
            String actual = testList.get(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E remove(int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());

            // perform actions here
            testList.remove(pos);
            toCompare.remove(pos);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeAFterFirst()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            if (toCompare.size() == 1) {
                toCompare.add("Item " + 2);
                testList.add("Item " + 2);
            }
            // perform actions here
            testList.remove(1);
            toCompare.remove(1);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // E removeBeforeLast()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = toCompare.size() - 2;
            if (pos == -1) {
                pos = 0;
            }
            // perform actions here

            String expected = toCompare.remove(pos);
            String actual = testList.remove(pos);

            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean remove(E obj)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            String objToRemove = toCompare.get((int) (Math.random() * toCompare.size()));

            // perform actions here
            testList.remove(objToRemove);
            toCompare.remove(objToRemove);

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // Ilist<E> getSubList(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int size()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            IList<String> actualA = testList.getSubList(start, stop);
            List<String> expectedB = toCompare.subList(start, stop);
            String[] expected = expectedB.toArray(new String[expectedB.size()]);
            String[] actual = toArray2(actualA);
            if (actualA.size() == expectedB.size()) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // int indexOf(E item)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos = (int) (Math.random() * toCompare.size());
            toCompare.add(pos, methodName);
            testList.insert(pos, methodName);
            // perform actions here

            int expected = toCompare.indexOf(methodName);
            int actual = testList.indexOf(methodName);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // int indexOf(E item, int pos)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            int pos2 = (int) (Math.random() * toCompare.size()) + 1;
            int pos1 = (int) (Math.random() * pos2);
            toCompare.add(pos1, methodName);
            toCompare.add(pos2, methodName);
            testList.insert(pos1, methodName);
            testList.insert(pos2, methodName);

            int posToCheckFrom = (int) (Math.random() * toCompare.size());
            // perform actions here
            int expected;
            if (posToCheckFrom > pos2) {
                expected = -1;
            } else if (posToCheckFrom > pos1 && posToCheckFrom <= pos2) {
                expected = pos2;
            } else {
                expected = pos1;
            }

            int actual = testList.indexOf(methodName, posToCheckFrom);

            if (expected == actual) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual + "  toCompare Array: " + toCompare.toString()
                        + " testList array " + testList.toString() + "  POS1: " + pos1 + " POS2: " + pos2
                        + " POSTTOCHECK: " + posToCheckFrom);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // void makeEmpty()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            testList.makeEmpty();
            toCompare.clear();

            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // void removeRange(int start, int stop)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            int start = (int) (Math.random() * toCompare.size());
            int stop = (int) (Math.random() * (toCompare.size() - start) + start);
            // perform actions here
            testList.removeRange(start, stop);
            for (int j = stop - 1; j >= start; j--) {
                toCompare.remove(j);
            }
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual) + " START: " + start
                        + " STOP: " + stop);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // string tosString()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here

            String expected = toCompare.toString();
            String actual = testList.toString();
            if (expected.equals(actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: " + expected
                        + " Actual Output = " + actual);
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // boolean equals(other)
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            LinkedList<String> toCompareLinkedList = arrayListToLinkedList(toCompare);
            // perform actions here

            if (testList.equals(toCompareLinkedList)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR LLIterator()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);
            // perform actions here

            if (testList.iterator().hasNext() && testList.iterator().next().equals(testList.get(0))) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + toCompare.toString() + " Actual Output = " + testList.toString());
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();

        // ITERATOR boolean hasNext()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int count1 = 0;
            int count2 = 0;
            while (testListIterator.hasNext()) {
                count1++;
                testListIterator.next();
            }
            while (toCompareIterator.hasNext()) {
                count2++;
                toCompareIterator.next();
            }

            if (count1 == count2) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR E next()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            boolean pass = true;
            while (testListIterator.hasNext() && toCompareIterator.hasNext() && pass) {
                if (!testListIterator.next().equals(toCompareIterator.next())) {
                    pass = false;
                }
            }
            if (testListIterator.hasNext() != toCompareIterator.hasNext()) {
                pass = false;
            }

            if (pass) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: ");
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        // ITERATOR void remove()
        methodNum++;
        methodName = methodNames[methodNum];
        for (int i = 0; i < NUM_TESTS_PER_METHOD; i++) {
            System.out.print("Testing Method " + methodName + " test number " + i);
            testList = newResetedTestList(testList);
            ArrayList<String> toCompare = linkedListToArrayList(testList);

            // perform actions here
            Iterator<String> testListIterator = testList.iterator();
            Iterator<String> toCompareIterator = toCompare.iterator();
            int random = (int) (Math.random() * toCompare.size()) + 1;
            for (int j = 0; j < random; j++) {
                if (testListIterator.hasNext()) {
                    testListIterator.next();
                }
                if (toCompareIterator.hasNext()) {
                    toCompareIterator.next();
                }
            }
            toCompareIterator.remove();
            testListIterator.remove();
            String[] expected = toCompare.toArray(new String[toCompare.size()]);
            String[] actual = toArray2(testList);
            if (arraysSame(expected, actual)) {
                System.out.println("   " + methodName + " test " + i + " PASSED");
            } else {
                System.out.println("   " + methodName + " test " + i + " FAILED    Expected OutPut: "
                        + Arrays.toString(expected) + " Actual Output = " + Arrays.toString(actual));
                numTestsFailed++;
                failedTests.add(methodName);
            }
        }
        System.out.println();
        System.out.println("RESULTS:");
        System.out.println("TOTAL TESTS: " + (NUM_TESTS_PER_METHOD * methodNames.length) + " | TOTAL FAILED: "
                + numTestsFailed + " | FAILED METHODS: " + failedTests.toString() + " |");
    }


    private static LinkedList<String> newResetedTestList(LinkedList<String> a) {
        a.makeEmpty();
        int random = (int) (Math.random() * MAX_LENGTH) + 1;
        for (int j = 0; j < random; j++) {
            a.add("Item " + (j));
        }
        return a;
    }

    private static ArrayList<String> linkedListToArrayList(LinkedList<String> testList) {
        ArrayList<String> result = new ArrayList<>();
        Iterator<String> s = testList.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static LinkedList<String> arrayListToLinkedList(ArrayList<String> toCompare) {
        LinkedList<String> result = new LinkedList<>();
        Iterator<String> s = toCompare.iterator();
        while (s.hasNext()) {
            result.add(s.next());
        }
        return result;
    }

    private static String[] toArray2(IList<String> actualA) {
        String[] result = new String[actualA.size()];
        Iterator<String> it = actualA.iterator();
        int index = 0;
        while (it.hasNext()) {
            result[index] = it.next();
            index++;
        }
        return result;
    }

    private static void itRemoveStressTests() {
        /*
         *  Test that the iterator remove is O(1).
         *  Total time to remove half of list should roughly double
         *  when size of list is doubled.
         */
        final int SEED = 19431215;
        Random r = new Random(SEED);
        Stopwatch st = new Stopwatch();
        int n = 50_000;
        for (int i = 0; i < 6; i++) {
            LinkedList<Double> list = new LinkedList<>();
            for (int j =0; j < n; j++) {
                list.add(r.nextDouble());
            }
            Iterator<Double> it = list.iterator();
            final int LIMIT = n / 2;
            for (int j = 0; j < LIMIT; j++) {
                it.next();
            }
            st.start();
            while(it.hasNext()) {
                it.next();
                it.remove();
            }
            st.stop();
            System.out.println("number of elements = " + n
                    + " time to remove half of list with iterator = " + st);
            n *= 2;
        }
    }

    // Convert elements of list to an array. Uses the list
    // size method and iterator.
    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while(it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }


    private static final int NUM_DOUBLINGS_OF_N = 5;
    private static final int NUM_REPEATS_OF_TEST = 100;

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    private static void comparison(){
        Stopwatch s = new Stopwatch();

        int initialN = 30000;
        addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 10000;
        addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 2000;
        removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 5000;
        removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 10000;
        getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 50000;
        getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
        getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 100000;
        getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 1000;
        getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

    }

    // These pairs of methods illustrate a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    private static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: ArrayList", totalTimes, initialN);
    }

    private static void showResults(String title, double[] times, int initialN) {
        System.out.println();
        System.out.println("Number of times test run: " + NUM_REPEATS_OF_TEST);
        System.out.println(title);
        for (double time : times) {
            System.out.print("N = " + initialN + ", total time: ");
            System.out.printf("%7.4f\n", time);
            initialN *= 2;
        }
        System.out.println();
    }

    private static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: LinkedList", totalTimes, initialN);
    }

    private static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: ArrayList", totalTimes, initialN);
    }

    private static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.insert(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: LinkedList", totalTimes, initialN);
    }

    private static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<String> javaList = new ArrayList<>();
                for(int j = 0; j < n; j++)
                    javaList.add(j + "");
                s.start();
                while (!javaList.isEmpty()) {
                    javaList.remove(0);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Removing from front: ArrayList", totalTimes, initialN);
    }

    private static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<String> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j + "");
                }
                s.start();
                while (studentList.size() != 0) {
                    studentList.removeFirst();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("removing from front: LinkedList", totalTimes, initialN);
    }

    private static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                for (int j = 0; j < n; j++) {
                    total += javaList.get(r.nextInt(javaList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: ArrayList", totalTimes, initialN);
    }

    private static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                int total = 0;
                s.start();
                for (int j = 0; j < n; j++) {
                    total += studentList.get(r.nextInt(studentList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                Iterator<Integer> it = javaList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                Iterator<Integer> it = studentList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < javaList.size(); j++) {
                    x += javaList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < studentList.size(); j++) {
                    x += studentList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: LinkedList", totalTimes, initialN);
    }
}
