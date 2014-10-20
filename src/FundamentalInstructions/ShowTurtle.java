package FundamentalInstructions;

import frontend.Turtle;

public class ShowTurtle extends FundamentalInstruction {


	public ShowTurtle(){
		
		numChildren = 0; 
	}
	
	@Override
	public void doAction(Turtle turtle) {
		turtle.showTurtle();
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ONE;
	}

}
