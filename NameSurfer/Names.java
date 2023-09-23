/*  Student information for assignment:
*
*  On my honor, Diego Wearden, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: daw3784
*  email address: dialwera@gmail.com
*  Number of slip days I am using: 0
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
* A collection of NameRecords.
* Stores NameRecord objects and provides methods to select
* NameRecords based on various criteria.
*/
public class Names {
    ArrayList<NameRecord> nameRecords = new ArrayList<NameRecord>();

    /**
     * Construct a new Names object based on the data source the Scanner
     * sc is connected to. Assume the first two lines in the
     * data source are the base year and number of decades to use.
     * Any lines without the correct number of decades are discarded
     * and are not part of the resulting Names object.
     * Any names with ranks of all 0 are discarded and not
     * part of the resulting Names object.
     * @param sc Is connected to a data file with baby names
     * and positioned at the start of the data source.
     */
    public Names(Scanner sc) {
        int baseYear = sc.nextInt();
        int numDecades = sc.nextInt();
        sc.nextLine();
        while (sc.hasNextLine()){
            String nameData = sc.nextLine();
            NameRecord nameRecord = new NameRecord(nameData, baseYear);
            if (nameRecord.getNumDecades() == numDecades){
                nameRecords.add(nameRecord);
            }
        }
    }

   /**
    * Returns an ArrayList of NameRecord objects that contain a
    * given substring, ignoring case.  The names must be in sorted order based
    * on the names of the NameRecords.
    * @param partialName != null, partialName.length() > 0
    * @return an ArrayList of NameRecords whose names contains
    * partialName. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<NameRecord> getMatches(String partialName) {
       if (partialName == null || partialName.length() == 0){
           throw new IllegalArgumentException("partial name cannot be null or have length of zero");
       }
       ArrayList<NameRecord> namesWithPartialName = new ArrayList<NameRecord>();
       for (int i = 0; i < nameRecords.size(); i++){
           String name = nameRecords.get(i).getName();
           String partialNameLowerCase = partialName.toLowerCase();
           if (name.toLowerCase().contains(partialNameLowerCase)){
               namesWithPartialName.add(nameRecords.get(i));
           }
       }
       Collections.sort(namesWithPartialName);
       return namesWithPartialName;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the
    * top 1000 or better for every decade. The Strings  must be in sorted
    * order based on the name of the NameRecords.
    * @return A list of the names that have been ranked in the top
    * 1000 or better in every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedEveryDecade() {
       ArrayList<String> namesRankedEveryDecade = new ArrayList<String>();
       for (int i = 0; i < nameRecords.size(); i++){
           NameRecord nameRecord = nameRecords.get(i);
           String name = nameRecord.getName();
           if (nameRecord.isRankedInEveryDecade()){
               namesRankedEveryDecade.add(name);
           }
       }
       Collections.sort(namesRankedEveryDecade);
       return namesRankedEveryDecade;
   }

   /**
    * Returns an ArrayList of Strings of names that have been ranked in the
    * top 1000 or better in exactly one decade. The Strings must be in sorted
    * order based on the name of the NameRecords.
    * @return A list of the names that have been ranked in the top
    * 1000 or better in exactly one decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> rankedOnlyOneDecade() {
       ArrayList<String> namesRankedOneDecade = new ArrayList<String>();
       for (int i = 0; i < nameRecords.size(); i++){
           NameRecord nameRecord = nameRecords.get(i);
           String name = nameRecord.getName();
           if (nameRecord.isRankedInOneDecade()){
               namesRankedOneDecade.add(name);
           }
       }
       Collections.sort(namesRankedOneDecade);
       return namesRankedOneDecade;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting more
    * popular every decade. The Strings  must be in sorted
    * order based on the name of the NameRecords.
    * @return A list of the names that have been getting more popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> alwaysMorePopular() {
       ArrayList<String> alwaysMorePopular = new ArrayList<String>();
       for (int i = 0; i < nameRecords.size(); i++){
           NameRecord nameRecord = nameRecords.get(i);
           String name = nameRecord.getName();
           if (nameRecord.isAlwaysMorePopular()){
               alwaysMorePopular.add(name);
           }
       }
       Collections.sort(alwaysMorePopular);
       return alwaysMorePopular;
   }

   /**
    * Returns an ArrayList of Strings of names that have been getting less
    * popular every decade. The Strings  must be in sorted order based
    * on the name of the NameRecords.
    * @return A list of the names that have been getting less popular in
    * every decade. The list is in sorted ascending
    * order. If there are no NameRecords that meet this
    * criteria returns an empty list.
    */
   public ArrayList<String> alwaysLessPopular() {
       ArrayList<String> alwaysLessPopular = new ArrayList<String>();
       for (int i = 0; i < nameRecords.size(); i++){
           NameRecord nameRecord = nameRecords.get(i);
           String name = nameRecord.getName();
           if (nameRecord.isAlwaysLessPopular()){
               alwaysLessPopular.add(name);
           }
       }
       Collections.sort(alwaysLessPopular);
       return alwaysLessPopular;
   }

    /**
     * returns an ArrayList of NameRecords that contain that many number of characters
     * in its name ignoring case.
     * @param character the letter to be searched for
     * @param numberOfCharacters != null, partialName.length() > 0
     * @return an array of name records with the names that contains
     * a specific number of characters. if there are none it returns an empty array.
     * it is sorted in ascending order
     */
    public ArrayList<NameRecord> getNameWithMostAmountOfLettersOf(String character, int numberOfCharacters) {
        if (character == null || character.length() == 0){
            throw new IllegalArgumentException("character entered cannot " +
                    "be null or have a length of 0");
        }
        ArrayList<NameRecord> namesWithMostAmountOfLetters = new ArrayList<NameRecord>();
        for (int i = 0; i < nameRecords.size(); i++){
            int currentConsecutiveLetters = 0;
            NameRecord nameRecord = nameRecords.get(i);
            String name = nameRecord.getName();
            String nameLowerCase = name.toLowerCase();
            if (nameLowerCase.contains(character)){
                for (int j = 0; j < name.length(); j++){
                    String currentString = String.valueOf(nameLowerCase.charAt(j));
                    if (currentString.equals(character)){
                        currentConsecutiveLetters++; // counts the number of characters
                    }
                }
                if (currentConsecutiveLetters == numberOfCharacters){
                    namesWithMostAmountOfLetters.add(nameRecord);
                }
            }
        }
        Collections.sort(namesWithMostAmountOfLetters);
        return namesWithMostAmountOfLetters;
    }

   /**
    * Return the NameRecord in this Names object that matches the given String ignoring case.
    * <br>
    * <tt>pre: name != null</tt>
    * @param name The name to search for.
    * @return The name record with the given name or null if no NameRecord in this Names
    * object contains the given name.
    */
   public NameRecord getName(String name) {
       if (name == null) {
           throw new IllegalArgumentException("The parameter name cannot be null");
	   }
       for (int i = 0; i < nameRecords.size(); i++){
           NameRecord currentNameRecord = nameRecords.get(i);
           String currentName = currentNameRecord.getName().toLowerCase();
           if (currentName.equals(name.toLowerCase())){
               return currentNameRecord;
           }
       }
       return null;
   }
}
