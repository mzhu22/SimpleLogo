package controlStructures;

import expressionTree.ExpressionNode;

public class If extends ExpressionNode {

	public If() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		 if (myLeft.evaluate() !=0 )  return myValue = myRight.evaluate();
	
		 else return myValue =  0 ; 
	}

	
	

}
