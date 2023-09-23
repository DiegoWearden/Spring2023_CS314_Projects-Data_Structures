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
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class HuffmanCodeTree {
    private final TreeNode root;

    public HuffmanCodeTree(int[] freqs) {
        PriorityQueue314<TreeNode> q = new PriorityQueue314<TreeNode>();
        for (int i = 0; i < freqs.length; i++){
            if (freqs[i] != 0){
                q.enqueue(new TreeNode(i,freqs[i]));
            }
        }
        q.enqueue(new TreeNode(IHuffConstants.PSEUDO_EOF, 1));
        while (!q.isCompleteTree()){
            TreeNode treeNode1 =  q.dequeue();
            TreeNode treeNode2 =   q.dequeue();
            TreeNode parentNode = new TreeNode(treeNode1, -1, treeNode2);
            q.enqueue(parentNode);
        }
        root = q.dequeue();
    }

    HuffmanCodeTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot(){
        return root;
    }

    //also create a hash map of itself
    public Map<Integer, String> createMap() {
        Map<Integer, String> mp = new TreeMap<Integer, String>();
        plotMap(mp, this.root, "");
        return mp;
    }
    //recursion time
    private void plotMap(Map<Integer, String> mp, TreeNode cur, String route) {
        if (cur.isLeaf()) {
            mp.put(cur.getValue(), route);
        } else {
            //go left
            plotMap(mp, cur.getLeft(), route + "0");
            plotMap(mp, cur.getRight(), route + "1");
        }
    }

    // //use this to grab whatever node we need to
    // public TreeNode getNode(String route) {
    //     return getHelper(this.root, route);
    // }
    // private TreeNode getHelper(TreeNode cur, String route) {
    //     if (cur.isLeaf() && route.length() == 0) {
    //         return cur;
    //     } else if (cur.isLeaf() || route.length() == 0) {
    //         return null;
    //     } else {
    //         TreeNode ret = null;
    //         if (route.charAt(0) == '0') {
    //             ret = getHelper(cur.getLeft(), route.substring(1));
    //         } else if (route.charAt(0) == '1') {
    //             ret = getHelper(cur.getRight(), route.substring(1));
    //         }
    //         return ret;
    //     }


    // }

    //find how many leaves and parent nodes are in the tree, feed through a array of size 1 int
    public int findNumBits() {
        int[] count = new int[1];
        count[0] += IHuffConstants.BITS_PER_INT;
        bitSizeHelper(this.root, count);
        return count[0];
    }
    private void bitSizeHelper(TreeNode n, int[] count) {
        //base case it's a leaf just add one and then add the value size
        if (n.isLeaf()) {//node
            count[0]++;
            count[0]+= (1 + IHuffConstants.BITS_PER_WORD) ; //for the value itself

        } else { //we are in a parent node
            count[0]++; //count the node itself
            treeSizeHelper(n.getLeft(), count);
            treeSizeHelper(n.getRight(), count);
        }
    }

    public int decode(BitInputStream bitInputStream) throws IOException {
        TreeNode currentNode = root;
        while (!currentNode.isLeaf()) {
            int bit = bitInputStream.readBits(1);
            if (bit == 0)  {
                currentNode = currentNode.getLeft();
            } else if (bit == 1) {
                currentNode = currentNode.getRight();
            } else {
                throw new IOException("Invalid bit encountered during decoding");
            }
        }
        return currentNode.getValue();
    }

    public static TreeNode readTree(BitInputStream bitInputStream) throws IOException {
        int treeSize = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
        return readTreeHelper(bitInputStream, treeSize);
    }


    private static TreeNode readTreeHelper(BitInputStream bitInputStream, int treeSize) throws IOException {
        if (treeSize <= 0){
            return null;
        }
        int bit = bitInputStream.readBits(1);
        if (bit == 1) {
            int value = bitInputStream.readBits(IHuffConstants.BITS_PER_WORD + 1);
            System.out.println(value);
            return new TreeNode(value, 1);
        } else if (bit == 0) {
            TreeNode left = readTreeHelper(bitInputStream, treeSize - 1);
            TreeNode right = readTreeHelper(bitInputStream, treeSize - 1);
            return new TreeNode(left, -1, right);
        } else {
            throw new IOException("Invalid bit encountered during tree reading");
        }
    }

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
            count[0]++; //count the node itself
            treeSizeHelper(n.getLeft(), count);
            treeSizeHelper(n.getRight(), count);
        }
    }
    //TODO make both private methods the same;
    //write to bit output our new tree
    public void outputTree(BitOutputStream bt) {
        //get the size of the tree
        int size = getTreeSize();
        System.out.println(size);
        bt.writeBits(IHuffConstants.BITS_PER_INT, size);
        outputHelper(bt, root);
    }
    private void outputHelper(BitOutputStream bt,TreeNode n) {
        if (n.isLeaf()) {
            bt.writeBits(1, 1);
            bt.writeBits(IHuffConstants.BITS_PER_WORD + 1, n.getValue());
        }
        else { //is parent
            bt.writeBits(1, 0);
            outputHelper(bt, n.getLeft());
            outputHelper(bt, n.getRight());
        }
    }


    // public void printTree() {
    //     recursiveHelper(this.root);
    // }

    // private void recursiveHelper(TreeNode cur) {
    //     if (cur.isLeaf()) {
    //         System.out.println(cur);
    //     } else {
    //         recursiveHelper(cur.getLeft());
    //         recursiveHelper(cur.getRight());
    //     }
    // }


}