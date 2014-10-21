package frontend;

import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_HEIGHT;
import static frontend.AbstractFeatures.GUIFeatureWithButton.BUTTON_WIDTH;

import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import frontend.AbstractFeatures.GUIFeature;
import frontend.AbstractFeatures.GUIFeatureWithButton;
import frontend.AbstractFeatures.GUIFeatureWithColorPicker;
import frontend.ConcreteFeatures.ChangeBackgroundButton;
import frontend.ConcreteFeatures.ChangeLineWidthTextBox;
import frontend.ConcreteFeatures.ClearCanvasButton;
import frontend.ConcreteFeatures.EnableArrowsButton;
import frontend.ConcreteFeatures.GUIChooseImage;
import frontend.ConcreteFeatures.GUIChooseLineStyle;
import frontend.ConcreteFeatures.HelpButton;
import frontend.ConcreteFeatures.InputTextBox;
import frontend.ConcreteFeatures.QuitButton;
import frontend.ConcreteFeatures.ResetButton;
import frontend.ConcreteFeatures.SetLineColorButton;
import frontend.ConcreteFeatures.ToggleGridLinesButton;

public class SLogoTab {

	private static final int CANVAS_HEIGHT = 500;
	private static final int CANVAS_WIDTH = 500;
	//private final static int GUIFeature[] DEFAULT_FEATURES ;
	private double myWidth;
	private double myHeight;
	private Group myRoot = new Group();
	private SLogoCanvas myCanvas = new SLogoCanvas(CANVAS_WIDTH, CANVAS_HEIGHT, 0, 0);
	private ColorPicker myColorPicker = new ColorPicker();
	private Turtle myTurtle;
	private TurtleMover myMover;
	private GUIFeature[] startingFeatures;
	private TabPane myTabPane;
	
	public static final ResourceBundle GUI_NAMES = ResourceBundle.getBundle("resources.languages/buttonNames");

	public SLogoTab(TabPane tp)
	{
		
		
		this.myTabPane = tp;
		this.myWidth = this.myTabPane.getWidth();
		this.myHeight = this.myTabPane.getHeight();
		
		this.myRoot.getChildren().add(myCanvas.getHolder());
		double button_x = this.myWidth - BUTTON_WIDTH;
		myTurtle = new Turtle(CANVAS_WIDTH/2, CANVAS_HEIGHT/2,"images/arrow_red.png", myCanvas);	
		Pen turtlePen = myTurtle.getPen();
		
		myMover = new TurtleMover(myTurtle);

		startingFeatures = new GUIFeature[] {
				new GUIFeatureWithColorPicker(button_x, BUTTON_HEIGHT*0, myColorPicker),
				new InputTextBox(0, myCanvas.getHeight() + 10, myCanvas.getWidth() - BUTTON_WIDTH, 100, myMover, GUI_NAMES.getString("Run"), "Enter commands here"),
				new QuitButton(button_x, BUTTON_HEIGHT*1, GUI_NAMES.getString("Quit")),
				new ChangeBackgroundButton(button_x, BUTTON_HEIGHT*2, GUI_NAMES.getString("ChangeBG"), myCanvas, myColorPicker),
				new HelpButton(button_x, BUTTON_HEIGHT*3, "Help"),
				new SetLineColorButton(button_x, BUTTON_HEIGHT*4, GUI_NAMES.getString("ChangeLC"), turtlePen, myColorPicker),
				new ChangeLineWidthTextBox(button_x -100 , BUTTON_HEIGHT*8, 100, 10, turtlePen, GUI_NAMES.getString("ChangeLW"), GUI_NAMES.getString("LWPromptText")),
				new ClearCanvasButton(button_x, BUTTON_HEIGHT*5, GUI_NAMES.getString("Clear"), myCanvas),
				new ToggleGridLinesButton(button_x, BUTTON_HEIGHT*6, GUI_NAMES.getString("ToggleGrid"), myCanvas),
				new ResetButton(button_x, BUTTON_HEIGHT*7, GUI_NAMES.getString("Reset"), myCanvas, myTurtle, turtlePen),
				new EnableArrowsButton(button_x, BUTTON_HEIGHT*9, GUI_NAMES.getString("EnableArrows")),
				new GUIChooseImage(button_x, BUTTON_HEIGHT*10, GUI_NAMES.getString("SelectImage"), myTurtle),
				new GUIChooseLineStyle(button_x, BUTTON_HEIGHT*11, GUI_NAMES.getString("SelectLS"), turtlePen),
				new AddWorkspaceButton(button_x, BUTTON_HEIGHT*12, GUI_NAMES.getString("AddWorkspace"), myTabPane),
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
