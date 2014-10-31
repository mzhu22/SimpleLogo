// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;
import expressionTree.ExpressionNode;

public class Product extends Operation{

	
	public Product() {
		
		super(2); 
	}
	
	public Product(int numChildren){
		super(numChildren); 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		myValue = 1;
		for( ExpressionNode n : myChildren){
			myValue*= n.evaluate(); 
		}
		return myValue; 
	}
}
