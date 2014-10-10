package frontend;

import SLogoControllers.InputController;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InputTextBox extends GUIFeatureWithTextBox {
	
	ActionObjectMover myMover;
	
	public InputTextBox(double x, double y, double width, double height, ActionObjectMover mover, String buttonName, String initialText) {
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
			System.out.println("Empty");
			//show GUI error popup
		}
	}

	


}
