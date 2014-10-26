package frontend.ConcreteFeatures;

import frontend.AbstractFeatures.GUIFeatureWithButton;


/**
 * The Javafx TabPane defaults to the arrow keys switching between tabs
 * when pressed. To make sure the arrow keys were recognized by the TurtleKeyHandler,
 * we realized a button on the tab needed to be pressed. To accomplish this we added this button,
 * which has no real action, but once pressed acts like a normal button in that the
 * keys will affect the turtle rather than switching tabs.
 * @author Chris Bernt, Safkat Islam
 *
 */
public class EnableArrowsButton extends GUIFeatureWithButton{

	public EnableArrowsButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
	}

	@Override
	public void action() {
		//Action is intentionally nothing, see class documentation
	}
}
