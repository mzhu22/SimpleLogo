package frontend;

import javafx.scene.canvas.Canvas;

public class ClearCanvasButton extends GUIFeatureWithButton {

	private Canvas myCanvas;
	
	public ClearCanvasButton(double x, double y, String buttonName, Canvas canvas) {
		super(x, y, buttonName);
		myCanvas = canvas;
	}

	@Override
	public void action() {
		((SLogoCanvas) myCanvas).getHolder().setStyle("-fx-background-color: white");
		myCanvas.getGraphicsContext2D().clearRect(0, 0, 1000, 1000); //BAD hardcoding
		
		//also reset turtle
	}

}
