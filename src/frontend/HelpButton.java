package frontend;

public class HelpButton extends GUIFeatureWithButton {

	public HelpButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
	}

	@Override
	public void action() {
		System.out.println("Help.");
	}

}
