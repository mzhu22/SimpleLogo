// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;

public class Power extends Operation {


	
	public Power (){
		
		super(2); 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.pow(getChild(MY_LEFT_CHILD).evaluate(), getChild(MY_RIGHT_CHILD).evaluate());
	}
}
