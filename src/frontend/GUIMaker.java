package frontend;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIMaker {
	private int myWidth;
	private int myHeight;
	private Group myRoot;
	
	public GUIMaker(int w, int h){
		myWidth = w;
		myHeight = h;
		myRoot = new Group();
	}
	
	public Scene make(Stage s, int width, int height){
		Scene scene = new Scene(myRoot, width, height);
		
		GUIFeature[] features = new GUIFeature[] {
			new InputTextBox(100, 100, 100, 100),
			new QuitButton(0, 200, "Quit"),
			new ChangeBackgroundButton(300, 300, "BG Color", scene),
			new HelpButton(400, 400, "Help")
		};
		
		
		for(GUIFeature f : features){
			myRoot.getChildren().add(f.makeTool());
		}
		
		
		return scene;
		
		
	}
	
}