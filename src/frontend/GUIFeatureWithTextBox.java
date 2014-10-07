/**
 * This class represents a GUIFeature that uses a writable text box to interact.
 * 
 * @author Safkat Islam
 * @author Chris Bernt
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public abstract class GUIFeatureWithTextBox extends GUIFeature {

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
	public abstract Group makeTool();

}
