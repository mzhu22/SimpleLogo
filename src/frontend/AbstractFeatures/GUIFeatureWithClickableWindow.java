/**
 * This class represents a GUIFeature that uses a clickable window to interact.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 */
package frontend.AbstractFeatures;

import javafx.scene.Group;

public abstract class GUIFeatureWithClickableWindow extends GUIFeatureWithUpdateableScrollPane {

	/**
	 * @see GUIFeature#GUIFeature(double, double)
	 * 
	 * @param width The width of the window.
	 * @param height The height of the window.
	 */
	public GUIFeatureWithClickableWindow(double x, double y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return null;
	}

}
