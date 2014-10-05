package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Arctan extends Operation {

	public Arctan(ExpressionNode first, ExpressionNode second) {
		super(first, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return Math.atan(getLeft().evaluate());
	}

}
