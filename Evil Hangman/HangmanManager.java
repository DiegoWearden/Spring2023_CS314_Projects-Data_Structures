/*  Student information for assignment:
 *
 *  On my honor, Diego Wearden, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Diego Wearden
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  Section 5 digit ID: 52085
 *  Grader name: Lilly Tian
 *  Number of slip days used on this assignment: 2
 */

// add imports as necessary

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;

/**
 * Manages the details of EvilHangman. This class keeps
 * tracks of the possible words from a dictionary during
 * rounds of hangman, based on guesses so far.
 *
 */
public class HangmanManager {

    // instance variables / fields
     private final TreeMap<Integer, ArrayList<String>> allWords;
     private final ArrayList<Character> guessedChars;
     private ArrayList<String> wordFamily;
     private int numGuesses;
     private HangmanDifficulty diff;
     private String currentPattern;
     private int wordLength;
     private int diffCounter;

    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * pre: words != null, words.size() > 0
     * @param words A set with the words for this instance of Hangman.
     * @param debugOn true if we should print out debugging to System.out.
     */
    public HangmanManager(Set<String> words, boolean debugOn) {
        guessedChars = new ArrayList<>();
        allWords = new TreeMap<>();
        for(String word : words){
            int wordLength = word.length();
            if (!allWords.containsKey(wordLength)){
                allWords.put(wordLength, new ArrayList<String>());
            }
            allWords.get(wordLength).add(word);
        }
    }

    /**
     * Create a new HangmanManager from the provided set of words and phrases.
     * Debugging is off.
     * pre: words != null, words.size() > 0
     * @param words A set with the words for this instance of Hangman.
     */
    public HangmanManager(Set<String> words) {
        this(words, false);
    }


    /**
     * Get the number of words in this HangmanManager of the given length.
     * pre: none
     * @param length The given length to check.
     * @return the number of words in the original Dictionary
     * with the given length
     */
    public int numWords(int length) {
        if (allWords.containsKey(length)){
            return allWords.get(length).size();
        }
        else{
            return 0;
        }
    }


