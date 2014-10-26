package frontend;

import static frontend.GUIMaker.EPU;

import java.util.HashMap;
import java.util.Map;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * This class represents a pen which contains information
 * about the color, style, and width and has the ability
 * to directly draw on a canvas.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class Pen {
	
	private Color myLineColor;
	private double myLineWidth;
	private String myLineStyle;
	private boolean myIsPenDown;
	private final static Map<String, Double> LINE_STYLES = new HashMap<String, Double>()
			{
				//for serialization
				private static final long serialVersionUID = 1L;

			{
				put("Dotted", 3d);
				put("Dashed", 10d);
				put("Solid", Double.MAX_VALUE);
			}};
	
	public static final Color DEFAULT_LINE_COLOR = Color.BLACK;
	public static final double DEFAULT_LINE_WIDTH = 1;
	public static final String DEFAULT_LINE_STYLE = "Solid";		
			
			
	/**
	 * Constructor.
	 * 
	 * @param initColor The initial color of the pen.
	 * @param initWidth The initial width of the pen.
	 * @param initIsDown The initial value of whether the pen is down.
	 * @param initStyle The initial style value of the pen.
	 */
	public Pen(Color initColor, double initWidth, boolean initIsDown, String initStyle){
	
		myIsPenDown = initIsDown;
		myLineColor = initColor;
		myLineWidth = initWidth;
		
		if(LINE_STYLES.containsKey(initStyle)){
			myLineStyle = initStyle;
		}
		else{
			EPU.display("Entered invalid line style. Defaulted to " + DEFAULT_LINE_STYLE + ".", false);
			myLineStyle = DEFAULT_LINE_STYLE;
		}
	}
	
	/**
	 * Constructor.
	 * 
	 * Default pen constructor.
	 * 
	 */
	public Pen()
	{
		this(DEFAULT_LINE_COLOR, DEFAULT_LINE_WIDTH, true, DEFAULT_LINE_STYLE);
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
	
	/**
	 * Sets the style of the pen.
	 * 
	 * @param style Style of the pen.
	 */
	public void setLineStyle(String style){
		myLineStyle = style;
	}
	
	/**
	 * Sets the pen down.
	 */
	public void penUp(){
		myIsPenDown = false;
	}
	
	/**
	 * Sets the pen up.
	 */
	public void penDown(){
		myIsPenDown = true;
	}
	
	/**
	 * Checks whether the pen is down.
	 * @return Whether the pen is down.
	 */
	public boolean isPenDown(){
		return myIsPenDown; 
	}

}
