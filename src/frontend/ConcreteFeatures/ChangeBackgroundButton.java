package frontend.ConcreteFeatures;

import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import frontend.SLogoCanvas;
import frontend.AbstractFeatures.GUIFeatureWithButton;

public class ChangeBackgroundButton extends GUIFeatureWithButton{

	private Node myNode;
	private ColorPicker myColorPicker;
	
	public ChangeBackgroundButton(double x, double y, String buttonName, Node node, ColorPicker cp) {
		super(x, y, buttonName);
		myNode = node;
		myColorPicker = cp;
		
	}
	
	@Override
	public void action(){	
		((SLogoCanvas) myNode).changeBackground(this.myColorPicker.getValue());
	}
	
	

}
