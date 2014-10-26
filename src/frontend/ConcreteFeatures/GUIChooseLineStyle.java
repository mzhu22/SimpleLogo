package frontend.ConcreteFeatures;

import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

/**
 * This class represents a drop down box
 * that allows the user to choose a line style.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class GUIChooseLineStyle extends GUIFeatureWithDropDown {

	private TurtleCollection myTurtleCollection;
	
	/**
	 * Constructor
	 * 
	 * @see GUIFeatureWithDropDown#GUIFeatureWithDropDown(double, double, String)
	 * @param turtles The turtles to change the line style for.
	 */
	public GUIChooseLineStyle(double x, double y, String prompt, TurtleCollection turtles) {
		super(x, y, prompt);
		myTurtleCollection = turtles;
	}

	/**
	 * {@inheritDoc}
	 * Sets the line style for the given turtles to the chosen value.
	 */
	@Override
	public void doDropDownClickAction(String chosen) {
		myTurtleCollection.setActiveTurtles();
		for(Turtle t: myTurtleCollection)
		{
			t.getPen().setLineStyle(chosen);
		}

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
