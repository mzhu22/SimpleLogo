package frontend;

import static frontend.AbstractFeatures.SLogoButton.BUTTON_HEIGHT;
import static frontend.AbstractFeatures.SLogoButton.BUTTON_WIDTH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import expressionTree.HistoryCollection;
import frontend.AbstractFeatures.GUIFeature;
import frontend.AbstractFeatures.SLogoButton;
import frontend.AbstractFeatures.SLogoScrollPane;
import frontend.ConcreteFeatures.ChangeBackground;
import frontend.ConcreteFeatures.ChangeCodingLanguage;
import frontend.ConcreteFeatures.ChangeLineWidth;
import frontend.ConcreteFeatures.ChooseImage;
import frontend.ConcreteFeatures.ChooseLineStyle;
import frontend.ConcreteFeatures.ClearCanvas;
import frontend.ConcreteFeatures.CommandExecuter;
import frontend.ConcreteFeatures.CommandsWindow;
import frontend.ConcreteFeatures.CurrentVariablesWindow;
import frontend.ConcreteFeatures.EnableArrows;
import frontend.ConcreteFeatures.Help;
import frontend.ConcreteFeatures.HistoryWindow;
import frontend.ConcreteFeatures.LoadSLogoFile;
import frontend.ConcreteFeatures.LoadVariablesButton;
import frontend.ConcreteFeatures.Quit;
import frontend.ConcreteFeatures.Reset;
import frontend.ConcreteFeatures.SLogoColorPicker;
import frontend.ConcreteFeatures.SaveVariablesButton;
import frontend.ConcreteFeatures.SetLineColor;
import frontend.ConcreteFeatures.ToggleGridLines;
import frontend.ConcreteFeatures.TurtleStatsWindow;

/**
 * This class represents a workspace with unique elements, including the turtles,
 * and all GUIFeatures. It is added as a tab to the TabPane in the GUIMaker.
 *
 * @author Chris Bernt
 * @author Safkat Islam
 */
public class SLogoWorkspace {

	public static final int CANVAS_WIDTH = 500;
	public static final int CANVAS_HEIGHT = 500;
	private double myWidth;
	private double myHeight;
	private Group myRoot = new Group();
	private SLogoCanvas myCanvas;
	private ColorPicker myColorPicker = new ColorPicker();
	private Turtle myInitialTurtle;
	private TurtleMover myMover;
	private List<GUIFeature> startingFeatures;
	private TabPane myTabPane;
	private Translator myTranslator;
	
	private TurtleCollection myTurtleCollection;
	public static final ResourceBundle GUI_PREFERENCES = ResourceBundle.getBundle("resources.buttonLanguages/GUIPreferences");
	public static final ResourceBundle GUI_NAMES = ResourceBundle.getBundle("resources.buttonLanguages/EnglishButtonNames");
	public static final String[] IMAGE_LIST = GUI_PREFERENCES.getString("StartingImages").split(",");
	private PaneUpdater myPaneUpdater;
	private HistoryCollection myHistory;


