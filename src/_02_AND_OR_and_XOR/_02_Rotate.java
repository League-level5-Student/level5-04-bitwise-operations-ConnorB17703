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


//last time you thought of a new process, using a for loop. The for loop iterates for how many rotations there is and each time, you check if there is a 1 or 0 at the front of the number
//before shifting the number to the left once. Depending whether or not the number has a 1 or 0 in the front you "|| 0b001" the number to add a 1 to the end. CODE THAT!

//new problem: you need to fix the variables of b and the finalvalue so that every time you add 1 to the end, it is a new number.

public class _02_Rotate {
    
    int rotateLeft(int value, int rotateAmount) {
    	int b = 0;
    	int finalvalue = 0;
    	System.out.println("Orignal Value: " + value); 
    	System.out.println("Binary Value: " + Integer.toBinaryString(value));
    	
    	int num = value & 0b1000;
    	
    	for(int i = 1; i<rotateAmount+1; i++) {
    	//checking if 1 is at the front 
    	if(num == 8) {
    		//***
    		b = value << i;
    		b = b|0b0001;
    		//***
    		System.out.println("Iteration:"+ i + "  There was a 1 at the front --> "+ Integer.toBinaryString(b));
    		
    	}else{
    	//if there wasn't a 1 at the front
    		b = value << i; 
    		System.out.println("Iteration:"+ i + "  There was a 0 at the front --> " + Integer.toBinaryString(b));

    	}
    	
    	
    	
    	
    	}
    	
    	
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
    	
    	return b;
    }
    
    
    
    
    int rotateRight(int value, int rotateAmount) {
        return -1;
    }
    
    @Test
    void testRotateLeft() {
        int i = -8;

        int result = rotateLeft(i, 1);
        System.out.println("Left rotate tests");
        System.out.println("Expected: " + Integer.toBinaryString(-15));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-15, result);
        
    	System.out.println("\n");
        
        result = rotateLeft(i, 3);
        System.out.println();
        System.out.println("Expected: " + Integer.toBinaryString(-57));
        System.out.println("Actual  : " + Integer.toBinaryString(result));
        assertEquals(-57, result);
        
    }
//    
//    @Test
//    void testRotateRight() {
//        int i = 7;
//        
//        int result = rotateRight(i, 1);
//        System.out.println("\nRight rotate tests");
//        System.out.println("Expected: " + Integer.toBinaryString(-2147483645));
//        System.out.println("Actual  : " + Integer.toBinaryString(result));
//        assertEquals(-2147483645, result);
//        
//        result = rotateRight(i, 16);
//        System.out.println();
//        System.out.println("Expected: " + Integer.toBinaryString(458752));
//        System.out.println("Actual  : " + Integer.toBinaryString(result));
//        assertEquals(458752, result);
//    }
}
