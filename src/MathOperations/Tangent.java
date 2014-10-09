package MathOperations;

import CommandAbstractClasses.Operation;

public class Tangent extends Operation {

	public Tangent(){
		
		numChildren = 1; 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.tan((PI*getLeft().evaluate())/ONE_EIGHTY);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
