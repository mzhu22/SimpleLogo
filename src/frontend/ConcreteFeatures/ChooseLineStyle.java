package frontend.ConcreteFeatures;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;
import frontend.AbstractFeatures.SLogoDropDown;

/**
 * This class represents a drop down box
 * that allows the user to choose a line style.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ChooseLineStyle extends TurtleChanger {

	/**
	 * 
	 * @see SLogoDropDown#GUIFeatureWithDropDown(double, double, String)
	 * @param turtles The collection of turtles to change the image for.
	 */
	public ChooseLineStyle(double x, double y, String prompt, TurtleCollection turtles) {
		super(x, y, prompt, turtles);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doAction(Turtle t, String chosen) {
		t.getPen().setLineStyle(chosen);
	}

	/**
	 * {@inheritDoc}
	 * Adds the line styles.
	 */
	@Override
	public void fillItemList() {
		myItems.add("Solid");
		myItems.add("Dashed");
		myItems.add("Dotted");
	}

}
