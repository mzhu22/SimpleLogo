package frontend;

import SLogoControllers.InputController;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class InputTextBox extends GUIFeatureWithTextBox {
	
	public InputTextBox(double x, double y, double width, double height) {
		super(x, y, width, height);
	}

	@Override
	public void action() {
		String input = inputBox.getText();
		
		if(input != null && !input.isEmpty()){
			InputController ic = new InputController();
			ic.giveInput(input);
			//SEND TO PARSER
			
			
		}
		else{
			System.out.println("Empty");
			//show GUI error popup
		}
	}

	


}
