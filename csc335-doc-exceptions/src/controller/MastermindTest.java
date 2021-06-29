package controller;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.MastermindModel;

/**
 * This class collects all of the test methods for our controller.
 * 
 * In eclipse, running it should run it under JUnit. Running the Mastermind class (since
 * it is our main class) will actually run the program. If you're not using eclipse,
 * you'll need to run this under JUnit 5. 
 * 
 * @author Chris Lin
 *
 */
class MastermindTest {

	/**
	 * Test method for {@link MastermindController#isCorrect(java.lang.String)}.
	 * @throws MastermindIllegalColorException 
	 * @throws MastermindIllegalLengthException 
	 */
	@Test
	void testIsCorrect() throws MastermindIllegalLengthException, MastermindIllegalColorException {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return true
		assertTrue(controllerUnderTest.isCorrect("rrrr"));
		//For a properly working controller, this should be false
		assertFalse(controllerUnderTest.isCorrect("oooo"));
		
		//Make as many more assertions as you feel you need to test the MastermindController.isCorrect method
	}

	/**
	 * Test method for {@link MastermindController#getRightColorRightPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorRightPlace() {
		//Build a model with a known answer, using our special testing constructor
		MastermindModel answer = new MastermindModel("rrrr");
		//Build the controller from the model
		MastermindController controllerUnderTest = new MastermindController(answer);
		
		//For a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrrr"), 4);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 0);
		
		//You'll need lots more of these to convince yourself your implementation is right
	}

	/**
	 * Test method for {@link MastermindController#getRightColorWrongPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorWrongPlace() {
		MastermindModel ans = new MastermindModel("ropb");
		MastermindController contorllerTest = new MastermindController(ans);
		assertEquals(contorllerTest.getRightColorWrongPlace("orpb"), 2);
		assertEquals(contorllerTest.getRightColorWrongPlace("rrrr"), 0);
		assertEquals(contorllerTest.getRightColorWrongPlace("orpb"), 2);
		assertEquals(contorllerTest.getRightColorWrongPlace("orbp"), 4);
		
	}
	
	/**
	 * Test2 method for {@link MastermindController#getRightColorWrongPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorWrongPlace2() { 
		MastermindModel ans = new MastermindModel("ygrb");
		MastermindController controllerTest = new MastermindController(ans);
		assertEquals(controllerTest.getRightColorWrongPlace("rbyg"), 4);
		assertEquals(controllerTest.getRightColorWrongPlace("ygbr"), 2);
		assertEquals(controllerTest.getRightColorWrongPlace("yrbg"), 3);
		assertEquals(controllerTest.getRightColorWrongPlace("gbbb"), 1);
		
	}
	
	/**
	 * Test method for {@link MastermindIllegalLengthException(java.lang.String)}.
	 */
	@Test
	void testMastermindIllegalLengthException() {
		MastermindModel ans = new MastermindModel("rbyg");
		MastermindController controllerTest = new MastermindController(ans);
		WrapperForException testLength = new WrapperForException();
		assertThrows(MastermindIllegalLengthException.class,() -> {
			testLength.testExpection(controllerTest, "rbygg");
		});
		
	}
	/**
	 * Test method for {@link MastermindIllegalColorException(java.lang.String)}.
	 */
	@Test
	void testMastermindIllegalColorException() { 
		MastermindModel ans = new MastermindModel("rbyg");
		MastermindController controllerTest = new MastermindController(ans);
		WrapperForException testColor = new WrapperForException();
		assertThrows(MastermindIllegalColorException.class,() -> {
			testColor.testExpection(controllerTest, "rwro");
		});
		
	}


}
