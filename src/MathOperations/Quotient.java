package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Quotient  extends Operation {

	public Quotient(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getLeft().evaluate() / getRight().evaluate() ;
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
