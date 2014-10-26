package frontend.ConcreteFeatures;

import static frontend.SLogoCanvas.START_COLOR;
import turtleClasses.TurtleStamp;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Line;
import frontend.SLogoCanvas;
import frontend.AbstractFeatures.SLogoButton;

/**
 * This class represents a button that allows the user
 * to clear the lines off the screen.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ClearCanvas extends SLogoButton {

	protected Canvas myCanvas;
	
	/**
	 * Constructor.
	 * 
	 * @see SLogoButton#GUIFeatureWithButton(double, double, String)
	 * @param canvas The canvas to clear lines from.
	 */
	public ClearCanvas(double x, double y, String buttonName, Canvas canvas) {
		super(x, y, buttonName);
		myCanvas = canvas;
	}

	/**
	 * {@inheritDoc}
	 * Sets background to white and removes all lines and stamps.
	 */
	@Override
	public void action() {
		((SLogoCanvas) myCanvas).changeBackground(START_COLOR);
		((SLogoCanvas)myCanvas).removeObjects(new Line());
		((SLogoCanvas)myCanvas).removeObjects(new TurtleStamp());

	}

}
