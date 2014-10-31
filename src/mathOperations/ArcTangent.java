// This entire file is part of my masterpiece.
// Dimeji Abidoye
package mathOperations;

import commandAbstractClasses.Operation;

public class ArcTangent extends Operation {

	
	public ArcTangent(){
		super(1); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.toDegrees(Math.atan(getChild(MY_LEFT_CHILD).evaluate()));
	}
}
