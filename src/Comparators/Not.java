package Comparators;

import CommandAbstractClasses.Comparator;
import ExpressionTree.ExpressionNode;

public class Not  extends Comparator{

	public Not(ExpressionNode first, ExpressionNode second) {
		super(first, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double evaluate() {
		// TODO Auto-generated method stub
		return ( getLeft().evaluate()==0 ) ? 1 : 0;
	}

}
