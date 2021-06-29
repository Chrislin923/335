import java.util.Scanner;

import controller.MastermindController;
import model.MastermindModel;

/**
 * 
 * @author Chris Lin
 *
 */
public class Mastermind {

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
		while(option.equals("yes")) {
			//This is the loop for the playing the game, continue to play multiple times if
			//the user say yes
			i=0;
			m = new MastermindModel();
			controller = new MastermindController(m);
			while(i < 10) {
				//This loop gives the user 10 guesses 
				System.out.print("\nEnter guess number " + (i + 1) + ": ");
				guess = userIn.next();
				if(controller.isCorrect(guess)) {
					//If all guesses are correct
					win = true;
					System.out.println("You win the game!");
					System.out.print("Would you like to play again?");
					option = userIn.next();
					break;
				}
				System.out.println("Color in the correct place: " + controller.getRightColorRightPlace(guess));
				System.out.println("Color correct but in the wrong position: " + controller.getRightColorWrongPlace(guess));
				System.out.println();
				i++;
			}
			if(win) {
				//Continue if the user win the game
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
