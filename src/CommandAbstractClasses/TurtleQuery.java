package CommandAbstractClasses;

import frontend.ActionObject;
import ExpressionTree.ExpressionNode;



public  abstract class TurtleQuery extends ExpressionNode {

	protected ActionObject myActionable; 
	
	public TurtleQuery(ActionObject actionable){
		myActionable = actionable; 
		numChildren = 0; 
	}
	
	@Override
	public abstract double evaluate(); 

}
