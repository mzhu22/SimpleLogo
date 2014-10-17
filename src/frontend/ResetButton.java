package frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class ResetButton extends ClearCanvasButton {

	ActionObject myTurtle;
	
	public ResetButton(double x, double y, String buttonName, Canvas canvas, ActionObject turtle) {
		super(x, y, buttonName, canvas);
		myTurtle = turtle;
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
		
		((SLogoCanvas) myCanvas).setLineColor(Color.BLACK);
		((SLogoCanvas) myCanvas).setLineWidth(1);
	}
	
}
