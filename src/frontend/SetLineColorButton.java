package frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SetLineColorButton extends GUIFeatureChangeColorButton{

	private Canvas myCanvas;
	
	public SetLineColorButton(double x, double y, String buttonName, Canvas canvas) {
		super(x, y, buttonName);
		myCanvas = canvas;
	}

	@Override
	public void submitAction() {
		((SLogoCanvas) myCanvas).setLineColor(this.colorPicker.getValue());
	}

}
