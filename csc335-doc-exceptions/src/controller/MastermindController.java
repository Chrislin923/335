package controller;
import model.MastermindModel;

/**
 * 
 * @author Chris Lin
 *
 * This class uses the MastermindModel to check the color answer and the 
 * guesses user input.
 * 
 * 
 */
public class MastermindController {
	

	//RCRP is the count for right color right place
	//RCWP is the count for right color wrong place
	//checkG is check list for guess
	//checkA is check list for answer
	private MastermindModel m;
	private int RCRP;
	private int RCWP;
	private int[] checkG;
	private int[] checkA;
	
	/**
	 * initialize check list and model
	 * @param   model the MastermindModel class
	 * 
	 */
	
	public MastermindController(MastermindModel model) {
		m = model;
		checkG = new int[4];
		checkA = new int[4];
	}
 
	/**
	 * Check if the guess and the answer are equal to each other. Also checks
	 * for Illegal Length Exception and Illegal Color Exception which are the 
	 * two classes I created handling the exceptions
	 * 
	 * @param guess  the guess user input
	 * @return	true or false
	 * @throws MastermindIllegalLengthException
	 * @throws MastermindIllegalColorException
	 */

    public boolean isCorrect(String guess) throws MastermindIllegalLengthException, MastermindIllegalColorException {
    	//check if guess and answer equal to each other
    	checkLength(guess);
    	checkColor(guess);
		
    	for(int i= 0; i < 4; i++) {
    		if (m.getColorAt(i) != guess.charAt(i))
    			return false;
    	}
    	return true; 
    }
    
    /**
     * This method counts the right color being guess in the right place
     * 
     * @param the guess user input of guess colors
     * @return RCRP the counts of right color in the right place
     */


    public int getRightColorRightPlace(String guess) { 
    	//count the guess of right color right place
    	RCRP = 0;
    	checkSet(checkG);
    	checkSet(checkA);
    	for(int i= 0; i < 4; i++) {
    		if (m.getColorAt(i) == guess.charAt(i)) {
    			checkG[i] = 0;
    			checkA[i] = 0;
    			RCRP++;
    		}
    	}
    	return RCRP;
    }
    
    /**
     * This method counts the right color being guess in the wrong place
     * 
     * @param guess  the guess user input of guess colors
     * @return RCWP  the counts of right color in the wrong place
     */


    public int getRightColorWrongPlace(String guess) {
    	//count the guess of right color wrong place
    	RCWP = 0;
    	getRightColorRightPlace(guess);
    	for(int i= 0; i < 4; i++) {
    		//making sure we don't recount the guess we have already count
    		if(checkG[i] == 0)
    			continue;
    		for(int j =0; j< 4; j++) {
    			if( guess.charAt(i) == m.getColorAt(j)
    					&& checkA[j] == 1) {
    				RCWP++;
    				checkA[j] = 0;
    				break;
    			}
    		}
    	}
    	return RCWP;
    }

    /**
     * A method to generate check list
     * 
     * 
     * @param arr the array of checklist to be generate, set all to 1.
     */
    private void checkSet(int[] arr) {
    	//A method to generate check list
    	for(int i = 0; i < 4; i++) {
    		arr[i] = 1;
    	}
    }
    
    /**
     * A method to throw illegal length exception when length is greater or shorter than 4.
     * 
     * @param userGuess the guess user input
     * @throws MastermindIllegalLengthException The exception we throw if the check doesn't pass
     */
    static void checkLength(String userGuess) throws MastermindIllegalLengthException {
	    if (userGuess.length() != 4) {
	      throw new MastermindIllegalLengthException(" Enter four colors per guess");
	    }
	  }
    
    /**
     * A method to throw illegal color exception when the color input is not one of the six
     * color we expected
     * 
     * @param userGuess  userGuess the guess user input
     * @throws MastermindIllegalColorException The exception we throw when an illegal color gets input
     */
	static void checkColor(String userGuess) throws MastermindIllegalColorException {
		boolean check;
		char[] validColor = {'r', 'o', 'y', 'g', 'b', 'p'};
		//a double for loop to check whether the input color is a valid color
		for (int i = 0; i < 4; i++) {
			check = false;
			for(int j= 0; j <6; j++) {
				if(userGuess.charAt(i) == validColor[j]) {
					check = true;
				}
			}
			if(check != true)
				throw new MastermindIllegalColorException(" Enter only r, o, y, g, b, or p");
		}
	  }


}
