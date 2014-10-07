/**
 * This class represents a GUIFeature that uses a button to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;

public abstract class GUIFeatureWithButton extends GUIFeature {

	private String myName;
	
	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithButton(double x, double y, String buttonName) {
		super(x, y);
		myName = buttonName;
		// TODO Auto-generated constructor stub
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
		
		Button b = new Button(myName);
		b.setLayoutX(myX);
		b.setLayoutY(myY);
		b.setOnMouseClicked(event -> action());
		
		g.getChildren().add(b);
		
		return g;
	}

}
