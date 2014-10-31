// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;

public class Quotient  extends Operation {

	public Quotient (){
		
		super(2);  
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getChild(MY_RIGHT_CHILD).evaluate() / getChild(MY_LEFT_CHILD).evaluate() ;
	}
}
