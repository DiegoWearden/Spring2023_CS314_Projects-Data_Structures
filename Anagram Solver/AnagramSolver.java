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


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class AnagramSolver {
    private final Map<String, LetterInventory> dictionary;

    /*
     * pre: list != null
     * @param list Contains the words to form anagrams from.
     */
    public AnagramSolver(Set<String> dictionary) {
        this.dictionary = new HashMap<>();
        for (String word : dictionary){
            LetterInventory letterInventory = new LetterInventory(word);
            this.dictionary.put(word, letterInventory);
        }
    }

    /*
     * pre: maxWords >= 0, s != null, s contains at least one
     * English letter.
     * Return a list of anagrams that can be formed from s with
     * no more than maxWords, unless maxWords is 0 in which case
     * there is no limit on the number of words in the anagram
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
        if (s == null || s.length() == 0 || maxWords < 0) {
            throw new IllegalArgumentException();
        }
        LetterInventory anagramLetterInventory = new LetterInventory(s);
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> anagramsSoFar = new ArrayList<>();
        if (maxWords == 0){
            maxWords = s.length();
        }
        findAnagrams(maxWords, anagramLetterInventory, result, anagramsSoFar,
                getNewDictionary(anagramLetterInventory));
        result.sort(new AnagramComparator());
        return result;
    }

    /*
     * Recursive helper method that finds all anagrams that can be
     * formed from a given LetterInventory object.
     * @param maxWords The maximum number of words allowed in the anagrams.
     * @param anagramLetterInventory The LetterInventory object
     * \representing the letters to form anagrams from.
     * @param result The list of anagrams found so far.
     * @param anagramsSoFar The list of words that have been added
     * to the current anagram so far.
     * @param newDictionary The dictionary to use for the current recursion level.
     */

    private void findAnagrams(int maxWords, LetterInventory anagramLetterInventory,
                              List<List<String>> result, ArrayList<String> anagramsSoFar,
                              ArrayList<String> newDictionary) {
        if (!anagramLetterInventory.isEmpty()){
            if (maxWords != 0){
                newDictionary.sort(Comparator.comparing(String::length).reversed());
                for (int i = 0; i < newDictionary.size(); i++) {
                    String word = newDictionary.get(i);
                    LetterInventory li = dictionary.get(word);
                    LetterInventory newLetterInventory = anagramLetterInventory.subtract(li);
                    if (newLetterInventory != null){
                        anagramsSoFar.add(word);
                        findAnagrams(maxWords - 1, newLetterInventory, result, anagramsSoFar,
                                new ArrayList<>(newDictionary.subList(i, newDictionary.size())));
                        anagramsSoFar.remove(anagramsSoFar.size() - 1);
                    }
                }
            }
        }
        else{
            ArrayList<String> anagramsSoFarResult = new ArrayList<>(anagramsSoFar);
            Collections.sort(anagramsSoFarResult);
            result.add(anagramsSoFarResult);
        }
    }

    /*
     * The nested class AnagramComparator is a private inner class of the
     * AnagramSolver class. It implements the Comparator interface to
     * define a custom sorting order for lists of anagrams based on their
     * size and lexicographic order.
     */
    private static class AnagramComparator implements Comparator<List<String>> {
        @Override
        public int compare(List<String> a, List<String> b) {
            if (a.size() != b.size()) {
                return a.size() - b.size();
            } else {
                for (int i = 0; i < a.size(); i++) {
                    String wordA = a.get(i);
                    String wordB = b.get(i);
                    int cmp = wordA.compareToIgnoreCase(wordB);
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return 0;
            }
        }
    }

    /*
     * Returns a new ArrayList of strings representing a filtered version of the
     * dictionary, containing only the words that can be formed
     * using the letters in the given anagramLetterInventory.
     * @param anagramLetterInventory A LetterInventory object
     *                               representing the letters in the anagram to be formed.
     * @return An ArrayList of strings containing words from the
     * dictionary that can be formed using the letters in the anagramLetterInventory.
     */
    private ArrayList<String> getNewDictionary(LetterInventory anagramLetterInventory){
        ArrayList<String>newDictionary = new ArrayList<>();
        for (String word : dictionary.keySet()) {
            LetterInventory li = dictionary.get(word);
            if (anagramLetterInventory.subtract(li) != null){
                newDictionary.add(word);
            }
        }
        return newDictionary;
    }
}
