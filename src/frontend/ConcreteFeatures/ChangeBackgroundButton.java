package frontend.ConcreteFeatures;

import frontend.SLogoCanvas;
import frontend.AbstractFeatures.GUIFeatureWithButton;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
