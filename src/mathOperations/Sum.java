// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;
import expressionTree.ExpressionNode;

public class Sum extends Operation {

	public Sum() {
		super(2); 
		
	} 
	
	public Sum( int numChildren) {
		super (numChildren); 
	}
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		for( ExpressionNode n : myChildren ){
			myValue += n.getValue(); 
		}
		return myValue; 
	}
	
}
