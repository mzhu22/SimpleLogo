package MathOperations;

import CommandAbstractClasses.Operation;

public class Cosine extends Operation {



	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.cos((PI*getLeft().evaluate())/ONE_EIGHTY);
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
