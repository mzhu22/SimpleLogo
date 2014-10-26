package controlStructures;

import expressionTree.ExpressionNode;

/**
 * Class used to enable variable declarations. Takes in a VariableNode as the left child
 * and its value expressions as the right child.
 * 
 * Evaluate() recursively evaluates the right child and places the value into the left. 
 * @author Mike Zhu
 *
 */
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
