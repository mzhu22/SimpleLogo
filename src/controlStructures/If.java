package controlStructures;

import expressionTree.ExpressionNode;

/**
 * Stores an expression to be evaluated in the left child, a set of commands to be run on 
 * the right when expression==true.
 * @author Mike Zhu
 *
 */
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
