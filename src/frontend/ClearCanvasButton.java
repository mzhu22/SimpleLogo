package frontend;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class ClearCanvasButton extends GUIFeatureWithButton {

	private Canvas myCanvas;
	
	public ClearCanvasButton(double x, double y, String buttonName, Canvas canvas) {
		super(x, y, buttonName);
		myCanvas = canvas;
	}

	@Override
	public void action() {
		((SLogoCanvas) myCanvas).changeBackground(Color.WHITE);
		myCanvas.getGraphicsContext2D().clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
		

		//also reset turtle
	}

}
