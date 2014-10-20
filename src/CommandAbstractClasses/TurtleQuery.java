package CommandAbstractClasses;

/**
 * @author Dimeji Abidoye
 * 
 *
 */

import frontend.Turtle;
import ExpressionTree.ExpressionNode;



public  abstract class TurtleQuery extends ExpressionNode {

	protected Turtle myActionable; 
	
	public TurtleQuery(Turtle actionable){
		myActionable = actionable; 
		numChildren = 0; 
	}
	
	@Override
	public abstract double evaluate(); 

}