	/**
	 * Constructor.
	 * 
	 * @param tp The TabPane to which to add workspaces.
	 */
	public SLogoWorkspace(TabPane tp)
	{
		this.myCanvas = new SLogoCanvas(CANVAS_WIDTH, CANVAS_HEIGHT, 0, 0);
		
		this.myTabPane = tp;
		this.myWidth = this.myTabPane.getWidth();
		this.myHeight = this.myTabPane.getHeight();

		this.myRoot.getChildren().add(myCanvas.getHolder());
		double button_x = this.myWidth - BUTTON_WIDTH;
		myInitialTurtle = new Turtle(myCanvas, 0);	
		
		
		myTurtleCollection = new TurtleCollection(new ArrayList<Turtle>(), myCanvas);
		myTurtleCollection.addTurtle(myInitialTurtle);
				
		myMover = new TurtleMover(myTurtleCollection);
		
		myTranslator = new Translator();
		myHistory = new HistoryCollection();
		
		/**
		 * A List of panes with updateable information.
		 */
		List<SLogoScrollPane> updateables = new ArrayList<SLogoScrollPane>(
				Arrays.asList(
						new CurrentVariablesWindow(button_x - 200, 0, 200, 100),
						new TurtleStatsWindow(button_x - 200, 250, 200, 100, myTurtleCollection),
						new CommandsWindow(button_x - 200, 350, 200, 100),
						new HistoryWindow(button_x - 200, 450, 200, 100, myHistory)
						
					)
				);

		myPaneUpdater = new PaneUpdater(updateables);

		/**
		 * A List of all of the features to be added statically to the workspace.
		 */
		startingFeatures = new ArrayList<GUIFeature>(
				Arrays.asList(
						new SLogoColorPicker(button_x, BUTTON_HEIGHT*0, myColorPicker),
						new CommandExecuter(0, myCanvas.getHeight() + 10, myCanvas.getWidth() - BUTTON_WIDTH, 100, myMover, GUI_NAMES.getString("Run"), GUI_NAMES.getString("InputPrompt"), myPaneUpdater, myTranslator, myHistory),
						new Quit(button_x, BUTTON_HEIGHT*1, GUI_NAMES.getString("Quit")),
						new ChangeBackground(button_x, BUTTON_HEIGHT*2, GUI_NAMES.getString("ChangeBG"), myCanvas, myColorPicker),
						new Help(button_x, BUTTON_HEIGHT*3, GUI_NAMES.getString("Help")),
						new SetLineColor(button_x, BUTTON_HEIGHT*4, GUI_NAMES.getString("ChangeLC"), myTurtleCollection, myColorPicker),
						new ChangeLineWidth(button_x -100 , BUTTON_HEIGHT*8, 100, 10, myTurtleCollection, GUI_NAMES.getString("ChangeLW"), GUI_NAMES.getString("LWPromptText")),
						new ClearCanvas(button_x, BUTTON_HEIGHT*5, GUI_NAMES.getString("Clear"), myCanvas),
						new ToggleGridLines(button_x, BUTTON_HEIGHT*6, GUI_NAMES.getString("ToggleGrid"), myCanvas),
						new Reset(button_x, BUTTON_HEIGHT*7, GUI_NAMES.getString("Reset"), myCanvas, myTurtleCollection, myPaneUpdater),
						new EnableArrows(button_x, BUTTON_HEIGHT*9, GUI_NAMES.getString("EnableArrows")),
						new ChooseImage(button_x, BUTTON_HEIGHT*10, GUI_NAMES.getString("SelectImage"), myTurtleCollection),
						new ChooseLineStyle(button_x, BUTTON_HEIGHT*11, GUI_NAMES.getString("SelectLS"), myTurtleCollection),
						new AddWorkspaceButton(button_x, BUTTON_HEIGHT*12, GUI_NAMES.getString("AddWorkspace"), myTabPane),
						new ChangeCodingLanguage(button_x, BUTTON_HEIGHT*13, "Choose Coding Language", myTranslator),
						new LoadSLogoFile(button_x, BUTTON_HEIGHT*14, "Load SLogoFile", myMover, myPaneUpdater, myTranslator),
						new LoadVariablesButton(button_x, BUTTON_HEIGHT*15, "Load Variables"),
						new SaveVariablesButton(button_x, BUTTON_HEIGHT*16, "Save Variables")
					)
				);
		
		startingFeatures.addAll(updateables);
	}

	/**
	 * Adds all of the initial GUIFeatures to the workspace. 
	 * 
	 * @param numTab The number of the tab being added.
	 * @return The created tab.
	 */
	public Tab createWorkspace(int numTab) {

		for(GUIFeature f : startingFeatures){
			myRoot.getChildren().add(f.makeTool());
		}

		myRoot.addEventHandler(KeyEvent.KEY_PRESSED, new TurtleKeyHandler(myMover, myPaneUpdater));

		String tabTitle = "Workspace" + " " + numTab;
		Tab tab = new Tab(tabTitle);
		tab.setContent(myRoot);

		return tab;

	}

	/**
	 * This class represents a button to add a workspace. This is inside of the
	 * SLogoWorkspace class in order to access SLogoWorkspace without passing
	 * it in.
	 * 
	 * @author Chris Bernt
	 * @author Safkat Islam
	 *
	 */
	public class AddWorkspaceButton extends SLogoButton {

		private TabPane myTabPane;
		
		/**
		 * Constructor.
		 * @see SLogoButton#GUIFeatureWithButton(double, double, String)
		 * 
		 * @param tp The TabPane to be added to.
		 */
		public AddWorkspaceButton(double x, double y, String buttonName, TabPane tp) {
			super(x, y, buttonName);
			this.myTabPane = tp;
		}

		
		/**
		 * {@inheritDoc}
		 * Adds a new workspace to the TabPane.
		 */
		@Override
		public void action() {
			SLogoWorkspace st = new SLogoWorkspace(this.myTabPane);
			this.myTabPane.getTabs().add(st.createWorkspace(this.myTabPane.getTabs().size() + 1));
		}

	}
}
