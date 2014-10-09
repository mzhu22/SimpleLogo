package frontend;

import javafx.scene.canvas.Canvas;

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
