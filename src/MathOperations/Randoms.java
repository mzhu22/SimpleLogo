package MathOperations;

import CommandAbstractClasses.Operation;
 

public class Randoms extends Operation {

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub

		return (randomizer.nextDouble()) * Math.abs(getLeft().evaluate());
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
