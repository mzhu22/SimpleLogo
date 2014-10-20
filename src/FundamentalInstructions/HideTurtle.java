package FundamentalInstructions;

import frontend.Turtle;

public class HideTurtle extends FundamentalInstruction {

	public HideTurtle(){
		numChildren = 0; 
	}


	@Override
	public void doAction(Turtle turtle) {
		turtle.hideTurtle();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ZERO;
	}

}
