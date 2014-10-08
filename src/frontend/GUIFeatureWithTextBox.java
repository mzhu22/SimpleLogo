/**
 * This class represents a GUIFeature that uses a writable text box to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public abstract class GUIFeatureWithTextBox extends GUIFeature {

	protected TextArea inputBox;
	protected double myWidth;
	protected double myHeight;
	
	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithTextBox(double x, double y, double width, double height) {
		super(x, y);
		myWidth = width;
		myHeight = height;
	}

	/**
	 * @see frontend.GUIFeature#action()
	 */
	@Override
	public abstract void action();

	/**
	 * @see frontend.GUIFeature#makeTool()
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		
		inputBox = new TextArea();
		inputBox.setLayoutX(this.myX);
		inputBox.setLayoutY(this.myY);

		inputBox.setPrefWidth(this.myWidth);
		inputBox.setPrefHeight(this.myHeight);
		
		
		g.getChildren().add(inputBox);
		
		Button b = new Button("Submit");
		b.setLayoutX(this.myX + this.myWidth);
		b.setLayoutY(this.myY);
		b.setOnMouseClicked(event -> this.action());
		
		g.getChildren().add(b);
		
		return g;
	}	

}
