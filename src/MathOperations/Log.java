package MathOperations;

import CommandAbstractClasses.Operation;

public class Log extends Operation {



	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.log(getLeft().evaluate());
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
