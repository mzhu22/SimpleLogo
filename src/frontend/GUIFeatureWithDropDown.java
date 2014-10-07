/**
 * This class represents a GUIFeature that uses a drop-down menu to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Node;

public abstract class GUIFeatureWithDropDown extends GUIFeature {

	/**
	 * @see frontend.GUIFeature@action()
	 */
	public GUIFeatureWithDropDown(double x, double y) {
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
