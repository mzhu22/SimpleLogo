package Comparators;

import CommandAbstractClasses.Comparator;
import ExpressionTree.ExpressionNode;

public class Or extends Comparator {

	public Or(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( (getLeft().evaluate() + getRight().evaluate()) != 0 ) ? 1 : 0 ; 
	}

}
