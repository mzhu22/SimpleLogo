package controlStructures;

import ExpressionTree.ExpressionNode;

public class Make extends ExpressionNode {

	public Make(){
		numChildren = 2; 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myLeft.setInfo( myRight.evaluate());
		myInfo = myRight.evaluate();
		return myInfo;
	}

}
