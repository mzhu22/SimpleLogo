// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;

public class Cosine extends Operation {

	public Cosine(){
		
		super(1);  
	}


	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.cos((PI*getChild(MY_LEFT_CHILD).evaluate())/ONE_EIGHTY);
	}
}
