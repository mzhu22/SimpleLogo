// This entire file is part of my masterpiece.
// Dimeji Abidoye
package comparators;

import commandAbstractClasses.Operation;

public class Or extends Operation {

	public Or(){
		super(2); 
	}


	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( (getChild(MY_LEFT_CHILD).evaluate() + getChild(MY_RIGHT_CHILD).evaluate()) != 0 ) ? 1 : 0 ; 
	}
}
