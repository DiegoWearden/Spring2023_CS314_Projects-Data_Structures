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

/**
 * Object that will handle preprocessing, compression, and decompression 
 * @author Nathan Chase, Diego Wearden, and Mike Scott.
 */

public class SimpleHuffProcessor implements IHuffProcessor {
    private Map<Integer, String> mp;
    private HuffmanCodeTree huffTree;
    private IHuffViewer myViewer;
    //original file bit count
    private int ogCount; 
    //compressed bit count
    private int compCount;
    private int[] freqs;
    private int format;

    /**
     * Preprocess data so that compression is possible --- count characters/create
     * tree/store state so that a subsequent call to compress will work. The
     * InputStream is <em>not</em> a BitInputStream, so wrap it int one as needed.
     * 
     * @param in           is the stream which could be subsequently compressed
     * @param headerFormat a constant from IHuffProcessor that determines what kind
     *                     of header to use, standard count format, standard tree
     *                     format, or possibly some format added in the future.
     * @return number of bits saved by compression or some other measure Note, to
     *         determine the number of bits saved, the number of bits written
     *         includes ALL bits that will be written including the magic number,
     *         the header format number, the header to reproduce the tree, AND the
     *         actual data.
     * @throws IOException if an error occurs while reading from the input file.
     */

    public int preprocessCompress(InputStream in, int headerFormat) throws IOException {
        this.format = headerFormat;
        this.compCount = 0;
        this.ogCount = 0;
        BitInputStream bitIn = new BitInputStream(in);
        this.freqs = this.getFreq(bitIn);
        this.huffTree = new HuffmanCodeTree(freqs);
        this.mp = this.huffTree.createMap();
        this.findCompBitCount(this.mp, headerFormat);
        // checkMap(mp);
        // checkGetNode(huffTree, mp);
        bitIn.close();

        return this.ogCount - this.compCount;
    }

    /**
     * Go through a file into int form counting the number of occurrences of characters
     * @param bitIn our bit stream
     * @return new array with our character frequencies
     * @throws IOException if there is issue with the file
     */
    private int[] getFreq(BitInputStream bitIn) throws IOException {
        int inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        int[] freqs = new int[IHuffConstants.ALPH_SIZE];
        // go through our file and convert into the Int BITS stuff
        while (inbits != -1) {
            freqs[inbits]++;
            this.ogCount += IHuffConstants.BITS_PER_WORD;
            inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        }
        return freqs;
    }

    /**
     * count how many bits will be written with a certain format=
     * @param mp map that contains ASCII value and their respective location in tree
     * @param headerFormat what kind of format the file will be written as
     */
    private void findCompBitCount(Map<Integer, String> mp, int headerFormat) {
        for (Integer key : mp.keySet()) {
            String route = mp.get(key);

            int freq = (key != IHuffConstants.ALPH_SIZE) ? freqs[key] : 1; 
            // if it's our EOF value then just make one
            this.compCount += freq * route.length();
        }
        this.compCount += 2 * IHuffConstants.BITS_PER_INT; 

        // now let's check which kind of header it will be
        // Store_Counts will be 256 * 32
        if (headerFormat == IHuffConstants.STORE_COUNTS) {
            this.compCount += IHuffConstants.ALPH_SIZE * IHuffConstants.BITS_PER_INT;
        } else if (headerFormat == IHuffConstants.STORE_TREE) {
            this.compCount += IHuffConstants.BITS_PER_INT;
            this.compCount += this.huffTree.getTreeSize();
            
        } else { 
            this.myViewer.showError("Custom header not supported");
        }
    }

