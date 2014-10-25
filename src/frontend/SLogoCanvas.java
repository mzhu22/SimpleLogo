/**
 * This class represents the field where the turtle can be and where the lines are drawn.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */

package frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SLogoCanvas extends Canvas {

	private Pane myHolder;
	private GridPane myGrid;
	private Rectangle myBackground;

	private static final int SPACE_BETWEEN_GRID_LINES = 10;
	/**
	 * Constructor. 
	 * 
	 * @param width The width of the drawing area.
	 * @param height The height of the drawing area.
	 * @param x The x-Coordinate of the drawing area.
	 * @param y The y-Coordinate of the drawing area.
	 */
	public SLogoCanvas(double width, double height, double x, double y) {
		// TODO Auto-generated constructor stub
		super(width, height);

		myHolder = new Pane();
		myHolder.setLayoutX(x);
		myHolder.setLayoutY(y);
		myHolder.setPrefHeight(height);
		myHolder.setPrefWidth(width);
		
		
		myGrid = new GridPane();
		myGrid.setPrefHeight(height);
		myGrid.setPrefWidth(width);
		
		
		for(int i = 0; i < width/SPACE_BETWEEN_GRID_LINES; i++){
			myGrid.getColumnConstraints().add(new ColumnConstraints(SPACE_BETWEEN_GRID_LINES));			
		}
		for(int i = 0; i < height/SPACE_BETWEEN_GRID_LINES; i++){
			myGrid.getRowConstraints().add(new RowConstraints(SPACE_BETWEEN_GRID_LINES));			
		}
		
		
		myGrid.setGridLinesVisible(false);
		
		myBackground = new Rectangle(0,0,width, height);
		
		myBackground.setFill(Color.WHITE);
		
		myHolder.getChildren().add(myBackground);
		myHolder.getChildren().add(this);
		myHolder.getChildren().add(myGrid);
	
	}
	
	public void changeBackground(Color c){
		myBackground.setFill(c);
	}
	
	public Pane getHolder()
	{
		return myHolder;
	}
	
	public void toggleGridLines(){
		this.myGrid.setGridLinesVisible(!this.myGrid.isGridLinesVisible());
	}
}
