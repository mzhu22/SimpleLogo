// This entire file is part of my masterpiece.
// Dimeji Abidoye

package displayCommands;

import turtleClasses.Turtle;
import turtleClasses.TurtleCollection;

public class SetPalette extends DisplayNode {

	private static final int MY_INDEX_NODE = 0; 
	private static final int MY_RED_NODE = 1; 
	private static final int MY_GREEN_NODE = 2; 
	private static final int MY_BLUE_NODE =3; 

	public SetPalette() {
		super(4);
	}
	@Override
	public void doAction(TurtleCollection turtles)
	{
		//turtles.getCanvas().addColor(index, r, g, b);
	}
	@Override
	protected void doAction(Turtle turtle) {
		// TODO Auto-generated method stub
	}

	@Override
	public double evaluate() {
		evaluateAllChildren(); 
		return myValue = getChild(MY_INDEX_NODE).getValue();
	}

}
