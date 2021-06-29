

import controller.MastermindController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.MastermindModel;


 

public class MastermindGUIView extends Application {
	private MastermindModel m = new MastermindModel();
	private MastermindController controller = new MastermindController(m);
	private Button button_guess = new Button("Guess");
	private VBox vbox = new VBox();
	private GridPane bGpane = new GridPane();
	private int count1 =0;
	private int count2 = 0;
	private int count3 = 0;
	private int count4 =0 ;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	public void start(Stage stage) {
		stage.setTitle("Mastermind");
		BorderPane window = new BorderPane();
		
		Canvas c1 = new Canvas(80, 80);
		Canvas c2 = new Canvas(80, 80);
		Canvas c3 = new Canvas(80, 80);
		Canvas c4 = new Canvas(80, 80);
		Canvas bg = new Canvas(400, 530);
		
		
		GraphicsContext gcBg = bg.getGraphicsContext2D();
		gcBg.setFill(Color.TAN);
		gcBg.fillRect(0,0,bg.getWidth(),bg.getHeight());
		
		GraphicsContext gc1 = c1.getGraphicsContext2D();
		gc1.setFill(Color.BLACK);
		gc1.fillOval(20,20,40,40);
		GraphicsContext gc2 = c2.getGraphicsContext2D();
		gc2.setFill(Color.BLACK);
		gc2.fillOval(20,20,40,40);
		GraphicsContext gc3 = c3.getGraphicsContext2D();
		gc3.setFill(Color.BLACK);
		gc3.fillOval(20,20,40,40);
		GraphicsContext gc4 = c4.getGraphicsContext2D();
		gc4.setFill(Color.BLACK);
		gc4.fillOval(20,20,40,40);
		
		bGpane.add(c1, 1, 0);
		bGpane.add(c2, 2, 0);
		bGpane.add(c3, 3, 0);
		bGpane.add(c4, 4, 0);
		bGpane.add(button_guess, 5, 0);
		
		
		
		

		
		
		


		
		EventHandler<MouseEvent> handler1 = new EventHandler<MouseEvent>() {
			public void handle (MouseEvent e) {
				if(count1 == 6) {
					gc1.setFill(Color.RED);
					gc1.fillOval(20,20,40,40);
					count1 = 1;
				}
				if(count1 ==0 ) {
					gc1.setFill(Color.RED);
					gc1.fillOval(20,20,40,40);
					count1++;
				}
				else if(count1 == 1) {
					gc1.setFill(Color.ORANGE);
					gc1.fillOval(20,20,40,40);
					count1++;
				}
				else if(count1 == 2) {
					gc1.setFill(Color.YELLOW);
					gc1.fillOval(20,20,40,40);
					count1++;
				}
				else if(count1 == 3) {
					gc1.setFill(Color.GREEN);
					gc1.fillOval(20,20,40,40);
					count1++;
				}
				else if(count1 == 4) {
					gc1.setFill(Color.BLUE);
					gc1.fillOval(20,20,40,40);
					count1++;
				}
				else if(count1 == 5) {
					gc1.setFill(Color.PURPLE);
					gc1.fillOval(20,20,40,40);
					count1++;
				}
				
			}
		};
		
		c1.addEventFilter(MouseEvent.MOUSE_CLICKED, handler1);
		
		EventHandler<MouseEvent> handler2 = new EventHandler<MouseEvent>() {
			public void handle (MouseEvent e) {
				if(count2 == 6) {
					gc2.setFill(Color.RED);
					gc2.fillOval(20,20,40,40);
					count2 = 1;
				}
				if(count2 ==0 ) {
					gc2.setFill(Color.RED);
					gc2.fillOval(20,20,40,40);
					count2++;
				}
				else if(count2 == 1) {
					gc2.setFill(Color.ORANGE);
					gc2.fillOval(20,20,40,40);
					count2++;
				}
				else if(count2 == 2) {
					gc2.setFill(Color.YELLOW);
					gc2.fillOval(20,20,40,40);
					count2++;
				}
				else if(count2 == 3) {
					gc2.setFill(Color.GREEN);
					gc2.fillOval(20,20,40,40);
					count2++;
				}
				else if(count2 == 4) {
					gc2.setFill(Color.BLUE);
					gc2.fillOval(20,20,40,40);
					count2++;
				}
				else if(count2 == 5) {
					gc2.setFill(Color.PURPLE);
					gc2.fillOval(20,20,40,40);
					count2++;
				}

				
			}
		};
		
		c2.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);
		
