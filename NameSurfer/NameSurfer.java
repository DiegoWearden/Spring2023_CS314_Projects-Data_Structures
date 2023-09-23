/*
 * Student information for assignment: Replace <NAME> in the following with your
 * name. You are stating, on your honor you did not copy any other code on this
 * assignment and have not provided your code to anyone. 
 * 
 * On my honor, Diego Wearden, this programming assignment is my own work
 * and I have not provided this code
 * to any other student. 
 * 
 * UTEID: daw3784
 * email address: dialwera@gmail.com
 * Number of slip days I am using: 0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NameSurfer {

    // CS314 students, explain your menu option 7 here:
    // my menu option 7 looks for the names in the database with the
    //  specified number of letters in its name. (Ex: looks for all names with
    //  3 C's or all names with 4 E's etc.)

    // CS314 students, Explain your interesting search / trend here:
    // one interesting trend that I have realized is that as time goes on there
    // seems to be a more diversity of names now then there was a long time ago.
    // nowadays, it seems like names such as Xander and Xzavier are more prevalent
    // because of their uniqueness. This is the data for those names:
    //
    //Xander
    //1900: 0
    //1910: 0
    //1920: 0
    //1930: 0
    //1940: 0
    //1950: 0
    //1960: 0
    //1970: 0
    //1980: 0
    //1990: 0
    //2000: 934

    //Xzavier
    //1900: 0
    //1910: 0
    //1920: 0
    //1930: 0
    //1940: 0
    //1950: 0
    //1960: 0
    //1970: 0
    //1980: 0
    //1990: 0
    //2000: 870
    // as you can see, these names were not really introduced until very recently
    // which is when the diversity of names increased as people wanted more unique names.
    // A long time ago, names like John, William, Mary
    // were the only names that people really ever had so those were a lot more common
    // than now.
    // John
    //1900: 1
    //1910: 1
    //1920: 2
    //1930: 3
    //1940: 3
    //1950: 4
    //1960: 3
    //1970: 6
    //1980: 9
    //1990: 14
    //2000: 14

    // William
    //1900: 2
    //1910: 2
    //1920: 4
    //1930: 4
    //1940: 4
    //1950: 6
    //1960: 7
    //1970: 9
    //1980: 15
    //1990: 19
    //2000: 11

    // Mary
    //1900: 1
    //1910: 1
    //1920: 1
    //1930: 1
    //1940: 1
    //1950: 1
    //1960: 2
    //1970: 15
    //1980: 34
    //1990: 41
    //2000: 47
    // as you can see, these names have decreased a lot in the recent decades because
    // of the desire for more unique names and at the time, when they were very popular
    // it seems like it was because there wasn't much diversity in how people chose names
    // back then

    // CS314 students, add test code for NameRecord class here:
    //        // test 1
//        System.out.println("Test 1: getNameRecordRankOfDecade");
//        int actualInt = jakeRecord.getNameRecordRankOfDecade(0);
//        int expectedInt = 262;
//        if (expectedInt == actualInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        String record = "Christene 0 895 768 0 0 0 0 0 0";
//        baseYear = 1910;
//        NameRecord nameRecord = new NameRecord(record, baseYear);
//        actualInt = nameRecord.getNameRecordRankOfDecade(2);
//        expectedInt = 768;
//        if (expectedInt == actualInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }

//        record = "Christene 0 895 768 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, baseYear, 9);
//        actualInt = nameRecord.getNameRecordRankOfDecade(2);
//        expectedInt = 768;
//        if (expectedInt == actualInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }

//        actualInt = jakeRecord.getNameRecordRankOfDecade(11);
//        expectedInt = 262;
//        if (expectedInt == actualInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        actualInt = jakeRecord.getNameRecordRankOfDecade(-1);
//        expectedInt = 262;
//        if (expectedInt == actualInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }

    // test 2
//        System.out.println("Test 2: getName");
//
//        actual = jakeRecord.getName();
//        expected = "Jake";
//        if (expected.equals(actual)){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//
//        actual = jakeRecord.getName();
//        expected = "Jake";
//        if (expected.equals(actual)){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//
//        record = "Christene 0 895 768 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, baseYear);
//        actual = nameRecord.getName();
//        expected = "Christene";
//        if (expected.equals(actual)){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        // test 3 getBaseYear
//        System.out.println("Test 3: getBaseYear");
//        actualInt = jakeRecord.getBaseYear();
//        expectedInt = 1900;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        actualInt = nameRecord.getBaseYear();
//        expectedInt = 1910;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }

    // test 4 NameRecord
//        nameRecord = new NameRecord(null, 10);

//        nameRecord = new NameRecord("\n", 10);
//
//        nameRecord = new NameRecord("", 10);
//
//        // test 5 getNumDecades
//        System.out.println("Test 5: getNumDecades");
//
//        actualInt = jakeRecord.getNumDecades();
//        expectedInt = 11;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        actualInt = nameRecord.getNumDecades();
//        expectedInt = 9;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        // test 6 getMostPopularDecade
//
//        System.out.println("Test 6: getMostPopularDecade");
//
//        actualInt = jakeRecord.getMostPopularDecade();
//        expectedInt = 2000;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        actualInt = nameRecord.getMostPopularDecade();
//        expectedInt = 1930;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        System.out.println("Test 7: numberOfDecadesInTop1000");
//
//        actualInt = jakeRecord.numberOfDecadesInTop1000();
//        expectedInt = 11;
//
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        actualInt = nameRecord.numberOfDecadesInTop1000();
//        expectedInt = 2;
//
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Reginald 0 0 0 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, baseYear);
//        actualInt = nameRecord.numberOfDecadesInTop1000();
//        expectedInt = 0;
//
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Reginald 365 314 311 236 151 134 172 212 275";
//        nameRecord = new NameRecord(record, baseYear);
//        actualInt = nameRecord.numberOfDecadesInTop1000();
//        expectedInt = 9;
//
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        System.out.println("Test 8: isRankedInEveryDecade");
//        boolean actualBool = nameRecord.isRankedInEveryDecade();
//        boolean expectedBool = true;
//
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        actualBool = jakeRecord.isRankedInEveryDecade();
//        expectedBool = true;
//
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Carleton 909 752 767 840 820 0 0 0 0";
//        nameRecord = new NameRecord(record, baseYear);
//        actualBool = nameRecord.isRankedInEveryDecade();
//        expectedBool = false;
//
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Reginald 0 0 0 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, baseYear);
//        actualBool = nameRecord.isRankedInEveryDecade();
//        expectedBool = false;
//
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        System.out.println("Test 9: isRankedInOneDecade");
//
//        actualBool = jakeRecord.isRankedInOneDecade();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        actualBool = nameRecord.isRankedInOneDecade();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Abigayle 0 0 0 0 0 0 0 0 0 0 720";
//        nameRecord = new NameRecord(record, 1900);
//        actualBool = nameRecord.isRankedInOneDecade();
//        expectedBool = true;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Eveline 890 0 0 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, baseYear);
//        actualBool = nameRecord.isRankedInOneDecade();
//        expectedBool = true;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Eveline 0 0 0 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, baseYear);
//        actualBool = nameRecord.isRankedInOneDecade();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        System.out.println("Test 9: isAlwaysMorePopular");
//
//        actualBool = nameRecord.isAlwaysMorePopular();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 9 8 7 6 6 4 3 2 1";
//        nameRecord = new NameRecord(record, 1910);
//        actualBool = nameRecord.isAlwaysMorePopular();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 0 0 0 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, 1910);
//        actualBool = nameRecord.isAlwaysMorePopular();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 9 8 7 6 5 4 3 2 01";
//        nameRecord = new NameRecord(record, 1910);
//        actualBool = nameRecord.isAlwaysMorePopular();
//        expectedBool = true;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 9 8 7 6 5 4 3 2 1";
//        nameRecord = new NameRecord(record, 1910);
//        actualBool = nameRecord.isAlwaysMorePopular();
//        expectedBool = true;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 9 8 7 6 5 4 3 2 1 0";
//        nameRecord = new NameRecord(record, 1910);
//        actualBool = nameRecord.isAlwaysMorePopular();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }

//        record = "Bruh 0 fg 0 0 0 0 0 0 0";
//        nameRecord = new NameRecord(record, 1910);
//        actualBool = nameRecord.isAlwaysMorePopular();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        System.out.println("Test 10: isAlwaysLessPopular");
//
//        record = "Bruh 0 1 2 3 4 5 6 7 8";
//        actualBool = nameRecord.isAlwaysLessPopular();
//        expectedBool = false;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 1 2 3 4 5 6 7 8 9";
//        nameRecord = new NameRecord(record, 1900);
//        actualBool = nameRecord.isAlwaysLessPopular();
//        expectedBool = true;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }

//        record = "Bruh 1 \n 3 4 5 6 7 8 9";
//        nameRecord = new NameRecord(record, 1900);
//        actualBool = nameRecord.isAlwaysLessPopular();
//        expectedBool = true;
//        if (actualBool == expectedBool){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        System.out.println("Test 11: toString");
//
//        record = "Bruh 1 2 3 4 5 6 7 8 9";
//        nameRecord = new NameRecord(record, 1900);
//        actual = nameRecord.toString();
//        expected = "Bruh\n1900: 1\n1910: 2\n1920: 3\n1930: 4\n1940: "
//                + "5\n1950: 6\n1960: 7\n1970: 8\n1980: 9\n";
//        if (actual.equals(expected)){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 1 2 3 4 5 6 7 8 9";
//        nameRecord = new NameRecord(record, 1810);
//        actual = nameRecord.toString();
//        expected = "Bruh\n1810: 1\n1820: 2\n1830: 3\n1840: 4\n1850: "
//                + "5\n1860: 6\n1870: 7\n1880: 8\n1890: 9\n";
//        if (actual.equals(expected)){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 1 2 3 4 5 6 7 8 9";
//        nameRecord = new NameRecord(record, 1810);
//        actual = nameRecord.toString();
//        expected = "Bruh\n1810: 1\n1820: 2\n1830: 3\n1840: 4\n1850: "
//                + "5\n1860: 6\n1870: 7\n1880: 8\n1890: 9\n";
//        if (actual.equals(expected)){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 1 \n 3 4 5 6 7 8 ";
//        nameRecord = new NameRecord(record, 1810);
//        actual = nameRecord.toString();
//        expected = "Bruh\n1810: 1\n1820: 3\n1830: 4\n1840: 5\n1850: "
//                + "6\n1860: 7\n1870: 8\n";
//        if (actual.equals(expected)){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        System.out.println("Test 12: compareTo");
//
//        record = "Bruh 1 2 3 4 5 6 7 8 9";
//        String otherRecord = "Bruh2 1 2 3 4 5 6 7 8 9 10";
//        nameRecord = new NameRecord(record, 1810);
//        NameRecord nameRecord1 = new NameRecord(otherRecord, 1810);
//        actualInt = nameRecord.compareTo(nameRecord1);
//        expectedInt = -1;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 1 2 3 4 5 6 7 8 9";
//        nameRecord = new NameRecord(record, 1810);
//        nameRecord1 = new NameRecord(record, 1810);
//        actualInt = nameRecord.compareTo(nameRecord1);
//        expectedInt = 0;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
//
//        record = "Bruh 1 2 3 4 5 6 7 8 9";
//        otherRecord = "Bruh2 1 2 3 4 5 6 7 8 9 10";
//        nameRecord = new NameRecord(otherRecord, 1810);
//        nameRecord1 = new NameRecord(record, 1810);
//        actualInt = nameRecord.compareTo(nameRecord1);
//        expectedInt = 1;
//        if (actualInt == expectedInt){
//            System.out.println("TEST PASSED");
//        }
//        else{
//            System.out.println("TEST FAILED");
//        }
    //

    // A few simple tests for the Names and NameRecord class.
    public static void simpleTest() {
        // raw data for Jake. Alter as necessary for your NameRecord
        String jakeRawData = "Jake 262 312 323 479 484 630 751 453 225 117 97";
        int baseYear = 1900;
        NameRecord jakeRecord =  new NameRecord(jakeRawData, baseYear);
        String expected = "Jake\n1900: 262\n1910: 312\n1920: 323\n1930: 479\n1940: "
                + "484\n1950: 630\n1960: 751\n1970: 453\n1980: 225\n1990: "
                + "117\n2000: 97\n";
        String actual = jakeRecord.toString();
        System.out.println("expected string:\n" + expected);
        System.out.println("actual string:\n" + actual);
        if (expected.equals(actual)) {
            System.out.println("passed Jake toString test.");
        } else {
            System.out.println("FAILED Jake toString test."); 
        }

        // Some getName Tests
        String NAME_FILE = "names.txt";
        Names names = new Names(getFileScannerForNames(NAME_FILE));
        String[] testNames = {"Isabelle", "isabelle", "sel", 
                "X1178", "ZZ", "via", "kelly"};
        boolean[] expectNull = {false, false, true, true, true, true, false};
        for (int i = 0; i < testNames.length; i++) {
            performGetNameTest(names, testNames[i], expectNull[i]);
        }

    }

    // Checks if given name is present in Names.
    private static void performGetNameTest(Names names, String name, 
            boolean expectNull) {
        
        System.out.println("Performing test for this name: " + name);
        if (expectNull) {
            System.out.println("Expected return value is null");
        } else {
            System.out.println("Expected return value is not null");
        }
        NameRecord result = names.getName(name);
        if ((expectNull && result == null) || (!expectNull && result != null)) {
            System.out.println("PASSED TEST.");
        } else {
            System.out.println("Failed test");
        }
    }

    // main method. Driver for the whole program
    public static void main(String[] args) {
        // Delete the following line in the final version of your program.

        // Alter name of file to try different data sources.
        final String NAME_FILE = "names.txt";
        Scanner fileScanner = getFileScannerForNames(NAME_FILE);
        Names namesDatabase = new Names(fileScanner);
        fileScanner.close();
        runOptions(namesDatabase);
        fileScanner.close();
    }

    /* pre: namesDatabase != null
     * Ask user for options to perform on the given Names object.
     * Creates a Scanner connected to System.in.
     */
    private static void runOptions(Names namesDatabase) {
        Scanner keyboard = new Scanner(System.in);
        MenuChoices[] menuChoices = MenuChoices.values();
        MenuChoices menuChoice;
        do {
            showMenu();
            int userChoice = getChoice(keyboard) - 1;
            menuChoice = menuChoices[userChoice];
            if(menuChoice == MenuChoices.SEARCH) {
                search(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.ONE_NAME) {
                oneName(namesDatabase, keyboard);
            } else if (menuChoice == MenuChoices.APPEAR_ONCE) {
                appearOnce(namesDatabase);
            } else if (menuChoice == MenuChoices.APPEAR_ALWAYS) {
                appearAlways(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_MORE) {
                alwaysMore(namesDatabase);
            } else if (menuChoice == MenuChoices.ALWAYS_LESS) {
                alwaysLess(namesDatabase);
            } else if (menuChoice == MenuChoices.STUDENT_SEARCH) {
                mostAmountOfLetters(namesDatabase, keyboard);
            }
        } while(menuChoice != MenuChoices.QUIT);
        keyboard.close();
    }

    /**
     * gets all the names with a specific number of a specific letter in its name
     * @param namesDatabase pre: n != null
     * @param keyboard pre: n != null
     */
    private static void mostAmountOfLetters(Names namesDatabase, Scanner keyboard) {
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        String prompt = "Enter a number: ";
        System.out.print(prompt);
        while (!keyboard.hasNextInt()) {
            keyboard.next();
            System.out.println("That was not a number.");
            System.out.print(prompt);
        }
        int numberOfCharacters = keyboard.nextInt();
        prompt = "Enter a letter: ";
        System.out.print(prompt);
        String character = keyboard.next();
        while(character.length() != 1){
            System.out.println("that is not a character");
            System.out.print(prompt);
            character = keyboard.next();
        }
        ArrayList<NameRecord> namesWithMostAmountOfCharacter =
                namesDatabase.getNameWithMostAmountOfLettersOf(character, numberOfCharacters);
        System.out.println();
        if (namesWithMostAmountOfCharacter.size() > 0){
            boolean plural = (namesWithMostAmountOfCharacter.size() > 1);
            System.out.println("The " + namesWithMostAmountOfCharacter.size() +
                    (plural ? " names " : " name ") +  "with " +
                    numberOfCharacters + " number of " + character.toUpperCase()
                    + "'s in " + (plural ? "their " : "its ") + (plural ? "names " : "name ")
                    + "with " + (plural ? "their " : "its ") + "highest ranking decade "
                    + (plural ? "are" : "is") + ": ");
            for (int i = 0; i < namesWithMostAmountOfCharacter.size(); i++){
                NameRecord nameRecord = namesWithMostAmountOfCharacter.get(i);
                String name = nameRecord.getName();
                int highestRankingDecade = nameRecord.getMostPopularDecade();
                System.out.println(name + " " + highestRankingDecade);
            }
        }
        else {
            System.out.println("There is no name that contains that many number of " + character.toUpperCase() + "'s");
        }
    }

    /* Create a Scanner and return connected to a File with the given name.
     * pre: fileName != null
     * post: Return a Scanner connected to the file or null
     * if the File does not exist in the current directory.
     */
    private static Scanner getFileScannerForNames(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("\n***** ERROR IN READING FILE ***** ");
            System.out.println("Can't find this file " 
                    + fileName + " in the current directory.");
            System.out.println("Error: " + e);
            String currentDir = System.getProperty("user.dir");
            System.out.println("Be sure " + fileName + " is in this directory: ");
            System.out.println(currentDir);
            System.out.println("\nReturning null from method.");
            sc = null;
        }
        return sc;
    }

    /* Display the names that have appeared in every decade.
     * pre: n != null
     * post: print out names that have appeared in ever decade
     */
    private static void appearAlways(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter namesDatabase cannot be null");
        }
        ArrayList<String> everyDecade = namesDatabase.rankedEveryDecade();
        System.out.println( everyDecade.size() + " names appear in every decade. The names are: ");
        for (int i = 0; i < everyDecade.size(); i++){
            System.out.println(everyDecade.get(i));
        }
    }

    /* Display the names that have appeared in only one decade.
     * pre: n != null
     * post: print out names that have appeared in only one decade
     */
    private static void appearOnce(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }
        ArrayList<String> oneDecade = namesDatabase.rankedOnlyOneDecade();
        System.out.println(oneDecade.size() + " names appear in exactly one decade. The names are: ");
        for (int i = 0; i < oneDecade.size(); i++){
            System.out.println(oneDecade.get(i));
        }
    }
    
    /* Display the names that have gotten more popular
     * in each successive decade.
     * pre: n != null
     * post: print out names that have gotten more popular in each decade
     */
    private static void alwaysMore(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }
        ArrayList<String> alwaysMore = namesDatabase.alwaysMorePopular();
        System.out.println( alwaysMore.size() + " names are more popular in every decade. ");
        for (int i = 0; i < alwaysMore.size(); i++){
            System.out.println(alwaysMore.get(i));
        }
    }
    
    /* Display the names that have gotten less popular 
     * in each successive decade.
     * pre: n != null
     * post: print out names that have gotten less popular in each decade
     */
    private static void alwaysLess(Names namesDatabase) {
        if (namesDatabase == null) {
            throw new IllegalArgumentException("The parameter"
                    + " namesDatabase cannot be null");
        }
        ArrayList<String> alwaysLess = namesDatabase.alwaysLessPopular();
        System.out.println( alwaysLess.size() + " names are less popular in every decade. ");
        for (int i = 0; i < alwaysLess.size(); i++){
            System.out.println(alwaysLess.get(i));
        }
    }

    /* Display the data for one name or state that name has never been ranked.
     * pre: n != null, keyboard != null and is connected to System.in
     * post: print out the data for n or a message that n has never been in the
     * top 1000 for any decade
     */
    private static void oneName(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        System.out.print("Enter a name: ");
        String name = keyboard.nextLine();
        NameRecord nameRecord = namesDatabase.getName(name);
        System.out.println();
        if (nameRecord != null){
            System.out.println(nameRecord);
        }
        else {
            System.out.println(name + " does not appear in any decade.");
        }
    }

    /* Display all names that contain a substring from the user
     * and the decade they were most popular.
     * pre: n != null, keyboard != null and is connected to System.in
     * post: display the data for each name.
     */
    private static void search(Names namesDatabase, Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (namesDatabase == null || keyboard == null) {
            throw new IllegalArgumentException("The parameters cannot be null");
        }
        System.out.print("Enter a partial name: ");
        String partialName = keyboard.nextLine();
        System.out.println();
        ArrayList<NameRecord> names = namesDatabase.getMatches(partialName);
        System.out.println("There are " + names.size() + " matches for " + partialName + ".");
        if (names.size() != 0){
            System.out.println();
            System.out.println("The matches with their highest ranking decade are:");
            for (int i = 0; i < names.size(); i++){
                NameRecord name = names.get(i);
                String recordName = name.getName();
                int highestRankingDecade = name.getMostPopularDecade();
                System.out.println(recordName + " " + highestRankingDecade);
            }
        }
    }

    /* Get choice from the user keyboard != null and is connected to System.in
     * return an int that is >= MenuChoices.SEARCH.ordinal()
     *  and <= MenuChoices.QUIT.ordinal().
     */
    private static int getChoice(Scanner keyboard) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (keyboard == null) {
            throw new IllegalArgumentException("The parameter keyboard cannot be null");
        }
        int choice = getInt(keyboard, "Enter choice: ");
        keyboard.nextLine();
        // Add one due to zero based indexing of enums, but 1 based indexing of menu.
        final int MAX_CHOICE = MenuChoices.QUIT.ordinal() + 1;
        while (choice < 1  || choice > MAX_CHOICE) {
            System.out.println();
            System.out.println(choice + " is not a valid choice");
            choice = getInt(keyboard, "Enter choice: ");
            keyboard.nextLine();
        }
        return choice;
    }

    /* Ensure an int is entered from the keyboard.
     * pre: s != null and is connected to System.in
     * post: return the int typed in by the user.
     */
    private static int getInt(Scanner s, String prompt) {
        // Note, no way to check if keyboard actually connected to System.in
        // so we simply assume it is.
        if (s == null) {
            throw new IllegalArgumentException("The parameter s cannot be null");
        }
        System.out.print(prompt);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // Show the user the menu.
    private static void showMenu() {
        System.out.println();
        System.out.println("Options:");
        System.out.println("Enter 1 to search for names.");
        System.out.println("Enter 2 to display data for one name.");
        System.out.println("Enter 3 to display all names that appear in only "
                + "one decade.");
        System.out.println("Enter 4 to display all names that appear in all "
                + "decades.");
        System.out.println("Enter 5 to display all names that are more popular "
                + "in every decade.");
        System.out.println("Enter 6 to display all names that are less popular "
                + "in every decade.");
        System.out.println("Enter 7 to display all names with a specific " +
                "number of a specific letter in its name.");
        System.out.println("Enter 8 to quit.");
        System.out.println();
    }

    /**
     * An enumerated type to hold the menu choices 
     * for the NameSurfer program.
     */
    private static enum MenuChoices {
        SEARCH, ONE_NAME, APPEAR_ONCE, APPEAR_ALWAYS, ALWAYS_MORE, 
        ALWAYS_LESS, STUDENT_SEARCH, QUIT;
    }
}
