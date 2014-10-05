package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;
 

public class Randoms extends Operation {

	
	public Randoms(ExpressionNode first, ExpressionNode second) {
		super(first, null);
		// TODO Auto-generated constructor stub
	}

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
