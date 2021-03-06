package frontend.ConcreteFeatures;

import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import frontend.AbstractFeatures.GUIFeature;

/**
 * This class represents a GUIFeature that uses a ColorPicker to pick colors for various thing on the screen.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
public class SLogoColorPicker extends GUIFeature {

	private ColorPicker myColorPicker;
	
	/**
	 * Constructor. 
	 * 
	 * @see GUIFeature#GUIFeature(double, double) 
	 * @param cp The ColorPicker to get colors from.
	 */
	public SLogoColorPicker(double x, double y, ColorPicker cp) {
		super(x, y);
		myColorPicker = cp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void action() {
		//does nothing, passive object until another button is pressed
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		myColorPicker.setLayoutX(myX);
		myColorPicker.setLayoutY(myY);
		g.getChildren().add(myColorPicker);
		return g;
		
	}

}
