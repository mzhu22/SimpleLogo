package frontend;

import javafx.geometry.Point2D;
import javafx.scene.control.Slider;

public class MakeTestLineButton extends GUIFeatureWithButton{

	private ActionObject myTestObject;
	
	MakeTestLineButton(double x, double y, String buttonName, ActionObject s) {
		super(x, y, buttonName);
		myTestObject = s;
	}

	@Override
	public void action() {
		myTestObject.move(50);
	}


}
