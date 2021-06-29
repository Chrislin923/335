import java.util.Scanner;

import controller.MastermindController;
import controller.MastermindIllegalColorException;
import controller.MastermindIllegalLengthException;
import model.MastermindModel;

/**
 * 
 * @author Chris Lin
 *
 *This class is the main class to play the game of Mastermind
 *
 */
public class MastermindTextView {
	

	/**
	 * main is where the game runs
	 * @param args
	 */
	public static void main(String[] args) {
		// This class represents the view, it should be how uses play the game
		MastermindModel m = null;
		MastermindController controller = null;
		int i = 0;
		Scanner userIn = new Scanner(System.in);
		System.out.println("Welcome to Mastermind!");
		System.out.print("Would you like to play? ");
		String option = userIn.next();
		String guess ="";
		Boolean win = false;
		//This is the loop for the playing the game, continue to play multiple times if
		//the user say yes
		while(option.equals("yes")) {
			i=0;
			m = new MastermindModel();
			controller = new MastermindController(m);
			//This loop gives the user 10 guesses 
			while(i < 10) {
				System.out.print("\nEnter guess number " + (i + 1) + ": ");
				guess = userIn.next();
				//this while loop continue to check the user input for excpetions
				while(true) {
					try {
						if(controller.isCorrect(guess)) {
							win = true;
							System.out.println("You win the game!");
							System.out.print("Would you like to play again?");
						}
						break;
					} catch (MastermindIllegalLengthException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("\nPlease try again:");
						guess = userIn.next();
					} catch (MastermindIllegalColorException e2) {
						e2.printStackTrace();
						System.out.println("\nPlease try again:");
						guess = userIn.next();
					}
				}
				
				//If all guesses are correct
				if(win) {
					option = userIn.next();
					break;
				}
				System.out.println("Color in the correct place: " + controller.getRightColorRightPlace(guess));
				System.out.println("Color correct but in the wrong position: " + controller.getRightColorWrongPlace(guess));
				System.out.println();
				i++;
			}
			//Continue if the user win the game
			if(win) {
				win = false;
				continue;
			}
			System.out.println("You lose the game!");
			System.out.print("Would you like to play again?");
			option = userIn.next();
		}
		userIn.close();
		System.out.println("Game Over!");
		System.exit(0);
		

	}
	
	

}
