package frontend;

import ErrorsAndExceptions.ErrorPopUp;
import javafx.scene.canvas.Canvas;

public class ChangeLineWidthTextBox extends GUIFeatureWithTextBox {

	private Canvas myCanvas;
	
	public ChangeLineWidthTextBox(double x, double y, double width,
			double height, Canvas canvas) {
		super(x, y, width, height);
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
