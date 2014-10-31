// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;

public class Minus extends Operation{

	public Minus () {
		
		super(1); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return -getChild(MY_LEFT_CHILD).evaluate();
	}
}
