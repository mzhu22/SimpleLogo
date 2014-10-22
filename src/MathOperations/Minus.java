package MathOperations;

import CommandAbstractClasses.Operation;

public class Minus extends Operation{

	public Minus () {
		
		super(1); 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return -getLeft().evaluate();
	}
}
