import java.util.Scanner;

import controller.reversiController;
import model.reversiModel;

public class reversiText {
	
	public static void runGame() {
		reversiModel m = new reversiModel();
		reversiController c = new reversiController(m);
		
		c.printBoard();
		
		while(!c.endGame()) {
			c.printBoard();
			System.out.print("Enter location to place piece (0-7): ");
			Scanner in = new Scanner(System.in);
			int row, col;
			
			do {
				row = in.nextInt();
				col = in.nextInt();
			} while(!c.checkLegalMove(row, col, 1));
			
			c.playerTurn(row, col);
			
			if(c.endGame()) {
				break;
			}
			
			if(c.gameOver(2)) {
				continue;
			}
			
			do {
				c.computerTurn();
			} while(c.gameOver(1));
			
			if(c.endGame()) {
				break;
			}
		}
		
		if(c.playerWon()) {
			System.out.println("You won!");
		}
		else {
			System.out.println("You lost!");
		}
	}
}
