package frontend;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIMaker {
	private int myWidth;
	private int myHeight;
	private Group myRoot;
	private SLogoCanvas myCanvas;
	
	public GUIMaker(int w, int h){
		myWidth = w;
		myHeight = h;
		myRoot = new Group();
	}
	
	public Scene make(Stage s, int width, int height){
		Scene scene = new Scene(myRoot, width, height);
		

		
		myCanvas = new SLogoCanvas(400,400,200,200);
		myRoot.getChildren().add(myCanvas.getHolder());
		
		GUIFeature[] features = new GUIFeature[] {
			new InputTextBox(100, 100, 100, 100),
			new QuitButton(0, 200, "Quit"),
			new ChangeBackgroundButton(300, 300, "BG Color", myCanvas.getHolder()),
			new HelpButton(400, 400, "Help"),
			new MakeTestLineButton(500,500,"Test", myCanvas),
			new SetLineColorButton(50, 400, "Line Color", myCanvas),
			new ChangeLineWidthTextBox(400, 50, 100, 10, myCanvas)
			
		};
		
		
		for(GUIFeature f : features){
			myRoot.getChildren().add(f.makeTool());
		}
		
		
		return scene;
		
		
	}
	
}