package frontend;

import javafx.geometry.Point2D;
import javafx.scene.control.Slider;

public class MakeTestLineButton extends GUIFeatureWithButton{

	private Turtle myTestObject;
	
	MakeTestLineButton(double x, double y, String buttonName, Turtle s) {
		super(x, y, buttonName);
		myTestObject = s;
	}

	@Override
	public void action() {
		myTestObject.move(50);
	}


}
