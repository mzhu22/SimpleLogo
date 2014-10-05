package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Power extends Operation {

	public Power(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

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
