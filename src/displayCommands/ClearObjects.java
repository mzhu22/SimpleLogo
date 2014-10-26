package displayCommands;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;

public class ClearObjects extends DisplayNode {

	protected Object myObject;

	public ClearObjects() {
		super(0);
	}

	protected ClearObjects(Object o)
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
		
	}

	@Override
	public double evaluate() {
		return 0;
	}

}
