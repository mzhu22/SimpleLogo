package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Sine extends Operation {
	
	public Sine(ExpressionNode first) {
		super(first, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.sin((PI*getLeft().evaluate())/ONE_EIGHTY);
	}
}