    /**
     * Compresses input to output, where the same InputStream has previously been
     * pre-processed via <code>preprocessCompress</code> storing state used by this
     * call. <br>
     * pre: <code>preprocessCompress</code> must be called before this method
     * 
     * @param in    is the stream being compressed (NOT a BitInputStream)
     * @param out   is bound to a file/stream to which bits are written for the
     *              compressed file (not a BitOutputStream)
     * @param force if this is true create the output file even if it is larger than
     *              the input file. If this is false do not create the output file
     *              if it is larger than the input file.
     * @return the number of bits written.
     * @throws IOException if an error occurs while reading from the input file or
     *                     writing to the output file.
     */
    public int compress(InputStream in, OutputStream out, boolean force) throws IOException {
        if (this.compCount > this.ogCount && !force) {
            this.myViewer.showError("Compressed file has " + (this.compCount - this.ogCount)
                    + " more bits than uncompressed file.\n " 
                    + "Select \"force compression\" option to compress.");
            return 0;
        }

        BitInputStream bitIn = new BitInputStream(in);
        BitOutputStream bitOut = new BitOutputStream(out);

        bitOut.writeBits(IHuffConstants.BITS_PER_INT, IHuffConstants.MAGIC_NUMBER);
        bitOut.writeBits(IHuffConstants.BITS_PER_INT, this.format);
        this.writeHeader(bitOut);
        int count = this.writeInData(bitOut, bitIn);

        bitIn.close();
        bitOut.close();
        return count;
    }
    
