package frontend;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Pen {
	
	private Color myLineColor;
	private double myLineWidth;
	private String myLineStyle;
	private boolean myIsPenDown;
	private final static Map<String, Double> LINE_STYLES = new HashMap<String, Double>()
			{{
				put("Dotted", 3d);
				put("Dashed", 10d);
				put("Solid", Double.MAX_VALUE);
			}};
	
	public Pen(){
		
		myLineStyle = "Dashed";
		myIsPenDown = true;
		myLineColor = Color.BLACK;
		myLineWidth = 1;
	}
	
	/**
	 * This draws a line between two points given.
	 * 
	 * @param p1 The Point2D object of the turtle (the starting point of the line).
	 * @param p2 The Point2D object of the ending point of the line.
	 */
	public void drawLine(Point2D p1, Point2D p2, Pane holder)
	{
		Line line = new Line();
		if(myIsPenDown){
			line = new Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
			line.setStroke(myLineColor);
			line.setStrokeWidth(myLineWidth);
			line.getStrokeDashArray().addAll(LINE_STYLES.get(myLineStyle));
		}
		holder.getChildren().add(line);
	}
	
	/**
	 * Set the pen color.
	 * @param c Color to be set.
	 */
	public void setLineColor(Color c)
	{
		myLineColor = c;
	}
	
	/**
	 * Set the pen width.
	 * @param width The width of the pen.
	 */
	public void setLineWidth(double width)
	{
		myLineWidth = width;
	}
	
	public void setLineStyle(String style){
		myLineStyle = style;
	}
	
	public void penUp(){
		myIsPenDown = false;
	}
	public void penDown(){
		myIsPenDown = true;
	}
	public boolean isPenDown(){
		return myIsPenDown; 
	}

}
