package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Difference extends Operation {

	public Difference(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() - getRight().evaluate();
	}

}
