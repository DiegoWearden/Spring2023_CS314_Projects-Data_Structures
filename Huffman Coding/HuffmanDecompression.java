import java.io.IOException;

public class HuffmanDecompression {
    private BitInputStream bitIn;
    private BitOutputStream bitOut; 
    private HuffmanCodeTree huffTree;
    private int[] freqs;

    public HuffmanDecompression(BitInputStream in, BitOutputStream out) {
        this.bitIn = in;
        this.bitOut = out;
        this.freqs = new int[IHuffConstants.ALPH_SIZE];
    }

    /**
     * Reads file for the magic number
     */
    public void checkFile() throws IOException{
        int magic = bitIn.readBits(IHuffConstants.BITS_PER_INT);
        if (magic != IHuffConstants.MAGIC_NUMBER) {
            bitIn.close();
            bitOut.close();
            throw new IOException("Invalid magic number");
        }
    }

    /**
     * Reconstruct tree
     */

    public void readHeader() throws IOException {
        int headerFormat = bitIn.readBits(IHuffConstants.BITS_PER_INT);
        if (headerFormat == IHuffConstants.STORE_COUNTS) {
            // If the header format is STORE_COUNTS, construct the Huffman code tree from frequencies
            this.readStoreCounts();
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

    private void readStoreCounts() throws IOException {
        // Create an array to store the frequency counts
        this.freqs = new int[IHuffConstants.ALPH_SIZE];

        // Read the frequency count for each symbol
        for (int i = 0; i < IHuffConstants.ALPH_SIZE; i++) {
            this.freqs[i] = bitIn.readBits(IHuffConstants.BITS_PER_INT);
        }
    }

    public int getAllData() throws IOException{
        int bitCount = 0;
        //changed this file since we aren't allowed to use break
        // thanks I forgot about that
        int ch = this.huffTree.decode(bitIn);
        while (ch != IHuffConstants.PSEUDO_EOF) {
            bitOut.writeBits(IHuffConstants.BITS_PER_WORD, ch); // write the uncompressed data to the output stream
            bitCount += IHuffConstants.BITS_PER_WORD;
            ch = this.huffTree.decode(bitIn); // get uncompressed data from encoded file
        }
        bitIn.close();
        bitOut.close();
        return bitCount;
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
}
