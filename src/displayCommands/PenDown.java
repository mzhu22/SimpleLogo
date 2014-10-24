package displayCommands;

import frontend.Turtle;


public class PenDown extends DisplayNode {

	public PenDown (){
		
		super(0); 
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
