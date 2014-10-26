package frontend.ConcreteFeatures;

import static frontend.Pen.DEFAULT_LINE_COLOR;
import static frontend.Pen.DEFAULT_LINE_STYLE;
import static frontend.Pen.DEFAULT_LINE_WIDTH;
import static frontend.Turtle.TURTLE_DEFAULT_DIRECTION;
import javafx.scene.canvas.Canvas;
import frontend.PaneUpdater;
import frontend.Pen;
import frontend.Turtle;
import frontend.TurtleCollection;

/**
 * This class represents a button that allows
 * the user to reset the workspace, moving all turtles
 * back home and removing all lines and stamps and 
 * reverting line/color/background to their initial states.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ResetButton extends ClearCanvasButton {

	private TurtleCollection myTurtleCollection;
	private PaneUpdater myPaneUpdater;
	
	/**
	 * Constructor
	 * 
	 * @see ClearCanvasButton#ClearCanvasButton(double, double, String, Canvas)
	 * @param turtles Turtles to be reset.
	 * @param pu PaneUpdater to update based on the reset.
	 */
	public ResetButton(double x, double y, String buttonName, Canvas canvas, TurtleCollection turtles, PaneUpdater pu) {
		super(x, y, buttonName, canvas);
		this.myTurtleCollection = turtles;
		this.myPaneUpdater = pu;
	}
	
	/**
	 * {@inheritDoc}
	 * Resets all aspects of the current workspace to the default:
	 * clears the canvas/background, 
	 * sets turtle to initial position facing up, 
	 * Sets turtle to initial image, 
	 * sets line color to black and line width to 1, 
	 */
	@Override
	public void action(){
		
		super.action();
		myTurtleCollection.setActiveTurtles();
		for(Turtle t : this.myTurtleCollection)
		{
			t.resetPosition();
			t.setDirection(TURTLE_DEFAULT_DIRECTION);
			t.resetImage();
			Pen p = t.getPen();
			p.setLineColor(DEFAULT_LINE_COLOR);
			p.setLineStyle(DEFAULT_LINE_STYLE);
			p.setLineWidth(DEFAULT_LINE_WIDTH);
		}
		this.myPaneUpdater.updateAll();
	}
	
}
