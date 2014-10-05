package MathOperations;

import CommandAbstractClasses.Operation;
import ExpressionTree.ExpressionNode;

public class Product extends Operation{

	public Product(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return getRight().evaluate()*getLeft().evaluate() ;
	}

}
