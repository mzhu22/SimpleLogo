package FundamentalInstructions;

import ExpressionTree.ExpressionNode;

public class Left extends Right {

	public Left(int parameter, ExpressionNode myRight) {
		super(-ONE*parameter, myRight);
		myCode = "lf"; 
		// TODO Auto-generated constructor stub
	}

}
