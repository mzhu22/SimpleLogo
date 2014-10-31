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
	
	
	/** THESE GETTERS ARE ONLY FOR TESTING PURPOSES.
	 * THEY DO NOT NEED TO BE IN THIS CLASS FOR THE PROGRAM
	 * TO WORK. I THINK THIS CLASS IS SUPER SHY WHICH I BELIEVE
	 * IS GOOD FOR THIS COURSE. TO TEST MY MASTERPIECE, THOUGH,
	 * I NEED TO ADD THESE TO CHECK TO SEE IF THE BUTTON
	 * IS MADE PROPERLY.
	 */
	
	public double getX(){
		return myX;
	}
	public String getName(){
		return myName;
	}
	
	
}