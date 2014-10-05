package Comparators;

import CommandAbstractClasses.Comparator;
import ExpressionTree.ExpressionNode;

public class Equal extends Comparator {

	public Equal(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate() == getRight().evaluate()) ? 1 : 0 ; 
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}

}
