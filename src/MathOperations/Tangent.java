package MathOperations;

import CommandAbstractClasses.Operation;

public class Tangent extends Operation {

	public Tangent(){
		
		super(1); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.tan((PI*getLeft().evaluate())/ONE_EIGHTY);
	}
}
