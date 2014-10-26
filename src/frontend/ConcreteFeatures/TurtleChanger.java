package frontend.ConcreteFeatures;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;
import frontend.AbstractFeatures.SLogoDropDown;

public abstract class TurtleChanger extends SLogoDropDown {

	private TurtleCollection myTurtleCollection;
	
	/**
	 * @see SLogoDropDown#SLogoDropDown(double, double, String, String)
	 * 
	 * @param turtles The turtleCollection to iterate through.
	 */
	public TurtleChanger(double x, double y, String prompt, TurtleCollection turtles) {
		super(x, y, prompt, "src/images/");
		this.myTurtleCollection = turtles;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void doDropDownClickAction(String chosen)
	{
		myTurtleCollection.setActiveTurtles();
		for(Turtle t : myTurtleCollection)
		{
			doAction(t, chosen);
		}
	}

	/**
	 * Change the turtle based on the chosen item.
	 * @param t The turtle to change.
	 * @param chosen The item to change to.
	 */
	protected abstract void doAction(Turtle t, String chosen);
}
