/**
 * 
 * @author Chris Lin, Sarthak Bawal
 *
 * This is the GUI for the game Reversi
 * 
 * 
 */

import controller.reversiController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.reversiModel;


/**
 * main for the view 
 * 
 * 
 */

public class reversiGUI extends Application{
	private reversiModel m = new reversiModel();
	private reversiController c = new reversiController(m);
	
	public void start(Stage stage) {
		stage.setTitle("Reversi");
		BorderPane window = new BorderPane();
		
		GridPane g = new GridPane();
		g.setPadding(new Insets(8,8,8,8) );
		
		VBox scoreBox = new VBox();
		scoreBox.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Text score = new Text();
		
		score.setText("White: " + m.player1Score() + " - Black: " + m.player2Score());
		
		scoreBox.getChildren().add(score);
		
		
		
		Circle circle;
		
		
		StackPane sp;
		
		for(int i =0; i<8 ; i ++) {
			for(int j = 0; j< 8; j++) {
				if(i == 3 && j == 3 ||
						(i ==4 && j ==4)) {
					circle = new Circle(0, 0, 20);
					circle.setFill(Color.WHITE);
				}
				else if(i == 4 && j == 3 ||
						(i ==3 && j ==4)) {
					circle = new Circle(0, 0, 20);
					circle.setFill(Color.BLACK);
				} 
				else {
					circle = new Circle(0, 0, 20);
					circle.setFill(Color.TRANSPARENT);
				}
				
				
				sp = new StackPane(circle);
				sp.setMargin(circle, new Insets(2,2,2,2));
				g.add(sp, i, j);
				
			}
		}
		
		
		
		
		EventHandler<MouseEvent> playerMove = new EventHandler<MouseEvent>() {
			Circle cir;
			StackPane spane;
			int[][] grid;
			public void handle (MouseEvent e) {
				double x = e.getX();
				double y = e.getY();
				int row = (int) (x /45);
				int col = (int) (y /45);
				
				if(!(row >= 0 && row < 8 && col >= 0 && col < 8)) {
					return;
				}
				
				if(c.checkLegalMove(row, col, 1)) {
					addCircle(row, col, Color.WHITE);
					c.playerTurn(row, col);
					updateScore();
					grid = c.getBoard();
					updateGrid(grid);
					
					if(c.endGame()) {
						if(c.playerWon()) {
							displayMessage("You won!");
						}
						else {
							displayMessage("You lost!");
						}
						
						return;
					}
					
					if(c.gameOver(2)) {
						return;
					}
					
					do {
						int[] move = c.computerTurn();
						updateScore();
						addCircle(move[0], move[1], Color.BLACK);
						grid = c.getBoard();
						updateGrid(grid);
						
						if(c.endGame()) {
							if(c.playerWon()) {
								displayMessage("You won!");
							}
							else {
								displayMessage("You lost!");
							}
							
							return;
						}
					} while(c.gameOver(1));
					
				}
				
				
			}
			
			public void updateScore() {
				score.setText("White: " + m.player1Score() + " - Black: " + m.player2Score());
			}
			
			public void updateGrid(int[][] grid) {
				for(int i=0; i<8; i++) {
					for(int j=0; j<8; j++) {
						if(grid[i][j] == 0) {
							addCircle(i, j, Color.DARKGREEN);
						}
						else if(grid[i][j] == 1) {
							addCircle(i, j, Color.WHITE);
						}
						else if(grid[i][j] == 2) {
							addCircle(i, j, Color.BLACK);
						}
					}
				}
			}
			
			public void addCircle(int i, int j, Paint color) {
				cir = new Circle(0, 0, 20);
				cir.setFill(color);
				spane = new StackPane(cir);
				spane.setMargin(cir, new Insets(2, 2, 2, 2));
				g.add(spane, i, j);
			}
			
			public void displayMessage(String message) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText(message);
				alert.showAndWait();
				stage.close();
			}
		};

		
		
		g.setGridLinesVisible(true);
		
		window.setCenter(g);
		
		window.setBottom(scoreBox);
		
		
		Scene scene = new Scene(window, 370, 390, Color.DARKGREEN);
		scene.addEventFilter(MouseEvent.MOUSE_CLICKED, playerMove);
		
		stage.setScene(scene);
		stage.show();
	}
	
	
}