import java.util.Scanner;

import javafx.application.*;

public class Reversi {

	public static void main(String[] args) {
		System.out.print("1. Text-based game.\n2.GUI game.\nEnter choice: ");
		Scanner sc = new Scanner(System.in);
		int ch;
		
		do {
			ch = sc.nextInt();
		} while(ch != 1 && ch != 2);
		
		if(ch == 1) {
			reversiText.runGame();
		}
		else {
			Application.launch(reversiGUI.class, args);
		}
	}

}
