package displayCommands;

import javafx.scene.shape.Line;
import frontend.Turtle;
import frontend.TurtleCollection;

public class ClearScreen extends ClearObjects{

	public ClearScreen() {
		super(new Line());
	}
	
	@Override
	protected void doAction(Turtle turtle) {	
		turtle.resetPosition();
	}

}
