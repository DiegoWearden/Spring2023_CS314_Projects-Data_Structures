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


Huffman compression is a lossless data compression algorithm that uses variable-length 
codes to represent the different characters or symbols in a file. 
The compression ratio achieved by the algorithm depends on the type of file being 
compressed and the frequency of occurrence of each symbol in the file.

In the case of TXT and HTML files, which contain mostly textual data with limited 
variation in character types, Huffman compression can achieve a compression ratio of up 
to 40%. This is because the algorithm is able to assign shorter codes to the most frequently 
occurring characters, thus reducing the overall size of the file.

On the other hand, TIFF files typically contain a large amount of image data with more complex 
and varied patterns, resulting in a compression ratio of around 20% with Huffman compression.

When Huffman compression is applied to a file that has already been compressed using the same 
algorithm, such as a HF file, it may not result in any significant reduction in file size, or 
may even increase the file size due to the added overhead of the compression algorithm.

Overall, the effectiveness of Huffman compression depends on the nature of the data being 
compressed, with simpler and more repetitive data resulting in higher compression ratios.

