package frontend;

import SLogoControllers.InputController;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class InputTextBox extends GUIFeatureWithTextBox {

	private TextArea inputBox;
	
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

	@Override
	public Group makeTool() {
		Group g = new Group();
		
		inputBox = new TextArea();
		inputBox.setLayoutX(this.myX);
		inputBox.setLayoutY(this.myY);

		inputBox.setPrefWidth(this.myWidth);
		inputBox.setPrefHeight(this.myHeight);
		
		
		g.getChildren().add(inputBox);
		
		Button b = new Button("Submit");
		b.setLayoutX(this.myX + this.myWidth);
		b.setLayoutY(this.myY);
		b.setOnMouseClicked(event -> this.action());
		
		g.getChildren().add(b);
		
		return g;
	}	

}
