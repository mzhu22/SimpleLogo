/**
 * This abstract class represents any sort of interaction tool that the user may have to deal with.
 * An example of this is a button or a drop down menu.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */

package frontend.AbstractFeatures;

import javafx.scene.Group;

public abstract class GUIFeature {
	
	protected double myX;
	protected double myY;
	
	/**
	 * Constructor.
	 * @param x The x-coordinate of the tool on the screen.
	 * @param y The y-coordinate of the tool on the screen.
	 */
	public GUIFeature(double x, double y){
		myX = x;
		myY = y;
	}
	
	/**
	 * This method represents the action taken by the feature when it is interacted upon.
	 * For example, the turtle changes color if the changeColor button is pressed.
	 */
	public abstract void action();
	
	/**
	 * Creates the graphical representation of the GUIFeature.
	 * @return The JavaFX Node object that is the graphical representation and that the user interacts with.
	 */
	public abstract Group makeTool();
}
