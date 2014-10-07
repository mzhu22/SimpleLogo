package MathOperations;

import CommandAbstractClasses.Operation;

public class Difference extends Operation {

	public Difference (){
		
		numChildren = 2; 
	}
	
	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() - getRight().evaluate();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
