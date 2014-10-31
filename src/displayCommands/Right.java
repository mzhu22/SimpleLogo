// This entire file is part of my masterpiece
// MIKE ZHU

package displayCommands;

import frontend.Turtle;


public class Right extends Rotate {
	public Right() {
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.rotate(-myValue);
	}
}
