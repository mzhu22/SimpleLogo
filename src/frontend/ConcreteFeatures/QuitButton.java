package frontend.ConcreteFeatures;

import frontend.AbstractFeatures.GUIFeatureWithButton;

/**
 * This class represents a button that allows the user
 * to quit the program.
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class QuitButton extends GUIFeatureWithButton{

	/**
	 * Constructor
	 * 
	 * @see GUIFeatureWithButton#GUIFeatureWithButton(double, double, String)
	 */
	public QuitButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
	}

	/**
	 * {@inheritDoc}
	 * Exit the program.
	 */
	@Override
	public void action() {
		System.exit(0);
	}

}
