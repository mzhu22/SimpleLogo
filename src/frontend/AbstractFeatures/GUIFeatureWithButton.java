/**
 * This class represents a GUIFeature that uses a button to interact.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.control.Button;

public abstract class GUIFeatureWithButton extends GUIFeature {

	private String myName;
	public final static int BUTTON_WIDTH = 200;
	public final static int BUTTON_HEIGHT = 25;
	
	/**
	 * @see GUIFeature#GUIFeature(double, double)
	 * 
	 * @param buttonName String for the button.
	 */
	public GUIFeatureWithButton(double x, double y, String buttonName) {
		super(x, y);
		myName = buttonName;
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	public abstract void action();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		
		Button b = new Button(myName);
		b.setLayoutX(myX);
		b.setLayoutY(myY);
		b.setMinWidth(BUTTON_WIDTH);
		b.setMaxWidth(BUTTON_WIDTH);
		b.setMinHeight(BUTTON_HEIGHT);
		b.setMaxHeight(BUTTON_HEIGHT);
		b.setOnMouseClicked(event -> action());
		
		g.getChildren().add(b);
		
		return g;
	}
}
