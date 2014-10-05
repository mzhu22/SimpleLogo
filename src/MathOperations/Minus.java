package MathOperations;

import CommandAbstractClasses.Operation;

public class Minus extends Operation{

	

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return -getLeft().evaluate();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
