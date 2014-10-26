package frontend.ConcreteFeatures;

import static frontend.GUIMaker.EPU;
import javafx.scene.control.TextField;
import frontend.Turtle;
import frontend.TurtleCollection;
import frontend.AbstractFeatures.SLogoTextBox;

/**
 * This class represents a text box the user can enter numbers into to
 * change the line width.
 * 
 * @author Chris Bernt
 * @author Safkat Islam
 *
 */
public class ChangeLineWidth extends SLogoTextBox {

	private TurtleCollection myTurtleCollection;
	
	/**
	 * Constructor.
	 * 
	 * @see SLogoTextBox#GUIFeatureWithTextBox(double, double, double, double, String, String)
	 * @param turtles The turtles to change the line width for.
	 */
	public ChangeLineWidth(double x, double y, double width,
			double height, TurtleCollection turtles, String buttonName, String initialText) {
		super(x, y, width, height, buttonName, initialText);
		this.inputBox = new TextField();
		this.myTurtleCollection = turtles;
		
	}

	/**
	 * {@inheritDoc}
	 * Changes the line width to what was entered.
	 * Throws a SLogoException if an integer was not entered.
	 */
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
			EPU.display("Did not enter an integer", false);
		}
	}
}
