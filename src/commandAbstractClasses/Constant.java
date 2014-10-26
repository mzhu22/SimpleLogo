package commandAbstractClasses;

/**
 * Represents constant value inputs (numbers). 
 * @author Dimeji Abidoye
 */

import expressionTree.ExpressionNode;

public class Constant extends ExpressionNode {

	public Constant(){
		super (0); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue;
	}
	
}
