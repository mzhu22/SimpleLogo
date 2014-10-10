package MathOperations;

import CommandAbstractClasses.Operation;

public class Add extends Operation {

	public Add() {
		numChildren =2; 
		
	} 
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myInfo = getRight().evaluate() + getLeft().evaluate();
	}
	
}
