package CommandAbstractClasses;

import java.util.Random;

import ExpressionTree.ExpressionNode;

public abstract class Operation extends ExpressionNode {

	protected static final int ONE_EIGHTY = 180; 
	protected static final double PI = Math.PI; 
	protected static Random randomizer; 
	
	public Operation(ExpressionNode first, ExpressionNode second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}
	

	
}
