package frontend.ConcreteFeatures;

import javafx.scene.control.TextField;
import errorsAndExceptions.ErrorPopUp;
import frontend.Pen;
import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.GUIFeatureWithTextBox;

public class ChangeLineWidthTextBox extends GUIFeatureWithTextBox {

	private TurtleCollection myTurtleCollection;
	
	public ChangeLineWidthTextBox(double x, double y, double width,
			double height, TurtleCollection turtles, String buttonName, String initialText) {
		super(x, y, width, height, buttonName, initialText);
		this.inputBox = new TextField();
		this.myTurtleCollection = turtles;
		
	}

	@Override
	public void action() {
		try{
			myTurtleCollection.setActiveTurtles();
			for(Turtle t : this.myTurtleCollection)
			{
				t.getPen().setLineWidth(Integer.parseInt(inputBox.getText()));
			}
		}
		catch(NumberFormatException e){
			ErrorPopUp epu = new ErrorPopUp();
			epu.display("Did not enter an integer");
			
		}

	}

}
