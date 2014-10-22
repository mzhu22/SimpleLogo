/**
 * This class represents a GUIFeature that uses a window to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public abstract class GUIFeatureWithWindow extends GUIFeature {

	private double myWidth;
	private double myHeight;
	
	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithWindow(double x, double y, double width, double height) {
		super(x, y);
		myWidth = width;
		myHeight = height;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see frontend.AbstractFeatures.GUIFeature#action()
	 */
	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see frontend.AbstractFeatures.GUIFeature#makeTool()
	 */
	@Override
	public Group makeTool() {
		Group g = new Group();
		Pane myWindow = new Pane();
		myWindow.setLayoutX(myX);
		myWindow.setLayoutY(myY);
		myWindow.setPrefSize(myWidth, myHeight);
		return g;
	}

}
