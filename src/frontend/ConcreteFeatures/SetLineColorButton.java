package frontend.ConcreteFeatures;

import javafx.scene.control.ColorPicker;
import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithButton;

/**
 * This class represents a button that allows the user
 * to set the line color for turtles.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class SetLineColorButton extends GUIFeatureWithButton{

	private TurtleCollection myTurtleCollection;
	private ColorPicker myColorPicker;
	
	/**
	 * 
	 * @see GUIFeatureWithButton#GUIFeatureWithButton(double, double, String)
	 * @param turtles The turtles to have their line colors updated
	 * @param cp The ColorPicker from which to get the new color
	 */
	public SetLineColorButton(double x, double y, String buttonName, TurtleCollection turtles, ColorPicker cp) {
		super(x, y, buttonName);
		myTurtleCollection = turtles;
		myColorPicker = cp;
	}

	/**
	 * {@inheritDoc}
	 * Sets the line colors of the indicated turtles
	 * to be the specified color.
	 */
	@Override
	public void action() {
		myTurtleCollection.setActiveTurtles();
		for(Turtle t : this.myTurtleCollection)
		{
			t.getPen().setLineColor(this.myColorPicker.getValue());
		}
	}

}
