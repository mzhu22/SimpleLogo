package frontend.ConcreteFeatures;

import javafx.scene.control.ColorPicker;
import frontend.Pen;
import frontend.AbstractFeatures.GUIFeatureWithButton;

public class SetLineColorButton extends GUIFeatureWithButton{

	private Pen myPen;
	private ColorPicker myColorPicker;
	
	public SetLineColorButton(double x, double y, String buttonName, Pen pen, ColorPicker cp) {
		super(x, y, buttonName);
		myPen = pen;
		myColorPicker = cp;
	}

	@Override
	public void action() {
		myPen.setLineColor(this.myColorPicker.getValue());
	}

}
