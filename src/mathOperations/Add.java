package mathOperations;

import commandAbstractClasses.Operation;

public class Add extends Operation {

	public Add() {
		super(2); 
		
	} 
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myValue = getRight().evaluate() + getLeft().evaluate();
	}
	
}
