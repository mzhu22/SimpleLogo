/**
 * 
 */
package frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author safkat23
 *
 */
public abstract class GUIFeatureChangeColorButton extends GUIFeatureWithButton {

	protected final ColorPicker colorPicker;
	
	/**
	 * @param x
	 * @param y
	 * @param buttonName
	 */
	public GUIFeatureChangeColorButton(double x, double y, String buttonName) {
		super(x, y, buttonName);
		colorPicker = new ColorPicker();
	}

	/* (non-Javadoc)
	 * @see frontend.GUIFeatureWithButton#action()
	 */
	@Override
	public void action() {
		
        
        Stage stage = new Stage();
        Group colorRoot = new Group();
        Scene s = new Scene(colorRoot, 300, 300);
        
        Button sub = new Button("Submit");
        sub.setLayoutX(50);
        sub.setLayoutY(50);
        sub.setOnMouseClicked(event -> {
        	this.submitAction();
        	stage.close();
        });
        
        colorRoot.getChildren().addAll(colorPicker, sub);
        
        stage.setScene(s);
        stage.show();
        

	}
	
	public abstract void submitAction();

}
