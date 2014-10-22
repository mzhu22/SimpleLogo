/**
 * This class represents a GUIFeature that uses a window to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public abstract class GUIFeatureWithUpdateableScrollPane extends GUIFeature {

	private double myWidth;
	private double myHeight;
	protected ScrollPane myWindow;
	
	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithUpdateableScrollPane(double x, double y, double width, double height) {
		super(x, y);
		myWidth = width;
		myHeight = height;
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
		myWindow = new ScrollPane();
		myWindow.setLayoutX(myX);
		myWindow.setLayoutY(myY);
		myWindow.setPrefSize(myWidth, myHeight);
		updatePane();
		g.getChildren().add(myWindow);
		return g;
	}
	
	/**
	 * Modifies the parameter Group to fill the Pane.
	 * @param g
	 */
	public abstract void updatePane();

}
