package frontend.ConcreteFeatures;

import javafx.scene.control.TextField;
import ErrorsAndExceptions.ErrorPopUp;
import frontend.Pen;
import frontend.AbstractFeatures.GUIFeatureWithTextBox;

public class ChangeLineWidthTextBox extends GUIFeatureWithTextBox {

	private Pen myPen;
	
	public ChangeLineWidthTextBox(double x, double y, double width,
			double height, Pen pen, String buttonName, String initialText) {
		super(x, y, width, height, buttonName, initialText);
		this.inputBox = new TextField();
		myPen = pen;
		
	}

	@Override
	public void action() {
		try{
			myPen.setLineWidth(Integer.parseInt(inputBox.getText()));
		}
		catch(NumberFormatException e){
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Did not enter an integer");
			
		}

	}

}
