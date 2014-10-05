package Comparators;

import CommandAbstractClasses.Comparator;
import ExpressionTree.ExpressionNode;

public class NotEqual extends Comparator {

	public NotEqual(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		return ( getLeft().evaluate() != getRight().evaluate()) ? 1 : 0 ; 
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
