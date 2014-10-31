// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;

public class Sine extends Operation {
	
	public Sine () {
		
		super(1); 
	}
	

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.sin((PI*getChild(MY_LEFT_CHILD).evaluate())/ONE_EIGHTY);
	}
}
