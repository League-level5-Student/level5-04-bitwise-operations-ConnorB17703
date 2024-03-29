package _02_AND_OR_and_XOR;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
 * Goal: Implement left and right rotate methods.
 * 
 * Inherently Java doesn't have an instruction to perform left or right
 * rotates (though there are rotate functions in the Integer class).
 * 
 * A rotate is when a bit is shifted outside the width of the variable and is
 * placed on the other side. Here is an example of a right rotate on int 7
 * by 1:
 *      00000000 00000000 00000000 00000111   // original value of 7
 *      10000000 00000000 00000000 00000011   // rotate right by 1
 * 
 * Normally when the number 7 is right shifted by 1, the rightmost '1' is
 * discarded and the result looks like this:
 *      00000000 00000000 00000000 00000011   // 7 >> 1 (last '1' is discarded)
 * For a right rotate the number is not discarded and it's placed on the left,
 * the most significant bit (bit 31).
 * 
 * The same goes for a left rotate:
 *      11111111 11111111 11111111 11111000   // original value of -8
 *      11111111 11111111 11111111 11110001   // rotate left by 1
 */


//you were working on the rightRotate method last time. there is a problem with the shifting part of the method, everytime it shifts it still adds a 1 in the front even though no zero has been detected at the end.

public class _02_Rotate {
    
    int rotateLeft(int value, int rotateAmount) {
    	int b = value;
    	int finalvalue = 0;
    	System.out.println("Orignal Value: " + value); 
    	System.out.println("Binary Value: " + Integer.toBinaryString(value));
    	
    	int num = value & 0b1000;
    	
    	for(int i = 1; i<rotateAmount+1; i++) {
    	//checking if 1 is at the front 
    	if(num == 8) {
    		System.out.println("Iteration:"+ i + "  There was a 1 at the front");

    		//***
    		finalvalue = b << 1;
    		System.out.println("shift to left --> "+ Integer.toBinaryString(finalvalue));

    		b = finalvalue|0b0001;
    		System.out.println("adding 1 at the end --> "+ Integer.toBinaryString(b));

    		
    		finalvalue = b;
    		System.out.println("RESULT: --> "+ Integer.toBinaryString(finalvalue));
    		//***
    		
    		System.out.println("\n");
    		
    	}else if(num != 8){
    	//if there wasn't a 1 at the front
    		b = value << 1; 
    		System.out.println("Iteration:"+ i + "  There was a 0 at the front --> " + Integer.toBinaryString(b));

    	}
    	
    	}
    	
//    	for(int i = 0; i<33; i++) {
//    		int x = 1 <<i;
//    		int num2 = x & (1<<31);
//    		System.out.println("num2 --> " + Integer.toBinaryString(num2));
//    		System.out.println("x --> " + Integer.toBinaryString(x));
//    	}
//    	
    	
//    	//checking if 1 at the end
//    	if(num == 1) {
//    		b = value << rotateAmount;
//    		System.out.println("There was a 1 at the end --> " + Integer.toBinaryString(b));
//    		
//    		
//    	//checking if 0 at the end	
//    	}else {
//    		b = value << rotateAmount;
//    		System.out.println("There was a 0 at the end --> " + Integer.toBinaryString(b));
//
//    		finalvalue = b | 0b001;
//    		
//    	}
    	
    	return finalvalue;
    }
    
    boolean endsIn1(int value) {
    	int val = value & 0b0001;
    	if(val == 1 ) {
    		return true;
    	}
    	return false;
    }
 //          ^    
 //          | 
 //          | 
 //          | 
 //          V 
    int rotateRight1(int val) {
    	int output = 0;
    	//checking if 1 is at the end 
    									//System.out.println("value: " + Integer.toBinaryString(val));
    	if(endsIn1(val) == true) {
    		System.out.println("1 at the end \n");
    		
    		//***
    		output = val >>> 1;
    		System.out.println("shift to right --> "+ Integer.toBinaryString(output));

    		val= output|0b10000000000000000000000000000000;
    		System.out.println("adding 1 at the front --> "+ Integer.toBinaryString(val));

    		
    		output = val;
    		val = output;
    		System.out.println("RESULT: --> "+ Integer.toBinaryString(output));
    		//***
    		
    		System.out.println("\n");
    		
    	}else if(endsIn1(val) == false){
    	//if there wasn't a 1 at the end
    		System.out.println("0 at the end");
    		output = val >>> 1; 
    		System.out.println("shift to the right --> " + Integer.toBinaryString(output) + "\n");

    	}
    	return output;
    	
    }
    
    
    int rotateRight(int value, int rotateAmount) {
    	int b = value;
    	int finalvalue = 0;
    	System.out.println("Orignal Value: " + value); 
    	System.out.println("Binary Value: " + Integer.toBinaryString(value));
    	
    	
    	for(int i = 1; i<rotateAmount+1; i++) {
    		finalvalue = rotateRight1(b);
    		b = finalvalue;
    	}
    	
    	return finalvalue;
    }
    
    
    
    
    
    
    
    @Test
    void testRotateLeft() {
        int i = -8;

        int result = rotateLeft(i, 1);
        System.out.println("Left rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-15));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-15, result);
        
    	System.out.println("\n" + "-------------------------------------------------------------------");
        
        result = rotateLeft(i, 3);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(-57));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-57, result);
        
    }
    
    @Test
    void testRotateRight() {
        int i = 7;
        
        int result = rotateRight(i, 1);
        System.out.println("\nRight rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-2147483645));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-2147483645, result);
        
        result = rotateRight(i, 16);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(458752));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(458752, result);
    }
}
