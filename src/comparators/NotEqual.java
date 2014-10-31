// This entire file is part of my masterpiece.
// Dimeji Abidoye
package comparators;

import commandAbstractClasses.Operation;

public class NotEqual extends Operation {

	public NotEqual (){
		super(2); 
	}


	@Override
	public double evaluate() {
		return ( getChild(MY_LEFT_CHILD).evaluate() != getChild(MY_RIGHT_CHILD).evaluate()) ? 1 : 0 ; 
	}
}
