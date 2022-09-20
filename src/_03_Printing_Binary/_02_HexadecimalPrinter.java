package _03_Printing_Binary;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Goal: Create a program that converts a binary string to ascii, decimal,
 *       and hexadecimal.
 * 
 * Programmers sometimes use a number system called hexadecimal that has 16
 * different possible characters per digit. Each digit can be from 0 to F,
 *     hex character: 0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F
 *     decimal value: 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
 * 
 * Hex values are prefixed with a 0x in code,
 *      int hex = 0x1F;     // 31 decimal, 1 1111 1111 binary
 * 
 * Since each hex digit can be 16 different characters, 1 byte can be expressed
 * as 2 hex characters. All 3 int variables below are the same value.
 *      int hex = 0x1F;
 *      int bin = 0b11111;
 *      int dec = 31;
 * 
 * Hex is used because it is more compact than binary. For example,
 *      int bin = 0b11111111111111111111111111111111    // 32 1s
 *      int hex = 0xFFFFFFFF;       // 8 F characters
 * 
 * Complete the methods so that it displays the correct hex value,.
 * decimal value, and ASCII value, if applicable.
 */
public class _02_HexadecimalPrinter implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField hexResult, decimalResult, asciiResult, inputTextField;
    JLabel labelAscii, labelDecimal, labelHex;
    JButton convertButton;

    /*
     * Complete these 3 methods. Assume the binary value is an int (32 bits).
     * You don't have to handle negative numbers unless you want the challenge!
     */
    
    //you have to check every four bits and turn them into integers base on the chart. 
    //Reminder: you are working with 32 bits
    //use this binary sample to test: 11001010100111010101001101010101
    
    //9/19/2022: issues with binary to decimal method (probably problem with dec variable)
    
    String binaryToHex(String binaryStr) {
    	String hexVal = "";
//    	String byte1 = binaryStr.substring(0, 4);
//    	String byte2 = binaryStr.substring(4,8);
    	//String byte3 = binaryStr.substring(8, 12);
//    	String byte4 = binaryStr.substring(12,16);
//    	String byte5 = binaryStr.substring(16,20);
//    	String byte6 = binaryStr.substring(20,24);
//    	String byte7 = binaryStr.substring(24,28);
//    	String byte8 = binaryStr.substring(28,32);

    	String bytes[] = new String[8];
    	
    	// checks and saves each byte 
    	int o;
    	for(int i=0; i<8; i++){
    		o = 4+(4*i);
    		bytes[i] = binaryStr.substring(4*i, o);
    		System.out.println("(" + 4*i + ", " + o + "): " + bytes[i]);
    		
    	}
    	
    	//converts each byte into integers and checks
    	int b;
    	String hexDigit = "";
    	for(int i = 0 ; i<8; i++) {
    		b = Integer.parseInt(bytes[i]);
    		
    		switch(b) {
    		case 0001:
    			hexDigit = "1";
    			break;
    		
    		case 0010:
    			hexDigit = "2";
    			break;
    		
    		case 0011:
    			hexDigit = "3";
    			break; 
    			
    		case 0100:
    			hexDigit = "4";
    			break;
    			
    		case 0101:
    			hexDigit = "5";
    			break;
    			
    		case 0110:
    			hexDigit = "6";
    			break;
    			
    		case 0111:
    			hexDigit = "7";
    			break;
    			
    		case 1000:
    			hexDigit = "8";
    			break;
    			
    		case 1001:
    			hexDigit = "9";
    			break;
    			
    		case 1010:
    			hexDigit  = "A";
    			break;
    		
    		case 1011:
    			hexDigit = "B";
    			break;
    		
    		case 1100:
    			hexDigit = "C";
    			break;
    			
    		case 1101:
    			hexDigit = "D";
    			break;
    			
    		case 1110:
    			hexDigit = "E";
    			break;
    			
    		case 1111:
    			hexDigit = "F";
    			break;
    		}
    		hexVal += hexDigit;
    		
    	}
        
        
    	return hexVal;
    }
    
    String binaryToDec(String binaryStr) {
    	int dec = 0;
    	int[] bin = new int[binaryStr.length()];
    	int[] binVal = new int[bin.length];
    	int[] decVal = new int[bin.length];
    	
    	//assigning all characters into array
    	for(int i=0; i<binaryStr.length(); i++) {
        	//System.out.println(binaryStr.charAt(i));
        	bin[i] = Character.getNumericValue(binaryStr.charAt(i));
        }
    	
    	//assigning all character in array with values
    	int value = 1;
    	for(int i=binaryStr.length()-1; i>=0; i--) {
    		binVal[i] = value;
    		value = value+value;
    	}
    	
    	//iterating and checking each
    	for(int i = 0; i<bin.length; i++) {
    		if(bin[i] == 1) {
    			decVal[bin.length-1 -i] = bin[i];
    		}else {
    			decVal[bin.length-1 -i] = 0;
    			
    		}
    		System.out.println(bin[i] + "   " + binVal[i] + "   " + decVal[bin.length-1 -i]);	
    	}
    	
    	
    	//adding all values to create decimal  ***************
    	for(int i = 0; i<decVal.length; i++) {
    		dec += decVal[i];
    		System.out.println(dec);
    	}
    	
    	
    	return String.valueOf(dec);
    }

    /*
     * ASCII values are exactly 8 bits so return '-' if there isn't.
     */
    String binaryToAscii(String binaryStr) {
        if (binaryStr.length() != 8) {
            return "-";
        }

        return "-";
    }
    
    public static void main(String[] args) {
        new _02_HexadecimalPrinter().start();
    }

    public void start() {
        frame = new JFrame("Hexadecimal Printer");
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        hexResult = new JTextField(12);
        decimalResult = new JTextField(12);
        asciiResult = new JTextField(12);
        inputTextField = new JTextField(25);
        convertButton = new JButton("Convert");
        labelAscii = new JLabel("ASCII:");
        labelDecimal = new JLabel("Decimal:");
        labelHex = new JLabel("Hexadecimal:");
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        labelAscii.setFont(new Font("Arial", Font.PLAIN, 30));
        labelDecimal.setFont(new Font("Arial", Font.PLAIN, 30));
        labelHex.setFont(new Font("Arial", Font.PLAIN, 30));
        inputTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        decimalResult.setFont(new Font("Arial", Font.PLAIN, 30));
        asciiResult.setFont(new Font("Arial", Font.PLAIN, 30));
        hexResult.setFont(new Font("Arial", Font.PLAIN, 30));
        convertButton.setFont(new Font("Arial", Font.PLAIN, 30));
        convertButton.addActionListener(this);
        
        inputTextField.setText("<Input binary number>");
        inputTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) { }
            
            @Override
            public void focusGained(FocusEvent e) {
                if( inputTextField.getText().contains("binary") ) {
                    inputTextField.setText("");
                }
            }
        });
        
        addObjectToPanel(inputTextField, 0, 0, 2);
        addObjectToPanel(convertButton, 1, 0, 2);
        addObjectToPanel(labelAscii, 2, 0, 1);
        addObjectToPanel(asciiResult, 2, 1, 1);
        addObjectToPanel(labelDecimal, 3, 0, 1);
        addObjectToPanel(decimalResult, 3, 1, 1);
        addObjectToPanel(labelHex, 4, 0, 1);
        addObjectToPanel(hexResult, 4, 1, 1);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 18. If convertButton was pressed...
        JButton buttonPressed = (JButton) e.getSource();
        if( buttonPressed == convertButton) {
            String binaryStr = inputTextField.getText();
            
            String asciiStr = binaryToAscii(binaryStr);
            String decimalStr = binaryToDec(binaryStr);
            String hexStr = binaryToHex(binaryStr);
            
            asciiResult.setText(asciiStr);
            decimalResult.setText(decimalStr);
            hexResult.setText(hexStr);
        }
    }

    private void addObjectToPanel(JComponent component, int row, int column, int cellWidth) {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;       // This expands the JComponent to fill gridwidth
        constraints.gridx = column;             // This is the column the JComponent is placed
        constraints.gridy = row;                // This is the row the JComponent is placed
        constraints.gridwidth = cellWidth;      // This is how many horizontal cells to span across
        constraints.gridheight = 1;             // This is how many vertical cells to span across
        this.panel.add(component, constraints);
    }
}
