package FundamentalInstructions;

import frontend.Turtle;



public class PenUp extends FundamentalInstruction {

	
	public PenUp() {
		
		numChildren = 0; 
	}
	
	@Override
	public void doAction(Turtle turtle) {
		turtle.penUp();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ONE;
	}

}
