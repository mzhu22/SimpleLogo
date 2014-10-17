/**
 * This class represents the field where the turtle can be and where the lines are drawn.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */

package frontend;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class SLogoCanvas extends Canvas {

	private Pane myHolder;
	private GridPane myGrid;
	private Rectangle myBackground;
	
	private Color myLineColor;
	private double myLineWidth;
	private String myLineStyle;
	private final static Map<String, Double> LINE_STYLES = new HashMap<String, Double>();

	
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
		
		LINE_STYLES.put("Dotted", 3d);
		LINE_STYLES.put("Dashed", 10d);
		LINE_STYLES.put("Solid", Double.MAX_VALUE);
		
		myLineStyle = "Dashed";
		
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
		
		myLineColor = Color.BLACK;
		myLineWidth = 1;
		
		myBackground = new Rectangle(0,0,width, height);
		myBackground.setFill(Color.WHITE);
		
		myHolder.getChildren().add(myBackground);
		myHolder.getChildren().add(this);
		myHolder.getChildren().add(myGrid);
	
	}
	
	public void changeBackground(Color c){
		myBackground.setFill(c);
	}

	/**
	 * This draws a line between two points given.
	 * 
	 * @param p1 The Point2D object of the turtle (the starting point of the line).
	 * @param p2 The Point2D object of the ending point of the line.
	 */
	public void drawLine(Point2D p1, Point2D p2)
	{
		Line line = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		line.setStroke(myLineColor);
		line.setStrokeWidth(myLineWidth);
		line.getStrokeDashArray().addAll(LINE_STYLES.get(myLineStyle));
		myHolder.getChildren().add(line);
		
		//this.getGraphicsContext2D().strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	
	public Pane getHolder()
	{
		return myHolder;
	}
	
	/**
	 * Set the pen color.
	 * @param c Color to be set.
	 */
	public void setLineColor(Color c)
	{
		myLineColor = c;
		//this.getGraphicsContext2D().setStroke(c);
	}
	
	/**
	 * Set the pen width.
	 * @param width The width of the pen.
	 */
	public void setLineWidth(double width)
	{
		myLineWidth = width;
		//this.getGraphicsContext2D().setLineWidth(width);
	}
	
	public void setLineStyle(String style){
		myLineStyle = style;
	}
	
	public void toggleGridLines(){
		this.myGrid.setGridLinesVisible(!this.myGrid.isGridLinesVisible());
	}
}
