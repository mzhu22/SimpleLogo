package Comparators;

import CommandAbstractClasses.Comparator;
import ExpressionTree.ExpressionNode;



public class And extends Comparator {

	public And(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( (getLeft().evaluate() * getRight().evaluate()) != 0 ) ? 1 : 0 ; 
	}

}
