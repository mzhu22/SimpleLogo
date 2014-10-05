package CommandAbstractClasses;

import ExpressionTree.ExpressionNode;



public  abstract class TurtleQuery extends ExpressionNode {

	public TurtleQuery() {
		super(null, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract double evaluate(); 

}
