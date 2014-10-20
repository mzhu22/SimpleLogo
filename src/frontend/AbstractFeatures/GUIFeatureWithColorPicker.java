package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.control.ColorPicker;

public class GUIFeatureWithColorPicker extends GUIFeature {

	private ColorPicker myColorPicker;
	
	public GUIFeatureWithColorPicker(double x, double y, ColorPicker cp) {
		super(x, y);
		myColorPicker = cp;
	}

	@Override
	public void action() {
		//does nothing, passive object until another button is pressed
	}

	@Override
	public Group makeTool() {
		Group g = new Group();
		myColorPicker.setLayoutX(myX);
		myColorPicker.setLayoutY(myY);
		g.getChildren().add(myColorPicker);
		return g;
		
	}

}