    /**
     * look at our format inputed by client and encode tree construction instructions
     * @param bitOut write out to hf file
     */
    private void writeHeader(BitOutputStream bitOut) {
        if (this.format == IHuffConstants.STORE_COUNTS) {
            for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
                bitOut.writeBits(IHuffConstants.BITS_PER_INT, this.freqs[i]);
            }
        } else if (this.format == IHuffConstants.STORE_TREE) { 
            this.huffTree.outputTree(bitOut);
        }
    }
    
    /**
     * parse through input file and very every 8 bit occurance, output the encoded bits to hf
     * @param bitOut output stream to hf file
     * @param bitIn input stream to our input file 
     * @return number of bits written
     * @throws IOException
     */
    private int writeInData(BitOutputStream bitOut, BitInputStream bitIn) throws IOException {
        int count = 0;
        String route = null;
        char[] routeArr = null;
        int inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        while (inbits != -1) {
            //find a way to make this into a helper
            route = this.mp.get(inbits);
            routeArr = route.toCharArray();
            count += this.writeEncoding(routeArr, bitOut);
            inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        }
        // //Add EOF
        route = this.mp.get(IHuffConstants.PSEUDO_EOF);
        routeArr = route.toCharArray();
        count += this.writeEncoding(routeArr, bitOut);
        return count;
    }
    
    /**
     * 
     * @param routeArr character array that breaks down the encoded tree bits
     * @param bt where we will write out to the file 
     * @return return how many bits were written
     * @throws IOException
     */
    private int writeEncoding(char[] routeArr, BitOutputStream bt) throws IOException {
        int insert = 0;
        for (int i = 0; i < routeArr.length; i++) {
            insert = Integer.parseInt(String.valueOf(routeArr[i]));
            bt.writeBits(1, insert);
        }

        return routeArr.length;
    }

    /**
     * Uncompress a previously compressed stream in, writing the uncompressed
     * bits/data to out.
     * 
     * @param in  is the previously compressed data (not a BitInputStream)
     * @param out is the uncompressed file/stream
     * @return the number of bits written to the uncompressed file/stream
     * @throws IOException if an error occurs while reading from the input file or
     *                     writing to the output file.
     *
     *
     */

    public int uncompress(InputStream in, OutputStream out) throws IOException {
        BitInputStream bitIn = new BitInputStream(in);
        BitOutputStream bitOut = new BitOutputStream(out);

        int magic = bitIn.readBits(IHuffConstants.BITS_PER_INT);
        if (magic != IHuffConstants.MAGIC_NUMBER) {
            bitIn.close();
            bitOut.close();
            throw new IOException("Invalid magic number");
        }

        // Read the header and reconstruct the Huffman code tree, and get the number of bits written
        this.readHeader(bitOut,bitIn);
        int bitCount = this.getAllData(bitOut,bitIn);
        
        bitIn.close();
        bitOut.close();
        return bitCount;
    }
    
    /**
     * read the header portion of our hf file and reconstruct the tree accordingly
     * @param bitOut write to our unhf file
     * @param bitIn read our hf file
     * @throws IOException if user inputs a unknown header format
     */
    private void readHeader(BitOutputStream bitOut, BitInputStream bitIn ) throws IOException {
        int headerFormat = bitIn.readBits(IHuffConstants.BITS_PER_INT);
        if (headerFormat == IHuffConstants.STORE_COUNTS) {
            // If the header format is STORE_COUNTS, construct the Huffman code tree from frequencies
            this.readStoreCounts(bitIn);
            this.huffTree = new HuffmanCodeTree(this.freqs);
        } else if (headerFormat == IHuffConstants.STORE_TREE) {
            // If the header format is STORE_TREE, read the Huffman code tree directly
            this.huffTree = new HuffmanCodeTree(readTree(bitIn));
        } else {
            bitIn.close();
            bitOut.close();
            throw new IOException("Invalid header format");
        }
    }

    /**
     * reads encoding huffman tree. only gets called to uncompress
     * @param bitInputStream the encoded huffman tree instructions
     * @return root of the structured huffman tree
     * @throws IOException
     */
    public static TreeNode readTree(BitInputStream bitInputStream) throws IOException {
        // Read the size of the tree in bits.
        int treeSize = bitInputStream.readBits(IHuffConstants.BITS_PER_INT);
        // Call the helper method to recursively build the tree.
        return readTreeHelper(bitInputStream, treeSize);
    }


    private static TreeNode readTreeHelper(BitInputStream bitInputStream, int treeSize) throws IOException {
        // If the node is a leaf node, return null
        if (treeSize <= 0) {
            return null;
        }
        // Read the next bit from the input stream.
        int bit = bitInputStream.readBits(1);
        if (bit == 1) {
            // If the bit is 1, read the next IHuffConstants.BITS_PER_WORD + 1 encoded bits as the value of a leaf node.
            int value = bitInputStream.readBits(IHuffConstants.BITS_PER_WORD + 1);
            return new TreeNode(value, 1);
        } else if (bit == 0) {
            // If the bit is 0, recursively build the left and right subtrees.
            TreeNode left = readTreeHelper(bitInputStream, treeSize - 1);
            TreeNode right = readTreeHelper(bitInputStream, treeSize - 1);
            return new TreeNode(left, -1, right);
        } else {
            // If the bit is neither 0 nor 1, throw an exception.
            throw new IOException("Invalid bit encountered during tree reading");
        }
    }
    
    //make a helper that goes through the tree 
    private void readStoreCounts(BitInputStream bitIn) throws IOException {
        // Create an array to store the frequency counts
        this.freqs = new int[IHuffConstants.ALPH_SIZE];

        // Read the frequency count for each symbol
        for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
            this.freqs[i] = bitIn.readBits(IHuffConstants.BITS_PER_INT);
        }
    }
    
    //make a helper that writes out the actual data itself
    private int getAllData(BitOutputStream bitOut, BitInputStream bitIn) throws IOException {
        int bitCount = 0;
        //changed this file since we aren't allowed to use break
        // thanks I forgot about that
        int ch = this.huffTree.decode(bitIn);
        while (ch != IHuffConstants.PSEUDO_EOF) {
            bitOut.writeBits(IHuffConstants.BITS_PER_WORD, ch); // write the uncompressed data to the output stream
            bitCount += IHuffConstants.BITS_PER_WORD;
            ch = this.huffTree.decode(bitIn); // get uncompressed data from encoded file
        }
        return bitCount;
    }

    public void setViewer(IHuffViewer viewer) {
        this.myViewer = viewer;
    }

    private void showString(String s) {
        if (this.myViewer != null) {
            this.myViewer.update(s);
        }
    }
}