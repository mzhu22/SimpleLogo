package frontend.ConcreteFeatures;

import javafx.scene.control.ColorPicker;
import frontend.Pen;
import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithButton;

public class SetLineColorButton extends GUIFeatureWithButton{

	private TurtleCollection myTurtleCollection;
	private ColorPicker myColorPicker;
	
	public SetLineColorButton(double x, double y, String buttonName, TurtleCollection turtles, ColorPicker cp) {
		super(x, y, buttonName);
		myTurtleCollection = turtles;
		myColorPicker = cp;
	}

	@Override
	public void action() {
		for(Turtle t : this.myTurtleCollection)
		{
			t.getPen().setLineColor(this.myColorPicker.getValue());
		}
	}

}
