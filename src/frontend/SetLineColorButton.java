package frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SetLineColorButton extends GUIFeatureWithButton{

	private Canvas myCanvas;
	private ColorPicker myColorPicker;
	
	public SetLineColorButton(double x, double y, String buttonName, Canvas canvas, ColorPicker cp) {
		super(x, y, buttonName);
		myCanvas = canvas;
		myColorPicker = cp;
	}

	@Override
	public void action() {
		((SLogoCanvas) myCanvas).setLineColor(this.myColorPicker.getValue());
	}

}
