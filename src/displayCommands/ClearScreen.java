package displayCommands;

import turtleClasses.Turtle;
import javafx.scene.shape.Line;

public class ClearScreen extends ClearObjects{

	public ClearScreen() {
		super(new Line());
	}
	
	@Override
	protected void doAction(Turtle turtle) {	
		turtle.resetPosition();
	}

}
