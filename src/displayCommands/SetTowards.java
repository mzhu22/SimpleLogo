package displayCommands;

import frontend.Turtle;

public class SetTowards extends DisplayNode {

	public SetTowards(){
		super(1); 
	}


	@Override
	public void doAction(Turtle turtle) {
		turtle.setDirection(myValue);

	}

	@Override
	public double evaluate() {
		// TODO make this return the number of degrees turned?? how??
		return 0;
	}

}
