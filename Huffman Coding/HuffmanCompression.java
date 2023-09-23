import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


public class HuffmanCompression {
    private String[] mp;
    private HuffmanCodeTree huffTree;
    private IHuffViewer myViewer;
    //original file bit count
    private int[] freqs;
    private int format;
    private int ogCount;
    private int compCount;

    BitInputStream bitIn;
    BitOutputStream bitOut; 

    public HuffmanCompression(BitInputStream in, BitOutputStream out,
     int format, IHuffViewer viewer) {
        this.bitIn = in;
        this.bitOut = out;
        this.format = format;
        this.myViewer = viewer;
    }

    public int preprocessCompress() throws IOException {
        this.compCount = 0;
        this.ogCount = 0;
        this.freqs = getFreq();
        this.huffTree = new HuffmanCodeTree(freqs);
        this.mp = huffTree.createMap();
        findCompBitCount();
        // checkMap(mp);
        // checkGetNode(huffTree, mp);
        bitIn.close();

        return this.ogCount - this.compCount;
    }

    public int getOrginalCount() {
        return this.ogCount;
    }

    public int getCompressedCount() {
        return this.compCount;
    }

    public void setInput(BitInputStream in) {
        this.bitIn = in;
    }
    
    public void setOutput(BitOutputStream out) {
        this.bitOut = out;
    }

    public void setViewer(IHuffViewer view) {
        this.myViewer = view;
    }
    public IHuffViewer getViewer() {
        return this.myViewer;
    }

    private int[] getFreq() throws IOException {
        int inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        int[] freqs = new int[IHuffConstants.ALPH_SIZE + 1];
        // go through our file and convert into the Int BITS stuff
        while (inbits != -1) {
            freqs[inbits]++;
            ogCount += IHuffConstants.BITS_PER_WORD;
            inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        }
        return freqs;
    }

    /**
     * count how many bits will be written with a certain format=
     * @param mp map that contains ASCII value and their respective location in tree
     * @param headerFormat what kind of format the file will be written as
     */
    private void findCompBitCount() {
        for (int i = 0; i < mp.length; i++) {
            String route = mp[i];
            int freq = (i != 256) ? freqs[i] : 1; 
            // if it's our EOF value then just make one
            if (route != null) {
                compCount += freq * route.length(); 
            }
        }
        compCount += 2 * IHuffConstants.BITS_PER_INT; 

        // now let's check which kind of header it will be
        // Store_Counts will be 256 * 32
        if (format == IHuffConstants.STORE_COUNTS) {
            compCount += IHuffConstants.ALPH_SIZE * IHuffConstants.BITS_PER_INT;
        } else if (format == IHuffConstants.STORE_TREE) {
            compCount += IHuffConstants.BITS_PER_INT;
            compCount += this.huffTree.getTreeSize();
        } else { 
            this.myViewer.showError("Custom header not supported");
        }
    }

    /**
     * Write in our magic number, format number, and tree construction
     */
    public void writeHeader(boolean force) {
        if (this.ogCount < this.compCount && !force) {

        }
        this.bitOut.writeBits(IHuffConstants.BITS_PER_INT, IHuffConstants.MAGIC_NUMBER);
        this.bitOut.writeBits(IHuffConstants.BITS_PER_INT, this.format);
        this.writeTreeConstruction();
    }

    /**
     * look at our format inputed by client and encode tree construction instructions
     * @param bitOut write out to hf file
     */
    private void writeTreeConstruction() {
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
    public int writeInData() throws IOException {
        
        int count = 0;
        String route = null;
        char[] routeArr = null;
        int inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        while (inbits != -1) {
            //find a way to make this into a helper
            route = this.mp[inbits];
            routeArr = route.toCharArray();
            count += this.writeEncoding(routeArr, bitOut);
            inbits = bitIn.readBits(IHuffConstants.BITS_PER_WORD);
        }
        // //Add EOF
        route = this.mp[IHuffConstants.PSEUDO_EOF];
        routeArr = route.toCharArray();
        count += this.writeEncoding(routeArr, bitOut);
        bitIn.close();
        bitOut.close();
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
}
