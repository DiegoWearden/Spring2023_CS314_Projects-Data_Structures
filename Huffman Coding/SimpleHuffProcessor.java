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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class SimpleHuffProcessor implements IHuffProcessor {
    private Map<Integer, String> mp; //maybe store in tree object??????
    private HuffmanCodeTree huffTree;
    private IHuffViewer myViewer;
    private int ogCount; // original bit count
    private int compCount; //compressed bit count
    private int[] freqs;
    private int format;


    /**
     * Preprocess data so that compression is possible ---
     * count characters/create tree/store state so that
     * a subsequent call to compress will work. The InputStream
     * is <em>not</em> a BitInputStream, so wrap it int one as needed.
     * @param in is the stream which could be subsequently compressed
     * @param headerFormat a constant from IHuffProcessor that determines what kind of
     * header to use, standard count format, standard tree format, or
     * possibly some format added in the future.
     * @return number of bits saved by compression or some other measure
     * Note, to determine the number of
     * bits saved, the number of bits written includes
     * ALL bits that will be written including the
     * magic number, the header format number, the header to
     * reproduce the tree, AND the actual data.
     * @throws IOException if an error occurs while reading from the input file.
     */
    //TODO stop here and test over preprocess compression methods, I feel like everything is
    //working for the most part but I am not sure about the computing bits
    public int preprocessCompress(InputStream in, int headerFormat) throws IOException {
        this.format = headerFormat;
        this.compCount = 0;
        this.ogCount = 0;
        BitInputStream bitInputStream = new BitInputStream(in);
        this.freqs = getFreq(bitInputStream);
        this.huffTree = new HuffmanCodeTree(freqs);
        this.mp = huffTree.createMap();
        findCompBitCount(mp, headerFormat);
        // checkMap(mp);
        // checkGetNode(huffTree, mp);
        bitInputStream.close();

        return this.ogCount -  this.compCount;
    }
    //makes the frequency array given a BitStream obj
    private int[] getFreq(BitInputStream bitInputStream) throws IOException{
        int inbits = bitInputStream.readBits(IHuffConstants.BITS_PER_WORD);
        int[] freqs = new int[IHuffConstants.ALPH_SIZE];
        //go through our file and convert into the Int BITS stuff
        while (inbits != -1) {
            freqs[inbits]++;
            this.ogCount += IHuffConstants.BITS_PER_WORD; //one int is 32 bits
            inbits = bitInputStream.readBits(IHuffConstants.BITS_PER_WORD);
        }
        return freqs;
    }

    //makes the priority queue given an array of freqencies
//    private PriorityQueue314<TreeNode> createQueue() {
//        PriorityQueue314<TreeNode> q = new PriorityQueue314<TreeNode>();
//        for (int i = 0; i < freqs.length; i++){
//            if (freqs[i] != 0){
//                q.enqueue(new TreeNode(i,freqs[i]));
//            }
//        }
//        q.enqueue(new TreeNode(IHuffConstants.PSEUDO_EOF, 1));
//        return q;
//    }
//
//    // //debug make sure our map is being made correctly
//    // private void checkMap() {
//    //     System.out.println();
//    //     for (Integer num : mp.keySet()) {
//    //         System.out.println("value: " + num + ", as char: " + (char) (int) num + ", new Code: " + mp.get(num));
//    //     }
//    // }
//
//    // //debug our getter
//    // private void checkGetNode() {
//    //     for (Integer num : mp.keySet()) {
//    //         String route = mp.get(num);
//    //         TreeNode ret = huffTree.getNode(route);
//    //         if (num == ret.getValue()) {
//    //             System.out.println("Found: " + num + " Route: " + route);
//    //         }
//    //     }
//    // }
//
//    //TODO create a new Tree class and have it do this
//    // //restrutures our priority queue into a tree with the only node in queue being the root
//    private HuffmanCodeTree createTree(PriorityQueue314<TreeNode> q) {
//        while (!q.isCompleteTree()){
//            TreeNode treeNode1 =  q.dequeue();
//            TreeNode treeNode2 =   q.dequeue();
//            TreeNode parentNode = new TreeNode(treeNode1, -1, treeNode2);
//            q.enqueue(parentNode);
//        }
//        root = q.dequeue(); //cut off the PriorityQueue and keep the value
//        //create a new tree
//        return new HuffmanCodeTree(root);
//    }

    //look at our new huffman bits and count how many are there
    // IF THINGS GO WRONG JUST LOOK AT THIS METHOD, IT HELLA SUS
    private void findCompBitCount(Map<Integer, String> mp, int headerFormat) {
        for (Integer key : mp.keySet()) {
            String route = mp.get(key);

            int freq = (key != IHuffConstants.ALPH_SIZE) ? freqs[key] : 1; //if it's our EOF value then just make one
            this.compCount += freq * route.length();
        }
        this.compCount += IHuffConstants.BITS_PER_INT; //this is for the magic number which is a int
        this.compCount += IHuffConstants.BITS_PER_INT; //this is for the format number

        //now let's check which kind of header it will be
        //Store_Counts will be 256 * 32
        if (headerFormat == IHuffConstants.STORE_COUNTS) {
            this.compCount += IHuffConstants.ALPH_SIZE * IHuffConstants.BITS_PER_INT;
        } else if (headerFormat == IHuffConstants.STORE_TREE) {
            this.compCount += huffTree.findNumBits(); //
        } else { //for a custom format that I have no clue what to do with???????????

        }
    }

    /**
     * Compresses input to output, where the same InputStream has
     * previously been pre-processed via <code>preprocessCompress</code>
     * storing state used by this call.
     * <br> pre: <code>preprocessCompress</code> must be called before this method
     * @param in is the stream being compressed (NOT a BitInputStream)
     * @param out is bound to a file/stream to which bits are written
     * for the compressed file (not a BitOutputStream)
     * @param force if this is true create the output file even if it is larger than the input file.
     * If this is false do not create the output file if it is larger than the input file.
     * @return the number of bits written.
     * @throws IOException if an error occurs while reading from the input file or
     * writing to the output file.
     */
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        BitInputStream bitInputStream = new BitInputStream(in);
        BitOutputStream bitOutputStream = new BitOutputStream(out);

        bitOutputStream.writeBits(IHuffConstants.BITS_PER_INT, IHuffConstants.MAGIC_NUMBER);
        bitOutputStream.writeBits(IHuffConstants.BITS_PER_INT, format);

        //STANDARD COUNT FORMAT
        if (format == IHuffConstants.STORE_COUNTS) {
            for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
                bitOutputStream.writeBits(IHuffConstants.BITS_PER_INT, freqs[i]);

            }
        } else if (format == IHuffConstants.STORE_TREE) { //STANDARD TREE FORMAT
            huffTree.outputTree(bitOutputStream);
        }


        //go through all of the file
        //get the routes from the map
        //make those into ints
        //then right to output stream
        int inbits = bitInputStream.readBits(IHuffConstants.BITS_PER_WORD);
        int count = 0;
        String route = null;
        char[] routeArr = null;
        while (inbits != -1) {
            //grab value
            route = mp.get(inbits);
            routeArr = route.toCharArray();
            count += writeEncoding(routeArr, bitOutputStream);
            inbits = bitInputStream.readBits(IHuffConstants.BITS_PER_WORD);
        }
        // //Add EOF
        route = mp.get(IHuffConstants.PSEUDO_EOF);
        routeArr = route.toCharArray();
        count += writeEncoding(routeArr, bitOutputStream);

        bitInputStream.close();
        bitOutputStream.close();
        return count;
    }

    private int writeEncoding(char[] routeArr, BitOutputStream bt) throws IOException{
        int insert = 0;
        for (int i = 0; i < routeArr.length; i++) {
            insert = Integer.parseInt(String.valueOf(routeArr[i]));
            bt.writeBits(1, insert);
        }

        return routeArr.length;
    }

    /**
     * Uncompress a previously compressed stream in, writing the
     * uncompressed bits/data to out.
     * @param in is the previously compressed data (not a BitInputStream)
     * @param out is the uncompressed file/stream
     * @return the number of bits written to the uncompressed file/stream
     * @throws IOException if an error occurs while reading from the input file or
     * writing to the output file.
     *
     *
     */

    public int uncompress(InputStream in, OutputStream out) throws IOException {
        BitInputStream bitInputStream = new BitInputStream(in);
        BitOutputStream bitOutputStream = new BitOutputStream(out);

        int magic = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
        if (magic != IHuffConstants.MAGIC_NUMBER){
            throw new IOException("Invalid magic number");
        }

        int headerFormat = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
        HuffmanCodeTree huffTree;
        if (headerFormat == IHuffConstants.STORE_COUNTS) {
            int[] freqs = new int[IHuffConstants.ALPH_SIZE];
            for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
                freqs[i] = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
            }
            huffTree = new HuffmanCodeTree(freqs);
        } else if (headerFormat == IHuffConstants.STORE_TREE) {
            TreeNode root = HuffmanCodeTree.readTree(bitInputStream);
            huffTree = new HuffmanCodeTree(root);
        } else {
            throw new IOException("Invalid header format");
        }

        int bitCount = 0;

        while (true) {
            int ch = huffTree.decode(bitInputStream);
            if (ch == IHuffConstants.PSEUDO_EOF)
                break;
            bitOutputStream.writeBits(IHuffConstants.BITS_PER_WORD, ch);
            bitCount += IHuffConstants.BITS_PER_WORD;
        }

        bitInputStream.close();
        bitOutputStream.close();
        return bitCount;
    }

