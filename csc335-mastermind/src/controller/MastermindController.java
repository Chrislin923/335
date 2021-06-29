package controller;
import model.MastermindModel;

/**
 * 
 * @author Chris Lin
 *
 */
public class MastermindController {
	
	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
	//RCRP is the count for right color right place
	//RCWP is the count for right color wrong place
	//checkG is check list for guess
	//checkA is check list for answer
	private MastermindModel m;
	private int RCRP;
	private int RCWP;
	private int[] checkG;
	private int[] checkA;
	
	public MastermindController(MastermindModel model) {
		//initialize check list and model
		m = model;
		checkG = new int[4];
		checkA = new int[4];
	}
 

    public boolean isCorrect(String guess) {
    	//check if guess and answer equal to each other
    	for(int i= 0; i < 4; i++) {
    		if (m.getColorAt(i) != guess.charAt(i))
    			return false;
    	}
    	return true; //Just something for now to make sure the code compiles
    }


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


    public int getRightColorWrongPlace(String guess) {
    	//count the guess of right color wrong place
    	RCWP = 0;
    	for(int i= 0; i < 4; i++) {
    		if(checkG[i] == 0)
    			//making sure we don't recount the guess we have already count
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

    // Create as many private methods as you like
    private void checkSet(int[] arr) {
    	//A method to generate check list
    	for(int i = 0; i < 4; i++) {
    		arr[i] = 1;
    	}
    }

}
