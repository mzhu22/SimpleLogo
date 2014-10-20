package FundamentalInstructions;

import frontend.Turtle;

public class Towards extends FundamentalInstruction {

	public Towards(){

		numChildren = 1; 
	}


	@Override
	public void doAction(Turtle turtle) {
		turtle.setDirection(myInfo);

	}

	@Override
	public double evaluate() {
		// TODO make this return the number of degrees turned?? how??
		return 0;
	}

}
