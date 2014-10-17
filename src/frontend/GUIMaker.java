package frontend;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static frontend.GUIFeatureWithButton.BUTTON_WIDTH;
import static frontend.GUIFeatureWithButton.BUTTON_HEIGHT;

public class GUIMaker {
	
	public static final int BUTTON_OFFSET_X = 50;
	private int myWidth;
	private int myHeight;
	private double myTabWidth;
	private double myTabHeight;
	private Group myRoot;
	
	
	public GUIMaker(int w, int h){
		myWidth = w;
		myHeight = h;
		myRoot = new Group();
	}
	
	public Scene make(Stage s){
		Scene scene = new Scene(myRoot, myWidth, myHeight);
		

		TabPane tp = new TabPane();
		tp.resize(myWidth, myHeight);
		myTabWidth = tp.getWidth();
		myTabHeight = tp.getHeight();
		tp.getTabs().add(createTab("Tab One"));
		
		tp.getTabs().add(createTab("Tab Two"));
		
		//Should add a button that allows new tabs to be created
		myRoot.getChildren().add(tp);
		
//		myRoot.addEventHandler(KeyEvent.KEY_PRESSED, new ActionObjectKeyHandler(myMover));
		
		return scene;
		
		
	}

	private Tab createTab(String tabTitle) {
		Group curRoot = new Group();
		
		SLogoCanvas myCanvas = new SLogoCanvas(500, 500, 0, 0);
		ColorPicker myColorPicker = new ColorPicker();
		
		curRoot.getChildren().add(myCanvas.getHolder());
		
		ActionObject test = new ActionObject(myCanvas.getWidth()/2, myCanvas.getHeight()/2,"images/arrow_red.png", myCanvas);	
		ActionObjectMover myMover = new ActionObjectMover(test);
		double button_x = myTabWidth - BUTTON_WIDTH;
				
		GUIFeature[] features = new GUIFeature[] {
			new GUIFeatureWithColorPicker(button_x, BUTTON_HEIGHT*0, myColorPicker),
			new InputTextBox(0, myCanvas.getHeight() + 10, myCanvas.getWidth() - BUTTON_WIDTH, 100, myMover, "Run", "Enter commands here"),
			new QuitButton(button_x, BUTTON_HEIGHT*1, "Quit"),
			new ChangeBackgroundButton(button_x, BUTTON_HEIGHT*2, "Change Background Color", myCanvas, myColorPicker),
			new HelpButton(button_x, BUTTON_HEIGHT*3, "Help"),
			new SetLineColorButton(button_x, BUTTON_HEIGHT*4, "Change Line Color", myCanvas, myColorPicker),
			new ChangeLineWidthTextBox(button_x -100 , BUTTON_HEIGHT*8, 100, 10, myCanvas, "Change Line Width", "Line Width"),
			new ClearCanvasButton(button_x, BUTTON_HEIGHT*5, "Clear", myCanvas),
			new ToggleGridLinesButton(button_x, BUTTON_HEIGHT*6, "Toggle Grid", myCanvas),
			new ResetButton(button_x, BUTTON_HEIGHT*7, "Reset", myCanvas, test),
			new EnableArrowsButton(button_x, BUTTON_HEIGHT*9, "Enable Arrows"),
			new GUIChooseImage(button_x, BUTTON_HEIGHT*10, "Select Image", test),
			new GUIChooseLineStyle(button_x, BUTTON_HEIGHT*11, "Select Line Style", myCanvas),
			
			//new ChangeActionObjectImageButton(button_x, BUTTON_HEIGHT*7, "Change Image", test)
			
		};
		
		
		for(GUIFeature f : features){
			curRoot.getChildren().add(f.makeTool());
		}
		
		curRoot.addEventHandler(KeyEvent.KEY_PRESSED, new ActionObjectKeyHandler(myMover));
		
		
		Tab tab = new Tab(tabTitle);
		tab.setContent(curRoot);
		
		return tab;

	}
	
}