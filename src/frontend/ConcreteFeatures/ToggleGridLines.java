//This entire file is part of my masterpiece.
//CHRIS BERNT

package frontend.ConcreteFeatures;

import frontend.SLogoCanvas;
import frontend.AbstractFeatures.SLogoButton;

/**
 * This class represents a button that allows the user to
 * toggle whether or not the grid lines are displayed
 * on the canvas.
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ToggleGridLines extends SLogoButton {

	private SLogoCanvas myCanvas;
	
	/**
	 * Constructor
	 * 
	 * @see SLogoButton#GUIFeatureWithButton(double, double, String)
	 * @param canvas The canvas on which to toggle the lines.
	 */
	public ToggleGridLines(double x, double y, String buttonName, SLogoCanvas canvas) {
		super(x, y, buttonName);
		myCanvas = canvas;
	}

	/**
	 * {@inheritDoc}
	 * Toggles the grid lines of the canvas.
	 */
	@Override
	public void action() {
		myCanvas.toggleGridLines();
	}

}
