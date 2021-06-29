package controller;

import model.reversiModel;

/**
 * 
 * @author Chris Lin, Sarthak Bawal
 *
 * The controller for the game Reversi
 * 
 * 
 */

public class reversiController {
	private reversiModel m;
	
	
	/**
	 * Initialize the model
	 * @param m
	 * 
	 */
	public reversiController(reversiModel m) {
		this.m = m;
	}
	
	/**
	 * 
	 * Check if the user has won
	 * @return if the player wins
	 * 
	 */
	public boolean playerWon() {
		return m.player1Score() > m.player2Score();
	}
	
	/**
	 * get the whole playing grid
	 * 
	 * @return the gird
	 */
	
	public int[][] getBoard() {
		int[][] grid = new int[8][8];
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				grid[i][j] = m.getGrid(i, j);
			}
		}
		
		return grid;
	}
	
	/**
	 * 
	 * convert the object on grid from integer to character
	 * 
	 * @param type an integer represents the type of object on the grid
	 * @return an character representing the object
	 */
	private char convert(int type) {
		if(type == 0)
			return '_';
		else if(type == 1)
			return 'W';
		else if(type == 2)
			return 'B';
		return ' ';
	}
	
	/**
	 * print the whole game board
	 */
	public void printBoard() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(convert(m.getGrid(i, j)));
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("Score:");
		System.out.println("White: " + Integer.toString(m.player1Score()));
		System.out.println("Black: " + Integer.toString(m.player2Score()));
	}
	
	/**
	 * Check if the game has ended
	 * 
	 * @param piece an integer to check for next move
	 * @return boolean to check for more legal move
	 */
	public boolean gameOver(int piece) {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(checkLegalMove(i, j, piece)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * end the game 
	 * @return boolean, check if we should end the game
	 */
	
	public boolean endGame() {
		return gameOver(1) && gameOver(2);
	}
	
	public void playerTurn(int row, int col) {
		if(gameOver(1)) {
			return;
		}
		if(checkLegalMove(row, col, 1)) {
			m.setPosWhite(row, col);
			captureScore(row, col, 1, true);
		}
	}
	
	/**
	 * computer turn to move
	 * @return the move for computer
	 */
	public int[] computerTurn() {
		int[][] possibleMoves = new int[8][8];
		int maxScore = 0;
		int[] move = new int[2];
		
		move[0] = -1;
		move[1] = -1;
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(!checkLegalMove(i, j, 2)) {
					possibleMoves[i][j] = 0;
					continue;
				}
				possibleMoves[i][j] = captureScore(i, j, 2, false);
				if(possibleMoves[i][j] > maxScore) {
					maxScore = possibleMoves[i][j];
					move[0] = i;
					move[1] = j;
				}
			}
		}
		
		if(maxScore == 0) {
			System.out.println("No moves left!");
			return move;
		}

		m.setPosBlack(move[0], move[1]);
		captureScore(move[0], move[1], 2, true);
		
		return move;
	}
	
	/**
	 * capture the score of the game for both white and black
	 * 
	 * @param row
	 * @param col
	 * @param piece
	 * @param flip
	 * @return
	 */
	
	private int captureScore(int row, int col, int piece, boolean flip) {
		int score = 0;

		if(checkHL(row, col, piece)) {
			for(int i=col-1; i >= 0; i--) {
				if(m.getGrid(row, i) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(row, i);
					else
						m.setPosBlack(row, i);
				}
				score++;
			}
		}
		if(checkHR(row, col, piece)) {
			for(int i=col+1; i < 8; i++) {
				if(m.getGrid(row, i) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(row, i);
					else
						m.setPosBlack(row, i);
				}
				score++;
			}
		}
		
		if(checkVT(row, col, piece)) {
			for(int i=row-1; i >= 0; i--) {
				if(m.getGrid(i, col) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(i, col);
					else
						m.setPosBlack(i, col);
				}
				score++;
			}
		}
		if(checkVB(row, col, piece)) {
			for(int i=row+1; i < 8; i++) {
				if(m.getGrid(i, col) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(i, col);
					else
						m.setPosBlack(i, col);
				}
				score++;
			}
		}
		int i, j;
		if(checkDiagonalTL(row, col, piece)) {
			i = row - 1;
			j = col - 1;
			while(i >= 0 && j >= 0) {
				if(m.getGrid(i, j) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(i, j);
					else
						m.setPosBlack(i, j);
				}
				score++;
				i--;
				j--;
			}
		}
		if(checkDiagonalTR(row, col, piece)) {
			i = row - 1;
			j = col + 1;
			while(i >= 0 && j < 8) {
				if(m.getGrid(i, j) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(i, j);
					else
						m.setPosBlack(i, j);
				}
				score++;
				i--;
				j++;
			}
		}
		if(checkDiagonalBR(row, col, piece)) {
			i = row + 1;
			j = col + 1;
			while(i < 8 && j < 8) {
				if(m.getGrid(i, j) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(i, j);
					else
						m.setPosBlack(i, j);
				}
				score++;
				i++;
				j++;
			}
		}
		if(checkDiagonalBL(row, col, piece)) {
			i = row + 1;
			j = col - 1;
			while(i < 8 && j >= 0) {
				if(m.getGrid(i, j) == piece) {
					break;
				}
				if(flip)
				{
					if(piece == 1)
						m.setPosWhite(i, j);
					else
						m.setPosBlack(i, j);
				}
				score++;
				i++;
				j--;
			}
		}

		return score;
	}
	
	public boolean checkLegalMove(int row, int col, int piece) {
		if(m.getGrid(row, col) != 0)
			return false;
		return checkHL(row, col, piece) || checkHR(row, col, piece) || 
				checkVT(row, col, piece) || checkVB(row, col, piece) || 
				checkDiagonalTL(row, col, piece) || checkDiagonalTR(row, col, piece) ||
				checkDiagonalBL(row, col, piece) || checkDiagonalBR(row, col, piece);
	}
	
	private boolean checkHR(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		if(col + 2 < 8)
		{
			if(m.getGrid(row, col + 1) == otherPiece) {
				for(int i=col + 2; i < 8; i++) {
					if(m.getGrid(row, i) == 0) {
						break;
					}
					
					if(m.getGrid(row, i) == piece) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean checkHL(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		if(col > 1)
		{
			if(m.getGrid(row, col - 1) == otherPiece) {
				for(int i=col - 2; i >= 0; i--) {
					if(m.getGrid(row, i) == 0) {
						break;
					}
					
					if(m.getGrid(row, i) == piece) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean checkVB(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		if(row + 2 < 8)
		{
			if(m.getGrid(row + 1, col) == otherPiece) {
				for(int i=row + 2; i < 8; i++) {
					if(m.getGrid(i, col) == 0) {
						break;
					}
					
					if(m.getGrid(i, col) == piece) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean checkVT(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		if(row > 1)
		{
			if(m.getGrid(row - 1, col) == otherPiece) {
				for(int i=row - 2; i >= 0; i--) {
					if(m.getGrid(i, col) == 0) {
						break;
					}
					
					if(m.getGrid(i, col) == piece) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	private boolean checkDiagonalBR(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		int i, j;
		if(row + 2 < 8 && col + 2 < 8)
		{
			if(m.getGrid(row + 1, col + 1) == otherPiece) {
				i = row + 2;
				j = col + 2;
				while(i < 8 && j < 8) {
					if(m.getGrid(i, j) == 0) {
						break;
					}
					
					if(m.getGrid(i, j) == piece) {
						return true;
					}
					
					i++;
					j++;
				}
			}
		}
		
		return false;
	}

	private boolean checkDiagonalTL(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		int i, j;
		if(row > 1 && col > 1)
		{
			if(m.getGrid(row - 1, col - 1) == otherPiece) {
				i = row - 2;
				j = col - 2;
				while(i >= 0 && j >= 0) {
					if(m.getGrid(i, j) == 0) {
						break;
					}
					
					if(m.getGrid(i, j) == piece) {
						return true;
					}
					
					i--;
					j--;
				}
			}
		}
		
		return false;
	}

	private boolean checkDiagonalTR(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		int i, j;
		if(row > 1 && col + 2 < 8)
		{
			if(m.getGrid(row - 1, col + 1) == otherPiece) {
				i = row - 2;
				j = col + 2;
				while(i >= 0 && j < 8) {
					if(m.getGrid(i, j) == 0) {
						break;
					}
					
					if(m.getGrid(i, j) == piece) {
						return true;
					}
					
					i--;
					j++;
				}
			}
		}
		
		return false;
	}

	private boolean checkDiagonalBL(int row, int col, int piece) {
		int otherPiece;
		
		if(piece == 1)
			otherPiece = 2;
		else
			otherPiece = 1;
		
		int i, j;
		if(row + 2 < 8 && col > 1)
		{
			if(m.getGrid(row + 1, col - 1) == otherPiece) {
				i = row + 2;
				j = col - 2;
				while(i < 8 && j >= 0) {
					if(m.getGrid(i, j) == 0) {
						break;
					}
					
					if(m.getGrid(i, j) == piece) {
						return true;
					}
					
					i++;
					j--;
				}
			}
		}
		
		return false;
	}
}