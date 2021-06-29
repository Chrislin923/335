package controller;

/**
 * 
 * @author chrislin
 *
 *This class is a wrapper for exception to make two parameters same type in the assertThrow
 *
 */
public class WrapperForException {
	public void testExpection(MastermindController c, String guess) 
			throws MastermindIllegalLengthException, MastermindIllegalColorException{
		c.isCorrect(guess);
		
	}
}
