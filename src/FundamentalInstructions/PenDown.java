package FundamentalInstructions;

import frontend.Turtle;


public class PenDown extends FundamentalInstruction {

	public PenDown (){
		
		numChildren = 0; 
	}
	
	

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ONE;
	}



	@Override
	public void doAction(Turtle turtle) {
		turtle.getPen().penDown();
	}

}
