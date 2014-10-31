//This entire file is part of my masterpiece.
//CHRIS BERNT

package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 * This class represents a GUIFeature that uses a button to interact.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 * 
 */
public abstract class SLogoButton extends GUIFeature {

	private String myName;
	public final static int BUTTON_WIDTH = 200;
	public final static int BUTTON_HEIGHT = 25;
	
	/**
	 * Constructor.
	 * 
	 * @see GUIFeature#GUIFeature(double, double) 
	 * @param buttonName String for the button.
	 */
	public SLogoButton(double x, double y, String buttonName) {
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
	 * Specifically, makes a button and sets its on clicked action
	 * to be an abstract method defined by subclasses.
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		
		Button b = new Button(myName);
		b.setLayoutX(myX);
		b.setLayoutY(myY);
		setExactSize(b, BUTTON_WIDTH, BUTTON_HEIGHT);
		b.setOnMouseClicked(event -> action());
		g.getChildren().add(b);
		
		return g;
	}
	public void setExactSize(Button b, double width, double height){
		b.setMinWidth(width);
		b.setMaxWidth(width);
		b.setMinHeight(height);
		b.setMaxHeight(height);
	}
}
