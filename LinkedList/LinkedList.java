
/*
 * Student information for assignment:
 * On my honor, Diego Wearden, this programming assignment is my own work
 * and I have not provided this code to any other student.
 * UTEID: daw3784
 * email address: dialwera@gmail.com
 * TA name: Lilly Tian
 * Number of slip days I am using: 2
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements IList<E> {
    // CS314 students. Add you instance variables here.
    // You decide what instance variables to use.
    // Must adhere to assignment requirements.
    // No ArrayLists or Java LinkedLists.
    private DoubleListNode<E> head;
    private DoubleListNode<E> tail;
    private int length;

    // CS314 students, add constructors here:

    /**
     * Constructs a new, empty linked list with a null head and tail, and a length
     * of zero.
     * This constructor is called when a new linked list object is created without
     * any initial elements.
     * time complexity: O(1)
     */
    public LinkedList(){
        head = null;
        tail = null;
        length = 0;
    }
    // CS314 students, add methods here:

    /**
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(0) = item
     * time complexity: O(1)
     * @param item the data to add to the front of this list
     */
    public void addFirst(E item) {
        if (item == null){
            throw new IllegalArgumentException("item cannot be null");
        }
        DoubleListNode<E> newNode = new DoubleListNode<E>(null, item, null);
        if (head == null){
            tail = newNode;
        }
        else{
            head.setPrev(newNode);
        }
        newNode.setNext(head);
        head = newNode;
        length++;
    }

    /**
     * add item to the end of the list. <br>
     * pre: item != null <br>
     * post: size() = old size() + 1, get(size() -1) = item
     * time complexity: O(1)
     * @param item the data to add to the end of this list
     */
    public void addLast(E item) {
        if (item == null){
            throw new IllegalArgumentException("item cannot be null");
        }
        DoubleListNode<E> newNode = new DoubleListNode<>(null, item, null);
        if (length == 0){
            head = newNode;
        }
        else{
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        length++;
    }

    /**
     * remove and return the first element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * time complexity: O(1)
     * @return the old first element of this list
     */
    public E removeFirst() {
        if (size() <= 0){
            throw new IllegalArgumentException("list is empty");
        }
        DoubleListNode<E> temp;
        temp = head;
        if (head == tail){
            head = null;
        }
        else{
            head = head.getNext();
            temp.getNext().setPrev(null);
        }
        length--;
        return temp.getData();
    }

    /**
     * remove and return the last element of this list. <br>
     * pre: size() > 0 <br>
     * post: size() = old size() - 1
     * time complexity: O(1)
     * @return the old last element of this list
     */
    public E removeLast() {
        if (size() <= 0){
            throw new IllegalArgumentException("list is empty");
        }
        DoubleListNode<E> temp;
        temp = tail;
        if (head == tail){
            tail = null;
            head = null;
        }
        else{
            tail = tail.getPrev();
            temp.getPrev().setNext(null);
        }
        length--;
        return temp.getData();
    }

    /**
     * time complexity: O(1)
     * @param item the data to be added to the end of this list,
     * item != null
     */
    @Override
    public void add(E item) {
        addLast(item);
    }

    /**
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item,
     * all elements in the list with a positon >= pos have a
     * position = old position + 1
     * time complexity: O(N)
     * @param pos the position to insert the data at in the list
     * @param item the data to add to the list, item != null
     */
    @Override
    public void insert(int pos, E item) {
        if (pos < 0 || pos > length){
            throw new IllegalArgumentException("Invalid input for list position");
        }
        if (item == null){
            throw new IllegalArgumentException("Invalid input for list item");
        }
        if (pos == 0){
            addFirst(item);
        } else if (pos == length) {
            addLast(item);
        } else{
            DoubleListNode<E> oldNode = getNode(pos);
            DoubleListNode<E> oldNodePrevious = oldNode.getPrev();
            DoubleListNode<E> newNode = new DoubleListNode<E>(null, item, null);
            oldNode.getPrev().setNext(newNode);
            oldNode.setPrev(newNode);
            newNode.setNext(oldNode);
            newNode.setPrev(oldNodePrevious);
            length++;
        }
    }

    /**
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     * time complexity: O(N)
     * @param pos the position in the list to overwrite
     * @param item the new item that will overwrite the old item,
     * item != null
     * @return the old data at the specified position
     */
    @Override
    public E set(int pos, E item) {
        if (pos < 0 || pos > length-1){
            throw new IllegalArgumentException("Invalid input for list position");
        }
        if (item == null){
            throw new IllegalArgumentException("Invalid input for list item");
        }
        DoubleListNode<E> oldNode = getNode(pos);
        E oldData = oldNode.getData();
        oldNode.setData(item);
        return oldData;
    }

    /**
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * time complexity: O(N)
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     */
    @Override
    public E get(int pos) {
        if (pos < 0 || pos > length-1){
            throw new IllegalArgumentException("Invalid input for list position");
        }
        DoubleListNode<E> newNode = getNode(pos);
        return newNode.getData();
    }

    /**
     * returns node at given postion
     * time complexity: O(N)
     * @param pos
     * @return
     */
    private DoubleListNode<E> getNode(int pos){
        DoubleListNode<E> newNode;
        newNode = head;
        for (int i = 0; i < pos; i++){
            newNode = newNode.getNext();
        }
        return newNode;
    }

    /**
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a position > pos have a position = old position - 1
     * time complexity: O(N)
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     */
    @Override
    public E remove(int pos) {
        if (pos < 0 || pos > length-1){
            throw new IllegalArgumentException("Invalid input for list position");
        }
        if (pos == 0){
            return removeFirst();
        } else if (pos == length-1) {
            return removeLast();
        }
        DoubleListNode<E> temp = getNode(pos);
        temp.getNext().setPrev(temp.getPrev());
        temp.getPrev().setNext(temp.getNext());
        length--;
        return temp.getData();
    }

    /**
     * Remove the first occurrence of obj in this list.
     * Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     * <br>pre: obj != null
     * <br>post: if obj is in this list the first occurrence
     * has been removed and size() = old size() - 1.
     * If obj is not present the list is not altered in any way.
     * time complexity: O(N)
     * @param obj The item to remove from this list. obj != null
     * @return Return <tt>true</tt> if this list changed
     * as a result of this call, <tt>false</tt> otherwise.
     */
    @Override
    public boolean remove(E obj) {
        if (obj == null){
            throw new IllegalArgumentException("Object cannot be null");
        }
        DoubleListNode<E> temp;
        temp = head;
        E data = temp.getData();
        int index = 0;
        while (!data.equals(obj) && index < length-1){
            temp = temp.getNext();
            data = temp.getData();
            index++;
        }
        if(data.equals(obj)){
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Return a sublist of elements in this list
     * from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * This list is not changed as a result of this call.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: return a list whose size is stop - start
     * and contains the elements at positions start through stop - 1
     * in this list.
     * @param start index of the first element of the sublist.
     * @param stop stop - 1 is the index of the last element
     * of the sublist.
     *  time complexity: O(N)
     * @return a list with <tt>stop - start</tt> elements,
     * The elements are from positions <tt>start</tt> inclusive to
     * <tt>stop</tt> exclusive in this list.
     * If start == stop an empty list is returned.
     */
    @Override
    public IList<E> getSubList(int start, int stop) {
        if (start < 0 || start > length || stop < 0 || stop > length || stop - start < 0){
            throw new IllegalArgumentException("Invalid input for list position");
        }
        DoubleListNode<E> node = getNode(start);
        IList<E> subList = new LinkedList<E>();
        for (int i = start; i < stop; i++){
            subList.add(node.getData());
            node = node.getNext();
        }
        return subList;
    }

    /**
     * Return the size of this list.
     * In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     * time complexity: O(1)
     * @return the number of items in this list
     */
    @Override
    public int size() {
        return length;
    }

    /**
     * Find the position of an element in the list.
     * <br>pre: item != null
     * <br>post: return the index of the first element equal to item
     * or -1 if item is not present
     * @param item the element to search for in the list. item != null
     * @return return the index of the first element equal to item
     * or a -1 if item is not present
     * time complexity: O(N)
     */
    @Override
    public int indexOf(E item) {
        return indexOf(item, 0);
    }

    /**
     * find the position of an element in the list starting
     * at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal
     * to item starting at pos
     * or -1 if item is not present from position pos onward
     * @param item the element to search for in the list. Item != null
     * @param pos the position in the list to start searching from
     * @return starting from the specified position
     * return the index of the first element equal to item
     * or a -1 if item is not present between pos
     * and the end of the list
     * time complexity: O(N)
     */
    @Override
    public int indexOf(E item, int pos) {
        if (pos < 0 || pos > length-1){
            throw new IllegalArgumentException("Invalid input for list position");
        }
        if (item == null){
            throw new IllegalArgumentException("item cannon be null");
        }
        DoubleListNode<E> node = getNode(pos);
        int index = pos;
        while (node != null){
            if (node.getData().equals(item)){
                return index;
            }
            else{
                node = node.getNext();
                index++;
            }
        }
        return -1;
    }

    /**
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     * time complexity: O(1)
     */
    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * return an Iterator for this list.
     * <br>pre: none
     * <br>post: return an Iterator object for this List
     * time complexity: O(1)
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Determine if this IList is equal to other. Two
     * ILists are equal if they contain the same elements
     * in the same order.
     * time complexity: O(N)
     * @return true if this IList is equal to other, false otherwise
     */
    public boolean equals(IList<E> otherList) {
        if (otherList == null || this.size() != otherList.size()){
            return false;
        }
        if (this.size() == 0 && otherList.size() == 0){
            return true;
        }
        Iterator<E> it = this.iterator();
        Iterator<E> otherIt = otherList.iterator();
        if (it.hasNext() && otherIt.hasNext()){
            E node = it.next();
            E otherNode = otherIt.next();
            while (it.hasNext() && otherIt.hasNext()) {
                if (!node.equals(otherNode)) {
                    return false;
                }
                node = it.next();
                otherNode = otherIt.next();
            }
        }
        return true;
    }

    /**
     * This class provides an iterator for the elements of a linked list. The
     * iterator allows for iterating over the elements in the list, and for
     * removing elements from the list during iteration.
     */
    private class LinkedListIterator implements Iterator<E>{
        DoubleListNode<E> node;
        DoubleListNode<E> nodeToRemove;
        int length;
        int count;
        boolean remove;

        /**
         * Constructs a new iterator for the enclosing linked list. The iterator's
         * current node is set to the head of the list, and the iterator's length is
         * initialized to the length of the enclosing linked list.
         * The remove flag is set to false, indicating that remove() cannot be called
         * until after next() has been called at least once.
         * This constructor is private, so it can only be called from within the
         * enclosing LinkedList class.
         * time complexity: O(1)
         */
        private LinkedListIterator(){
            this.node = head;
            this.length = LinkedList.this.length;
            remove = false;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         * time complexity: O(1)
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return node != null && count != this.length;
        }

        /**
         * Returns the next element in the iteration.
         * @return the next element in the iteration
         * time complexity: O(1)
         * NoSuchElementException – if the iteration has no more elements
         */
        @Override
        public E next() {
            if (!hasNext()){
                throw new NoSuchElementException();
            }
            remove = true;
            E result = node.getData();
            nodeToRemove = node;
            node = node.getNext();
            count++;
            return result;
        }

        /**
         * Removes from the linked list the last element returned by this iterator.
         * This method can only be called once per call to next(). If remove() is called
         * before next() or if remove() is called multiple times after next(), an
         * IllegalStateException is thrown.
         * time complexity: O(1)
         */
        @Override
        public void remove() {
            if (node != null){
                if (remove){
                    DoubleListNode<E> prev = node.getPrev();
                    if (prev == head){
                        prev.getNext().setPrev(null);
                        head = node;
                    }
                    else{
                        prev.getNext().setPrev(prev.getPrev());
                        prev.getPrev().setNext(prev.getNext());
                    }
                }
                else{
                    throw new IllegalStateException();
                }
            }
            this.length--;
            LinkedList.this.length--;
            count--;
        }
    }

    /**
     * Remove all elements in this list from <tt>start</tt>
     * inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start <= size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * time complexity: O(N)
     * @param start position at beginning of range of elements
     * to be removed
     * @param stop stop - 1 is the position at the end
     * of the range of elements to be removed
     */
    @Override
    public void removeRange(int start, int stop) {
        if (start < 0 || start > length || stop < 0 || stop > length || stop - start < 0){
            throw new IllegalArgumentException("Invalid input for list position");
        }
        DoubleListNode<E> nodeStart = getNode(start).getPrev();
        DoubleListNode<E> nodeStop = getNode(stop);
        if (nodeStart == null){
            DoubleListNode<E> dummy = new DoubleListNode<>(); // make dummy to access first node
            head.setPrev(dummy);
            nodeStart = head.getPrev();
        }
        if (nodeStop == null){
            DoubleListNode<E> dummy = new DoubleListNode<>(); // make dummy to access last node
            tail.setNext(dummy);
            nodeStop = tail.getPrev();
        }
        nodeStart.setNext(nodeStop);
        nodeStop.setPrev(nodeStart);
        if (start == 0){
            head = nodeStart.getNext();
            head.setPrev(null);
        }
        length = length - (stop-start);
    }

    /**
     * Return a String version of this list enclosed in
     * square brackets, []. Elements
     *      * are in order based on position in the
     * list with the first element
     * first. Adjacent elements are separated by comma's
     * @return a String representation of this IList
     * time complexity: O(N)
     */
    public String toString() {
        DoubleListNode<E> temp;
        temp = head;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++){
            if (i == length-1){
                sb.append(temp.getData());
            }
            else{
                sb.append(temp.getData()).append(", ");
            }
            temp = temp.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * A class that represents a node to be used in a linked list.
     * These nodes are doubly linked. All methods are O(1).
     *
     * @author Mike Scott
     * @version July 25, 2005
     */

    private static class DoubleListNode<E> {

        // instance variables

        // The data stored in this node.
        private E myData;

        // The link to the next node (presumably in a list).
        private DoubleListNode<E> myNext;

        // The link to the previous node (presumably in a list).
        private DoubleListNode<E> myPrev;

        /**
         * default constructor.
         * <br>pre: none
         * <br>post: getData() = null, getNext() = null, getPrev() = null
         */
        public DoubleListNode() {
            this(null, null, null);
        }

        /**
         * create a DoubleListNode that holds the specified data
         * and refers to the specified next and previous elements.
         * <br>pre: none
         * <br>post: getData() = data, getNext() = next, getPrev() = prev
         * @param prev the previous node
         * @param data the  data this DoubleListNode should hold
         * @param next the next node
         */
        public DoubleListNode(DoubleListNode<E> prev, E data,
                DoubleListNode<E> next) {

            myData = data;
            myNext = next;
            myPrev = prev;
        }

        /**
         * return the data in this node.
         * <br>pre: none
         * @return the data this DoubleListNode holds
         */
        public E getData() {
            return myData;
        }

        /**
         * return the DoubleListNode this ListNode refers to.
         * <br>pre: none
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the next one in a list)
         */
        public DoubleListNode<E> getNext() {
            return myNext;
        }

        /**
         * return the DoubleListNode this DoubleListNode refers to.
         * <br>pre: none
         * @return the DoubleListNode this DoubleListNode refers to
         * (normally the previous one in a list)
         */
        public DoubleListNode<E> getPrev() {
            return myPrev;
        }

        /**
         * set the data in this node.
         * The old data is over written.
         * <br>pre: none
         * <br>post: getData() == data
         * @param data the new data for this DoubleListNode to hold
         */
        public void setData(E data) {
            myData = data;
        }

        /**
         * set the next node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getNext() = next
         * @param next the next node this DoubleListNode should refer to
         */
        public void setNext(DoubleListNode<E> next) {
            myNext = next;
        }

        /**
         * set the previous node this DoubleListNode refers to.
         * <br>pre: none
         * <br>post: getPrev() = next
         * @param prev the previous node this DoubleListNode should refer to
         */
        public void setPrev(DoubleListNode<E> prev) {
            myPrev = prev;
        }
    }
}
