package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;
import javafx.scene.control.TextArea;
import SLogoControllers.InputController;
import expressionTree.HistoryCollection;
import frontend.PaneUpdater;
import frontend.Translator;
import frontend.TurtleMover;
import frontend.AbstractFeatures.GUIFeatureWithTextBox;

/**
 * This class represents a text box with a run button, that, 
 * more importantly, delegates the commands off for execution.
 * Since so many GUIFeatures change based on the commands,
 * it requires many objects to run completely.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class CommandExecuter extends GUIFeatureWithTextBox {
	
	private TurtleMover myMover;
	private PaneUpdater myPaneUpdater;
	private Translator myTranslator;
	private HistoryCollection myHistory;
	
	/**
	 * 
	 * @see GUIFeatureWithTextBox#GUIFeatureWithTextBox(double, double, double, double, String, String)
	 * 
	 * @param mover The TurtleMover that moves turtles based on the commands.
	 * @param pu The PaneUpdater that updates panes based on the commands.
	 * @param t The Translator to translate the commands.
	 * @param history The History to add the commands to.
	 */
	public CommandExecuter(double x, double y, double width, double height, TurtleMover mover, String buttonName, String initialText, PaneUpdater pu, Translator t, HistoryCollection history) {
		super(x, y, width, height, buttonName, initialText);
		this.inputBox = new TextArea();
		this.myMover = mover;
		this.myPaneUpdater = pu;
		this.myTranslator = t;
		this.myHistory = history;
	}

	/**
	 * {@inheritDoc}
	 * Runs the commands and updates history and the panes.
	 * Throws a SLogoException if the input is null.
	 */
	@Override
	public void action() {
		String input = inputBox.getText();
		
		if(input != null && !input.isEmpty()){
			InputController ic = new InputController(myTranslator);
			myHistory.add(input);
			ic.giveInput(input);
			this.myMover.startDrawing(ic.getInstructions());
			this.myPaneUpdater.updateAll();
		}
		else{
			EPU.display("Empty input", false);
		}
	}
}
