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

import java.util.List;
import java.util.ArrayList;

/**
 * Shell for a binary search tree class.
 * @author scottm
 * @param <E> The data type of the elements of this BinarySearchTree.
 * Must implement Comparable or inherit from a class that implements
 * Comparable.
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> {

    private BSTNode<E> root;
    private int size;

    /** Uses code from lecture
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     */
    public boolean add(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot add null value to the tree.");
        }
        int oldSize = size;
        root = addHelp(root, value);
        return size != oldSize;
    }

    /**
     * Helper method for adding a value to the tree recursively.
     * @param node the current node in the recursion
     * @param value the value to add to the tree
     * @return the updated node after adding the value to the tree
     */
    private BSTNode<E> addHelp(BSTNode<E> node, E value) {
        if (node == null){
            size++;
            return new BSTNode<>(value);
        }
        int dir = value.compareTo(node.getData());
        if (dir < 0){
            node.setLeft(addHelp(node.getLeft(), value));
        } else if (dir > 0) {
            node.setRight(addHelp(node.getRight(), value));
        }
        return node;
    }


    /** Uses code from lecture
     *  Remove a specified item from this Binary Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     */
    public boolean remove(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot remove null value from the tree.");
        }
        int oldSize = size;
        root = removeHelper(root, value);
        return oldSize != size;
    }

    /**
     * Helper method for removing a value from the tree recursively.
     * @param node the current node in the recursion
     * @param value the value to remove from the tree
     * @return the updated node after removing the value from the tree
     */
    private BSTNode<E> removeHelper(BSTNode<E> node, E value) {
        if (node == null){
            return null;
        }
        int dir = value.compareTo(node.getData());
        if (dir < 0){
            node.setLeft(removeHelper(node.getLeft(), value));
        } else if (dir > 0) {
            node.setRight(removeHelper(node.getRight(), value));
        }else{
            size--;
            if (node.getLeft() == null && node.getRight() == null){
                node = null;
            } else if (node.getRight() == null) {
                node = node.getLeft();
            } else if (node.getLeft() == null) {
                node = node.getRight();
            }else {
                node.setData(max(node.getLeft()));
                node.setLeft(removeHelper(node.getLeft(), node.getData()));
                size++;
            }
        }
        return node;
    }

    /**
     * Helper method for finding the maximum value in a subtree.
     * @param node the root of the subtree to search for the maximum value
     * @return the maximum value in the subtree
     */
    private E max(BSTNode<E> node){
        while (node.getRight() != null){
            node = node.getRight();
        }
        return node.getData();
    }


    /**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @return true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        BSTNode<E> currNode = root;
        while (currNode != null) {
            int cmp = value.compareTo(currNode.getData());
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                currNode = currNode.getLeft();
            } else {
                currNode = currNode.getRight();
            }
        }
        return false;
    }


    /**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @return the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /** Uses code from lecture
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @return the height of this tree or -1 if the tree is empty
     */
    public int height() {
        return heightHelper(root);
    }

    /**
     * Helper method for calculating the height of the tree recursively.
     * @param node the current node in the recursion
     * @return the height of the tree
     */
    private int heightHelper(BSTNode<E> node) {
        if (node == null) {
            return -1;
        } else {
            int leftHeight = heightHelper(node.getLeft());
            int rightHeight = heightHelper(node.getRight());
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    /**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order.
     *  If the tree is empty return an empty List
     *  @return a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
        List<E> list = new ArrayList<>();
        getAllHelper(root, list);
        return list;
    }

    /**
     * Helper method for collecting all values in the tree in ascending order.
     * @param node the current node in the recursion
     * @param list the list to add the values to
     */
    private void getAllHelper(BSTNode<E> node, List<E> list) {
        if (node != null) {
            getAllHelper(node.getLeft(), list);
            list.add(node.getData());
            getAllHelper(node.getRight(), list);
        }
    }

    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
    public E max() {
        if (root == null){
            throw new IllegalStateException("size() must be greater than 0");
        }
        BSTNode<E> currNode = root;
        return max(currNode);
    }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
    public E min() {
        if (root == null){
            throw new IllegalStateException("size() must be greater than 0");
        }
        BSTNode<E> currNode = root;
        while (currNode.getLeft() != null){
            currNode = currNode.getLeft();
        }
        return currNode.getData();
    }

    /**
     * An add method that implements the add algorithm iteratively 
     * instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree, 
     * otherwise do nothing.
     * @param data the item to be added to this tree
     * @return true if data was not present before this call to add, 
     * false otherwise.
     */
    public boolean iterativeAdd(E data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot add null value to the tree.");
        }
        if (root == null) {
            root = new BSTNode<>(data);
            size++;
            return true;
        }
        BSTNode<E> currNode = root;
        while (true) {
            int comparison = data.compareTo(currNode.getData());
            if (comparison > 0) {
                if (currNode.getRight() == null) {
                    currNode.setRight(new BSTNode<>(data));
                    size++;
                    return true;
                } else {
                    currNode = currNode.getRight();
                }
            } else if (comparison < 0) {
                if (currNode.getLeft() == null) {
                    currNode.setLeft(new BSTNode<>(data));
                    size++;
                    return true;
                } else {
                    currNode = currNode.getLeft();
                }
            } else {
                return false;
            }
        }
    }


    /**
     * Return the "kth" element in this Binary Search Tree. If kth = 0 the
     * smallest value (minimum) is returned.
     * If kth = 1 the second-smallest value is returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Binary Search Tree
     */
    public E get(int kth) {
        if (kth < 0 || kth >= size()) {
            throw new IllegalArgumentException("kth cannot be less than 0 or greater than or equal to size()");
        }
        return getHelper(root, kth);
    }

    /**
     * A helper method for the public method get().
     * It recursively searches for the "kth" element in the Binary Search Tree
     * and returns the value of the node with rank kth.
     * @param node the root node of the current subtree
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Binary Search Tree
     */
    private E getHelper(BSTNode<E> node, int kth) {
        int leftSize = size(node.getLeft());
        if (kth < leftSize) {
            return getHelper(node.getLeft(), kth);
        } else if (kth > leftSize) {
            return getHelper(node.getRight(), kth - leftSize - 1);
        } else {
            return node.getData();
        }
    }

    /**
     * A helper method for calculating the number of nodes in a subtree.
     * @param node the root node of the current subtree
     * @return the number of nodes in the subtree rooted at node
     */
    private int size(BSTNode<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    /**
     * Return a List with all values in this Binary Search Tree 
     * that are less than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than 
     * the parameter value. If there are no values in this tree less 
     * than value return an empty list. The elements of the list are 
     * in ascending order.
     */
    public List<E> getAllLessThan(E value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot get less than null value");
        }
        List<E> result = new ArrayList<>();
        getAllLessThanHelper(root, value, result);
        return result;
    }

    /**
     * A helper method for the public method getAllLessThan().
     * It recursively searches for all the values in the Binary Search Tree
     * less than the parameter value and adds them to the result list.
     * @param node the root node of the current subtree
     * @param value the cutoff value
     * @param result the list to which the values less than value are added
     */
    private void getAllLessThanHelper(BSTNode<E> node, E value, List<E> result) {
        if (node == null) {
            return;
        }
        getAllLessThanHelper(node.getLeft(), value, result);
        if (node.getData().compareTo(value) < 0) {
            result.add(node.getData());
        }
        getAllLessThanHelper(node.getRight(), value, result);
    }



    /**
     * Return a List with all values in this Binary Search Tree 
     * that are greater than the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater
     *  than the parameter value. If there are no values in this tree
     * greater than value return an empty list. 
     * The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
        List<E> result = new ArrayList<>();
        getAllGreaterThanHelper(root, value, result);
        return result;
    }

    /**
     * A helper method for the public method getAllGreaterThan().
     * It recursively searches for all the values in the Binary Search Tree
     * greater than the parameter value and adds them to the result list.
     * @param node the root node of the current subtree
     * @param value the cutoff value
     * @param result the list to which the values greater than value are added
     */
    private void getAllGreaterThanHelper(BSTNode<E> node, E value, List<E> result) {
        if (node == null) {
            return;
        }
        getAllGreaterThanHelper(node.getLeft(), value, result);
        if (node.getData().compareTo(value) > 0){
            result.add(node.getData());
        }
        getAllGreaterThanHelper(node.getRight(), value, result);
    }


    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
        return numNodesAtDepthHelper(root, d, 0);
    }

    /**
     * A helper method for the public method numNodesAtDepth().
     * It recursively counts the number of nodes in the Binary Search Tree
     * at the target depth.
     * @param node the root node of the current subtree
     * @param targetDepth the target depth at which the number of nodes is to be counted
     * @param currentDepth the depth of the current node in the subtree
     * @return the number of nodes in the subtree at the target depth
     */
    private int numNodesAtDepthHelper(BSTNode<E> node, int targetDepth, int currentDepth) {
        if (node == null || currentDepth > targetDepth) {
            return 0;
        }
        if (currentDepth == targetDepth) {
            return 1;
        }
        int leftCount = numNodesAtDepthHelper(node.getLeft(), targetDepth, currentDepth + 1);
        int rightCount = numNodesAtDepthHelper(node.getRight(), targetDepth, currentDepth + 1);
        return leftCount + rightCount;
    }

    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children will not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * <br>pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<? super E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null);
        }

        public BSTNode(BSTNode<E> initLeft,
                E initValue,
                BSTNode<E> initRight) {
            data = initValue;
            left = initLeft;
            right = initRight;
        }

        public E getData() {
            return data;
        }

        public BSTNode<E> getLeft() {
            return left;
        }

        public BSTNode<E> getRight() {
            return right;
        }

        public void setData(E theNewValue) {
            data = theNewValue;
        }

        public void setLeft(BSTNode<E> theNewLeft) {
            left = theNewLeft;
        }

        public void setRight(BSTNode<E> theNewRight) {
            right = theNewRight;
        }
    }
}
