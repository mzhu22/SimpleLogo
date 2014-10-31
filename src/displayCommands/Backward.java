// This entire file is part of my masterpiece
// MIKE ZHU

package displayCommands;

import frontend.Turtle;

public class Backward extends Move {

	public Backward() {
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.move(-myValue);
	}
}
