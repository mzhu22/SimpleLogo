package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Add extends Operation {

	public Add(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getRight().evaluate() + getLeft().evaluate();
	}

}
