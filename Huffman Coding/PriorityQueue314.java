/*  Student information for assignment:
 *
 *  On our honor, Nathan Chase and Diego Wearden, this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used:
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID: ntc477
 *  email address: ntc477@cs.utexas.edu
 *  Grader name: Lily Tian
 *
 *  Student 2
 *  UTEID: daw3784
 *  email address: dialwera@gmail.com
 *
 */
import java.util.ArrayList;

/**
 * implementation of Queue that gives 'fair' priority based on value size.
 * Smaller values go towards the 'front' of the line, when of equal values 
 * any new value will be in the back behind its equivalents.
 * @author Nathan Chase and Diego Wearden
 *
 * @param <E> general value
 */
public class PriorityQueue314<E extends Comparable<E>> {
    ArrayList<E> con;
    
    /**
     * Default constructor
     */
    public PriorityQueue314() {
        this.con = new ArrayList<E>();
    }
    
    /**
     * place a new value in our priority queue 
     * @param val must not be null
     * @throws IllegalArgumentException
     */
    public void enqueue(E val){
        if (val == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        if (this.con.size() == 0){
            this.con.add(val);
        } else {
            int placeAt = this.findPlace(val);
            this.con.add(placeAt, val);
        }
    }
    
    /**
     * determining the 'priority' of the input value about to be enqueued
     * @param other general value that is going to be enqueued 
     * @return index of container that value will be placed
     */
    private int findPlace(E other){
        for (int i = this.con.size() - 1; i >= 0; i--) {
            int diff = other.compareTo(con.get(i));
            if (diff < 0) { 
                return i + 1;
            }
        }
        //our new treeNode is the biggest one add to very end
        return 0; 
    }
    
    /**
     * remove from 'front' of the queue 
     * @return our removed element
     */
    public E dequeue(){
        return this.con.remove(this.con.size() - 1);
    }
    
    /**
     * debug function which prints out all contents inside the queue 
     * @return container's result for toString()
     */
    public String toString() {
        return this.con.toString();
    }
    
    /**
     * check to see if tree construction is complete
     * @return if size == 1
     */
    public boolean isCompleteTree(){
        return this.con.size() == 1;
    }
}
