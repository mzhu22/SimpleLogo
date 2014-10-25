package controlStructures;

import expressionTree.ExpressionNode;

public class MakeVariable extends ExpressionNode {

	public MakeVariable(){
		super(2);  
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myLeft.setValue( myRight.evaluate());
		myValue = myRight.evaluate();
		return myValue;
	}

}
