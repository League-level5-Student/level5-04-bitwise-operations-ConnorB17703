package _00_Binary_Conversion;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Goal: Learn how to convert binary to decimal
 * 
 * EXAMPLE: Convert 0 1 0 1 1 0 from binary to decimal
 * 
 * 1. Start from the right most digit of the binary number and assign
 *    that bit the value of 1.
 * 
 *          0   1   0   1   1   0
 *                              1
 *                              
 * 2. As you move to the left, assign the next digit a value that is
 *    double the previous digit.
 *          0   1   0   1   1   0
 *         32  16   8   4   2   1
 *
 * 3. For every 1 in the binary number, add all of the corresponding values
 *    together.
 *          0   1   0   1   1   0
 *         32  16   8   4   2   1
 *          ----------------------
 *         0 + 16 + 0 + 4 + 2 + 0 = 22
 * 
 *   010110 in binary is equal to 22 in decimal!
 */

//Concept: I am making two seperate arrays and comparing them. One for each binary number and another for its assigned values.
//Problem: something is wrong with the iterating and comparing block

public class _02_BinaryToDecimal {
    int convertBinaryStringToDecimalInt(String binStr) {
    	int dec = 0;
    	int[] bin = new int[binStr.length()];
    	int [] binValue = new int[bin.length];
    	int[] decValues = new int[bin.length];
     	
    	//putting each number into the array
    	for(int i = 0; i<binStr.length(); i++) {
    		bin[i] = Character.getNumericValue(binStr.charAt(i));
    		//System.out.println(bin[i]);
    	}
    	System.out.println("\n");
    	//assigning each value
    	int value  = 1;
    	for(int i = binValue.length-1; i>=0; i--) {
    		binValue[i] = value;
    		value = value + value;
    		
    	}
    	
    	
    	
    	//iterating and comparing
    	for(int i = 0; i<bin.length; i++) {
    		if(bin[i]==1){
    			decValues[bin.length-1 -i] = binValue[i];

    		}else {
    			decValues[bin.length-1 -i] = 0;
    		}
    		System.out.println(bin[i] + "   " + binValue[i] + "   " + decValues[bin.length-1 -i]);	
    		
    	}
    	
    	for(int i = 0; i<decValues.length; i++) {
    		dec+=decValues[i];
    	}
    	
    	return dec;
    	
    }

    @Test
    public void TestBinToDec() {
        String binStr = "010110";
        int expected = 22;
        assertEquals(expected, convertBinaryStringToDecimalInt(binStr));
        
        binStr = "11110000";
        expected = 240;
        assertEquals(expected, convertBinaryStringToDecimalInt(binStr));
        
        binStr = "10100101";
        expected = 165;
        assertEquals(expected, convertBinaryStringToDecimalInt(binStr));
    }
}

