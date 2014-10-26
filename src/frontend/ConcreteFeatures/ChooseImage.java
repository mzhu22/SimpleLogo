package frontend.ConcreteFeatures;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;
import frontend.AbstractFeatures.SLogoDropDown;

/**
 * This class represents drop down box that allows
 * the user to choose an image for the turtle.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ChooseImage extends TurtleChanger{
		
	/**
	 * 
	 * @see SLogoDropDown#GUIFeatureWithDropDown(double, double, String)
	 * @param turtles The collection of turtles to change the image for.
	 */
	public ChooseImage(double x, double y, String prompt, TurtleCollection turtles) {
		super(x, y, prompt, turtles);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doAction(Turtle t, String chosen) {
		t.changeImage(chosen);
	}
}
