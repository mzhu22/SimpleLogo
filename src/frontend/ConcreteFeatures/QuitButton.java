package frontend.ConcreteFeatures;

import frontend.AbstractFeatures.GUIFeatureWithButton;

public class QuitButton extends GUIFeatureWithButton{

	public QuitButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
	}

	@Override
	public void action() {
		System.exit(0);
	}

}
