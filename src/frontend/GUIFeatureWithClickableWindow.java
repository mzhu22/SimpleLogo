/**
 * This class represents a GUIFeature that uses a clickable window to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Node;

public abstract class GUIFeatureWithClickableWindow extends GUIFeatureWithWindow {

	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithClickableWindow(double x, double y, double width, double height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see frontend.GUIFeature#action()
	 */
	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	/**
	 * @see frontend.GUIFeature#makeTool()
	 */
	@Override
	public Group makeTool() {
		// TODO Auto-generated method stub
		return null;
	}

}
