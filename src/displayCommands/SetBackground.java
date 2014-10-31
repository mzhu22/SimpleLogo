package displayCommands;
import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;

public class SetBackground extends DisplayNode {

	public SetBackground() {
		super(1);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doAction(Turtle turtle) {
		
	}
	
	@Override
	public void doAction(TurtleCollection turtles)
	{
		turtles.getCanvas().changeBackground((int) myValue);
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue = getChild(MY_LEFT_CHILD).evaluate();
	}

}
