package frontend.AbstractFeatures;

import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_HEIGHT;
import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_WIDTH;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;

/**
 * This class represents a GUIFeature that uses a writable text box to interact.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
public abstract class GUIFeatureWithTextBox extends GUIFeature {

	protected TextInputControl inputBox;
	protected double myWidth;
	protected double myHeight;
	protected String myButtonName;
	protected String myInitialText;
	
	/**
	 * Constructor.
	 * 
	 * @see GUIFeature#GUIFeature(double, double) 
	 * @param width The width of the text box.
	 * @param height The height of the text box.
	 * @param buttonName The text on the button.
	 * @param initialText The initial text of the text box when created.
	 */
	public GUIFeatureWithTextBox(double x, double y, double width, double height, String buttonName, String initialText) {
		super(x, y);
		myWidth = width;
		myHeight = height;
		myButtonName = buttonName;
		myInitialText = initialText;
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
		
		inputBox.setLayoutX(this.myX);
		inputBox.setLayoutY(this.myY);

		inputBox.setPrefWidth(this.myWidth);
		inputBox.setPrefHeight(this.myHeight);
		
		inputBox.setPromptText(myInitialText);
		
		
		g.getChildren().add(inputBox);
		
		Button b = new Button(myButtonName);
		b.setLayoutX(this.myX + this.myWidth);
		b.setLayoutY(this.myY);
		b.setMinWidth(BUTTON_WIDTH);
		b.setMaxWidth(BUTTON_WIDTH);
		b.setMinHeight(BUTTON_HEIGHT);
		b.setMaxHeight(BUTTON_HEIGHT);
		b.setOnMouseClicked(event -> this.action());
		
		g.getChildren().add(b);
		
		return g;
	}	
}
