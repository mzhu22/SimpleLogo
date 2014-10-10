package frontend;

import ErrorsAndExceptions.ErrorPopUp;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;

public class ChangeLineWidthTextBox extends GUIFeatureWithTextBox {

	private Canvas myCanvas;
	
	public ChangeLineWidthTextBox(double x, double y, double width,
			double height, Canvas canvas, String buttonName, String initialText) {
		super(x, y, width, height, buttonName, initialText);
		this.inputBox = new TextField();
		myCanvas = canvas;
		
	}

	@Override
	public void action() {
		try{
			((SLogoCanvas)myCanvas).setLineWidth(Integer.parseInt(inputBox.getText()));
		}
		catch(NumberFormatException e){
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Did not enter an integer");
			
		}

	}

}
