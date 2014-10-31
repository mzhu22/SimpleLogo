// This entire file is part of my masterpiece
// MIKE ZHU

package displayCommands;

import frontend.Turtle;

public class Forward extends Move{

	public Forward() {
	}

	@Override
	protected void doAction(Turtle turtle) {
		turtle.move(myValue);
	}
}
