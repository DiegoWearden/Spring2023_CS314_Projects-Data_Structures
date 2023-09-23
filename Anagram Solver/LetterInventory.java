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

import java.util.Arrays;

/**
 * This class represents an inventory of letters in a given word. It stores the frequency of
 * each letter
 * in an array and provides methods to manipulate the inventory.
 */
public class LetterInventory {
    private final int ASCII_LOWER_A = 97;
    private final int[] charFrequencies;
    private int size;
    private final int NUM_LETTERS_IN_ALPHABET = 26;

    /**
     * Constructor for LetterInventory class. Creates an inventory of the letters in the given word.
     * @param word The word to create the letter inventory out of
     * @throws IllegalArgumentException if the word is null.
     */
    public LetterInventory(String word){
        if (word == null){
            throw new IllegalArgumentException("String parameter cannot be null");
        }
        charFrequencies = new int[NUM_LETTERS_IN_ALPHABET];
        if(!word.isEmpty()){
            for (int i = 0; i < word.length(); i++){
                char ch = Character.toLowerCase(word.charAt(i));
                if ('a' <= ch && ch <= 'z'){
                    charFrequencies[ch - ASCII_LOWER_A]++;
                }
            }
            for (int i = 0; i < NUM_LETTERS_IN_ALPHABET; i++){
                size += charFrequencies[i];
            }
        }

    }

    /**
     * Returns the frequency of the given letter in the inventory.
     * @param letter The letter to get the frequency of.
     * @return The frequency of the given letter.
     * @throws IllegalArgumentException if the letter is not a lowercase English letter.
     */
    public int get(char letter){
        char newChar = Character.toLowerCase(letter);
        if (!('a' <= newChar && newChar <= 'z')){
            throw new IllegalArgumentException("Failed precondition: must be english char");
        }
        return charFrequencies[newChar - ASCII_LOWER_A];
    }

    /**
     * Returns the total size of the inventory.
     * @return The size of the inventory.
     */
    public int size(){
        return size;
    }

    /**
     * Returns true if the inventory is empty (has a size of zero), false
     * otherwise.
     * @return True if the inventory is empty, false otherwise.
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * Returns a string representation of the inventory. The string contains
     * all the letters in the inventory
     * in alphabetical order and their respective frequencies.
     * @return A string representation of the inventory.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charFrequencies.length; i++) {
            for (int j = 0; j < charFrequencies[i]; j++) {
                sb.append((char) (i + ASCII_LOWER_A));
            }
        }
        return sb.toString();
    }

    /**
     * Returns a new LetterInventory object that represents the sum of this
     * inventory and another inventory.
     * @param other The LetterInventory to add to this inventory.
     * @return A new LetterInventory object that represents the sum of this
     * inventory and another inventory.
     * @throws IllegalArgumentException if the other inventory is null.
     */
    public LetterInventory add(LetterInventory other){
        if (other == null){
            throw new IllegalArgumentException("parameter cannot be null");
        }
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < NUM_LETTERS_IN_ALPHABET; i++) {
            int frequency = this.charFrequencies[i] + other.charFrequencies[i];
            result.charFrequencies[i] = frequency;
            result.size += frequency;
        }
        return result;
    }

    /**
     *
     * @param other
     * @return
     */
    public LetterInventory subtract(LetterInventory other){
        if (other == null){
            throw new IllegalArgumentException("parameter cannot be null");
        }
        LetterInventory result = new LetterInventory("");
        for (int i = 0; i < NUM_LETTERS_IN_ALPHABET; i++) {
            int frequency = this.charFrequencies[i] - other.charFrequencies[i];
            if (frequency < 0){
                return null;
            }
            result.charFrequencies[i] = frequency;
            result.size += frequency;
        }
        return result;
    }

    /**
     * Compares this LetterInventory with another object for equality.
     * Two LetterInventory objects are considered equal if their charFrequencies
     * arrays have the same values.
     * @param other the object to compare to
     * @return true if the two objects are equal, false otherwise
     */
    public boolean equals(Object other){
        if (!(other instanceof LetterInventory)) {
            return false;
        }
        return Arrays.equals(this.charFrequencies, ((LetterInventory) other).charFrequencies);
    }
}