		EventHandler<MouseEvent> handler3 = new EventHandler<MouseEvent>() {
			public void handle (MouseEvent e) {
				if(count3 == 6) {
					gc3.setFill(Color.RED);
					gc3.fillOval(20,20,40,40);
					count3 = 1;
				}
				if(count3 ==0 ) {
					gc3.setFill(Color.RED);
					gc3.fillOval(20,20,40,40);
					count3++;
				}
				else if(count3 == 1) {
					gc3.setFill(Color.ORANGE);
					gc3.fillOval(20,20,40,40);
					count3++;
				}
				else if(count3 == 2) {
					gc3.setFill(Color.YELLOW);
					gc3.fillOval(20,20,40,40);
					count3++;
				}
				else if(count3 == 3) {
					gc3.setFill(Color.GREEN);
					gc3.fillOval(20,20,40,40);
					count3++;
				}
				else if(count3 == 4) {
					gc3.setFill(Color.BLUE);
					gc3.fillOval(20,20,40,40);
					count3++;
				}
				else if(count3 == 5) {
					gc3.setFill(Color.PURPLE);
					gc3.fillOval(20,20,40,40);
					count3++;
				}

				
			}
		};
		c3.addEventFilter(MouseEvent.MOUSE_CLICKED, handler3);
		
		EventHandler<MouseEvent> handler4 = new EventHandler<MouseEvent>() {
			public void handle (MouseEvent e) {
				if(count4 == 6) {
					gc4.setFill(Color.RED);
					gc4.fillOval(20,20,40,40);
					count4 = 1;
				}
				else if(count4 ==0 ) {
					gc4.setFill(Color.RED);
					gc4.fillOval(20,20,40,40);
					count4++;
				}
				else if(count4 == 1) {
					gc4.setFill(Color.ORANGE);
					gc4.fillOval(20,20,40,40);
					count4++;
				}
				else if(count4 == 2) {
					gc4.setFill(Color.YELLOW);
					gc4.fillOval(20,20,40,40);
					count4++;
				}
				else if(count4 == 3) {
					gc4.setFill(Color.GREEN);
					gc4.fillOval(20,20,40,40);
					count4++;
				}
				else if(count4 == 4) {
					gc4.setFill(Color.BLUE);
					gc4.fillOval(20,20,40,40);
					count4++;
				}
				else if(count4 == 5) {
					gc4.setFill(Color.PURPLE);
					gc4.fillOval(20,20,40,40);
					count4++;
				}

				
			}
		};
		c4.addEventFilter(MouseEvent.MOUSE_CLICKED, handler4);
		
		EventHandler<ActionEvent> g_handler = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e) {
				GridPane color_g = new GridPane();

				Text t = new Text(20, color_g.getHeight()/1.8 ,"1" );
				t.setFont(Font.font("Serif", FontWeight.NORMAL, FontPosture.REGULAR, 20));
				color_g.addColumn(1, t);
				color_g.add(c1, 2, 0);
				color_g.add(c2, 3, 0);
				color_g.add(c3, 4, 0);
				color_g.add(c4, 5, 0);
				vbox.getChildren().add(color_g);
				
			}
		};
		
		button_guess.setOnAction(g_handler);
		
		
		window.setBottom(bGpane);
		window.setCenter(vbox);
		
		Scene scene = new Scene(window, 400, 600);
		stage.setScene(scene);
		stage.show();
		
	}
	

	


			

}
