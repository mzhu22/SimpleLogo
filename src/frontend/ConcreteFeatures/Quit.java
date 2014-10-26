package frontend.ConcreteFeatures;

import frontend.AbstractFeatures.SLogoButton;

/**
 * This class represents a button that allows the user
 * to quit the program.
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class Quit extends SLogoButton{

	/**
	 * Constructor
	 * 
	 * @see SLogoButton#GUIFeatureWithButton(double, double, String)
	 */
	public Quit(double x, double y, String buttonName) {
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
