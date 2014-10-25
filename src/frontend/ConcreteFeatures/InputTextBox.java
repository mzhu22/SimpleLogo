package frontend.ConcreteFeatures;

import javafx.scene.control.TextArea;
import SLogoControllers.InputController;
import errorsAndExceptions.ErrorPopUp;
import expressionTree.HistoryCollection;
import expressionTree.VariableNodeMap;
import frontend.PaneUpdater;
import frontend.Translator;
import frontend.TurtleMover;
import frontend.AbstractFeatures.GUIFeatureWithTextBox;

public class InputTextBox extends GUIFeatureWithTextBox {
	
	private TurtleMover myMover;
	private PaneUpdater myPaneUpdater;
	private Translator myTranslator;
	private HistoryCollection myHistory;
	
	public InputTextBox(double x, double y, double width, double height, TurtleMover mover, String buttonName, String initialText, PaneUpdater pu, Translator t, HistoryCollection history) {
		super(x, y, width, height, buttonName, initialText);
		this.inputBox = new TextArea();
		this.myMover = mover;
		this.myPaneUpdater = pu;
		this.myTranslator = t;
		this.myHistory = history;
	}

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
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Empty input");
		}
	}

	


}
