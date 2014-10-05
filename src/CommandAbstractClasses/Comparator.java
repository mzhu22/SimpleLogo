package CommandAbstractClasses;

import ExpressionTree.ExpressionNode;

public abstract class Comparator extends Operation{

	public Comparator(ExpressionNode first, ExpressionNode second) {
		super(first, second);
	}
	
}
