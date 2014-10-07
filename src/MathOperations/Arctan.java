package MathOperations;

import CommandAbstractClasses.Operation;

public class Arctan extends Operation {

	
	public Arctan(){
		numChildren = 1; 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.atan(getLeft().evaluate());
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
