//This entire file is part of my masterpiece.
//Dimeji Abidoye
package displayCommands;

import turtleClasses.Turtle;


public class Backward extends DisplayNode {

	public Backward() {
		super(1);
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.move(-myValue);
	}

	@Override
	public double evaluate() {
		return (myValue = getChild(MY_LEFT_CHILD).evaluate());
	}


}
