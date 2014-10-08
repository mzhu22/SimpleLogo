package frontend;

import javafx.geometry.Point2D;
import javafx.scene.control.Slider;

public class MakeTestLineButton extends GUIFeatureWithButton{

	private SLogoCanvas testCanvas;
	
	MakeTestLineButton(double x, double y, String buttonName, SLogoCanvas s) {
		super(x, y, buttonName);
		testCanvas = s;
	}

	@Override
	public void action() {
		
		testCanvas.drawLine(new Point2D(10,10), new Point2D(100,100));
	}


}
