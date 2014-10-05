package frontend;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
			new TestButton(100, 100)	
		};
		
		for(GUIFeature f : features){
			myRoot.getChildren().add(f.makeTool());
		}
		
		
		return scene;
		
		
	}
	
}
