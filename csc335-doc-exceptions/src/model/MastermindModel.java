package model;

import java.util.Random;

/**
 * 
 * @author Chris Lin
 *
 * This class generate the answer of the game and have methods to 
 * switch the color back and forth from integer to color.
 * 
 */

public class MastermindModel {
	//private variable(s) to store the answer
	private int[] ans;

	/**
	 * This method generate a random answer for the game
	 */
    public MastermindModel() { 
    	// generate a random answer
    	ans = new int[4];
    	Random random = new Random();
    	for(int i = 0; i < 4; i++ ) {
    		ans[i] = random.nextInt(5) + 1;
    	}

    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	// generate a specific answer for the game
    	ans = new int[4];
    	for(int i=0; i < 4; i++) {
    		ans[i] = colorToInt(answer.charAt(i));
    	}

    }


    /**
     * This method return the color that the user asked for at the specific index
     * 
     * @param index an integer representing the location of the color
     * @return the color at the index user asking for
     */
    public char getColorAt(int index) {
          /* Return color at position index as a char
           (first converted if stored as a number) */
    	return intToColor(ans[index]);
    }
    

    
    /**
     * Convert integer representation of color to character representation of color
     * @param choice the integer representation of color
     * @return return character representation of color 
     */
    private char intToColor(int choice) {
    	/*
    	 * Change integer represent color to character representation
    	 */
    	if(choice == 1) 
    		return 'r';
    	if(choice == 2)
    		return 'o';
    	if(choice == 3)
    		return 'y';
    	if(choice == 4)
    		return 'g';
    	if(choice == 5)
    		return 'b';
    	else
    		return 'p';
    }
    
    /**
     * Convert character representation of color to integer representation of color
     * @param choice the character representation of color
     * @return return integer representation of color 
     */
    private int colorToInt(char choice) {
    	/*
    	 * Change character represent color to Integer representation
    	 */
    	if(choice == 'r') 
    		return 1;
    	if(choice == 'o')
    		return 2;
    	if(choice == 'y')
    		return 3;
    	if(choice == 'g')
    		return 4;
    	if(choice == 'b')
    		return 5;
    	else
    		return 6;
    }

}
