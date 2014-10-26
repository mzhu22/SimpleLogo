package frontend;

import static frontend.SLogoWorkspace.CANVAS_HEIGHT;
import static frontend.SLogoWorkspace.CANVAS_WIDTH;
import static frontend.Turtle.DEGREES_TO_RADIANS_FACTOR;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

/**
 * This class contains the ability to draw lines on the canvas
 * by calling on the Pen object.
 * 
 * @author Chris Bernt
 * @author Sakfat Islam
 *
 */
public class LineDrawer {
	
	private Turtle myTurtle;
	private double myX;
	private double myY;
	private double myDirection;
	private Pen myPen;
	private Pane myPane;
	
	/**
	 * Constructor.
	 * 
	 * @param turtle The turtle that needs to draw a line.
	 * @param pane The pane on which to draw the line.
	 */
	public LineDrawer(Turtle turtle, Pane pane){
		myTurtle = turtle;
		this.myX = myTurtle.getX();
		this.myY = myTurtle.getY();
		this.myDirection = myTurtle.getDirection();
		this.myPen = myTurtle.getPen();
		myPane = pane;
		
	}
	
	/**
	 * Draws the necessary lines and returns new (myX, myY) Point2D.
	 * Also handles edge cases (as in when the turtle goes off the edge
	 * of the canvas, the proper lines are drawn and position updated).
	 * 
	 * @param oldPosition The position of the turtle when this is called.
	 * @return The turtle's new position.
	 */
	public Point2D draw(Point2D oldPosition) {

		if(myX < 0){
			double angle = 180 - myDirection;
			double interimY = myY - (myX * Math.tan(angle * DEGREES_TO_RADIANS_FACTOR));
			Point2D interim = new Point2D(0, interimY);
			makeLine(oldPosition, interim);
			oldPosition = new Point2D(CANVAS_WIDTH, interimY);
			myX += (Math.ceil((-myX / CANVAS_WIDTH))*CANVAS_WIDTH);			
		}
		
		if(myX > CANVAS_WIDTH){
			double angle = myDirection;
			double interimY = myY - ((CANVAS_WIDTH - myX) * Math.tan(angle * DEGREES_TO_RADIANS_FACTOR));
			Point2D interim = new Point2D(CANVAS_WIDTH, interimY);
			makeLine(oldPosition, interim);
			oldPosition = new Point2D(0, interimY);
			myX %= CANVAS_WIDTH;
		}
		
		if(myY < 0){
			double angle = 90 - myDirection;
			double interimX = myX + (myY * Math.tan(angle * DEGREES_TO_RADIANS_FACTOR));
			Point2D interim = new Point2D(interimX, 0);
			makeLine(oldPosition, interim);
			oldPosition = new Point2D(interimX, CANVAS_WIDTH);
			myY += (Math.ceil((-myY / CANVAS_HEIGHT))*CANVAS_HEIGHT);
		}
		
		if(myY > CANVAS_HEIGHT){
			double angle = 270 - myDirection;	
			double interimX = myX - ((CANVAS_HEIGHT - myY) * Math.tan(angle * DEGREES_TO_RADIANS_FACTOR));
			Point2D interim = new Point2D(interimX, CANVAS_HEIGHT);
			makeLine(oldPosition, interim);
			oldPosition = new Point2D(interimX, 0);
			myY %= CANVAS_HEIGHT;
		}
		
		
		makeLine(oldPosition, new Point2D(myX, myY));
		return new Point2D(myX, myY);
	}

	/**
	 * Draws a line on the canvas between two points.
	 * 
	 * @param oldPos Point2D representing first point of a line.
	 * @param newPos Point2D representing second point of a line.
	 */
	private void makeLine(Point2D oldPos, Point2D newPos) {
		myPen.drawLine(oldPos, newPos, myPane);
	}
}
