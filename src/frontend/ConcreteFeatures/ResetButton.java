package frontend.ConcreteFeatures;

import static frontend.Pen.DEFAULT_LINE_COLOR;
import static frontend.Pen.DEFAULT_LINE_STYLE;
import static frontend.Pen.DEFAULT_LINE_WIDTH;
import javafx.scene.canvas.Canvas;
import frontend.PaneUpdater;
import frontend.Pen;
import frontend.Turtle;
import frontend.TurtleCollection;

public class ResetButton extends ClearCanvasButton {

	private TurtleCollection myTurtleCollection;
	private PaneUpdater myPaneUpdater;
	
	public ResetButton(double x, double y, String buttonName, Canvas canvas, TurtleCollection turtles, PaneUpdater pu) {
		super(x, y, buttonName, canvas);
		this.myTurtleCollection = turtles;
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
		for(Turtle t : this.myTurtleCollection)
		{
			t.resetPosition();
			t.setDirection(90);
			t.resetImage();
			Pen p = t.getPen();
			p.setLineColor(DEFAULT_LINE_COLOR);
			p.setLineStyle(DEFAULT_LINE_STYLE);
			p.setLineWidth(DEFAULT_LINE_WIDTH);
		}
		this.myPaneUpdater.updateAll();
	}
	
}
