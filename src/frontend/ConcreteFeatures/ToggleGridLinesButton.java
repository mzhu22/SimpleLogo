package frontend.ConcreteFeatures;

import javafx.scene.canvas.Canvas;
import frontend.SLogoCanvas;
import frontend.AbstractFeatures.GUIFeatureWithButton;

public class ToggleGridLinesButton extends GUIFeatureWithButton {

	private Canvas myCanvas;
	
	public ToggleGridLinesButton(double x, double y, String buttonName, Canvas canvas) {
		super(x, y, buttonName);
		myCanvas = canvas;
	}

	@Override
	public void action() {
		((SLogoCanvas) myCanvas).toggleGridLines();
	}

}
