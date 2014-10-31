// This entire file is part of my masterpiece.
// Dimeji Abidoye
package commandAbstractClasses;

/**
 * Represents constant value inputs (numbers). 
 * @author Dimeji Abidoye
 */

import expressionTree.ExpressionNode;

public class Constant extends ExpressionNode {

	public Constant(double value){
		super (0); 
		myValue = value; 
	}
	
	public Constant(){
		super(0); 
		}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue;
	}
	
}
