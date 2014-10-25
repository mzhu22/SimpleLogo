package displayCommands;

import javafx.scene.shape.Line;
import frontend.Turtle;
import frontend.TurtleCollection;

public class ClearScreen extends DisplayNode{

	protected Object myObject;
	
	public ClearScreen() {
		this(new Line());
	}

	protected ClearScreen(Object o)
	{
		super(0);
		myObject = o;
	}
	@Override
	public void doAction(TurtleCollection turtles){
		super.doAction(turtles);
		turtles.getCanvas().removeObjects(myObject);
	}
	
	@Override
	protected void doAction(Turtle turtle) {	
		turtle.resetPosition();
	}

	@Override
	public double evaluate() {
		return 0;
	}

}
