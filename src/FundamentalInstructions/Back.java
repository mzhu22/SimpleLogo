package FundamentalInstructions;

import ExpressionTree.ExpressionNode;

public class Back extends Forward {

	public Back(int parameter, ExpressionNode myRight) {
		super(-ONE*parameter,  myRight);
		myCode = "bk"; 
		// TODO Auto-generated constructor stub
	}

}
