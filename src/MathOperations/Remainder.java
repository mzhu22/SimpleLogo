package MathOperations;

import CommandAbstractClasses.Operation;

public class Remainder extends Operation {

	
	public Remainder (){
		
		numChildren = 2; 
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() % getRight().evaluate();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
