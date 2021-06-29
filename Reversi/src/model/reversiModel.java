package model;

/**
 * 
 * @author Chris Lin, Sarthak Bawal
 *
 * This is the model of the game Reversi, contains the grid and the information
 * needed for the game
 * 
 * 
 */


 
public class reversiModel {
	
	private int[][] grid;
	
	public reversiModel() {
		grid = new int[8][8];
		for(int i = 0; i < 8 ; i++) {
			for(int j =0; j< 8; j++) {
				grid[i][j]= 0;
			}
		}
		
		//initialize original grid 1 is white 2 is black
		grid[3][3] = 1;
		grid[3][4] = 2;
		grid[4][3] = 2;
		grid[4][4] = 1;
		
	}
	
	/**
	 * Get the information of the specifying location
	 * 
	 * @param row an integer, the row on the grid
	 * @param col an integer, the column on the grid
	 * @return an integer representing the place contains black white or nothing.
	 */
	public int getGrid(int row, int col) {
		
		return grid[row][col];
	}
	
	
	/**
	 * set the grid position to white
	 * 
	 * @param row an integer, the row on the grid
	 * @param col an integer, the column on the grid
	 */
	public void setPosWhite(int row, int col) {
		grid[row][col] = 1;
	}
	
	public void setPosBlack(int row, int col) {
		grid[row][col] = 2;
	}
	
	
	/**
	 * set the grid position to black
	 * 
	 * @param row an integer, the row on the grid
	 * @param col an integer, the column on the grid
	 */
	public String getPosStatus(int row, int col) {
		if(grid[row][col] == 0) {
			return "null";
		}
		if(grid[row][col] == 1) {
			return "white";
		}

		return "black";
	}
	
	/**
	 * Check if the positon is empty
	 * 
	 * @param row an integer, the row on the grid
	 * @param col an integer, the column on the grid
	 */
	
	public boolean isEmpty(int row, int col) {
		if(grid[row][col] == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * return player1 score
	 * 
	 * 
	 */
	public int player1Score() {
		return getCount(1);
	}
	
	/**
	 * return player2 score
	 * 
	 * 
	 */
	public int player2Score() {
		return getCount(2);
	}
	
	/**
	 * get the count of the specifying type
	 * 
	 * @param type an integer represent the type
	 * 
	 * @return the amount of that type
	 */
	private int getCount(int type) {
		int cnt = 0;
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(grid[i][j] == type) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
}
