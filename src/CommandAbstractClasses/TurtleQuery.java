package CommandAbstractClasses;

import ExpressionTree.ExpressionNode;



public  abstract class TurtleQuery extends ExpressionNode {


	public TurtleQuery(){
		numChildren = 0; 
	}
	
	@Override
	public abstract double evaluate(); 

}
