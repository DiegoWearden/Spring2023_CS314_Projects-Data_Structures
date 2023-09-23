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

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {

    private ArrayList<E> myCon;

    public UnsortedSet(){
        myCon = new ArrayList<E>();
    }

    @Override
    public boolean add(E item) {
        if (this.contains(item)){
            return false;
        }
        return myCon.add(item);
    }

    @Override
    public boolean addAll(ISet<E> otherSet) {
        int prevSize = this.size();
        for (E element : otherSet){
            if (!this.contains(element)){
                this.add(element);
            }
        }
        return this.size() > prevSize;
    }

    @Override
    public ISet<E> difference(ISet<E> otherSet) {
        ISet<E> diffSet = new UnsortedSet<E>();
        ISet<E> parsedSet = otherSet.size() >= this.size() ? otherSet : this;
        ISet<E> comparedSet = otherSet.size() < this.size() ? otherSet : this;
        for (E element : parsedSet){
            if (!comparedSet.contains(element)){
                diffSet.add(element);
            }
        }
        return diffSet;
    }

    @Override
    public ISet<E> intersection(ISet<E> otherSet) {
        ISet<E> interSet = new UnsortedSet<E>();
        ISet<E> parsedSet = otherSet.size() >= this.size() ? otherSet : this;
        ISet<E> comparedSet = otherSet.size() < this.size() ? otherSet : this;
        for (E element : parsedSet){
            if (comparedSet.contains(element)){
                interSet.add(element);
            }
        }
        return interSet;
    }

    @Override
    public Iterator<E> iterator() {
        return myCon.listIterator();
    }

//    private class Seterator implements Iterator<E> {
//
//        boolean removeOk;
//        E curElement;
//        int index;
//
//        private Seterator(){
//            index = 0;
//            curElement = null;
//            removeOk = false;
//            Iterator<E> it = myCon.iterator();
//        }
//        @Override
//        public boolean hasNext() {
//            return index < myCon.size();
//        }
//
//        @Override
//        public E next() {
//            index++;
//            curElement = myCon.get(index);
//            removeOk = true;
//            return curElement;
//        }
//
//        @Override
//        public void remove(){
//            if(!removeOk){
//                throw new IllegalStateException("must call next before remove");
//            }
//            removeOk = false;
//            myCon.remove(index);
//            index--;
//        }
//    }

    @Override
    public int size() {
        return myCon.size();
    }
}
