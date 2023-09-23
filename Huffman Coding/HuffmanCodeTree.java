/*  Student information for assignment:
 *
 *  On our honor, Nathan Chase and Diego Wearden, this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *  Number of slip days used: 0
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Supporting data structure for Huffman compression. 
 * Stores values read from uncompressed files and puts them into 
 * leaflets with varying depths based on frequency. More frequent 
 * elements are put closer to the root. Return ecoded values that 
 * navigate this data structure for decompression.
 * 
 * @author Nathan Chase and Diego Wearden
 *
 */
public class HuffmanCodeTree {
    private final TreeNode root;
    
    /**
     * Constructor that based on inputted frequencies creates a temporary PriorityQueue314 queue,
     * and then forms a tree based on this queue.
     * 
     * @param freqs
     * 
     * @throws NullPointerException
     */
    public HuffmanCodeTree(int[] freqs) {
        if (freqs == null) {
            throw new NullPointerException("frequency array is null");
        }
        PriorityQueue314<TreeNode> q = new PriorityQueue314<TreeNode>();
        for (int i = 0; i < freqs.length; i++){
            if (freqs[i] != 0) {
                q.enqueue(new TreeNode(i, freqs[i]));
            }
        }
        q.enqueue(new TreeNode(IHuffConstants.PSEUDO_EOF, 1));
        while (!q.isCompleteTree()){
            TreeNode treeNode1 =  q.dequeue();
            TreeNode treeNode2 =   q.dequeue();
            TreeNode parentNode = new TreeNode(treeNode1, -1, treeNode2);
            q.enqueue(parentNode);
        }
        //cut off our tree from the queue, making the queue defunct
        this.root = q.dequeue();
    }
    
    /**
     * Alternative constructor which given a root with all connected nodes
     * makes it into a HuffmanCodeTree. Written for greater client flexibility, 
     * such as if client wishes for tree to be formatted differently.
     * 
     * @param inputRoot client inputed root with all branches connected
     * @throws NullPointerException if the client ends up feeding a null root 
     */
    public HuffmanCodeTree(TreeNode inputRoot) {
        if (inputRoot == null) {
            throw new NullPointerException("root node is null");
        }
        this.root = inputRoot;
    }
    
    /**
     * grabs the root of the tree and returns it
     * 
     * @return TreeNode root
     */
    
    public TreeNode getRoot() {
        return this.root;
    }

    /**
     * Based on the tree, create a map that stores the Integer 'bits' and the
     * encoded bit instructions to navigate tree
     * 
     * @return a new map
     */
    public Map<Integer, String> createMap() {
        //CHANGED TO HASHMAP
        Map<Integer, String> mp = new HashMap<Integer, String>();
        this.plotMap(mp, this.root, "");
        return mp;
    }
    
    /**
     * Recursive helper method which performs a In-Order transversal of our leaflet nodes.
     * 
     * @param mp the map which we will put our encoded bits into 
     * @param cur which node we are on right now in the tree 
     * @param route the resulting ecoded bits, which show how to navigate tree to data point
     */
    private void plotMap(Map<Integer, String> mp, TreeNode cur, String route) {
        if (cur.isLeaf()) {
            mp.put(cur.getValue(), route);
        } else {
            this.plotMap(mp, cur.getLeft(), route + "0");
            this.plotMap(mp, cur.getRight(), route + "1");
        }
    }
    
    // method decode huffman tree instructions
    public int decode(BitInputStream bitInputStream) throws IOException {
        TreeNode currentNode = root;
        // Traverse the encoded Huffman tree until a leaf node is reached.
        while (!currentNode.isLeaf()) {
            // Read the next bit from the input stream.
            int bit = bitInputStream.readBits(1);
            if (bit == 0) {
                // If the bit is 0, move to the left child node.
                currentNode = currentNode.getLeft();
            } else if (bit == 1) {
                // If the bit is 1, move to the right child node.
                currentNode = currentNode.getRight();
            } else {
                throw new IOException("Invalid bit encountered during decoding");
            }
        }
        // Return the value represented by the leaf node.
        return currentNode.getValue();
    }
    
    //TODO this method seems redundant but everytime I replace one, it fails a test????
    /**
     * This method seems hella redundant
     * @return size of our tree
     */
    public int getTreeSize() {
        int[] count = new int[1];
        treeSizeHelper(this.root, count);
        return count[0];
    }
    private void treeSizeHelper(TreeNode n, int[] count) {
        //base case it's a leaf just add one and then add the value size
        if (n.isLeaf()) {//node
            count[0] += 2;//for the value itself
            count[0] += IHuffConstants.BITS_PER_WORD;
        } else { //we are in a parent node
            count[0]++; 
            this.treeSizeHelper(n.getLeft(), count);
            this.treeSizeHelper(n.getRight(), count);
        }
    }

    //write to bit output our new tree
    public void outputTree(BitOutputStream bt) {
        //get the size of the tree
        int size = this.getTreeSize();
        bt.writeBits(IHuffConstants.BITS_PER_INT, size);
        this.outputHelper(bt, root);
    }
    private void outputHelper(BitOutputStream bt,TreeNode n) {
        if (n.isLeaf()) {
            bt.writeBits(1, 1);
            bt.writeBits(IHuffConstants.BITS_PER_WORD + 1, n.getValue());
        }
        else { //is parent
            bt.writeBits(1, 0);
            this.outputHelper(bt, n.getLeft());
            this.outputHelper(bt, n.getRight());
        }
    }
}