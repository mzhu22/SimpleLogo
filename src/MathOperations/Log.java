package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Log extends Operation {

	public Log(ExpressionNode first) {
		super(first, null);
		// TODO Auto-generated constructor stub
	}

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
