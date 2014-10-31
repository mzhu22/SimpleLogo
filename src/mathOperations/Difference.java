// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;

public class Difference extends Operation {

	public Difference (){
		
		super(2); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getChild(MY_LEFT_CHILD).evaluate() - getChild(MY_RIGHT_CHILD).evaluate();
	}
}
