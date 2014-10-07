/**
 * This class represents a GUIFeature that uses a window to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Node;

public abstract class GUIFeatureWithWindow extends GUIFeature {

	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithWindow(double x, double y) {
		super(x, y);
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
