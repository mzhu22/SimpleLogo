package frontend.ConcreteFeatures;

import frontend.Pen;
import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithDropDown;

public class GUIChooseLineStyle extends GUIFeatureWithDropDown {

	private TurtleCollection myTurtleCollection;
	
	public GUIChooseLineStyle(double x, double y, String prompt, TurtleCollection turtles) {
		super(x, y, prompt);
		myTurtleCollection = turtles;
	}

	@Override
	public void doDropDownClickAction(String chosen) {
		myTurtleCollection.setActiveTurtles();
		for(Turtle t: myTurtleCollection)
		{
			t.getPen().setLineStyle(chosen);
		}

	}

	@Override
	public void fillItemList() {
		myItems.add("Solid");
		myItems.add("Dashed");
		myItems.add("Dotted");
	}

}
