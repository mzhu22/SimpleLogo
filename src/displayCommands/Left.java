// This entire file is part of my masterpiece
// MIKE ZHU

package displayCommands;

import frontend.Turtle;


public class Left extends Rotate {

	public Left() {
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.rotate(myValue);
	}
}
