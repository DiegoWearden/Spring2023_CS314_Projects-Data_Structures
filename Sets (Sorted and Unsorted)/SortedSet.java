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
import java.util.ArrayList;

/**
 * In this implementation of the ISet interface the elements in the Set are
 * maintained in ascending order.
 *
 * The data type for E must be a type that implements Comparable.
 *
 * Implement methods that were not implemented in AbstractSet
 * and override methods that can be done more efficiently. An ArrayList must
 * be used as the internal storage container. For methods involving two set,
 * if that method can be done more efficiently if the other set is also a
 * SortedSet, then do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    /**
     * create an empty SortedSet
     */
    public SortedSet() {
        myCon = new ArrayList<E>();
    }

    /**
     * Create a copy of other that is sorted.<br>
     * @param other != null
     */
    public SortedSet(ISet<E> other) {
        if (other == null) {
            throw new IllegalArgumentException("other is null");
        }
        UnsortedSet<E> thing = null;
        //check to see if other set is ordered
        if (other instanceof SortedSet<?>) {
            myCon = deepCopy(other);
        } else { //if it's not then merge sort
            myCon = mergeSortManager(other);
        }
    }

    private ArrayList<E> deepCopy(ISet<E> sortedOther) {
        ArrayList<E> res = new ArrayList<E>();

        for (E element : sortedOther) {
            res.add(element);
        }
        return res;
    } 

     private ArrayList<E> mergeSortManager(ISet<E> other) {
         ArrayList<E> tempArrList = new ArrayList<>(other.size());
         ArrayList<E> otherCon = new ArrayList<>();
         for (E e : other){
             otherCon.add(e);
         }
         mergeSort(otherCon, tempArrList, 0, other.size() -1);
         return otherCon;
     }
     private void mergeSort(ArrayList<E> otherCon, ArrayList<E> temp, int low, int high) {
         if (low < high) {
             int center = (low + high) / 2;
             mergeSort(otherCon, temp, low, center); //left side
             mergeSort(otherCon, temp, center + 1, high); //right side
             merge(otherCon , temp, low, center+1, high); //merge
         }
     }

     private void merge(ArrayList<E> other, ArrayList<E> temp, int leftPos, int rightPos, int rightEnd) {
         int leftEnd = rightPos - 1; //get our left side boundary
         int tempPos = leftPos; //make our cursor
         int numElements = rightEnd - leftPos + 1; //find how many elements are being merged

         while (leftPos <= leftEnd && rightPos <= rightEnd) {
             //look at both sides, if one side's element is greater than the other we move the up one element on that side
             //and we assign at tempPos the bigger element
            
             //see if the left side has the larger element
             if (other.get(leftPos).compareTo(other.get(rightPos)) <= 0) {
                 temp.add(tempPos, other.get(leftPos));
                 leftPos++;
             } else {
                 temp.add(tempPos, other.get(rightPos));
                 rightPos++;
             }
             tempPos++;
         }

         while (leftPos <= leftEnd) {
             temp.add(tempPos, other.get(leftPos));
             tempPos++;
             leftPos++;
         }
        
         while (rightPos <= rightEnd) {
             temp.add(tempPos, other.get(rightPos));
             tempPos++;
             rightPos++;
         }

         for (int i = 0; i < numElements; i++, rightEnd--) {
             other.add(rightEnd, temp.get(rightEnd));
         }
     }

    /**
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    public E min() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("size is zero");
        }
        
        return this.myCon.get(0);
    }

    /**
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    public E max() {
        if (this.size() == 0) {
            throw new IllegalArgumentException("size is zero");
        }
        return this.myCon.get(this.size() - 1);
    }


    @Override
    public boolean add(E item) {
        //look through whole list and see when the item is larger and at what index
        int i = 0;
        for (E e : this) {
            int compared = e.compareTo(item);
            if (compared > 0) {
                this.myCon.add(i, item);
                return true;
            }
            else if (compared == 0) {
                return false;
            } else {
                i++;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(ISet<E> otherSet) {
        //check if it's a sorted set, if so then we will use merge from merge sort
        boolean addAllSuccess = false;
        
        if (otherSet instanceof SortedSet<?>) {
            //merge
        } else {
            for (E item : otherSet) {
                if (this.add(item) && !addAllSuccess) {
                    addAllSuccess = true;
                }
            }
        } 
        return addAllSuccess;
    }

    @Override
    public ISet<E> difference(ISet<E> otherSet) {
        return null;
    }

    @Override
    public ISet<E> intersection(ISet<E> otherSet) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return myCon.listIterator();
    }

    @Override
    public int size() {
        return myCon.size();
    }

    @Override
    public boolean contains(E item) {
       
       //perform binary search here

        return false;

    }
}
