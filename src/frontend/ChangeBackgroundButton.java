package frontend;

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

public class ChangeBackgroundButton extends GUIFeatureChangeColorButton{

	private static final String FX_BACKGROUND_COLOR = "-fx-background-color: ";
	private Node myNode;
	
	public ChangeBackgroundButton(double x, double y, String buttonName, Node node) {
		super(x, y, buttonName);
		myNode = node;
		
	}
	
	@Override
	public void submitAction(){	
		((SLogoCanvas) myNode).changeBackground(this.colorPicker.getValue());
	}
	
	

}
