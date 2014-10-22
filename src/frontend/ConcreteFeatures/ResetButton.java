package frontend.ConcreteFeatures;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import frontend.PaneUpdater;
import frontend.Pen;
import frontend.Turtle;
import static frontend.Pen.DEFAULT_LINE_COLOR;
import static frontend.Pen.DEFAULT_LINE_STYLE;
import static frontend.Pen.DEFAULT_LINE_WIDTH;

public class ResetButton extends ClearCanvasButton {

	private Turtle myTurtle;
	private Pen myPen;
	private PaneUpdater myPaneUpdater;
	
	public ResetButton(double x, double y, String buttonName, Canvas canvas, Turtle turtle, Pen pen, PaneUpdater pu) {
		super(x, y, buttonName, canvas);
		this.myTurtle = turtle;
		this.myPen = pen;
		this.myPaneUpdater = pu;
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
		this.myTurtle.resetPosition();
		this.myTurtle.setDirection(90);
		this.myTurtle.resetImage();
		
		this.myPen.setLineColor(DEFAULT_LINE_COLOR);
		this.myPen.setLineWidth(DEFAULT_LINE_WIDTH);
		this.myPen.setLineStyle(DEFAULT_LINE_STYLE);
		this.myPaneUpdater.updateAll();
	}
	
}
