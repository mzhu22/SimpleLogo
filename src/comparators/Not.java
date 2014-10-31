// This entire file is part of my masterpiece.
// Dimeji Abidoye
package comparators;

import commandAbstractClasses.Operation;

public class Not  extends Operation{

	public Not(){
		super( 1); 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getChild(MY_LEFT_CHILD).evaluate()==0 ) ? 1 : 0;
	}
}
