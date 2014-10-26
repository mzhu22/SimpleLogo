package displayCommands;

import static frontend.GUIMaker.EPU;
import javafx.scene.paint.Color;
import frontend.Turtle;
import frontend.TurtleCollection;


public class SetPenColor extends DisplayNode {

	private Color myColor;
	public SetPenColor() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.getPen().setLineColor(myColor);
	}
	
	@Override
	public void doAction(TurtleCollection turtles)
	{
		try{
			myColor = turtles.getCanvas().getColor((int) myValue);
			super.doAction(turtles);
		}
		catch(IndexOutOfBoundsException e){
			EPU.display("Not valid color index.", true);
		}
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue = myLeft.evaluate();
	}

}
