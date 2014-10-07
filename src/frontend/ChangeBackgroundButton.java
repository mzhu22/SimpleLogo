package frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChangeBackgroundButton extends GUIFeatureWithButton{

	private Scene myScene;
	
	public ChangeBackgroundButton(double x, double y, String buttonName, Scene scene) {
		super(x, y, buttonName);
		myScene = scene;
		
	}

	/**
	 * NOTE: CHANGES BACKGROUND OF WHOLE SCENE, NOT TURTLE'S CANVAS
	 */
	
	
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
        	myScene.setFill(colorPicker.getValue());
        	stage.close();
        });
        
        colorRoot.getChildren().addAll(colorPicker, sub);
        
        stage.setScene(s);
        stage.show();
        
        
        
        
		
	}

}
