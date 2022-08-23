package _03_Printing_Binary;

public class _01_BinaryPrinter {
    /*
     * Complete the methods below so they print the passed in parameter in binary.
     * Do not use the Integer.toBinaryString method!
     * Use the main method to test your methods.
     */

	

    public static void printByteBinary(byte b) {
        // We first want to print the bit in the one's place
    	for(int i = 0; i<8; i++) {
        // Shift b seven bits to the right
    	int bShifted  = b >>> 7 - i;
        // Use the & operator to "mask" the bit in the one's place
        // This can be done by "anding" (&) it with the value of 1
    	int j = bShifted&1;
    	
        // Print the result using System.out.print (NOT System.out.println)
    	System.out.print(j);
    	}
        //Use this method to print the remaining 7 bits of b
    	
    	
    }

    public static void printShortBinary(short s) {
        // Create 2 byte variables
    	byte half1;
    	byte half2;
        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte
    	half1 = (byte) (s&0xFF);
    	
    	int SS = s>>>7;
    	half2 = (byte)(SS&0xFF);
    	
        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
    	printByteBinary(half1);
    	printByteBinary(half2);
    }

    public static void  printIntBinary(int i) {
        // Create 2 short variables
    	short h1;
    	short h2;
    	
        // Use bit shifting and masking (&) to save the first
        // 16 bits of i in one short, and the second 16 bits of
        // i in the other short
    	h1 = (short) (i & 0xFF);
    	
    	int IS = i >>> 15;
    	h2 = (short) (IS & 0xFF);

        // Call printShortBinary twice using the two short variables
        // Make sure they are in the correct order
    	printShortBinary(h1);
    	printShortBinary(h2);
    	
    }

    public static void printLongBinary(long l) {
        // Use the same method as before to complete this method
    	int h1;
    	int h2;
    	
    	h1 = (int) (l&0xFF);
    	
    	int LS = (int) (l >>> 31);
    	h2 = (int) (LS &0xFF);
    	
    	printIntBinary(h1);
    	printIntBinary(h2);
    }

    public static void main(String[] args) {
        // Test your methods here
    	printByteBinary((byte) 80);
    	System.out.println("\n");
    	
    	printShortBinary((short)80);
    	System.out.println("\n");
    	
    	printIntBinary(80);    
    	System.out.println("\n");
    	
    	printLongBinary(80);
    }
}
