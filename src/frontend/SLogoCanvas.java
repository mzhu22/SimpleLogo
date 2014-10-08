/**
 * This class represents the field where the turtle can be and where the lines are drawn.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */

package frontend;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SLogoCanvas extends Canvas {

	private StackPane myHolder;
	
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
		this.setLayoutX(x);
		this.setLayoutY(y);
		
		myHolder = new StackPane();
		myHolder.setLayoutX(x);
		myHolder.setLayoutY(y);
		myHolder.setPrefHeight(height);
		myHolder.setPrefWidth(width);
		myHolder.getChildren().add(this);
	
	}

	/**
	 * This draws a line between two points given.
	 * 
	 * @param p1 The Point2D object of the turtle (the starting point of the line).
	 * @param p2 The Point2D object of the ending point of the line.
	 */
	public void drawLine(Point2D p1, Point2D p2)
	{
		this.getGraphicsContext2D().strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}
	
	public StackPane getHolder()
	{
		return myHolder;
	}
	
	/**
	 * Set the pen color.
	 * @param c Color to be set.
	 */
	public void setLineColor(Color c)
	{
		this.getGraphicsContext2D().setStroke(c);
	}
	
	/**
	 * Set the pen width.
	 * @param width The width of the pen.
	 */
	public void setLineWidth(double width)
	{
		this.getGraphicsContext2D().setLineWidth(width);
	}
}
