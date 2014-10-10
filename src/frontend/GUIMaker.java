package frontend;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
		

		TabPane tp = new TabPane();
		tp.setPrefSize(width, height);
		tp.getTabs().add(createTab("Tab One"));
		
		tp.getTabs().add(createTab("Tab Two"));
		
		//Should add a button that allows new tabs to be created
		myRoot.getChildren().add(tp);
		
		return scene;
		
		
	}

	private Tab createTab(String tabTitle) {
		Group curRoot = new Group();
		
		myCanvas = new SLogoCanvas(400,400,200,200);
		curRoot.getChildren().add(myCanvas.getHolder());
		
		ActionObject test = new ActionObject(50,50,"images/arrow_red.png", myCanvas);	
		ActionObjectMover myMover = new ActionObjectMover(test);
		
		GUIFeature[] features = new GUIFeature[] {
			new InputTextBox(100, 100, 100, 100, myMover),
			new QuitButton(0, 200, "Quit"),
			new ChangeBackgroundButton(300, 300, "BG Color", myCanvas),
			new HelpButton(400, 400, "Help"),
			new MakeTestLineButton(500,500,"Test", test),
			new SetLineColorButton(50, 400, "Line Color", myCanvas),
			new ChangeLineWidthTextBox(400, 50, 100, 10, myCanvas),
			new ClearCanvasButton(500, 300, "Clear", myCanvas),
			new ToggleGridLinesButton(500, 200, "Toggle Grid", myCanvas),
			new ChangeActionObjectImageButton(500, 300, "Change Image", test)
			
		};
		
		
		for(GUIFeature f : features){
			curRoot.getChildren().add(f.makeTool());
		}
		Tab tab = new Tab(tabTitle);
		tab.setContent(curRoot);
		return tab;

	}
	
}