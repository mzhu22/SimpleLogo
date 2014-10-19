package frontend;

import static frontend.GUIFeatureWithButton.BUTTON_HEIGHT;
import static frontend.GUIFeatureWithButton.BUTTON_WIDTH;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.input.KeyEvent;

public class SLogoTab {

	//private final static int GUIFeature[] DEFAULT_FEATURES ;
	private double myWidth;
	private double myHeight;
	private Group myRoot = new Group();
	private SLogoCanvas myCanvas = new SLogoCanvas(500, 500, 0, 0);
	private ColorPicker myColorPicker = new ColorPicker();

	public SLogoTab(double width, double height)
	{
		this.myWidth = width;
		this.myHeight = height;
	}

	public Tab createTab(int numTab) {

		this.myRoot.getChildren().add(myCanvas.getHolder());
		double button_x = this.myWidth - BUTTON_WIDTH;
		ActionObject test = new ActionObject(myCanvas.getWidth()/2, myCanvas.getHeight()/2,"images/arrow_red.png", myCanvas);	
		ActionObjectMover myMover = new ActionObjectMover(test);

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
			myRoot.getChildren().add(f.makeTool());
		}

		myRoot.addEventHandler(KeyEvent.KEY_PRESSED, new ActionObjectKeyHandler(myMover));

		String tabTitle = "Tab " + numTab;
		Tab tab = new Tab(tabTitle);
		tab.setContent(myRoot);

		return tab;

	}

}
