package MathOperations;

import CommandAbstractClasses.Operation;

public class Add extends Operation {

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return myInfo = getRight().evaluate() + getLeft().evaluate();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
