package MathOperations;

import CommandAbstractClasses.Operation;

public class Power extends Operation {

	

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.pow(getLeft().evaluate(), getRight().evaluate());
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
