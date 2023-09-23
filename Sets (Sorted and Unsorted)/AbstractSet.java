/*  Student information for assignment:
 *
 *  On OUR honor, Nathan Chase and Diego Wearden),
 *  this programming assignment is OUR own work
 *  and WE have not provided this code to any other student.
 *
 *  Number of slip days used:
 *
 *  Student 1 (Student whose Canvas account is being used)
 *  UTEID: ntc477 
 *  email address: ntc477@utexas.cs.edu
 *  TA name: Lily Tian
 *  
 *  Student 2 
 *  UTEID:daw3784
 *  email address: dialwera@gmail.com
 */

import java.util.Iterator;

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E> {

    /* DELETE THIS COMMENT FROM YOUR SUBMISSION.
     * 
     * RECALL:
     * 
     * NO INSTANCE VARIABLES ALLOWED.
     * 
     * NO DIRECT REFERENCE TO UnsortedSet OR SortedSet ALLOWED.
     * (In other words the data types UnsortedSet and SortedSet
     * will not appear any where in this class.)
     * 
     * NO DIRECT REFERENCES to ArrayList or other Java Collections.
     * 
     * NO METHODS ADDED other than those in ISet and Object.
     */
    
        /**
     * Add an item to this set.
     * <br> item != null
     * @param item the item to be added to this set. item may not equal null.
     * @return true if this set changed as a result of this operation, 
     * false otherwise.
     */
    // public boolean add(E item) {

    // }
    

    /**
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void clear() {
        //create the iterator 
        //while hasNext()
            //remove 
        
        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            it.remove();
            it.next();
        }
    }
    

    /**
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. 
     * Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    public boolean contains(E item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null");
        }
        
        //linear search and can be overwritten otherwise

        for (E e : this) {
            if (item.equals(e)) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    public boolean containsAll(ISet<E> otherSet) {
       
        //should we not allow client to use containsAll for a non ISet<E> object???
        //
        if (otherSet == null) {
            throw new IllegalArgumentException("otherSet is null");
        }

         //linear search 
         //first compare size
         if (otherSet.size() > this.size()) {
             return false;
         }
         
         boolean isEqual;
         //except it terminates the loop when it finds something !=
        Iterator<E> it2 = otherSet.iterator();
        while (it2.hasNext()){
            isEqual = contains(it2.next());
            if (!isEqual) {
                return false;
            }
        }
         return true;
    }

    /**
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    public boolean equals(Object other) {
        return (!(other instanceof ISet<?>)) ? false : this.containsAll((ISet<E>) other);
    }
    
    /**
     * Return an Iterator object for the elements of this set.
     * pre: none
     * @return an Iterator object for the elements of this set
     */
    public abstract Iterator<E> iterator();
    
    
    /**
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, 
     * false otherwise
     */
    public boolean remove(E item) {
        if (item == null) {
            throw new IllegalArgumentException("item is null");
        }

        Iterator<E> it = this.iterator();

        while(it.hasNext()) {
            //check to see if it's equal
            E curObject = it.next();
            if (curObject.equals(item)) {
                it.remove();
                return true;
            }
        }
        return false;
    }  
    
    
    /**
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    // public int size() {

    // }
    
    
    /**
     * Create a new set that is the union of this set and otherSet.
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the union of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     */
    public ISet<E> union(ISet<E> otherSet) {
//        n(A) + n(B) – n(A ∩ B)
        // this.addAll(otherSet);
        // ISet<E> unionSet = this.difference(this.intersection(otherSet));
        // for (E e : otherSet) {
        //     this.remove(e);
        // }
        //have all values of this. set that are not shared with otherSet 
        ISet<E> unionSet = this.difference(otherSet);
        //have all values of otherSet that are not shared with this. set
        unionSet.addAll(otherSet); //add both sets together 

        return unionSet;
    }
      
    /**
     * Return a String version of this set. 
     * Format is (e1, e2, ... en)
     * @return A String version of this set.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0) {
            result.setLength(result.length() - seperator.length());
        }

        result.append(")");
        return result.toString();
    }

}
