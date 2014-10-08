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

public class ChangeBackgroundButton extends GUIFeatureWithButton{

	private static final String FX_BACKGROUND_COLOR = "-fx-background-color: ";
	private Node myNode;
	
	public ChangeBackgroundButton(double x, double y, String buttonName, Node node) {
		super(x, y, buttonName);
		myNode = node;
		
	}
	
	@Override
	public void action() {
		
		final ColorPicker colorPicker = new ColorPicker();
        colorPicker.setValue(Color.WHITE);
        
        Stage stage = new Stage();
        Group colorRoot = new Group();
        Scene s = new Scene(colorRoot, 300, 300);
        
        Button sub = new Button("Submit");
        sub.setLayoutX(50);
        sub.setLayoutY(50);
        sub.setOnMouseClicked(event -> {
        	String colorHex = colorPicker.getValue().toString().substring(2, 8);
        	myNode.setStyle(FX_BACKGROUND_COLOR + colorHex);
        	stage.close();
        });
        
        colorRoot.getChildren().addAll(colorPicker, sub);
        
        stage.setScene(s);
        stage.show();
        
        
        
        
		
	}

}
