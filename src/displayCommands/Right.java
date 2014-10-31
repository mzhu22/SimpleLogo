//This entire file is part of my masterpiece.
//Dimeji Abidoye
package displayCommands;

import turtleClasses.Turtle;


public class Right extends DisplayNode {


	public Right() {
		super(1);
	}

	@Override
	public double evaluate() {
		return(myValue = getChild(MY_LEFT_CHILD).evaluate());
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.rotate(-myValue);
	}

}
