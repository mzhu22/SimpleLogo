package MathOperations;

import CommandAbstractClasses.Operation;

public class Arctan extends Operation {

	
	public Arctan(){
		numChildren = 1; 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.toDegrees(Math.atan(getLeft().evaluate()));
	}
}
