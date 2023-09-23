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

import java.util.ArrayList;
import java.util.Scanner;

public class NameRecord implements Comparable<NameRecord> {
    private final String name;
    private final int baseYear;
    private final int numDecades;
    private final ArrayList<Integer> ranks = new ArrayList<Integer>();

    /**
     * Constructs a NameRecord object that contains information about
     * the names ranks throughout the decades
     * @param nameData the ranking data of the name passed in as a string
     *                 pre: nameData != null, nameData.length > 0
     *                 nameData must not only contain whitespaces
     * @param baseYear the year the data begins with
     */
    public NameRecord(String nameData, int baseYear){
        Scanner lineScanner = new Scanner(nameData);
        if (nameData == null || nameData.length() == 0 || !lineScanner.hasNext()){
            throw new IllegalArgumentException("nameData cannot be null, have a length of 0," +
                    " or only contain whitespaces");
        }
        this.name = lineScanner.next();
        this.baseYear = baseYear;
        int numDecades = 0;
        while(lineScanner.hasNextInt()){
            ranks.add(lineScanner.nextInt());
            numDecades++;
        }
        if (lineScanner.hasNext()){
            throw new IllegalArgumentException("all ranks must be numbers");
        }
        this.numDecades = numDecades;
        lineScanner.close();
    }

    /**
     * method that returns the name of the NameRecord Object
     * @return the name of the NameRecord Object
     */
    public String getName(){
        return this.name;
    }

    /**
     * method that returns the base year of the data given
     * @return the base year of the NameRecord object
     */
    public int getBaseYear(){
        return this.baseYear;
    }

    /**
     *  method that returns the number of decades of the data given
     * @return the number of decades that the NameRecord object has
     */
    public int getNumDecades(){
        return this.numDecades;
    }

    /**
     * a method that returns the rank of a name given a decade number (int from 0
     * to max number of decades - 1)
     * @param decadeNumber a number between 0 to (max number of decades - 1)
     * @return returns the rank of the given decade
     */
    public int getNameRecordRankOfDecade(int decadeNumber){
        if (decadeNumber < 0 ||  decadeNumber >= this.ranks.size()) {
            throw new IllegalArgumentException("The parameter name cannot be negative, null, or" +
                    " greater than or equal to the number of decades given");
        }
        return ranks.get(decadeNumber);
    }

    /**
     * method that returns the decade with the highest ranking of the
     * names popularity
     * @return the decade with the lowest number in the ranks array
     */
    public int getMostPopularDecade(){
        int min = 1000;
        int decade = 0;
        for (int i = 0; i < ranks.size(); i++){
            int currentRank = ranks.get(i);
            if (currentRank < min && currentRank != 0){
                min = currentRank;
                decade = baseYear + (i * 10);
            }
        }
        return decade;
    }

    /**
     * method that returns the number of decades that a NameRecord came out in the
     * top 1000
     * @return number of decades that this name appeared in top 1000
     */
    public int numberOfDecadesInTop1000(){
        int numDecadesInTop1000 = 0;
        for (int i = 0; i < ranks.size(); i++){
            if (ranks.get(i) != 0){
                numDecadesInTop1000++;
            }
        }
        return numDecadesInTop1000;
    }

    /**
     * method that returns true or false depending on if the name
     * record is ranked in every decade of the given data
     * @return boolean
     */
    public boolean isRankedInEveryDecade(){
        for (int i = 0; i < ranks.size(); i++){
            if (ranks.get(i) == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * method that returns true or false depending on if the
     * name is ranked in only one decade in the given data
     * @return boolean
     */
    public boolean isRankedInOneDecade(){
        int num = 0;
        for (int i = 0; i < ranks.size(); i++){
            if (ranks.get(i) != 0){
                num++;
            }
        }
        return num == 1;
    }

    /**
     * method that returns true if the NameRecord is getting more popular
     * as the decades go on
     * @return boolean
     */
    public boolean isAlwaysMorePopular(){
        int num = ranks.get(0);
        int i = 1;
        if (num == 0){
            num = ranks.get(1);
            i = 2;
        }
        for (; i < ranks.size(); i++){
            int rank = ranks.get(i);
            if (rank < num && rank != 0){
                num = ranks.get(i);
            }
            else{
                return false;
            }
        }
        return true;
    }

    /**
     * returns a true if the NameRecord is getting less
     * popular as the decades go on
     * @return boolean
     */
    public boolean isAlwaysLessPopular(){
        int num = ranks.get(ranks.size() - 1);
        int start = ranks.size() - 2;
        if (num == 0){
            num = ranks.get(ranks.size() - 2);
            start = ranks.size() - 3;
        }
        for (int i = start; i >= 0; i--){
            String name = this.name;
            int rank = ranks.get(i);
            if (rank < num && rank != 0){
                num = ranks.get(i);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(name + "\n");
        for (int i = 0; i < numDecades; i++){
            sb.append(baseYear + i * 10).append(": ").append(ranks.get(i)).append("\n");
        }
        return sb.toString();
    }

    public int compareTo(NameRecord other) {
        return this.name.compareTo(other.name);
    }

}