    /**
     * Get for a new round of Hangman. Think of a round as a
     * complete game of Hangman.
     * @param wordLen the length of the word to pick this time.
     * numWords(wordLen) > 0
     * @param numGuesses the number of wrong guesses before the
     * player loses the round. numGuesses >= 1
     * @param diff The difficulty for this round.
     */
    public void prepForRound(int wordLen, int numGuesses, HangmanDifficulty diff) {
        if ((wordLen == 0) || (numGuesses < 1)){
            throw new IllegalArgumentException("word length must not be 0" +
                    " or numGuesses must not be less than 1");
        }
        this.diffCounter = 0;
        this.wordFamily = allWords.get(wordLen);
        this.numGuesses = numGuesses;
        this.diff = diff;
        this.wordLength = wordLen;
        guessedChars.clear();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++){
            sb.append("-");
        }
        currentPattern = sb.toString();
    }

    /**
     * The number of words still possible (live) based on the guesses so far.
     *  Guesses will eliminate possible words.
     * @return the number of words that are still possibilities based on the
     * original dictionary and the guesses so far.
     */
    public int numWordsCurrent() {
        return wordFamily.size();
    }

    /**
     * Get the number of wrong guesses the user has left in
     * this round (game) of Hangman.
     * @return the number of wrong guesses the user has left
     * in this round (game) of Hangman.
     */
    public int getGuessesLeft() {
        return numGuesses;
    }

    /**
     * Return a String that contains the letters the user has guessed
     * so far during this round.
     * The characters in the String are in alphabetical order.
     * The String is in the form [let1, let2, let3, ... letN].
     * For example [a, c, e, s, t, z]
     * @return a String that contains the letters the user
     * has guessed so far during this round.
     */
    public String getGuessesMade() {
        Collections.sort(guessedChars);
        return guessedChars.toString();
    }

    /**
     * Check the status of a character.
     * @param guess The characater to check.
     * @return true if guess has been used or guessed this round of Hangman,
     * false otherwise.
     */
    public boolean alreadyGuessed(char guess) {
        return guessedChars.contains(guess);
    }

    /**
     * Get the current pattern. The pattern contains '-''s for
     * unrevealed (or guessed) characters and the actual character 
     * for "correctly guessed" characters.
     * @return the current pattern.
     */
    public String getPattern() {
        return currentPattern;
    }

    /**
     * Update the game status (pattern, wrong guesses, word list),
     * based on the give guess.
     * @param guess pre: !alreadyGuessed(ch), the current guessed character
     * @return return a tree map with the resulting patterns and the number of
     * words in each of the new patterns.
     * The return value is for testing and debugging purposes.
     */
    public TreeMap<String, Integer> makeGuess(char guess) {
        if (alreadyGuessed(guess)){
            throw new IllegalStateException("letter cannot be one that's already been guessed");
        }
        TreeMap<String, Integer> result = new TreeMap<>();
        TreeMap<String, ArrayList<String>> possibleWordFamilies = new TreeMap<>();
        ArrayList<String> patterns = new ArrayList<>();
        ArrayList<PatternGroups> patternGroups = new ArrayList<>();
        String oldPattern = currentPattern;
        guessedChars.add(guess);
        for (int i = 0; i < wordFamily.size(); i++){
            String word = wordFamily.get(i);
            String pattern = getCurrentPattern(guess, word);
            if (!possibleWordFamilies.containsKey(pattern)){
                ArrayList<String> newWords = new ArrayList<>();
                newWords.add(word);
                possibleWordFamilies.put(pattern, newWords);
                patterns.add(pattern);
            }
            else {
                possibleWordFamilies.get(pattern).add(word);
            }
            result.put(pattern, possibleWordFamilies.get(pattern).size());
        }
        for (String pattern : patterns){
            PatternGroups patternGroup = new PatternGroups(pattern, possibleWordFamilies.get(pattern).size());
            patternGroups.add(patternGroup);
        }
        Collections.sort(patternGroups);
        currentPattern = getHardestWords(patternGroups);
        wordFamily = possibleWordFamilies.get(currentPattern);
        if (oldPattern.equals(currentPattern)){
            numGuesses--;
        }
        return result;
    }

    /**
     * obtains the hardest/second-hardest pattern depending on chosen difficulty
     * @param patternGroups ArrayList of PatternGroups which represents the pattern and number
     * of words for each pattern
     * @return pattern as String
     */
    private String getHardestWords(ArrayList<PatternGroups> patternGroups){
        diffCounter++;
        if (diff != HangmanDifficulty.HARD && (patternGroups.size() >= 2)){
            if (diff.equals(HangmanDifficulty.EASY) && ((diffCounter % 2) == 0)){
                return patternGroups.get(1).pattern;
            } else if (diff.equals(HangmanDifficulty.MEDIUM) && ((diffCounter % 4) == 0)) {
                return patternGroups.get(1).pattern;
            }
        }
        return patternGroups.get(0).pattern;
    }

    /**
     * Represents the pattern and number of words for each pattern
     * mainly used to get the hardest pattern by using the compareTo method
     * to sort PatternGroup objects by difficulty
     */
    private static class PatternGroups implements Comparable<PatternGroups>{
        private final String pattern;
        private final int numWords;
        private PatternGroups(String pattern, int numWords){
            this.pattern = pattern;
            this.numWords = numWords;
        }

        @Override
        public int compareTo(PatternGroups otherPatternGroup) {
            if (this.numWords < otherPatternGroup.numWords){
                return 1;
            } else if (this.numWords > otherPatternGroup.numWords) {
                return -1;
            }
            else{
                return this.pattern.compareTo(otherPatternGroup.pattern);
            }
        }
    }

    /**
     * returns a string of the built pattern given the guessed character
     * @param guess the letter guessed
     * @param word the word the guess is being compared to
     * @return returns a String of the pattern
     */
    private String getCurrentPattern(char guess, String word) {
        String oldPattern = currentPattern;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordLength; i++){
            if (guess != word.charAt(i)){
                sb.append(oldPattern.charAt(i));
            }
            else{
                sb.append(guess);
            }
        }
        return sb.toString();
    }


    /**
     * Return the secret word this HangmanManager finally ended up
     * picking for this round.
     * If there are multiple possible words left one is selected at random.
     * <br> pre: numWordsCurrent() > 0
     * @return return the secret word the manager picked.
     */
    public String getSecretWord() {
        if (!(numWordsCurrent() > 0)){
            throw new IllegalStateException("the number of words in the word family cannot be zero");
        }
        int max = wordFamily.size();
        int min = 0;
        int randomIndex = (int) Math.floor(Math.random() *(max - min) + min);
        return wordFamily.get(randomIndex);
    }
}
