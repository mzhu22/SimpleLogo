package frontend.ConcreteFeatures;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import frontend.Pen;
import frontend.Turtle;

public class ResetButton extends ClearCanvasButton {

	Turtle myTurtle;
	Pen myPen;
	
	public ResetButton(double x, double y, String buttonName, Canvas canvas, Turtle turtle, Pen pen) {
		super(x, y, buttonName, canvas);
		myTurtle = turtle;
		myPen = pen;
	}
	
	/**
	 * Resets all aspects of the current workspace to the default:
	 * clears the canvas/background
	 * sets turtle to initial position facing up
	 * Sets turtle to initial image
	 * turns grid lines off? - TODO
	 * sets line color to black and line width to 1
	 */
	@Override
	public void action(){
		super.action();
		myTurtle.resetPosition();
		myTurtle.setDirection(90);
		myTurtle.resetImage();
		
		myPen.setLineColor(Color.BLACK);
		myPen.setLineWidth(1);
	}
	
}
