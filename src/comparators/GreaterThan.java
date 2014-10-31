// This entire file is part of my masterpiece.
// Dimeji Abidoye
package comparators;

import commandAbstractClasses.Operation;

public class GreaterThan extends Operation {

	public GreaterThan (){
		super(2); 
	}


	@Override
	public double evaluate() {
		return (getChild(MY_LEFT_CHILD).evaluate() > getChild(MY_RIGHT_CHILD).evaluate()) ? 1 : 0 ; 
	}
}
