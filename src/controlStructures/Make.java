package controlStructures;

import ExpressionTree.ExpressionNode;

public class Make extends ExpressionNode {

	public Make(){
		super(2);  
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myLeft.setInfo( myRight.evaluate());
		myValue = myRight.evaluate();
		return myValue;
	}

}
