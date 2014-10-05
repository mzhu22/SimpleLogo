package FundamentalInstructions;

import ExpressionTree.ExpressionNode;

public class Right extends FundamentalInstruction {

	public Right(int parameter, ExpressionNode myRight) {
		super(myRight );
		myCode = "rt"; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return(myInfo = myRight.evaluate());
	}

}
