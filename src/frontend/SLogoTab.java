package frontend;

import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_HEIGHT;
import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_WIDTH;
import frontend.ConcreteFeatures.*;
import frontend.AbstractFeatures.*;
import frontend.*;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;

public class SLogoTab {

	//private final static int GUIFeature[] DEFAULT_FEATURES ;
	private double myWidth;
	private double myHeight;
	private Group myRoot = new Group();
	private SLogoCanvas myCanvas = new SLogoCanvas(500, 500, 0, 0);
	private ColorPicker myColorPicker = new ColorPicker();
	private Turtle myTurtle;
	private TurtleMover myMover;
	private GUIFeature[] startingFeatures;
	private TabPane myTabPane;

	public SLogoTab(TabPane tp)
	{
		this.myTabPane = tp;
		this.myWidth = this.myTabPane.getWidth();
		this.myHeight = this.myTabPane.getHeight();
		
		this.myRoot.getChildren().add(myCanvas.getHolder());
		double button_x = this.myWidth - BUTTON_WIDTH;
		myTurtle = new Turtle(myCanvas.getWidth()/2, myCanvas.getHeight()/2,"images/arrow_red.png", myCanvas);	
		myMover = new TurtleMover(myTurtle);

		startingFeatures = new GUIFeature[] {
				new GUIFeatureWithColorPicker(button_x, BUTTON_HEIGHT*0, myColorPicker),
				new InputTextBox(0, myCanvas.getHeight() + 10, myCanvas.getWidth() - BUTTON_WIDTH, 100, myMover, "Run", "Enter commands here"),
				new QuitButton(button_x, BUTTON_HEIGHT*1, "Quit"),
				new ChangeBackgroundButton(button_x, BUTTON_HEIGHT*2, "Change Background Color", myCanvas, myColorPicker),
				new HelpButton(button_x, BUTTON_HEIGHT*3, "Help"),
				new SetLineColorButton(button_x, BUTTON_HEIGHT*4, "Change Line Color", myCanvas, myColorPicker),
				new ChangeLineWidthTextBox(button_x -100 , BUTTON_HEIGHT*8, 100, 10, myCanvas, "Change Line Width", "Line Width"),
				new ClearCanvasButton(button_x, BUTTON_HEIGHT*5, "Clear", myCanvas),
				new ToggleGridLinesButton(button_x, BUTTON_HEIGHT*6, "Toggle Grid", myCanvas),
				new ResetButton(button_x, BUTTON_HEIGHT*7, "Reset", myCanvas, myTurtle),
				new EnableArrowsButton(button_x, BUTTON_HEIGHT*9, "Enable Arrows"),
				new GUIChooseImage(button_x, BUTTON_HEIGHT*10, "Select Image", myTurtle),
				new GUIChooseLineStyle(button_x, BUTTON_HEIGHT*11, "Select Line Style", myCanvas),
				new AddWorkspaceButton(button_x, BUTTON_HEIGHT*12, "Add New Workspace", myTabPane),
		};
	}

	public Tab createTab(int numTab) {

		for(GUIFeature f : startingFeatures){
			myRoot.getChildren().add(f.makeTool());
		}

		myRoot.addEventHandler(KeyEvent.KEY_PRESSED, new TurtleKeyHandler(myMover));

		String tabTitle = "Workspace " + numTab;
		Tab tab = new Tab(tabTitle);
		tab.setContent(myRoot);

		return tab;

	}

	public class AddWorkspaceButton extends GUIFeatureWithButton {

		private TabPane myTabPane;
		public AddWorkspaceButton(double x, double y, String buttonName, TabPane tp) {
			super(x, y, buttonName);
			this.myTabPane = tp;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			SLogoTab st = new SLogoTab(this.myTabPane);
			this.myTabPane.getTabs().add(st.createTab(this.myTabPane.getTabs().size() + 1));
		}

	}
}
