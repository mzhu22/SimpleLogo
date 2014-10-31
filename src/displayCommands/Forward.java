//This entire file is part of my masterpiece.
//Dimeji Abidoye
package displayCommands;

import turtleClasses.Turtle;

public class Forward extends DisplayNode{


	public Forward() {
		super(1);
	}

	@Override
	public double evaluate() {
		return (myValue = getChild(MY_LEFT_CHILD).evaluate());
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.move(myValue);
		
	}
}
