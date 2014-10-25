package mathOperations;

import commandAbstractClasses.Operation;

public class Sum extends Operation {

	public Sum() {
		super(2); 
		
	} 
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue = getRight().evaluate() + getLeft().evaluate();
	}
	
}
