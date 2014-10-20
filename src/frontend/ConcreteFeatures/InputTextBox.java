package frontend.ConcreteFeatures;

import javafx.scene.control.TextArea;
import ErrorsAndExceptions.ErrorPopUp;
import SLogoControllers.InputController;
import frontend.TurtleMover;
import frontend.AbstractFeatures.GUIFeatureWithTextBox;

public class InputTextBox extends GUIFeatureWithTextBox {
	
	TurtleMover myMover;
	
	public InputTextBox(double x, double y, double width, double height, TurtleMover mover, String buttonName, String initialText) {
		super(x, y, width, height, buttonName, initialText);
		this.inputBox = new TextArea();
		myMover = mover;
	}

	@Override
	public void action() {
		String input = inputBox.getText();
		
		if(input != null && !input.isEmpty()){
			InputController ic = new InputController();
			ic.giveInput(input);
			myMover.startDrawing(ic.getInstructions());
			
			
		}
		else{
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Empty input");
		}
	}

	


}
