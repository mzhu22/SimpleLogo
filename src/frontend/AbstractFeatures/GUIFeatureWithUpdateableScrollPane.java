/**
 * This class represents a GUIFeature that uses a ScrollPane to display information.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
package frontend.AbstractFeatures;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;

public abstract class GUIFeatureWithUpdateableScrollPane extends GUIFeature {

	private double myWidth;
	private double myHeight;
	protected ScrollPane myWindow;
	
	/**
	 * @see GUIFeature#GUIFeature(double, double)
	 * 
	 * @param width The width of the ScrollPane.
	 * @param height The height of the ScrollPane.
	 */
	public GUIFeatureWithUpdateableScrollPane(double x, double y, double width, double height) {
		super(x, y);
		myWidth = width;
		myHeight = height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
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
	 * Update the ScrollPane to represent the new data.
	 */
	public abstract void updatePane();

}
