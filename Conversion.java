/**
 * Contains method to convert string of digits to integer.
 *
 * @author Klentin Mollai
 * @version 9/23/2019
 */
import java.util.Scanner;

public class Conversion {
	
	/**
     * Launches the application
     * @param input asks for user's input and stores it 
     * Checks for user's sentinel value and throws exception
     * @param sum is stored total of added converted user's input
     */

	public static void main(String[] args) {
		System.out.println("Start conversion"); 
		String input; 
		int sum = 0;
		Scanner in = new Scanner(System.in);    
		try {
			do {
				
				System.out.println();  
				System.out.println("Enter digits or " + "[q]" + " to quit."); 
				input = in.next(); 
				
				// checks user's input if is 'q' or bigger than 8 it stops.
				if (input.charAt(0) == 'q' || input.length() > 8) 
					break;
				else {
					
					// Calls and displays function toInt with user's input passed to it.
					sum += toInt(input);
					System.out.println(toInt(input));
					
				}
			} while (true);
			System.out.println("End of conversion");  
		} catch (Exception e) {                     
			System.out.println("Input shoud be less than 8 digits."); 
			System.out.println("End of conversion");
		}
		System.out.println("Sum is: " + sum ); 
		  in.close();

	}
    /**
     * Takes a String value and returns asInt as integer. 
     * @param digit - String value is passed. 
     * @param x - Is stored integer value of last character.
     * @return x - Integer value after conversion.
     */

	private static int toInt(String digit) {
		if (digit.length() == 1) {
			return digit.charAt(0) - '0';
		} else {
			int asInt = digit.charAt(digit.length() - 1) - '0';
			return asInt + 10 * toInt(digit.substring(0, digit.length() - 1));
		}
	}

}
