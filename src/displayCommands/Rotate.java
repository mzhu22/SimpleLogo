// This entire file is part of my masterpiece
// MIKE ZHU

package displayCommands;

import frontend.Turtle;

public abstract class Rotate extends DisplayNode {

	public Rotate() {
		super(1);
	}

	public double evaluate() {
		return(myValue = getChild(0).evaluate());
	}

	protected abstract void doAction(Turtle turtle);
}