//    public int uncompress(InputStream in, OutputStream out) throws IOException {
//        BitInputStream bitInputStream = new BitInputStream(in);
//        BitOutputStream bitOutputStream = new BitOutputStream(out);
//
//        // Read and validate magic number
//        int magic = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
//        if (magic != IHuffConstants.MAGIC_NUMBER) {
//            throw new IOException("Invalid magic number");
//        }
//
//        // Read and process header format
//        int headerFormat = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
//        int[] freqs;
//        if (headerFormat == IHuffConstants.STORE_COUNTS) {
//            freqs = new int[IHuffConstants.ALPH_SIZE + 1];
//            for (int i = 0; i < IHuffConstants.ALPH_SIZE + 1; i++) {
//                freqs[i] = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
//            }
//        } else if (headerFormat == IHuffConstants.STORE_TREE) {
//            freqs = HuffmanCodeTree.readTree(bitInputStream);
//        } else {
//            throw new IOException("Invalid header format");
//        }
//
//        // Create a Huffman tree from the frequency data
//        HuffmanCodeTree huffTree = new HuffmanCodeTree(freqs);
//        int bitCount = 0;
//
//        // Decode and write the uncompressed data
//        int ch = huffTree.decode(bitInputStream);
//        while (ch != IHuffConstants.PSEUDO_EOF) {
//            bitOutputStream.writeBits(IHuffConstants.BITS_PER_WORD, ch);
//            bitCount += IHuffConstants.BITS_PER_WORD;
//            ch = huffTree.decode(bitInputStream);
//        }
//
//        // Close input and output streams
//        bitInputStream.close();
//        bitOutputStream.close();
//
//        return bitCount;
//    }
//    public int uncompress(InputStream in, OutputStream out) throws IOException {
//        BitInputStream bitInputStream = new BitInputStream(in);
//        BitOutputStream bitOutputStream = new BitOutputStream(out);
//
//        int magic = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
//        if (magic != IHuffConstants.MAGIC_NUMBER) {
//            throw new IOException("Invalid magic number");
//        }
//
//        int headerFormat = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
//        int[] freqs = new int[IHuffConstants.ALPH_SIZE];
//
//        if (headerFormat == IHuffConstants.STORE_COUNTS) {
//            for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
//                // get freqs from compressed file
//                freqs[i] = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
//            }
//        } else if (headerFormat == IHuffConstants.STORE_TREE) {
//            freqs = HuffmanCodeTree.readTree(bitInputStream);
//        } else { // custom, not sure what to do with
//
//        }
//
//        HuffmanCodeTree huffTree = new HuffmanCodeTree(freqs);
//        int bitCount = 0;
//
//
//        int ch = huffTree.decode(bitInputStream);
//        while (ch != IHuffConstants.PSEUDO_EOF) {
//            bitOutputStream.writeBits(IHuffConstants.BITS_PER_WORD, ch);
//            bitCount += IHuffConstants.BITS_PER_WORD;
//            ch = huffTree.decode(bitInputStream);
//        }
//
//        bitInputStream.close();
//        bitOutputStream.close();
//        return bitCount;
//    }

    public void setViewer(IHuffViewer viewer) {
        myViewer = viewer;
    }

    private void showString(String s){
        if (myViewer != null) {
            myViewer.update(s);
        }
    }
}